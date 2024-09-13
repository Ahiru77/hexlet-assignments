package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage {
    // Map<String, String> map;
    private Map<String, String> map = new HashMap<>();

    InMemoryKV(Map<String,String> map) {
        this.map.putAll(map);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }
    @Override
    public void unset(String key) {
        map.remove(key);
    }
    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
// END