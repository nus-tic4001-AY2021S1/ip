package Duke;

class TodoCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The description of a todo cannot be empty.");

            }
            else{

                Task newTodo = new Todo(details);
                taskList.addTask(newTodo);
                //print reply
                String msgPrint = ui.printAddMsg();
                msgPrint += ui.indentPrintString(taskList.getTask(taskList.getSize()-1).toString());
                msgPrint += ui.printTotalListSize(taskList.getSize());
              //  storage.saveToFile(taskList);
                return msgPrint;

            }

        } catch(DukeException ex) {
            // ui.showError(ex.getMessage());
            //  String msgPrint = ui.showError(ex.getMessage());
            return ui.showError(ex.getMessage());
        }
    }
}

