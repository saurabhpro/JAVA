/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package basicfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalMapFlatMapExample {
    private static final Logger LOG = LoggerFactory.getLogger(OptionalMapFlatMapExample.class);

    public static void main(String[] args) {

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        LOG.info("Non-Empty Optional:: {}", nonEmptyGender.map(String::toUpperCase));
        LOG.info("Empty Optional    :: {}", emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        LOG.info("Optional value   :: {}", nonEmptyOptionalGender);
        LOG.info("Optional.map     :: {}", nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        LOG.info("Optional.flatMap :: {}", nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

    }

}