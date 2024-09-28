package org.uofpeople.poirot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uofpeople.poirot.controllers.LinkedInOps;
import org.uofpeople.poirot.pojos.PersonInfoRequest;

/**
 *
 * DDG curl command example
 *
 * curl 'https://duckduckgo.com/?q=site%3Alinkedin.com+%22Jon+Snow%22&t=newext&atb=v300-1'
 * --compressed -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:130.0) Gecko/20100101 Firefox/130.0'
 * -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/png,image/svg+xml,
 *
 */
@RestController
public class PersonInformationFetcher {
    private Logger logger = LoggerFactory.getLogger(PersonInformationFetcher.class);

    private LinkedInOps ops;

    public PersonInformationFetcher(LinkedInOps ops) {
        this.ops = ops;
    }


    @PostMapping("/linkedin/persons")
    public void gatherInformationLinkedIn(@RequestBody PersonInfoRequest personInfoRequest) {
        logger.info("Fetching person information from linkedin {}", personInfoRequest);
        ops.runSearch(personInfoRequest.getFirstName() + " " + personInfoRequest.getLastName());
    }

    @PostMapping("/facebook/persons")
    public void gatherInformationFacebook(@RequestBody PersonInfoRequest personInfoRequest) {
        logger.info("Fetching person information from facebook {}", personInfoRequest);
        ops.runSearch(personInfoRequest.getFirstName() + " " + personInfoRequest.getLastName());
    }
}
