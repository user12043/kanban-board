package ogr.user12043.kanban12043.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by user12043 on 04.07.2018 - 18:55
 * Part of project: kanban12043
 */
public class Properties {
    private static final Logger logger = LogManager.getLogger(Properties.class);

    public Properties() {
        initializeProperties();
    }

    // Read properties from file
    private void initializeProperties() {
        try {
            String fileContent = Utils.readFile(Constants.settingsFileName);
            JSONObject jsonObject = new JSONObject(fileContent);
            if (fileContent.contains("\"" + Constants.args_languageArgumentName + "\":")) {
                lang = jsonObject.getString(Constants.args_languageArgumentName);
            }
        } catch (JSONException | IOException e) {
            logger.warn("Failed to read configuration file (\"" + Constants.settingsFileName + "\")! Using default settings");
        }
    }

    public static String lang = "en-US";
}
