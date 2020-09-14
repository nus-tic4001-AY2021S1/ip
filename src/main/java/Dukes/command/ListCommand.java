package Dukes.command;

import Dukes.Storage;
import Dukes.TaskList;
import Dukes.Ui;
/**
 * Create a ListCommand. It lists all tasks for users.
 */
public class ListCommand extends Command {
    /**
     * Constructor for <code>ListCommand</code>.
     */
    public ListCommand() {
        super();
    }
    /**
     * print commands detail into the <code>TaskList</code>.
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws <code>IndexOutOfBoundsException</code> if there is empty list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if(!tasks.isEmpty()) {
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < tasks.list.size(); i++) {
                    System.out.println("    " + (i + 1) + "." + tasks.list.get(i));
                }
            } else{
                System.out.println("There are no tasks in your list");
                }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("current task is empty in your list.");
        }
    }
}
