package org.uofpeople.poirot;

import org.apache.commons.lang3.RandomStringUtils;
import org.uofpeople.poirot.dmos.LIPersonDMO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public final class TestUtils {
    private TestUtils() {}

    public static final int STR_LEN = 10;

    /**
     * Generates a random phone number
     *
     * @return randomly generated phone number
     */
    public static String generatePhoneNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(RandomStringUtils.randomNumeric(3));
        sb.append(")");

        sb.append(RandomStringUtils.randomNumeric(7));
        return sb.toString();
    }

    /**
     * Creates random email address.
     *
     * @return randomly created email address.
     */
    public static String createEmail() {
        return RandomStringUtils.randomAlphabetic(STR_LEN) + "@" +
                RandomStringUtils.randomAlphabetic(STR_LEN) + "." + RandomStringUtils.randomAlphabetic(STR_LEN / 3);

    }

    /**
     * Creates a PersonDTO
     *
     * @return randomly created {@link LIPersonDMO}
     */
    public static LIPersonDMO createPersonDMO() {
        LIPersonDMO personDMO = new LIPersonDMO();
        personDMO.setFirstName(RandomStringUtils.randomAlphabetic(STR_LEN));
        personDMO.setLastName(RandomStringUtils.randomAlphabetic(STR_LEN));
        personDMO.setEmail(createEmail());
        personDMO.setId(UUID.randomUUID().toString());
        personDMO.setAlumni(new ArrayList<>());
        personDMO.setPhone(generatePhoneNumber());
        personDMO.setLocation(RandomStringUtils.randomAlphabetic(STR_LEN));
        return personDMO;
    }

    public static String createRandomString() {
        return "http://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".html";
    }

    public static List<String> createLinkList() {
        List<String> linkList = new ArrayList<>();
        IntStream.range(0, STR_LEN).forEach(i -> {
            linkList.add(createRandomString());
        });
        return linkList;
    }
}
