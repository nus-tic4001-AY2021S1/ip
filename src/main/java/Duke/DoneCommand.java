package Duke;

class DoneCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The task number of done command cannot be empty.");
            }
            else{
                int i = Integer.parseInt(details);
                taskList.getTask(i-1).markAsDone();
                ui.printDoneMsg();
                String msgPrint = ui.indentPrintString(taskList.getTask(i-1).toString());
                storage.saveToFile(taskList);
                return msgPrint;
            }
        } catch(DukeException ex) {
            String msgPrint = ui.showError(ex.getMessage());
            return  msgPrint;
        }
    }
}


