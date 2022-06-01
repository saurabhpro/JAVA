/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package basicfeatures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalBasicExample {
    private static final Logger LOG = LoggerFactory.getLogger(OptionalBasicExample.class);

    public static void main(String[] args) {

        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        LOG.info("Non-Empty Optional:{}", gender);
        LOG.info("Non-Empty Optional: Gender value : {}", gender.get());
        LOG.info("Empty Optional: {}", Optional.empty());

        LOG.info("ofNullable on Non-Empty Optional: {}", Optional.ofNullable(answer1));
        LOG.info("ofNullable on Empty Optional: {}", Optional.ofNullable(answer2));
    }

    public static void optionalOfNullArgument() {
        String answer2 = null;

        // java.lang.NullPointerException
        LOG.info("ofNullable on Non-Empty Optional: {}", Optional.of(answer2));
        // so use Optional.ofNullable() whenever you can
    }

}