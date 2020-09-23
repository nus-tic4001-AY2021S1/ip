class ByeCommand extends Command {
    public void executeCommand(String details, Ui ui, Storage storage, TaskList taskList) {
        ui.setIsExit();
        ui.printClosing();
    }
}

