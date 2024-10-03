package org.uofpeople.poirot.commons;

import org.apache.commons.lang3.math.NumberUtils;
import org.uofpeople.poirot.dmos.FBPersonDMO;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.pojos.facebook.FBPerson;
import org.uofpeople.poirot.pojos.linkedin.Graph;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.uofpeople.poirot.commons.Constants.NONE;


/**
 * Contains common functions.
 */
public final class Utilities {
    private Utilities() {}

    /**
     * Creates Person DMO from the {@link Graph}
     *
     * @param linkedInPerson
     *
     * @return a {@link LIPersonDMO}
     */
    public static LIPersonDMO buildFrom(Graph linkedInPerson, String liUrl) {
        LIPersonDMO personDMO = new LIPersonDMO();

        if(linkedInPerson.getAlumniOf() != null) {
            List<String> alumni = new ArrayList<>();

            if(linkedInPerson.getAlumniOf().stream().filter(al -> al != null).findFirst().isPresent()) {
                alumni.add(linkedInPerson.getAlumniOf().stream().filter(al -> al != null).findFirst().get().getName());
                personDMO.setAlumni(alumni);
            }
        }

        personDMO.setFirstName(linkedInPerson.getName().split(" ")[0].trim());
        personDMO.setLastName(linkedInPerson.getName().split(" ")[1].trim().replace(",", ""));

        if(linkedInPerson.getAddress() != null) {
            personDMO.setLocation(linkedInPerson.getAddress().getAddressLocality());
        }

        if(linkedInPerson.getImage() != null) {
            personDMO.setPhotoUrl(linkedInPerson.getImage().getContentUrl());
        }

        if(liUrl != null && !liUrl.isEmpty()) {
            personDMO.setLinkedInURL(liUrl);
        }

        return personDMO;
    }

    public static String checkAndFixUrl(String url) {
        if(url.contains("%20")) {
            return URLDecoder.decode(url, Charset.defaultCharset());
        }
        return url;
    }

    /**
     * Create {@link FBPersonDMO} object
     *
     * @param person
     * @param query
     *
     * @return
     */
    public static FBPersonDMO fromFrom(FBPerson person, String query) {
        FBPersonDMO dmo = new FBPersonDMO();

        String[] firstAndLastName = query.split(" ");
        dmo.setFirstName(firstAndLastName[0]);
        dmo.setLastName(firstAndLastName[1]);

        if(person.getLocation()!= null && !person.getLocation().equals(NONE)) {
            dmo.setLocation(person.getLocation());
        }

        if(person.getEmail() != null && !person.getEmail().equals(NONE)) {
            dmo.setEmail(person.getEmail());
        }

        if(person.getPhoneNumber()!= null && !person.getPhoneNumber().equals(NONE)) {
            dmo.setPhone(person.getPhoneNumber());
        }

        if(person.getPageWebsite()!= null && !person.getPageWebsite().equals(NONE)) {
            dmo.setPersonalWebPageURL(person.getPageWebsite());
        }

        if(person.getPageCategory()!= null && !person.getPageCategory().equals(NONE)) {
            dmo.setProfession(person.getPageCategory());
        }

        if(person.getPageFollowers() != null && !person.getPageFollowers().trim().equals(NONE)) {
            String followers = person.getPageFollowers().trim();
            dmo.setFollowers(checkAndParseInt(followers));
        }

        if(person.getFollowing() != null && !person.getFollowing().trim().equals(NONE)) {
            String following = person.getFollowing().trim();
            dmo.setFollowers(checkAndParseInt(following));
        }

        return dmo;
    }

    /**
     * Checks if a String is number and return appropriate number.
     *
     * @param input may be 3.1M, 30k etc.
     *
     * @return
     */
    private static Integer checkAndParseInt(String input) {
        if(NumberUtils.isDigits(input)) {
            return Integer.valueOf(input);
        } else {
            String toBe = input.trim().toLowerCase();
            if(toBe.contains("k")) {
                toBe = toBe.replace("k","");
                if(checkAndParseFloat(toBe) != null) {
                    return checkAndParseFloat(toBe) * 1000;
                }

                return (Integer.valueOf(toBe) * 1000);
            }

            if(toBe.contains("m")) {
                toBe = toBe.replace("m","");
                if(checkAndParseFloat(toBe) != null) {
                    return checkAndParseFloat(toBe) * 1000000;
                }
                return (Integer.valueOf(toBe) * 1000000);
            }
        }
        return -1;
    }

    /**
     * Converts float/double into rounded int.
     *
     * @param input
     * @return
     */
    private static Integer checkAndParseFloat(String input) {
        if(input.contains(".")) {
            return Math.round(Float.parseFloat(input));
        }
        return null;
    }
}
