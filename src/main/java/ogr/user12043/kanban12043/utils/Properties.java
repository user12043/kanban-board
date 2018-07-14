package ogr.user12043.kanban12043.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by user12043 on 04.07.2018 - 18:55
 * Part of project: kanban12043
 */
public class Properties {
    private static final Logger logger = LogManager.getLogger(Properties.class);
    //<editor-fold desc="Property fields" defaultstate="collapsed">
    public static String lang = "en-US";
    public static int theme = 1;
    //</editor-fold>

    // Read properties from file
    public static void initializeProperties() {
        try {
            String fileContent = Utils.readFile(Constants.settingsFileName);
            JSONObject jsonObject = new JSONObject(fileContent);
            if (jsonObject.has(Constants.args_languageArgumentName)) {
                lang = jsonObject.getString(Constants.args_languageArgumentName);
            }
            if (jsonObject.has(Constants.args_themeArgumentName)) {
                theme = jsonObject.getInt(Constants.args_themeArgumentName);
            }
        } catch (JSONException | IOException e) {
            logger.warn("Failed to read configuration file (\"" + Constants.settingsFileName + "\")! Using default settings");
        }
    }

    // Update properties
    public static void updateProperty(String key, Object value) {
        try {
            String fileContent = Utils.readFile(Constants.settingsFileName);
            JSONObject jsonObject = new JSONObject(fileContent);
            jsonObject.put(key, value);
            Writer writer = jsonObject.write(new FileWriter(Constants.settingsFileName), 2, 2);
            writer.close();

        } catch (IOException e) {
            logger.error("Failed to set update property: " + key);
        }
    }
}
