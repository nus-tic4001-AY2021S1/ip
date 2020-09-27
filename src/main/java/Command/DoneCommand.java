package Command;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(String i) {
        type = "done";
        content = "";
        index = Integer.parseInt(i);
    }

    public int getIndex(){
        return index;
    }

}
