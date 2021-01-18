package Dukes.command;

import Dukes.storage.Storage;
import Dukes.Tasks.TaskList;
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
     * List all the tasks in the task list that was saved on the disk, and display to user
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws <code>IndexOutOfBoundsException</code> if there is empty list.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            int count =tasks.list.size();
            if(count ==0) {
                System.out.println("OOPS!!! There are no tasks in your list.");
            }else{
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < tasks.list.size(); i++) {
                    System.out.println("    " + (i + 1) + "." + tasks.list.get(i));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("current task is empty in your list.");
        }
    }
}
