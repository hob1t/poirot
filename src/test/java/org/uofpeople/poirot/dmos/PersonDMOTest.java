package org.uofpeople.poirot.dmos;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.uofpeople.poirot.TestUtils.*;

class PersonDMOTest {

    private LIPersonDMO personDMO;

    @BeforeEach
    void setUp() {
        personDMO = new LIPersonDMO();
    }

    @Test
    void getId() {
        String id = UUID.randomUUID().toString();
        personDMO.setId(id);
        assertEquals(id, personDMO.getId());
    }

    @Test
    void getFirstName() {
        String firstName = RandomStringUtils.randomAlphabetic(STR_LEN);
        personDMO.setFirstName(firstName);
        assertEquals(firstName, personDMO.getFirstName());
    }

    @Test
    void getLastName() {
        String lastName = RandomStringUtils.randomAlphabetic(STR_LEN);
        personDMO.setLastName(lastName);
        assertEquals(lastName, personDMO.getLastName());
    }

    @Test
    void getEmail() {
        String email = createEmail();
        personDMO.setEmail(email);
        assertEquals(email, personDMO.getEmail());
    }

    @Test
    void getPhone() {
        String phone = generatePhoneNumber();
        personDMO.setPhone(phone);
        assertEquals(phone, personDMO.getPhone());
    }

    @Test
    void getConnection() {
        personDMO.setConnection(STR_LEN);
        assertEquals(STR_LEN, personDMO.getConnection());
    }

    @Test
    void getLocation() {
        String location = "Greater Los Angeles Area";
        personDMO.setLocation(location);
        assertEquals(location, personDMO.getLocation());
    }

    @Test
    void getAlumni() {
        List<String> alumni = new ArrayList<>();
        alumni.add("Boston University");

        personDMO.setAlumni(alumni);
        assertEquals(alumni, personDMO.getAlumni());
    }

    @Test
    void getPhotoUrl() {
        String photoUrl = "https://media.licdn.com/dms/image/v2/C4E03AQFzcFq29PMm_A/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1516324484040?e=2147483647&v=beta&t=Jfh0Qi-kW6cuENjAJgd5Kv4nh9C_JU0YTFxMAuIm7e8";
        personDMO.setPhotoUrl(photoUrl);
        assertEquals(photoUrl, personDMO.getPhotoUrl());
    }

    @Test
    void getLinkedInURL() {
        String linkedInURL = "https://www.linkedin.com/in/ashleyhume";
        personDMO.setLinkedInURL(linkedInURL);
        assertEquals(linkedInURL, personDMO.getLinkedInURL());
    }

    @Test
    void testToString() {
        personDMO = createPersonDMO();
        assertNotNull(personDMO.toString());
    }
}