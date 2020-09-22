package org.autodatacorp.vindescription.common;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Util {

    public Util() { }

    private static final String  stringReplaceAnySpaces = "\\s+";

    public static String getEnvironmentProperty(String propertyName) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(propertyName);
    }

    public static List<String> stringToList(String stringToBeConverted){

        List<String> convertedList = new ArrayList<>();
        String replaceAll = stringToBeConverted.replaceAll(stringReplaceAnySpaces,"");
        convertedList.addAll(asList(replaceAll.split(",")));

        return convertedList;

    }
}
