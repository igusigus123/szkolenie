package pl.jsystems.szkolenie.szkolenieApi.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ApiConfig {
    private static final Config CONFIG = ConfigFactory.load("szkolenieapiconfig.conf");
    private static final String ENVIRONMENT = CONFIG.getString("environment");
    private static final Config ENV = CONFIG.getConfig("environments").getConfig(ENVIRONMENT);

    public static final String BASE_URL = ENV.getString("baseUrl");
    public static final String AZURE_URL = ENV.getString("azureUrl");
    public static final String API_KEY = ENV.getString("apikey");
}
