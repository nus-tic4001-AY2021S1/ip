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

    public static String printWelcomeMessage(){
        StringBuilder sb = new StringBuilder();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        sb.append("Hello from\n" + logo);
        sb.append("Hello! I'm NUS Duke System\n" +
                "What can I do for you?");
        return sb.toString();
    }

    public static String printHelpList(){
        StringBuilder sb = new StringBuilder();
        sb.append("Thank you for using Duke, please see the command below for each task: \n");
        sb.append("list - this is to list all the task you have created. \n");
        sb.append("todo (todo task description) - this is to create a todo task, usage example : " +
                "'todo do homework'\n");
        sb.append("event (event task description) /at (event timing)- this is create an event" +
                " task and at certain timing, there is no format for the timing. usage example :" +
                " event project meeting /at 9:30\n");
        sb.append("deadline (deadline task description) /by (deadline date)- this is create an " +
                "deadline task and by certain date, the format for date is yyyy-mm-dd" +
                " usage example : deadline submit homework /by 2020-09-28 \n");
        sb.append("delete (task id) - this is to delete the task. usage example : delete 1 \n");
        sb.append("deleteAll - this is to delete all the tasks.\n");
        sb.append("find (task description) - this is to find the task with matching description. " +
                "usage example : find do homework\n");
        sb.append("findBy (/s date /e date), /s is the start date and /e is the end date. Date format must be 'YYYY-MM-DD'." +
                " Usage example : findby /s 2020-05-01 /e 2020-05-20");
        sb.append("done (task id) - this is to mark the task is done. usage example : done 1 \n");
        sb.append("save - this is to save all the tasks you have created to file in the folder named DukeFile.txt. \n");
        sb.append("bye - this is to list all the task you have created. \n");

        return sb.toString();

    }
    public static String printList(List<TaskDTO> taskList){
        StringBuilder sb = new StringBuilder();
        StringBuilder finalSb = new StringBuilder();
        if (taskList.size()==0){
            finalSb.append("You have no task yet, please add task.");
        }else {
            taskList.forEach(task -> {
                sb.append(taskList.indexOf(task)+1 + ". ");
                sb.append(task.getTaskFullDescription());
                sb.append("\n");
            });

            finalSb.append(sb.toString());
        }
        return finalSb.toString();
    }

    public static void printDoneMessage(){
        System.out.println("");
    }
    public static String printDeleteAllTaskMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("All the task has been deleted.");
        return sb.toString();
    }

    public static String printByeMessage(){ return "Bye. Hope to see you again soon!";
    }
    public static void printErrorMessage(String message) {
        try {
            throw new ProcessingException(message);
        } catch (ProcessingException e) {
            e.getMessage();
        }
    }

    public static String printAddTaskMessage(TaskDTO task){
        StringBuilder sb = new StringBuilder();
        sb.append(" Got it. I've added this task: \n"+ task.getTaskFullDescription() +"\n"
                +" Now you have "+ParserUtil.taskList.size()+" tasks in the list");

        return sb.toString();
    }

    public static String printDeleteTaskMessage(TaskDTO task){
        StringBuilder sb = new StringBuilder();
        sb.append(" Noted. I've removed this task: \n"+ task.getTaskFullDescription() +"\n"
                +" Now you have "+ParserUtil.taskList.size()+" tasks in the list");
        return sb.toString();
    }

    public static String printFoundTaskList(List<TaskDTO> foundList){
        StringBuilder sb = new StringBuilder();
        if (foundList.size()>0){
            sb.append(" Here are the matching tasks in your list: \n");
            foundList.forEach(taskDTO -> {
                sb.append((ParserUtil.taskList.indexOf(taskDTO)+1)+":"+taskDTO.getTaskFullDescription()+"\n");
            });
            return (sb.toString());
        }else {
           return ("Sorry here are no match task in your list.");
        }
    }
}
