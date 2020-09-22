package org.autodatacorp.vindescription.storm.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

    private Properties properties = new Properties();

    private InputStream is;

    public ConfigUtils() throws IOException {
        is=getClass().getClassLoader().getResourceAsStream("lnoc-dvcp-filter.properties");

        properties.load(is);

    }

    public Properties getProperties() {
        return properties;
    }
}
