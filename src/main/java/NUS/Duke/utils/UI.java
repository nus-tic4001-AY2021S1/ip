package NUS.Duke.utils;

import NUS.Duke.DTO.TaskDTO;
import NUS.Duke.ProcessingException;

import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner in;
    static String indent = "    ";
    public UI() {
        in = new Scanner(System.in);
    }
    public String readCommand() {
        return in.nextLine();
    }

    public static void printWelcomeMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
    }

    public static void printList(List<TaskDTO> taskList){
        StringBuilder sb = new StringBuilder();
        taskList.forEach(task -> {
            sb.append(task.getTaskId()+". ");
            sb.append(task.getTaskFullDescription());
            sb.append("\n");
        });

        System.out.println(sb.toString());

    }

    public static void printByeMessage(){
        System.out.println("Bye. Hope to see you again soon!");
    }
    public static void printErrorMessage(String message) {
        try {
            throw new ProcessingException(message);
        } catch (ProcessingException e) {
            e.getMessage();
        }
    }

    public static void printAddTaskMessage(TaskDTO task){
        System.out.println(" Got it. I've added this task: \n"+ task.getTaskFullDescription() +"\n"
                +" Now you have "+task.getTaskId()+" tasks in the list");
    }
}
