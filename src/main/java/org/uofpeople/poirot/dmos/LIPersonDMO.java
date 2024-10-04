package org.uofpeople.poirot.dmos;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a person information data model object
 *
 * <p>Location Alumni Image URL - for reverse search First Name Last Name Phone Email Follows - a
 * counter Connection # Works for LinkedIn URL
 */
@Data
@Document(collection = "linkedin")
public class LIPersonDMO {
  @Id private String id;

  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private int connection;
  private String location;
  private List<String> alumni;
  private String photoUrl;
  private String linkedInURL;
}
