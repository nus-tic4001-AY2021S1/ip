package Duke;

class ByeCommand extends Command {
    public String executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        ui.setIsExit();
        return ui.printClosing();
    }
}

