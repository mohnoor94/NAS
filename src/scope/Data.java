package scope;

import java.util.HashMap;

/**
 * Created by mkhlif on 6/21/17.
 */
public class Data {
    private static HashMap<String, String> data = new HashMap<String, String>();

    public static HashMap<String, String> getData() {
        return data;
    }
}
