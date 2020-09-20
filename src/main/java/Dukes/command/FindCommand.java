package Dukes.command;

import Dukes.Exceptions.DukeException;
import Dukes.Storage;
import Dukes.Tasks.Task;
import Dukes.Tasks.TaskList;
import Dukes.Ui;


/**
 * Creates a FindCommand. It search for tasks when given keyword.
 */
public class FindCommand extends Command {
    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * Finds the tasks with the given keyword.
     *
     * @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files.
     */

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        TaskList filteredTasks = new TaskList();
        int count = 0;
        try {
            for (Task task : tasks.list) {
                String description = task.getDescription().toLowerCase();
                if (description.contains(keyWord)) {
                    filteredTasks.list.add(task);
                    count += 1;
                }
            }
                if (count == 0) {
                    throw new DukeException("There is no task in the list");
                } else {
                    System.out.println("Here are the matching tasks in your list:");
                    for (int i = 0; i < filteredTasks.list.size(); i++) {
                        System.out.println((i + 1) + "." + filteredTasks.list.get(i));
                    }
                }
            }catch (IndexOutOfBoundsException e) {
            System.out.print("current task is empty in your list.");
        }
        }
    }


