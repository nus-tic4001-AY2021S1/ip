import command.DukeException;
import command.Switch;
import storage.Storage;


/**
 * This is a small bot program to allow user to record their tasks and save in a txt file
 *
 */
public class Duke {
    private Storage storage;

    public Duke(String filePath){
        storage = new Storage(filePath);

    }

    public void run() throws DukeException {
        //...
        Switch switchTasks = new Switch();
        switchTasks.option();
    }

    public static void main(String[] args) throws DukeException {
        new Duke("/Users/linbinhui/Documents/TIC4001/data/duke.txt").run();
    }
}
