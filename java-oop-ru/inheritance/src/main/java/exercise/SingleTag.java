package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    private String name;
    private Map<String, String> map;

    SingleTag (String name, Map<String, String> map) {
        this.name = name;
        // this.map.putAll(map);
        this.map = map;
    }

    @Override
    public String toString() {
        String text = "";
        for (String key : map.keySet()) {
            text = text + key + "=" + "\"" + map.get(key) + "\"" + " ";
        }
        if (text.isEmpty()) {
            return "<" + name + ">";
        }
        return "<" + name + " " + text.trim() + ">";
    }
}
// END
