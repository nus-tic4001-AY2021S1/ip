package Command;

public class TodoCommand extends Command{
    public TodoCommand(String content) {
        type = "todo";
        this.content = content;
    }
}
