package command;

public class DoneCommand extends Command {
    private int index;

    /**
     * @param i indext of the task that are going to be mark as done
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
