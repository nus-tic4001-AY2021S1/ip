

public class Duke {


    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "src/main/java/data/duke.txt";


    public static void main(String[] args)  {



        Ui ui = new Ui();
        ProgramExit programExit = new ProgramExit();
        Parser parser = new Parser();
        TaskList taskList = new TaskList();
        Storage store = new Storage();

        // reading the date from task data file
        // if this is the first time, a message will be shown that no data file is found
       // todoList.readFromFile(filename);

        store.readFromFile(filename);

        Ui.sayWelcome();
        while (!programExit.getIsExit()) {
            parser.getCommand(Ui.readUserCommand(), ui, programExit, taskList,filename , store);
        }


    }
}





