package command;

public class TodoCommand extends Command {
    /**
     * @param content todo task description
     */
    public TodoCommand(String content) {
        type = "todo";
        this.content = content;
    }
}
