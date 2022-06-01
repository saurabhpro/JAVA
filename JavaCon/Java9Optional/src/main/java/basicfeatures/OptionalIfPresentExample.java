/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package basicfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalIfPresentExample {
    private static final Logger LOG = LoggerFactory.getLogger(OptionalIfPresentExample.class);

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();

        if (gender.isPresent()) {
            LOG.info("Value available.");
        } else {
            LOG.info("Value not available.");
        }

        gender.ifPresent(g -> LOG.info("In gender Option, value available."));

        //condition failed, no output print
        emptyGender.ifPresent(g -> LOG.info("In emptyGender Option, value available."));

    }

}