package Duke;

import java.time.LocalDate;

class EventCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The description of event cannot be empty.");
            }
            else{
                if(!details.contains(" /at")){
                    throw new DukeException("No /at found in command.");
                }
                else{
                    String eDescription = details.split(" /at ")[0];
                    if(details.split(" /at ").length<2){
                        throw new DukeException("No event time found after keyword /at.");
                    }
                    else{
                        String at = details.split(" /at ")[1];
                        try{
                            //add event to arraylist
                            Task newEvent = new Event(eDescription, LocalDate.parse(at));
                            taskList.addTask(newEvent);
                            //print reply
                            ui.printAddMsg();
                            ui.indentPrintString(taskList.getTask(taskList.getSize()-1).toString());
                            ui.printTotalListSize(taskList.getSize());
                            storage.saveToFile(taskList);
                        }
                        catch(Exception ex){
                            ui.showError("\tPlease enter date according to this format (yyyy-mm-dd)");
                        }
                    }
                }
            }
        }
        catch(DukeException ex) {
            ui.showError(ex.getMessage());
        }
    }
}
