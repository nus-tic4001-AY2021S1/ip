package Duke;

class FindCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList){
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
                    String msgPrint = ui.printNoMatchesMsg();
                    return msgPrint;
                }
                else{
                    String msgPrint = ui.printMatchesMsg();
                    for(int i=0; i<resultList.getSize(); i++){
                        msgPrint += ui.indentPrintString((i+1) + ". " + resultList.getTask(i).toString());
                    }
                    return msgPrint;
                }
            }
        } catch(DukeException ex) {
            String msgPrint = ui.showError(ex.getMessage());
            return  msgPrint;
        }
    }
}
