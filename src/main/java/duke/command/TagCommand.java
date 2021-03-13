package duke.command;

public class TagCommand extends Command {
    private int index;

    /**
     * @param s The tag content
     */
    public TagCommand(int i, String s) {
        this.type = "tag";
        this.content = s;
        this.index = i;
    }

    /**
     * @return the index which needs to be tagged
     */
    public int getIndex() {
        return index;
    }

}
