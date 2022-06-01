/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package basicfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalOrElseExample {
    private static final Logger LOG = LoggerFactory.getLogger(OptionalOrElseExample.class);

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyGender = Optional.empty();


        LOG.info(gender.orElse("<N/A>")); //MALE
        LOG.info(emptyGender.orElse("<N/A>")); //<N/A>

        LOG.info(gender.orElseGet(() -> "<N/A>")); //MALE
        LOG.debug(emptyGender.orElseGet(() -> "<N/A>")); //<N/A>

        LOG.info(gender.orElseThrow(NullPointerException::new)); //MALE
        try {
            emptyGender.orElseThrow(() -> new NullPointerException());
        } catch (NullPointerException e) {
            LOG.warn("or else throw", e.fillInStackTrace());
        }
    }
}