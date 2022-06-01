/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package basicfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalFilterExample {
    private static final Logger LOG = LoggerFactory.getLogger(OptionalFilterExample.class);

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        //Filter on Optional
        LOG.info("{}", gender.filter(g -> g.equals("male"))); //Optional.empty
        LOG.info("{}", gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        LOG.info("{}", emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty

    }

}