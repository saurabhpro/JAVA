package java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class FlatMapOptional {
    private static final Logger LOG = LoggerFactory.getLogger(FlatMapOptional.class);

    public static void main(String[] args) {
        var value = Optional.of("String")
                .map(s -> Optional.of(s).map(String::toUpperCase));

        LOG.info(value.toString());


        var value2 = Optional.of("String")
                .flatMap(s -> Optional.of(s).map(String::toUpperCase));
        LOG.info(value2.toString());
    }
}
