package org.uofpeople.poirot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uofpeople.poirot.services.FIDAService;
import org.uofpeople.poirot.services.LIDAService;

@RestController
public class AdminController {
  private Logger logger = LoggerFactory.getLogger(AdminController.class);

  private FIDAService fidaService;
  private LIDAService lidaService;

  public AdminController(FIDAService fidaService, LIDAService lidaService) {
    this.fidaService = fidaService;
    this.lidaService = lidaService;
  }

  @DeleteMapping("/linkedin/persons")
  public ResponseEntity<String> deleteLinkedInPersons() {
    logger.info("Got delete linkedIn persons request");
    lidaService.deleteAll();
    return new ResponseEntity<>("LI documents deleted", HttpStatus.OK);
  }

  @DeleteMapping("/facebook/persons")
  public ResponseEntity<String> deleteFacebookPersons() {
    logger.info("Got delete facebook persons request");
    fidaService.deleteAll();
    return new ResponseEntity<>("FB documents deleted", HttpStatus.OK);
  }
}
