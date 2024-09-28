package org.uofpeople.poirot.commons;

import org.uofpeople.poirot.dmos.PersonDMO;
import org.uofpeople.poirot.pojos.Graph;
import org.uofpeople.poirot.pojos.LinkedInPerson;

import java.util.ArrayList;
import java.util.List;


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
     * @return a {@link PersonDMO}
     */
    public static PersonDMO buildFrom(Graph linkedInPerson, String liUrl) {
        PersonDMO personDMO = new PersonDMO();

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
}
