package Duke;

import java.time.LocalDate;

class DeadlineCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The description of a deadline cannot be empty.");
            }
            else {
                if(!details.contains(" /by")){
                    throw new DukeException("No /by found in command.");
                }
                else{
                    String dDescription = details.split(" /by ")[0];
                    if(details.split(" /by ").length<2){
                        throw new DukeException("No deadline time found after keyword /by.");
                    }
                    else{
                        String by = details.split(" /by ")[1];
                        try{
                            //add deadline to arraylist
                            Task newDeadline = new Deadline(dDescription, LocalDate.parse(by));
                            taskList.addTask(newDeadline);
                            //print reply
                            ui.printAddMsg();
                            ui.indentPrintString(taskList.getTask(taskList.getSize()-1).toString());
                            String msgPrint = ui.printTotalListSize(taskList.getSize());
                            //storage.saveToFile(taskList);
                            return msgPrint;
                        }
                        catch(Exception ex){
                            String msgPrint = ui.showError("\tPlease enter date according to this format (yyyy-mm-dd)");
                            return msgPrint;
                        }
                    }
                }
            }
        }
        catch(DukeException ex) {
            String msgPrint = ui.showError(ex.getMessage());
            return msgPrint;
        }
    }
}

