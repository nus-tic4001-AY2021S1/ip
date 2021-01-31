package Duke;

class DeleteCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The task number of delete command cannot be empty.");
            }
            else{
                int j = Integer.parseInt(details);
                ui.printDeleteMsg();
                ui.indentPrintString(taskList.deleteTask(j-1).toString());
                String msgPrint = ui.printTotalListSize(taskList.getSize());
                storage.saveToFile(taskList);
                return msgPrint;
            }
        } catch(DukeException ex) {
            String msgPrint = ui.showError(ex.getMessage());
            return msgPrint;
        }
    }
}

