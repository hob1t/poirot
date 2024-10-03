package org.uofpeople.poirot.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.uofpeople.poirot.commons.Utilities;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.pojos.linkedin.Graph;
import org.uofpeople.poirot.pojos.linkedin.LinkedInPerson;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import static org.uofpeople.poirot.commons.Constants.GRAPH;
import static org.uofpeople.poirot.commons.Constants.RESULT_LIMIT;


/**
 * Performs search on linkedin using DDG
 *
 * curl 'https://duckduckgo.com/?q=site:linkedin.com "Jon Snow"&t=newext&atb=v300-1'
 */
@Service
public class LinkedInOps implements Operations {

    private final Logger logger = LoggerFactory.getLogger(LinkedInOps.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private LIDAService lidaService;

    public LinkedInOps(LIDAService lidaService) {
        this.lidaService = lidaService;
    }

    @Override
    public void runSearch(String query) {
        logger.info("Searching for linked In {}", query);
        // better scrap non js https://duckduckgo.com/html/?q=x
        String url = String.format("https://duckduckgo.com/html/?q=site:linkedin.com \"%s\"", query);

        try {
            Document doc = Jsoup.connect(url).get();

            if(doc.getElementById("links")!= null && doc.getElementById("links").getElementsByClass("results_links") != null) {
                Elements results = doc.getElementById("links").getElementsByClass("results_links");

                for(Element result: results.stream().limit(RESULT_LIMIT).toList()){
                    Element title = result.getElementsByClass("links_main").first().getElementsByTag("a").first();
                    String liUrl = title.attr("href");

                    try {
                        Document liDoc = Jsoup.connect(liUrl).get(); //script
                        Elements scrappedData = liDoc.getElementsByTag("script");

                        scrappedData.stream().forEach( el -> {
                            if(el.toString().contains(GRAPH)) {
                                String payload = el.toString().substring(el.toString().indexOf("{"), el.toString().lastIndexOf("}") + 1);
                                logger.info(payload);

                                try {
                                    LinkedInPerson linkedInPerson = objectMapper.readValue(payload, LinkedInPerson.class);
                                    Optional<Graph> person = linkedInPerson.getGraph().stream().filter(gp -> gp.getType().equals("Person")).findFirst();

                                    if(person.isPresent()) {
                                        lidaService.create(Utilities.buildFrom(person.get(), title.attr("href")));
                                    }

                                } catch (JsonProcessingException e) {
                                    logger.error(e.getMessage());
                                }

                                logger.info("Title:" + title.text());
                                logger.info("Snippet:" + result.getElementsByClass("result__snippet").first().text());
                            }
                        });
                    } catch (IOException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Error while searching for linked In {}", query, e);
        }

        logger.warn("Cannot scrap any LI page for query {}", query);
    }

    /**
     * Gets all saved LI Persons
     *
     * @return
     */
    public List<LIPersonDMO> getAllPersons() {
        return lidaService.findAll();
    }
}
