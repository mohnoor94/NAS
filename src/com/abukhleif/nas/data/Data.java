package com.abukhleif.nas.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Store some com.abukhleif.nas.data for later uses
 *
 * @author AbuKhleif
 */
public class Data {
    private static Map<String, String> data;
    private static Map<String, String> userData;
    private static Map<String, Boolean> scenariosStatus;

    public static Map<String, String> getData() {
        if (data == null) {
            data = new HashMap<>();
        }
        return data;
    }

    public static Map<String, String> getUserData() {
        if (userData == null) {
            userData = new HashMap<>();
        }
        return userData;
    }

    public static Map<String, Boolean> getScenariosStatus() {
        if (scenariosStatus == null){
            scenariosStatus = new HashMap<>();
        }
        return scenariosStatus;
    }
}
