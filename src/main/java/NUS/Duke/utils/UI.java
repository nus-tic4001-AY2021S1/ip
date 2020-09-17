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
        System.out.println("Hello! I'm NUS.Duke.Duke\n" +
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

    public static void printDeleteTaskMessage(TaskDTO task){
        System.out.println(" Noted. I've removed this task: \n"+ task.getTaskFullDescription() +"\n"
                +" Now you have "+ParserUtil.taskList.size()+" tasks in the list");
    }

    public static void printFoundTaskList(List<TaskDTO> foundList){
        StringBuilder sb = new StringBuilder();
        if (foundList.size()>0){
            sb.append(" Here are the matching tasks in your list: \n");
            foundList.forEach(taskDTO -> {
                sb.append(taskDTO.getTaskId()+":"+taskDTO.getTaskFullDescription()+"\n");
            });
            System.out.println(sb.toString());
        }else {
            System.out.println("Sorry here are no match task in your list.");
        }
    }
}
