package duke.command;

public class DeleteCommand extends Command {
    private int index;

    /**
     * @param i the index
     */
    public DeleteCommand(String i) {
        type = "delete";
        content = "";
        index = Integer.parseInt(i);
    }

    public int getIndex() {
        return index;
    }
}
