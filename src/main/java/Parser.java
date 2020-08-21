public class Parser {
    public void getCommand(String input,Storage store, Ui ui){
        String command, others;
        if(input.contains(" ")){
            command = input.split(" ",2)[0];
            others = input.split(" ",2)[1];
        }else{
            command = input;
            others = "";
        }
        switch (command) {
            case "bye":
                store.toExit();
                ui.byeToUser();
                break;
            case "list":
                ui.printLine();
                ui.indentPrint("Here are the tasks in your list:");
                for(int i=0;i<store.getSize();i++){
                    ui.indentPrint((i+1)+". "+store.getTask(i).toString());
                }
                ui.printLine();
                break;
            case "done":
                int index = Integer.parseInt(others);
                store.setDoneAt(index-1);
                ui.printLine();
                ui.indentPrint("Nice! I've marked this task as done: ");
                ui.indentPrint("  "+store.getTask(index-1).toString());
                ui.printLine();
                break;
            case "todo":
                store.addToDoToTemp(others);
                ui.printLine();
                ui.indentPrint("Got it. I've added this task: ");
                ui.indentPrint("  "+store.getTask(store.getSize()-1).toString());
                ui.indentPrint( "Now you have "+store.getSize()+" tasks in the list.");
                ui.printLine();
                break;
            case "deadline":
                store.addDeadlineToTemp(others);
                ui.printLine();
                ui.indentPrint("Got it. I've added this task: ");
                ui.indentPrint("  "+store.getTask(store.getSize()-1).toString());
                ui.indentPrint( "Now you have "+store.getSize()+" tasks in the list.");
                ui.printLine();
                break;
            case "event":
                store.addEventToTemp(others);
                ui.printLine();
                ui.indentPrint("Got it. I've added this task: ");
                ui.indentPrint("  "+store.getTask(store.getSize()-1).toString());
                ui.indentPrint( "Now you have "+store.getSize()+" tasks in the list.");
                ui.printLine();
                break;
            default:
                ui.printLine();
                ui.indentPrint("unknown command, please try again");
                ui.printLine();
                break;
        }
    }
}
