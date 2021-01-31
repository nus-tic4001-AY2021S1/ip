package Duke;

//deals with making sense of the user command
class Parser {
    public String execute(String fullCommand, Ui ui, Storage storage, TaskList taskList){
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
                return new ByeCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //command: [list]
            case "list":
                return new ListCommand().executeCommand(details, ui, storage, taskList);
               //break;

            //command: [done] [task number]
            case "done":
                return new DoneCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //command: [delete] [task number]
            case "delete":
                return new DeleteCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //command: [todo] [description]
            case "todo":
                return new TodoCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //command: [deadline] [description] [/by] [time]
            case "deadline":
                return new DeadlineCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //command: [event] [description] [/at] [time]
            case "event":
                return new EventCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //command: [find] [keyword]
            case "find":
                return new FindCommand().executeCommand(details, ui, storage, taskList);
                //break;

            //all other inputs
            default:
                return new DefaultCommand().executeCommand(details, ui, storage, taskList);
        }
    }
}
