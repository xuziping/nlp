package com.xuzp.util;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberRangeUtil {


    public static Set<String> getValidValues(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        return Arrays.stream(value.split(",")).filter(StringUtils::isNotEmpty).map(String::trim)
                .filter(NumberRangeUtil::isValidate).collect(Collectors.toSet());
    }

    public static boolean isValidInput(String value) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        return Arrays.stream(value.split(",")).filter(StringUtils::isNotEmpty).map(String::trim)
                .allMatch(NumberRangeUtil::isValidate);
    }

    private static boolean isValidate(String value) {
        return ValidateUtils.PositiveNumber(value) || ValidateUtils.isValidRange(value);
    }

}
