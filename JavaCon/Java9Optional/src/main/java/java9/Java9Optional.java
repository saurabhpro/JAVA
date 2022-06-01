/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9Optional {

    private static final Logger LOG = LoggerFactory.getLogger(Java9Optional.class);

    public static void main(String[] args) {

        LOG.info("--- stream() ---");
        try {
            final var collect = getStreamOptional().map(Optional::get).collect(Collectors.toList());
            LOG.info(collect.toString());
        } catch (NoSuchElementException e) {
            LOG.error("calling collect on empty optional throws", e.fillInStackTrace());
        }

        List<Optional<String>> strings = getStreamOptional()
                .filter(Optional::isPresent)
                .collect(Collectors.toList());

        LOG.info("map {}", strings);

        List<String> newStrings = getStreamOptional()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        LOG.info("flatMap {}", newStrings);

        LOG.info("--- ifPresent()/isPresent()/orElse() ---");
        Optional<Integer> result1 = Optional.of(42);
        result1.ifPresent(x -> LOG.info("Result = {}", x));

        Optional<Integer> result2 = Optional.empty();
        result2.ifPresent(x -> LOG.info("Result = {}", x));

        //noinspection ConstantConditions
        if (result2.isPresent())
            LOG.info("Result = {}", result2.get());
        else
            LOG.info("return {}: Result not found.", result2.orElse(-1));

        LOG.info("--- If PresentOrElse (Consumer, Runnable) ---");
        Optional<Integer> result3 = getOptionalEmpty();
        result3.ifPresentOrElse(x -> LOG.info("Result = {}", x),
                () -> LOG.info("return {}: Result not found.", result2.orElse(-1)));

        LOG.info("--- or() ---");
        //noinspection Convert2MethodRef
        Optional<Integer> result = getOptionalEmpty()
                .or(() -> getAnotherOptionalEmpty())
                .or(() -> getOptionalNormal())
                .or(() -> getAnotherOptionalNormal());
        LOG.info("{}", result);
    }

    private static Optional<Integer> getOptionalNormal() {
        return Optional.of(42);
    }

    private static Optional<Integer> getAnotherOptionalNormal() {
        return Optional.of(99);
    }

    private static Optional<Integer> getOptionalEmpty() {
        return Optional.empty();
    }

    private static Optional<Integer> getAnotherOptionalEmpty() {
        return Optional.empty();
    }

    private static Stream<Optional<String>> getStreamOptional() {
        return Stream.of(Optional.empty(), Optional.of("one"), Optional.of("two"), Optional.of("three"));
    }
}