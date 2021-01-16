package duke.command;

public class TodoCommand extends Command {
    /**
     * @param content the content to create an todo command
     */
    public TodoCommand(String content) {
        type = "todo";
        this.content = content;
    }

}
