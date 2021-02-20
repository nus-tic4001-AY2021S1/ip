package duke.command;

/**
 * A command which user has key in wrong command line.
 */
public class InvalidCommand extends Command {

    public InvalidCommand() {
    }

    @Override
    public String execute() {
        return "<<Invalid Command. Please refer to --help>>";
    }
}
