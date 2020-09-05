import Duke.Exceptions.DukeException;
import Duke.Tasks.Deadlines;
import Duke.Tasks.Events;
import Duke.Tasks.Task;
import Duke.Tasks.ToDos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Duke {

    static final String CURRENTWORKINGDIR = System.getProperty("user.dir");
    static final String DIVIDER = "________________________________________________________";

    public static void main(String[] args) {
        String hello = " Hello! I'm Duke\n" +
                " What can I do for you?";

        String bye = " Bye. Hope to see you again soon!";

        String path = CURRENTWORKINGDIR + "/data/duke.txt";

        printDivider();
        System.out.println(hello);
        printDivider();

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(path);

        try {
            if(f.exists()){
                load(f, tasks);
            }else{
                createDukeTXT(path);
            }
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            String userInput = scanner.nextLine();
            String[] cmd = userInput.split("\\s+");

            if (cmd[0].equalsIgnoreCase("bye")) {
                break;
            }

            try {
                switch (cmd[0]) {
                    case "list":
                        System.out.println("Here are the tasks in your list:");
                        int i = 1;

                        for (Task s : tasks) {
                            System.out.println(i + "." + s.toString());
                            i++;
                        }
                        break;
                    case "done":
                        try {
                            int index = Integer.parseInt(userInput.split(" ")[1]);
                            tasks.get(index - 1).setDone(true);
                            System.out.println("Nice! I've marked this task as done: ");
                            System.out.println(tasks.get(index - 1).toString());
                        }catch(IndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The task does not exist.");
                        }catch (NumberFormatException e) {
                            throw new DukeException("☹ OOPS!!! Please specify the task need to be done.");
                        }
                        break;
                    case "delete":
                        try {
                            int index = Integer.parseInt(userInput.split(" ")[1]);
                            System.out.println("Noted. I've removed this task: ");
                            System.out.println(tasks.get(index - 1).toString());
                            tasks.remove(index - 1);
                            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        }catch(IndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The task does not exist.");
                        }catch (NumberFormatException e) {
                            throw new DukeException("☹ OOPS!!! Please specify the number of the task need to be delete.");
                        }
                        break;
                    case "todo":
                        try {
                            ToDos t = createToDos(userInput.substring(5, userInput.length()),false);
                            tasks.add(t);
                            printTask(t, tasks);
                        }catch(StringIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        break;
                    case "deadline":
                        try {
                            String[] deadlineContent = userInput.split(" /by ");
                            Deadlines d = createDeadlines(deadlineContent[0].substring(9, deadlineContent[0].length()), deadlineContent[1],false);
                            tasks.add(d);
                            printTask(d, tasks);
                        }catch(StringIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        }catch(ArrayIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The keyword /by is missing.");
                        }
                        break;
                    case "event":
                        try {
                            String[] eventContent = userInput.split(" /at ");
                            Events e = createEvents(eventContent[0].substring(6, eventContent[0].length()), eventContent[1],false);
                            tasks.add(e);
                            printTask(e, tasks);
                        }catch(StringIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                        }catch(ArrayIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The keyword /at is missing.");
                        }
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }catch (DukeException e) {
                System.out.println(e.getMessage());
                continue;
            }catch (Exception e) {
                System.out.println("☹ OOPS!!! Unknown internal error occurs.");
                continue;
            }

            try {
                save(tasks, path);
            }catch(IOException e){
                System.out.println("☹ OOPS!!!Updating file is fail.");
            }

            printDivider();
        }

        System.out.println(bye);
        printDivider();

    }

    private static Events createEvents(String taskDescription, String taskDate, boolean taskDoneStatus) {
        Events e = new Events(taskDescription,taskDate);
        e.setDone(taskDoneStatus);
        return e;
    }

    private static Deadlines createDeadlines(String taskDescription, String taskDate, boolean taskDoneStatus) {
        Deadlines d = new Deadlines(taskDescription, taskDate);
        d.setDone(taskDoneStatus);
        return d;
    }

    private static ToDos createToDos(String taskDescription, boolean taskDoneStatus) {
        ToDos t = new ToDos(taskDescription);
        t.setDone(taskDoneStatus);
        return t;
    }

    private static boolean checkDoneStatus(String content) {
        return content.equalsIgnoreCase("1");
    }

    private static void load(File f,ArrayList<Task> tasks) throws IOException, DukeException {
        Scanner s = new Scanner(f);

        while (s.hasNext()) {
            String line = s.nextLine();
            String[] contents = line.split("\\|");

            String taskDate = "unknown date";
            String taskType = contents[0];
            boolean taskDoneStatus = checkDoneStatus(contents[1]);
            String taskDescription = contents[2];
            if(contents.length == 4){
                taskDate = contents[3];
            }

            try {
                switch (taskType) {
                    case "T":
                        tasks.add(createToDos(taskDescription,taskDoneStatus));
                        break;
                    case "D":
                        tasks.add(createDeadlines(taskDescription,taskDate,taskDoneStatus));
                        break;
                    case "E":
                        tasks.add(createEvents(taskDescription,taskDate,taskDoneStatus));
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!!There's unknown tasks type in the file.");
                }
            }catch(Exception e){
                throw new DukeException("☹ OOPS!!!There is error in the file,please check the format.");
            }
        }
    }

    private static void createDukeTXT(String path) throws IOException {
        String folderPath = CURRENTWORKINGDIR + "/data";
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
            System.out.println("Folder created");
            printDivider();
        } else {
            System.out.println("Folder exist");
            printDivider();
        }
        FileWriter fw = new FileWriter(path);
        fw.close();
    }

    private static void save(ArrayList<Task> tasks,String path) throws IOException {
        FileWriter fw = new FileWriter(path);

        Iterator<Task> i = tasks.iterator();
        while (i.hasNext()) {
            fw.write(i.next().toSavingString());
            fw.write("\n");
        }

        fw.close();
    }

    private static void printTask(Task t, ArrayList<Task> tasks) {

        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");

    }

    private static void printDivider() {
        System.out.println(DIVIDER);
    }
}
