class DoneCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The task number of done command cannot be empty.");
            }
            else{
                int i = Integer.parseInt(details);
                taskList.getTask(i-1).markAsDone();
                ui.printDoneMsg();
                ui.indentPrintString(taskList.getTask(i-1).toString());
                storage.saveToFile(taskList);
            }
        } catch(DukeException ex) {
            ui.showError(ex.getMessage());
        }
    }
}


