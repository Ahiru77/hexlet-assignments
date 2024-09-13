package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App{
    public static void swapKeyValue(KeyValueStorage map) {
        var data = map.toMap();
        for (String key : data.keySet()) {
//        for (Map.Entry<String, String> ent: data.entrySet()) {
            map.set(map.get(key, "default"), key);
            map.unset(key);
        }
    }
}
// END
