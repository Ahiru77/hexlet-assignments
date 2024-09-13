package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String tag1;
    private TagInterface tag2;
    LabelTag(String tag1, TagInterface tag2) {
        this.tag1 = tag1;
        this.tag2 = tag2;
    }
    @Override
    public String render() {
        return "<label>" + tag1 + tag2.render() + "</label>";
    }
}
// END
