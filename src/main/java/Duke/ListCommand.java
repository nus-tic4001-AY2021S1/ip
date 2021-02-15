package Duke;

class ListCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        if(taskList.getSize() == 0){
            String msgPrint = ui.printNoRecords();
            return msgPrint;
        }
        else{
            String msgPrint = ui.printList();
            for(int i=0; i<taskList.getSize(); i++){
                msgPrint +=  ui.indentPrintString((i+1) + ". " + taskList.getTask(i).toString());

            }
            return msgPrint;
        }
    }
}


