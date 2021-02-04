package duke.tasks;

import java.util.ArrayList;

public abstract class tag {
    protected ArrayList<String> tags = new ArrayList<>();

    public ArrayList<String> getTags() {
        return tags;
    }

    protected boolean existTags() {
        if (!tags.isEmpty()) {
            return true;
        }
        return false;
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
}
