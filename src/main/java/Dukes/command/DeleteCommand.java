package Dukes.command;

import Dukes.*;

public class DeleteCommand extends Command{
    public DeleteCommand (int index){
        super.index =index;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            Task deletedTask = tasks.list.remove(index);
            ui.printDeleteMessage(deletedTask, tasks.list.size());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please key in a number from the list");
        }
    }

}
