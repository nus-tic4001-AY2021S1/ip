package duke.command;

public class DoneCommand extends Command {
    private int index;

    /**
     * @param i the index
     */
    public DoneCommand(String i) {
        type = "done";
        content = "";
        index = Integer.parseInt(i);
    }

    public int getIndex() {
        return index;
    }

}
