

class ListCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        if(taskList.getSize() == 0){
            ui.printNoRecords();
        }
        else{
            ui.printList();
            for(int i=0; i<taskList.getSize(); i++){
                ui.indentPrintString((i+1) + ". " + taskList.getTask(i).toString());
            }
        }
    }
}

