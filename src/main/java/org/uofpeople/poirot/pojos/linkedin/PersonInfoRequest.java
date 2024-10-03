package org.uofpeople.poirot.pojos.linkedin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonInfoRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String location;
}
