package NUS.Duke.utils;

import NUS.Duke.DTO.DeadlineDTO;
import NUS.Duke.DTO.EventDTO;
import NUS.Duke.DTO.TaskDTO;
import NUS.Duke.DTO.TodoDTO;
import NUS.Duke.ProcessingException;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserUtil {
    public static List<TaskDTO> taskList = new ArrayList<>();

    /**
     * this is the function to spilt the input string originalCommand and get operation
     * @param originalCommand
     * @return
     */
    public static String getFunctionCommand(String originalCommand){
        String operation ="";
        try {
            if (!originalCommand.isEmpty()) {
                operation = originalCommand.split(" ")[0];

            }else {

            }

        } catch (Exception exception) {

            System.out.println("Expception occured");
        }
        return operation.toLowerCase();
    }


    /**
     * This is the function to make task as done input param taskId
     * @param taskId
     */
    public static String doneTask (int taskId){
        String result ="";
        TaskDTO task = taskList.get(--taskId);
        result = task.processDoneTask();

        return result;
    }
    /**
     * This is the function to create event task by input param details
     * @param details
     */
    public static String createEventTask(String details,int doneInd) throws ProcessingException {
        String result ="";
        try {
            String taskName = details.substring(0, details.indexOf("/at"));
            String eventTime = details.substring(details.indexOf("/at") + 4).trim();
            EventDTO task = new EventDTO(taskName, eventTime);
            if (doneInd==0){
                task.setDone(false);
            }else {
                task.setDone(true);
            }
            taskList.add(task);
            result = UI.printAddTaskMessage(task);
        }catch (Exception e){
            result="Please check your input, /at is missing";
            UI.printErrorMessage("Please check your input, /at is missing");
        }

        return result;
    }

    /**
     * This is the function to create deadline task by input param details
     * @param details
     */
    public static String createDeadlineTask(String details,int doneInd) {
        String result = "";
        try {
            String taskName = details.substring(0,details.indexOf("/by"));
            String deadlineDate = details.substring(details.indexOf("/by")+4).trim();
            DeadlineDTO task = new DeadlineDTO(taskName,deadlineDate);
            if (doneInd==0){
                task.setDone(false);
            }else {
                task.setDone(true);
            }
            taskList.add(task);
            result=UI.printAddTaskMessage(task);
        }catch (Exception e){
            result="Please check your input, /by is missing or date entered is incorrect";
            UI.printErrorMessage("Please check your input, /by is missing or date entered is incorrect");
        }

        return result;


    }
    /**
     * This is the function to create todo task by input param details
     * @param details
     */
    public static String createTodoTask(String details,int doneInd){


        TodoDTO task = new TodoDTO(details);
        if (doneInd==0){
            task.setDone(false);
        }else {
            task.setDone(true);
        }
        taskList.add(task);
        String result = UI.printAddTaskMessage(task);

        return result;


    }

    /**
     * This is a function to delete task from tasklist with input param taskIdNumber
     * @param taskIdNumber
     */
    public static String deleteTask (int taskIdNumber){
        TaskDTO tempTask = null;
        String result ="";

        try {
            tempTask = taskList.get(--taskIdNumber);

            taskList.remove(tempTask);
            result=UI.printDeleteTaskMessage(tempTask);

        }catch (Exception e){
            result=e.getMessage();
            e.printStackTrace();
        }

        return result;
    }

    /**
     * This is the function to export the tasklist to a txt file in a format
     */
    public static String writeToFile(){
        StringBuilder result =new StringBuilder();
        try {
            FileWriter myWriter = new FileWriter("DukeFile.txt");
            taskList.forEach(task -> {
                try {
                    myWriter.write(task.getPrintFileString());
                } catch (IOException e) {
                    result.append("An error occurred.");
                    e.printStackTrace();
                }
            });

            myWriter.close();
            return ("Successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
            return ("An error occurred.");
        }
    }


    public static String readTaskFromFile(){
        StringBuilder result = new StringBuilder();
        try {
            File myObj = new File("DukeFile.txt");
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if(data!="" && data!=null) {
                    String values[] = data.split("\\|");
                    Integer doneInd = Integer.parseInt(values[1].trim());
                    String secValue = values[2].trim();
                    switch (values[0].trim()){
                        case "T":
                            createTodoTask(secValue,doneInd);
                            break;
                        case "E":
                            String details  = secValue +" /at " +values[3].substring(1);
                            createEventTask(details,doneInd);
                            break;
                        case "D":
                            String deadlineDetails  = secValue +" /by " +values[3].trim();
                            createDeadlineTask(deadlineDetails,doneInd);
                            break;
                        default:
                            System.out.println("There is a problem with the file, kindly check the file.");
                    }

                }
            }

             result.append("Successfully load record from the file.\n");

            result.append(UI.printWelcomeMessage());
            scanner.close();
        } catch (FileNotFoundException e){
            result = new StringBuilder();
            result.append("DukeFile is not found, skip reading task from file.");

        } catch (ProcessingException e) {
            result = new StringBuilder();
            result.append("An error occurred.");
        }

        return result.toString();
    }

    public static String deleteAllTask(){
        taskList.removeAll(taskList);
        return UI.printDeleteAllTaskMessage();
    }

    /**
     * This is the function to find the description from list of task
     */
    public static String findTask(String keyword){
        List foundTasks = new ArrayList();
        taskList.forEach(task -> {
            if (task.getTaskName().toLowerCase().contains(keyword)){
                foundTasks.add(task);
            }
        });

       return UI.printFoundTaskList(foundTasks);
    }

    static boolean match(String first, String second)
    {

        // If we reach at the end of both strings,
        // we are done
        if (first.length() == 0 && second.length() == 0)
            return true;

        // Make sure that the characters after '*'
        // are present in second string.
        // This function assumes that the first
        // string will not contain two consecutive '*'
        if (first.length() > 1 && first.charAt(0) == '*' &&
                second.length() == 0)
            return false;

        // If the first string contains '?',
        // or current characters of both strings match
        if ((first.length() > 1 && first.charAt(0) == '?') ||
                (first.length() != 0 && second.length() != 0 &&
                        first.charAt(0) == second.charAt(0)))
            return match(first.substring(1),
                    second.substring(1));

        // If there is *, then there are two possibilities
        // a) We consider current character of second string
        // b) We ignore current character of second string.
        if (first.length() > 0 && first.charAt(0) == '*')
            return match(first.substring(1), second) ||
                    match(first, second.substring(1));

        return false;
    }
}
