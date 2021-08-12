package command;


public class FindCommand extends Command {
    /**
     * @param keyword key word that used for the search
     */
    public FindCommand(String keyword) {
        type = "find";
        this.content = keyword;
    }
}
