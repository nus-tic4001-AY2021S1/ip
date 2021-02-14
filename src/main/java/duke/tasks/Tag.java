package duke.tasks;

import java.util.ArrayList;

public abstract class Tag {

    private static String tagDiv = "/div/";

    protected ArrayList<String> tags = new ArrayList<>();

    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * @return return the tag divider
     */
    public static String getTagDiv() {
        return tagDiv;
    }

    /**
     * @return return true if tag exists
     */
    public boolean existTags() {
        if (tags.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * @param s the tag
     */
    public void addTag(String s) {
        if (s.charAt(0) != '#') {
            tags.add('#' + s );
        } else {
            tags.add(s);
        }
    }

    /**
     * @param s the tag
     * @return true if remove successfully, else false.
     */
    public boolean removeTag(String s) {
        if (tags.contains(s)) {
            tags.remove(tags.indexOf(s));
            return true;
        }
        return false;
    }

    /**
     * @param i the index of the tag
     * @return true if successfully, else false
     */
    public boolean removeTag(int i) {
        if (i >= 0 && i < this.tags.size()) {
            tags.remove(i);
            return true;
        }
        return false;
    }

    /**
     * @return Output all the tags as a single string
     */
    public String printTags() {
        StringBuffer s = new StringBuffer();
        for (String tag : this.tags) {
            s.append(tag + System.lineSeparator());
        }
        return s.toString();
    }

    /**
     * @return return a string that contains all tags info and could be stored in file
     */
    public String toTagsString() {
        StringBuffer s = new StringBuffer();
        for (String tag : this.tags) {
            s.append(tag + tagDiv);
        }
        return s.toString();
    }
}
