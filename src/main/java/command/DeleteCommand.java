package command;

public class DeleteCommand extends Command {
    private int index;

    /**
     * @param i index of the task that are going to delete
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
