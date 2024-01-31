package com.saurabh.special.pattern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNull;

public class ReplaceWithAppendMatcher {

    private ReplaceWithAppendMatcher() {
    }

    private static final Pattern DATE_PATTERN = Pattern.compile("\\$\\{([YMd\\-_/]{1,10})}");
    private static final String CURRENCY_PATTERN = "${CCY}";

    public static String enrich(String settlementRef, LocalDate date, Currency currency) {
        requireNonNull(settlementRef, "Required 'settlementRef' is missing");
        return addCurrency(addDate(settlementRef, date), currency);
    }

    private static String addCurrency(String settlementRef, Currency currency) {
        return settlementRef.replace(CURRENCY_PATTERN, currency.getCurrencyCode());
    }

    private static String addDate(String settlementRef, LocalDate date) {
        final var matcher = DATE_PATTERN.matcher(settlementRef);

        final var result = new StringBuilder();
        while (matcher.find()) {
            final var dateFormat = matcher.group(1);
            final var replacement = date.format(DateTimeFormatter.ofPattern(dateFormat));
            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result);
        return result.toString();
    }
}
