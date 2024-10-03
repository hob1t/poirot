package org.uofpeople.poirot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.uofpeople.poirot.commons.Utilities;
import org.uofpeople.poirot.dmos.FBPersonDMO;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.pojos.facebook.FBPerson;

import java.util.List;

import static org.uofpeople.poirot.commons.Constants.RESULT_LIMIT;
import static org.uofpeople.poirot.commons.Utilities.checkAndFixUrl;

/**
 * Represents FB operations
 */
@Service
public class FBOps implements Operations {
    private final Logger logger = LoggerFactory.getLogger(FBOps.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private FIDAService fidaService;

    @Value("${fb.scrapper.url}")
    private String fbScrapperUrl;

    public FBOps(FIDAService fidaService) {
        this.fidaService = fidaService;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void runSearch(String query) {
        logger.info("Running search query: " + query);

        String url = String.format("https://duckduckgo.com/html/?q=site:facebook.com \"%s\"", query);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Document doc = Jsoup.connect(url).get();
            if (doc.getElementById("links").getElementsByClass("results_links") != null) {
                Elements results = doc.getElementById("links").getElementsByClass("results_links");

                for (Element result : results.stream().limit(RESULT_LIMIT).toList()) {
                    Element page = result.getElementsByClass("links_main").first().getElementsByTag("a").first();

                    String fbUrl = page.attr("href");
                    logger.info("FB URL: " + fbUrl);

                    try {
                        // send http request to python flask process
                        // creates payload
                        //"{\"link\":\"https://www.facebook.com/mr.pallab.ghosh/\"}"
                        String payload = String.format("{\"link\":\"%s\"}", checkAndFixUrl(fbUrl));

                        // creates a request
                        HttpEntity<String> request = new HttpEntity<>(payload, headers);
                        // sends a request
                        ResponseEntity<String> response = restTemplate.postForEntity(fbScrapperUrl, request , String.class);
                        FBPerson fbPerson = objectMapper.readValue(response.getBody(), FBPerson.class);

                        logger.info("scrapper result: " + response.getBody());
                        // create first, last name from the query
                        if(FBPerson.isNotBlank(fbPerson, 5)) {
                            fidaService.create(Utilities.fromFrom(fbPerson, query));
                        }

                    } catch (Throwable e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public List<FBPersonDMO> getAllPersons() {
        return fidaService.findAll();
    }
}
