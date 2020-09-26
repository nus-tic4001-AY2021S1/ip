package Duke;

class DeleteCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The task number of delete command cannot be empty.");
            }
            else{
                int j = Integer.parseInt(details);
                ui.printDeleteMsg();
                ui.indentPrintString(taskList.deleteTask(j-1).toString());
                ui.printTotalListSize(taskList.getSize());
                storage.saveToFile(taskList);
            }
        } catch(DukeException ex) {
            ui.showError(ex.getMessage());
        }
    }
}

