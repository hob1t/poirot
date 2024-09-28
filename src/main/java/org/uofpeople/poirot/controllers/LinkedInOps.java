package org.uofpeople.poirot.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.uofpeople.poirot.pojos.LinkedInPerson;

import java.io.IOException;

import static org.uofpeople.poirot.commons.Constants.RESULT_LIMIT;

/**
 * Performs search on linkedin using DDG
 *
 * curl 'https://duckduckgo.com/?q=site:linkedin.com "Jon Snow"&t=newext&atb=v300-1'
 */
@Service
public class LinkedInOps {
    private final Logger logger = LoggerFactory.getLogger(LinkedInOps.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LinkedInOps() {
    }

    public void runSearch(String query) {
        logger.info("Searching for linked In {}", query);
        // better scrap non js https://duckduckgo.com/html/?q=x
        String url = String.format("https://duckduckgo.com/html/?q=site:linkedin.com \"%s\"", query);

        try {
            Document doc = Jsoup.connect(url).get();

            if(doc.getElementById("links").getElementsByClass("results_links") != null) {
                Elements results = doc.getElementById("links").getElementsByClass("results_links");

                for(Element result: results.stream().limit(RESULT_LIMIT).toList()){
                    Element title = result.getElementsByClass("links_main").first().getElementsByTag("a").first();
                    String liUrl = title.attr("href");

                    try {
                        Document liDoc = Jsoup.connect(liUrl).get(); //script
                        Elements scrappedData = liDoc.getElementsByTag("script");

                        scrappedData.stream().forEach( el -> {
                            if(el.toString().contains("@graph")) {
                                String payload = el.toString().substring(el.toString().indexOf("{"), el.toString().lastIndexOf("}") + 1);
                                logger.info(payload);
                                try {
                                    LinkedInPerson linkedInPerson = objectMapper.readValue(payload, LinkedInPerson.class);
                                    logger.info(linkedInPerson.toString());
                                } catch (JsonProcessingException e) {
                                    logger.error(e.getMessage());
                                }

                                //999 Request Denied
                                logger.info("\nURL:" + title.attr("href"));
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
    }
}
