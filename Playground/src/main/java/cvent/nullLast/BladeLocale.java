package cvent.nullLast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize
@JsonDeserialize(as = ImmutableBladeLocale.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
/**
  Represent locales for a particular blade maintained in static json
 */
public interface BladeLocale {

    /**
     * @return the locale code, eg zh-CHT
     */
    String getLocaleId();

    /**
     * @return the locale name in respective language, eg '中文（繁體' for Chinese (Traditional)
     */
    String getLocaleName();

    /**
     * @return the locale country name in english language, eg. Chinese (Traditional)
     */
    String getLanguageCountry();

    /**
     * @return the order on which the particular locale will be displayed.
     * In case of null that locale will appear on the last
     */
    Integer getSortOrder();

}