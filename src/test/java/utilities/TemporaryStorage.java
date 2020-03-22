package utilities;

import java.util.HashMap;
import java.util.Map;

public class TemporaryStorage{

    private static Map<String, String> data = new HashMap<> ();

    public static void addData( String key , String value ) {

        data.put (key , value);

    }

    public static String getData( String key ) {

        return data.get (key);
    }
    public static void clearData() {

       data.clear ();
    }


}