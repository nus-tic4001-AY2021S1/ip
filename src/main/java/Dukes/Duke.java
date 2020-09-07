package Dukes;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>(100);
    private static Ui ui;
    static ArrayList<Task> task = new ArrayList<>();


    public static void main(String[] args) {
        ui.printWelcome();
        run();
        readFile();
        writeFile();
    }

    public static void run() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!input.isEmpty()) {
            if (input.startsWith("bye") || input.startsWith("exit")) {
                ui.showExit();
                break;
            } else if (input.startsWith("list")) {
                if(tasks.isEmpty()){
                    System.out.println("no task in your list.");
                } else {
                    printList();
                }
            } else {
                addTasks(input);
            }
            input = in.nextLine();
        }
    }

    private static void printList() {
        System.out.println("    ___________________________________________________________________\n"
                + "     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("    " + (i + 1) + "." + tasks.get(i));
        }
    }

    private static void addTasks(String input) {
        Task taskWord;
        try {
            if (input.startsWith("todo") && input.contains(" ")) {
                if (input.length() < 6) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
                }
                taskWord = new ToDo(input.substring(5));
                addTaskCase(taskWord);
            } else if (input.startsWith("deadline") && input.contains(" ")) {
                if (input.length() < 10) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                }
                String[] splitDetail = input.split("/by");
                if (splitDetail.length < 2) {
                    throw new DukeException("Please specify the deadline time\n");
                }
                String task = splitDetail[0];
                String by = splitDetail[1];
                taskWord = new Deadline(task, by);
                //taskWord = new Deadline(task, Deadline.timeChange(by));
                addTaskCase(taskWord);
            } else if (input.startsWith("event") && input.contains(" ")) {
                if (input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n");
                }
                String[] splitEvent = input.split("/at");
                if (splitEvent.length < 2) {
                    throw new DukeException("Please specify the event time\n");
                }
                String event = splitEvent[0];
                String time = splitEvent[1];
                taskWord = new Event(event, time);
                addTaskCase(taskWord);
            } else if(input.startsWith("delete") && input.contains(" ")){
                if(tasks.isEmpty() || input.length() < 7) {
                    throw new DukeException("☹ OOPS!!! There is no specific task to delete.\n");
                }
                int toDelete = Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
                Task task = tasks.get(toDelete);
                tasks.remove(toDelete);
                System.out.println("Noted, I've removed the following task:\n"
                        + "  "
                        + task
                        + "\n"
                        + "Now you have "
                        + tasks.size()
                        + " tasks in the list.");
            } else if (input.startsWith("done") && input.contains(" ")) {
                if (input.length() < 6) {
                    throw new DukeException("please key in correct format.\n");
                }
                else if(tasks.isEmpty()){
                    throw new DukeException("There is no task need to be done\n");
                }
                    int toEdit = Integer.parseInt(input.substring(input.indexOf(' ') + 1)) - 1;
                    Task task = tasks.get(toEdit);
                    task.setDone();
                    System.out.println("     Nice! I've marked this task as done:\n"
                        + task
                        + "\n"
                        + "___________________________________________________________________\n");
            }else{
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                }
        }catch (DukeException e) {
            System.out.print(e.getMessage());
        } catch (Exception e) {
            assert false : "Uncaught exception";
        }

    }

    public static void addTaskCase(Task taskWord){
        tasks.add(taskWord);
        System.out.println("Got it, I've added the following task:\n"
                + "  "
                + taskWord
                + "\n"
                + "Now you have "
                + tasks.size()
                + " tasks in the list.\n"
                + "___________________________________________________________________\n");
    }
    private static void readFile() {
        try {
            File file = new File("src/main/java/data/duke.txt");
            Scanner fileSc = new Scanner(file);
            System.out.println("Your task are: ");
            while (fileSc.hasNext()) {
                String input = fileSc.nextLine();
                String[] strArr = input.split(" \\| ");
                Task tasks = null;
                if (strArr[0].equals("T")) {
                    tasks = new ToDo(strArr[2]);
                }else if(strArr[0].equals("D")) {
                    tasks = new Deadline(strArr[2], strArr[3]);
                }else if(strArr[0].equals("E")) {
                    tasks = new Event(strArr[2], strArr[3]);
                }else{
                    throw new DukeException("Previous Tasks are corrupted. Please resetting your task . .");
                }
                if (strArr[1].equals("1")) {
                    tasks.setDone();
                }
                task.add(tasks);
                System.out.println(strArr);
            }

        } catch (FileNotFoundException e) {
            System.out.println("You have no task.");
        } catch (DukeException e) {
            try {
                System.out.println(e.getMessage());
                FileWriter fw = new FileWriter("src/main/java/data/duke.txt");
                String fileDetails = "";
                fw.write(fileDetails);
                fw.close();
            } catch (IOException ex) {
                System.out.println("FileWriting got problem");
                ex.printStackTrace();
            }
        }
    }
    private static void writeFile() {
        try {
            FileWriter fw = new FileWriter("src/main/java/data/duke.txt");
            String fileDetails = "";
            for (Task task : tasks) {
                fileDetails += task.toWriteFile() + "\n";
            }
            System.out.println(fileDetails);
            fw.write(fileDetails);
            fw.close();
        } catch (IOException e) {
            assert(false);
        }
    }




}




