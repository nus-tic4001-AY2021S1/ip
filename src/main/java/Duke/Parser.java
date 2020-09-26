package Duke;

//deals with making sense of the user command
class Parser {
    public void execute(String fullCommand, Ui ui, Storage storage, TaskList taskList){
        String command, details;

        if(fullCommand.contains(" ")){
            command = fullCommand.split(" ",2)[0];
            details = fullCommand.split(" ",2)[1];
        }
        else{
            command = fullCommand;
            details = "";
        }
        switch(command){
            //command: [bye]
            case "bye":
                new ByeCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [list]
            case "list":
                new ListCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [done] [task number]
            case "done":
                new DoneCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [delete] [task number]
            case "delete":
                new DeleteCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [todo] [description]
            case "todo":
                new TodoCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [deadline] [description] [/by] [time]
            case "deadline":
                new DeadlineCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [event] [description] [/at] [time]
            case "event":
                new EventCommand().executeCommand(details, ui, storage, taskList);
                break;

            //command: [find] [keyword]
            case "find":
                new FindCommand().executeCommand(details, ui, storage, taskList);
                break;

            //all other inputs
            default:
                new DefaultCommand().executeCommand(details, ui, storage, taskList);
        }
    }
}
