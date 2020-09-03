package Dukes;

import java.util.Scanner;
import java.util.ArrayList;

import static Dukes.Task.markAsDone;


public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>(100);
    private static Ui ui;

    public static void main(String[] args) {
        ui.printWelcome();
        run();
    }

    public static void run() {
        //Declare the object and initialize with
        Scanner in = new Scanner(System.in);
        //String input
        String input = in.nextLine();
        while (!input.isEmpty()) {
            if (input.startsWith("bye")) {
                ui.showExit();
                break;
            } else if (input.startsWith("list")) {
                printList();
            } else if (input.startsWith("done")) {
                markAsDone(input);
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

        private static void addTasks(String input){
            Task taskWord = new Task("");
            try {
                if (input.startsWith("todo")) {
                    if (input.length() < 6) {
                        throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
                    }
                    taskWord = new ToDo(input.substring(5));
                } else if (input.startsWith("deadline")) {
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
                } else if (input.startsWith("event")) {
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
                } else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                }
                tasks.add(taskWord);
                System.out.println("Got it, I've added the following task:\n"
                        + "  "
                        + taskWord
                        + "\n"
                        + "Now you have "
                        + tasks.size()
                        + " tasks in the list.\n"
                        + "___________________________________________________________________\n");
            } catch (DukeException e) {
                System.out.print(e.getMessage());
            } catch (Exception e) {
                assert false : "Uncaught exception";
            }
        }
    }




