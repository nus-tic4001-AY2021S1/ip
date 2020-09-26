package Duke;

class FindCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList){
        try {
            if(details.isEmpty()){
                throw new DukeException("The keyword of a find command cannot be empty.");
            }
            else{
                TaskList resultList = new TaskList();
                //load list of tasks which matched the keyword
                for(int i=0; i<taskList.getSize(); i++){
                    if(taskList.getTask(i).getDescription().contains(details)){
                        resultList.addTask(taskList.getTask(i));
                    }
                }
                //print the list of tasks
                if(resultList.getSize() == 0){
                    ui.printNoMatchesMsg();
                }
                else{
                    ui.printMatchesMsg();
                    for(int i=0; i<resultList.getSize(); i++){
                        ui.indentPrintString((i+1) + ". " + resultList.getTask(i).toString());
                    }
                }
            }
        } catch(DukeException ex) {
            ui.showError(ex.getMessage());
        }
    }
}
