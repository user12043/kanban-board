package ogr.user12043.kanban12043.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.List;

/**
 * Created by user12043 on 04.07.2018 - 19:19
 * Part of project: kanban12043
 */
public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    /**
     * Build the spring context
     */
    public static void buildContext() {
        try {
            Constants.context = new ClassPathXmlApplicationContext("application-context.xml");
        } catch (BeansException e) {
            logger.error("Error creating context", e);
            System.exit(1);
        }
    }

    /**
     * read whole file
     *
     * @param fileName Filename to read
     * @return file content
     * @throws IOException I/O error occurs
     */
    public static String readFile(String fileName) throws IOException {
        StringBuilder builder;
        try (FileReader reader = new FileReader(fileName)) {
            builder = new StringBuilder();
            while (reader.ready()) {
                builder.append((char) reader.read());
            }
        }
        return builder.toString();
    }


    /**
     * @return Current system locale
     */
    private static Locale getLocale() {
        if (Constants.locale == null) {
            Constants.locale = Locale.forLanguageTag(Properties.lang);
        }
        return Constants.locale;
    }

    private static ResourceBundle getLangResource() {
        //<editor-fold desc="Load resource if null" defaultstate="collapsed">
        if (Constants.langResourceBundle == null) {
            Constants.langResourceBundle = ResourceBundle.getBundle((Constants.languageDirectory + "/" + Constants.args_languageArgumentName), new ResourceBundle.Control() {
                @Override
                public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IOException {
                    String bundleName = toBundleName(baseName, getLocale());
                    String resourceName = toResourceName(bundleName, "properties");
                    ResourceBundle bundle = null;
                    InputStream stream = null;
                    if (reload) {
                        URL url = loader.getResource(resourceName);
                        if (url != null) {
                            URLConnection connection = url.openConnection();
                            if (connection != null) {
                                connection.setUseCaches(false);
                                stream = connection.getInputStream();
                            }
                        }
                    } else {
                        stream = loader.getResourceAsStream(resourceName);
                    }

                    if (stream != null) {
                        try {
                            bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                        } finally {
                            stream.close();
                        }
                    } else {
                        File file = new File(resourceName);
                        if (file.exists()) {
                            stream = new FileInputStream(file);
                            bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                            stream.close();
                        }
                    }
                    return bundle;
                }
            });
        }
        //</editor-fold>

        return Constants.langResourceBundle;
    }

    /**
     * Finds given key's string from language file. If key does not exists, returns "unnamed"
     *
     * @param key String's key
     * @return String
     */
    public static String getTag(String key) {
        String tag;
        try {
            tag = getLangResource().getString(key);
        } catch (Exception e) {
            logger.error("Can not get tag from lang resource for key: " + key);
            tag = Constants.defaultName;
        }
        return tag;
    }

    /**
     * Generates a table model with data for JTable from an entity. Entity fields must annotated
     * with @DisplayField annotation in order to get display names
     *
     * @param list        table data
     * @param entityClass display entity
     * @param <T>         entity type
     * @return generated table model
     */
    public static <T> DefaultTableModel generateTableModelFromList(List<T> list, Class entityClass) {
        DefaultTableModel tableModel = new DefaultTableModel(){
            // Make table non editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        final Field[] fields = entityClass.getDeclaredFields();
        List<Field> displayFields = new ArrayList<>();
        for (Field field : fields) {
            String name;
            final DisplayField annotation = field.getAnnotation(DisplayField.class);
            if (annotation != null) {
                if (!annotation.key().isEmpty()) {
                    name = Utils.getTag(annotation.key());
                } else {
                    name = annotation.value();
                }
                tableModel.addColumn(name);
                displayFields.add(field);
            }
        }
        for (T t : list) {
            Vector<Object> rowVector = new Vector<>();
            for (Field field : displayFields) {
                try {
                    rowVector.add(field.get(t));
                } catch (Exception e) {
                    logger.error("Can not get field value: " + field.getName());
                }
            }
            tableModel.addRow(rowVector);
        }

        return tableModel;
    }

    public static void errorDialog(Component parent, String message) {
        String[] options = new String[]{getTag("options.ok")};
        JOptionPane.showOptionDialog(parent, message, getTag("messages.error"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
    }
}
