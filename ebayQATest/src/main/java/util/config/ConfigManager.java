package util.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.constants.Constants;

import java.io.File;

public class ConfigManager {
   static Config config;
    static Config uiConfig;
    static Config apiConfig;
    private static String CONFIG_FILE = "src/main/resources/config/application.conf";
    public static Logger LOGGER = LoggerFactory.getLogger(ConfigManager.class);

    static{
        LOGGER.info("Default config file is loading "+CONFIG_FILE);
        config = ConfigFactory.parseFile(new File(CONFIG_FILE));
       // config = ConfigFactory.load(CONFIG_FILE);
    }


    public static Config getUiConfig(){
        uiConfig = config.getConfig(Constants.UI);
        LOGGER.info("Ui Configuration is loaded ..."+uiConfig.toString());
        return uiConfig;
    }

    public static Config getApiConfig(){
        apiConfig = config.getConfig(Constants.API);
        LOGGER.info("Api Configuration is loaded ..."+apiConfig.toString());
        return apiConfig;
    }
}
