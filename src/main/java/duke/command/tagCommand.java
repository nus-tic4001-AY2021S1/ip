package duke.command;

public class tagCommand extends Command {
    private int index;

    /**
     * @param s The tag content
     */
    public tagCommand(int i, String s) {
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
