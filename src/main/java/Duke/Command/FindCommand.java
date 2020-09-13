package Duke.Command;

public class FindCommand extends Command {

    public FindCommand(String keyword) {
        type = "find";
        this.content = keyword;
    }
}
