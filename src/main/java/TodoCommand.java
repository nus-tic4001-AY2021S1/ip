

class TodoCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        try {
            if(details.isEmpty()){
                throw new DukeException("The description of a todo cannot be empty.");
            }
            else{
                //add todo to arraylist
                Task newTodo = new Todo(details);
                taskList.addTask(newTodo);
                //print reply
                ui.printAddMsg();
                ui.indentPrintString(taskList.getTask(taskList.getSize()-1).toString());
                ui.printTotalListSize(taskList.getSize());
                storage.saveToFile(taskList);
            }
        } catch(DukeException ex) {
            ui.showError(ex.getMessage());
        }
    }
}
