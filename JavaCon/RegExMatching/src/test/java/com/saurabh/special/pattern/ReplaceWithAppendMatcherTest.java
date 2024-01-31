package com.saurabh.special.pattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.saurabh.special.pattern.ReplaceWithAppendMatcher.enrich;
import static java.time.LocalDate.now;
import static java.util.Currency.getInstance;
import static java.util.Locale.UK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReplaceWithAppendMatcherTest {

    @ParameterizedTest
    @CsvSource({
        "YYMMdd",
        "YYYYMMdd",
        "ddMMYY",
        "ddMMYYYY",
        "dd-MM-YYYY",
        "dd/MM/YYYY",
        "YYYY-MM-dd",
        "MM/dd",
        "dd/MM",
        "dd-MM"
    })
    void add_only_date_to_ref(String dateFormat) {
        // given
        var ref = "FXN${" + dateFormat + "}";
        var today = now();

        // when
        var resultRef = enrich(ref, today, getInstance(UK));

        // then
        assertThat(resultRef).isEqualTo("FXN" + DateTimeFormatter.ofPattern(dateFormat).format(today));
    }

    @Test
    void add_only_currency_to_ref() {
        // given
        var ref = "FXN_${CCY}_STH";
        var today = now();

        // when
        var resultRef = enrich(ref, today, getInstance(UK));

        // then
        assertThat(resultRef).isEqualTo("FXN_GBP_STH");
    }

    @Test
    void enrich_settlement_ref() {
        // given
        var ref = "FXN_${YYYYMMdd}_${CCY}_STH";
        var date = LocalDate.parse("2023-12-15");

        // when
        var resultRef = enrich(ref, date, getInstance(UK));

        // then
        assertThat(resultRef).isEqualTo("FXN_20231215_GBP_STH");
    }

    @Test
    void enrich_settlement_ref_with_multiple_date_formats() {
        // given
        var ref = "FXN_${YYYYMMdd}_${YYYY-MM-dd}_STH-${ddMMYY}_${YYYY-MM-dd}";
        var date = LocalDate.parse("2023-12-15");

        // when
        var resultRef = enrich(ref, date, getInstance(UK));

        // then
        assertThat(resultRef).isEqualTo("FXN_20231215_2023-12-15_STH-151223_2023-12-15");
    }

    @Test
    void enrich_settlement_ref_with_multiple_currency_place_holders() {
        // given
        var ref = "FXN_${CCY}_STH_${CCY}";

        // when
        var resultRef = enrich(ref, now(), getInstance(UK));

        // then
        assertThat(resultRef).isEqualTo("FXN_GBP_STH_GBP");
    }

    @Test
    void not_enrich_null_settlement_ref() {
        // when / then
        assertThatThrownBy(() -> enrich(null, now(), getInstance(UK)))
            .hasMessage("Required 'settlementRef' is missing");
    }

    @Test
    void does_not_fail_if_settlement_ref_was_empty() {
        // given
        var settlementRef = "";

        // when
        var actual = enrich(settlementRef, now(), getInstance(UK));

        // then
        assertThat(actual).isEmpty();
    }
}