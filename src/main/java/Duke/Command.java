package Duke;

abstract class Command {
    protected String content;
    //constructor
    public Command() {}
    public Command(String content) {
        this.content = content;
    }
    //abstract methods
    public abstract String executeCommand(String details, Ui ui, Storage storage, TaskList taskList);
}
