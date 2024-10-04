package org.uofpeople.poirot.dmos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * "email":"j.salhani@gmail.com", "following":"113 ", "location":null, "page_category":"Journalist",
 * "page_followers":"1.4K ", "page_likes":null, "page_name":"Justin Salhani", "page_rate":null,
 * "page_review_number":null, "page_website":"http://justinsalhani.com", "phone_number":null,
 */
@Data
@Document(collection = "facebook")
public class FBPersonDMO {
  @Id private String id;

  private String firstName;
  private String lastName;

  private String email;
  private String phone;

  private String profession;
  private String personalWebPageURL;

  private int followers;
  private int following;

  private String location;
}
