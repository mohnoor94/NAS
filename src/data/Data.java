package data;

import java.util.HashMap;

/**
 * Store some data for later uses
 *
 * @author AbuKhleif
 */
public class Data {
    private static HashMap<String, String> data = new HashMap<String, String>();
    private static HashMap<String, String> userData = new HashMap<String, String>();

    public static HashMap<String, String> getData() {
        return data;
    }

    public static HashMap<String, String> getUserData() {
        return userData;
    }
}
