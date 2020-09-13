package Dukes.command;

import Dukes.Storage;
import Dukes.TaskList;
import Dukes.Ui;

public class ListCommand extends Command {

    public ListCommand() {
        super();
    }
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
