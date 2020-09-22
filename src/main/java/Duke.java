import java.util.*;
import java.io.*;

public class Duke {
    public static void main(String[] args) throws DukeException {

        String tab = "\t";
        String newLine = "\n";
        String line = tab + "____________________________________________________" + newLine;
        String logo = tab + " ____        _        \n"
                + tab + "|  _ \\ _   _| | _____ \n"
                + tab + "| | | | | | | |/ / _ \\\n"
                + tab + "| |_| | |_| |   <  __/\n"
                + tab + "|____/ \\__,_|_|\\_\\___|\n";

        String greetings = line
                + logo + newLine
                + tab + "Hello! I'm Duke" + newLine
                + tab + "What can I do for you?" + newLine
                + line;

        String closing = line
                + tab + "Bye. Hope to see you again soon!" + newLine
                + line;

        //Load from file
        ArrayList<Task> arrlist = new ArrayList<Task>();
        String dir = System.getProperty("user.dir");
        checkFolder(dir);
        boolean fileExists = checkTextFile(dir);
        if(fileExists){ //exist a file, load to arraylist if it's not empty
            File dukeFile = new File(dir+"/data/duke.txt");
            if(dukeFile.length() != 0){
                arrlist = readFile(dukeFile);
            }
        }

        String input;
        Scanner sc = new Scanner(System.in);

        //Greet
        System.out.println(greetings);
        //Waiting for user input
        do{
            input = sc.nextLine();

            //Exit
            if (input.equals("bye")){
                System.out.println(closing);
                break;
            }
            //Process commands
            else {

                String command, details;

                if(input.contains(" ")){
                    command = input.split(" ",2)[0];
                    details = input.split(" ",2)[1];
                }
                else{
                    command = input;
                    details = "";
                }

                switch(command){

                    case "list": //command: [list]
                        if(arrlist.size() == 0){
                            System.out.println(line
                                    + tab + "No record added" + newLine
                                    + line);
                        }
                        else{
                            System.out.println(line
                                    + tab + "Here are the tasks in your list:" + newLine);
                            for(int i=0; i<arrlist.size(); i++){
                                System.out.println(tab+ tab + (i+1) + ". "
                                        + arrlist.get(i).toString());
                            }
                            System.out.println(line);
                        }
                        break;


                    case "done": //command: [done] [task number]
                        if(details.isEmpty()){
                            throw new DukeException("The task number of done command cannot be empty.");
                        }
                        int i = Integer.parseInt(details);
                        arrlist.get(i-1).markAsDone();
                        System.out.println(line
                                + tab + "Nice! I've marked this task as done:" + newLine
                                + tab + tab + arrlist.get(i-1).toString() + newLine
                                + line);
                        saveToFile(arrlist, dir);
                        break;


                    case "delete": //command: [delete] [task number]
                        if(details.isEmpty()){
                            throw new DukeException("The task number of delete command cannot be empty.");
                        }
                        int j = Integer.parseInt(details);
                        System.out.println(line
                                + tab + "Noted. I've removed this task:" + newLine
                                + tab + tab + arrlist.remove(j-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        saveToFile(arrlist, dir);
                        break;


                    case "todo": //command: [todo] [description]
                        if(details.isEmpty()){
                            throw new DukeException("The description of a todo cannot be empty.");
                        }
                        //add todo to arraylist
                        Task newTodo = new Todo(details);
                        arrlist.add(newTodo);
                        //print reply
                        System.out.println(line
                                + tab + "Got it. I've added this task:" + newLine
                                + tab + tab + arrlist.get(arrlist.size()-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        saveToFile(arrlist, dir);
                        break;


                    case "deadline": //command: [deadline] [description] [/by] [time]
                        if(details.isEmpty()){
                            throw new DukeException("The description of a deadline cannot be empty.");
                        }
                        if(!details.contains(" /by ")){
                            throw new DukeException("No /by found in command.");
                        }
                        String dDescription = details.split(" /by ")[0];
                        if(details.split(" /by ").length<2){
                            throw new DukeException("No deadline time found after keyword /by.");
                        }
                        String by = details.split(" /by ")[1];

                        //add deadline to arraylist
                        Task newDeadline = new Deadline(dDescription, by);
                        arrlist.add(newDeadline);
                        //print reply
                        System.out.println(line
                                + tab + "Got it. I've added this task:" + newLine
                                + tab + tab + arrlist.get(arrlist.size()-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        saveToFile(arrlist, dir);
                        break;


                    case "event": //command: [event] [description] [/at] [time]
                        if(details.isEmpty()){
                            throw new DukeException("The description of event cannot be empty.");
                        }
                        if(!details.contains(" /at ")){
                            throw new DukeException("No /at found in command.");
                        }
                        String eDescription = details.split(" /at ")[0];
                        if(details.split(" /at ").length<2){
                            throw new DukeException("No event time found after keyword /at.");
                        }
                        String at = details.split(" /at ")[1];

                        //add event to arraylist
                        Task newEvent = new Event(eDescription, at);
                        arrlist.add(newEvent);
                        //print reply
                        System.out.println(line
                                + tab + "Got it. I've added this task:" + newLine
                                + tab + tab + arrlist.get(arrlist.size()-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        saveToFile(arrlist, dir);
                        break;


                    default:
                        throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
            }
        } while(sc.hasNext());
    }
    //check folder
    public static void checkFolder(String dir){
        //check if folder exists
        java.nio.file.Path checkFolderPath = java.nio.file.Paths.get(dir+"/data");
        boolean directoryExists = java.nio.file.Files.exists(checkFolderPath);
        //folder not exists, create one
        if(!directoryExists) {
            new File(dir+"/data").mkdirs();
        }
    }
    //check text file
    public static boolean checkTextFile(String dir){
        //check if text file exists
        java.nio.file.Path checkFilePath = java.nio.file.Paths.get(dir+"/data/duke.txt");
        boolean fileExists = java.nio.file.Files.exists(checkFilePath);
        //text file not exists, create one
        if(!fileExists) {
            try {
                File dukeFile = new File(dir+"/data/duke.txt");
                dukeFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating file.");
                e.printStackTrace();
            }
        }
        return fileExists;
    }
    // Array to readfile
    public static ArrayList<Task> readFile(File file){
        ArrayList<Task> arrlist = new ArrayList<Task>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String instructions = myReader.nextLine();
                String type = instructions.split(" \\| ",4)[0];
                String done = instructions.split(" \\| ",4)[1];
                String description = instructions.split(" \\| ",4)[2];

                switch(type){
                    case "T":
                        Task newTodo = new Todo(description);
                        if(done.equals("1")){
                            newTodo.markAsDone();
                        }
                        arrlist.add(newTodo);
                        break;

                    case "D":
                        String dTime = instructions.split(" \\| ",4)[3];
                        Task newDeadline = new Deadline(description, dTime);
                        if(done.equals("1")){
                            newDeadline.markAsDone();
                        }
                        arrlist.add(newDeadline);
                        break;

                    case "E":
                        String eTime = instructions.split(" \\| ",4)[3];
                        Task newEvent = new Event(description, eTime);
                        if(done.equals("1")){
                            newEvent.markAsDone();
                        }
                        arrlist.add(newEvent);
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading text file.");
            e.printStackTrace();
        }
        return arrlist;
    }

    public static void saveToFile(ArrayList<Task> arrlist, String dir){
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(dir+"/data/duke.txt"));
            for(int i=0; i<arrlist.size(); i++){
                myWriter.write(writeToFile(arrlist.get(i)));
                if(i != arrlist.size()-1){
                    myWriter.newLine();
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred in saving file.");
            e.printStackTrace();
        }
    }

    public static String writeToFile(Task t){
        int done = 0; //default false
        if(t.getIsDone()){
            done = 1;
        }

        //[command] [done] [description] [time]
        if(t instanceof Todo){
            return "T | " + done + " | " + t.getDescription();
        }
        else if(t instanceof Deadline){
            return "D | " + done + " | " + t.getDescription() + " | " + ((Deadline)t).getBy();
        }
        else if(t instanceof Event){
            return "E | " + done + " | " + t.getDescription() + " | " + ((Event)t).getAt();
        }
        else{
            return "";
        }
    }
}
