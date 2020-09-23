

abstract class Command {
    protected String content;
    //constructor
    public Command() {}
    public Command(String content) {
        this.content = content;
    }
    //abstract methods
    public abstract void executeCommand(String details, Ui ui, Storage storage, TaskList taskList);
}
