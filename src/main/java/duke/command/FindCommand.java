package duke.command;

public class FindCommand extends Command {

    /**
     * @param keyword the command keyword
     */
    public FindCommand(String keyword) {
        type = "find";
        this.content = keyword;
    }
}
