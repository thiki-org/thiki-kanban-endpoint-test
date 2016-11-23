package org.thiki.kanban.web.test.util;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Created by xubt on 11/23/16.
 */
public class PropertiesUtil {
    private static String propertiesFileAddress = "env/default/init.properties";

    private static TreeMap<String, String> treeMap;

    private static void loadProps() {
        Properties prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(propertiesFileAddress);
            prop.load(inputStream);
            inputStream.close();
            treeMap = new TreeMap<>((Map) prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String loadPropByName(String propName) {
        if (treeMap == null) {
            loadProps();
        }
        return treeMap.get(propName);
    }
}
