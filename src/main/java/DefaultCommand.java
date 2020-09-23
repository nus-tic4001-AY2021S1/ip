

class DefaultCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList){
        try {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
        catch(DukeException ex) {
            ui.showError(ex.getMessage());
        }
    }
}
