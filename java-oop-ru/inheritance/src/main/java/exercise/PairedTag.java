package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String name;
    private Map<String, String> map;
    private String body;
    private List<Tag> childs;

    PairedTag (String name, Map<String, String> map, String body, List<Tag> childs) {
        this.name = name;
        // this.map.putAll(map);
        this.map = map;
        this.body = body;
        this.childs = childs;
    }
    @Override
    public String toString() {
        String str = childs.stream().map(e -> e.toString()).collect(Collectors.joining("", "", ""));

        String text = "";
        for (String key : map.keySet()) {
            text = text + key + "=" + "\"" + map.get(key) + "\"" + " ";
        }
        if (text.isEmpty()) {
            return "<" + name + ">" + "</" + name + ">";
        }

        return "<" + name + " " + text.trim() + ">" + body + str + "</" + name + ">";
    }
}
// END
