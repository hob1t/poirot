package org.uofpeople.poirot.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static org.uofpeople.poirot.commons.Constants.RESULT_LIMIT;

/**
 * Represents FB operations
 */
@Service
public class FBOps implements Operations {
    private final Logger logger = LoggerFactory.getLogger(FBOps.class);


    @Override
    public void runSearch(String query) {
        logger.info("Running search query: " + query);

        String url = String.format("https://duckduckgo.com/html/?q=site:facebook.com \"%s\"", query);

        try {
            Document doc = Jsoup.connect(url).get();
            if(doc.getElementById("links").getElementsByClass("results_links") != null) {
                Elements results = doc.getElementById("links").getElementsByClass("results_links");

                for (Element result : results.stream().limit(RESULT_LIMIT).toList()) {
                    Element page = result.getElementsByClass("links_main").first().getElementsByTag("a").first();

                    String fbUrl = page.attr("href") + "about";
                    logger.info("FB URL: " + fbUrl);

                    try {
                        Document fbDoc = Jsoup.connect(fbUrl).get();

                        Document new_doc = Jsoup.parse(fbDoc.outerHtml());
                        Elements elements = new_doc.select("p");
                        for (Element aa : elements) {
                            logger.info(aa.data());
                        }

                        logger.info("FB URL: " + fbDoc.title());
                        logger.info("FB text: " + fbDoc.text());

                    } catch (IOException e) {
                       logger.error(e.getMessage());
                    }
                }
            }


                } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
