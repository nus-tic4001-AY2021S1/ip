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
                    ui.indentPrint((i+1)+". "+ui.taskToString(store.getTask(i)));
                }
                ui.printLine();
                break;
            case "done":
                int index = Integer.parseInt(others);
                store.setDoneAt(index-1);
                ui.printLine();
                ui.indentPrint("Nice! I've marked this task as done: ");
                ui.indentPrint("  "+ui.taskToString(store.getTask(index-1)));
                ui.printLine();
                break;
            default:
                ui.printLine();
                store.addToTemp(input);
                ui.indentPrint("added: "+input);
                ui.printLine();
        }
    }
}
