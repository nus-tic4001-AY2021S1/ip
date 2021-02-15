package Duke;

class DefaultCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList){
        try {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
        catch(DukeException ex) {
            String msgPrint = ui.showError(ex.getMessage());
            return msgPrint;
        }
    }
}

