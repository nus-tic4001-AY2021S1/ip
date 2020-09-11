package NUS.Duke.utils;

import NUS.Duke.DTO.DeadlineDTO;
import NUS.Duke.DTO.EventDTO;
import NUS.Duke.DTO.TaskDTO;
import NUS.Duke.DTO.TodoDTO;
import NUS.Duke.ProcessingException;
import NUS.Duke.utils.UI;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParserUtil {
    public static List<TaskDTO> taskList = new ArrayList<>();
    public static int taskId = 0;
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





    public static void doneTask (int taskId){
        taskList.forEach(task -> {
            if (taskId == task.getTaskId()){
                task.processDoneTask();
            }
        });
    }
    public static void createEventTask(String details) throws ProcessingException {
        try {
            String taskName = details.substring(0, details.indexOf("/at"));
            String eventTime = details.substring(details.indexOf("/at") + 4).trim();
            EventDTO task = new EventDTO(taskName, ++taskId, eventTime);
            taskList.add(task);
            UI.printAddTaskMessage(task);
        }catch (Exception e){
            UI.printErrorMessage("Please check your input, /at is missing");
        }
    }

    public static void createDeadlineTask(String details) {
        try {
            String taskName = details.substring(0,details.indexOf("/by"));
            String deadlineDate = details.substring(details.indexOf("/by")+4).trim();
            DeadlineDTO task = new DeadlineDTO(taskName,deadlineDate,++taskId);
            taskList.add(task);
            UI.printAddTaskMessage(task);
        }catch (Exception e){
            UI.printErrorMessage("Please check your input, /by is missing");
        }

    }

    public static void createTodoTask(String details){

        TodoDTO task = new TodoDTO(details,++taskId);
        taskList.add(task);
        UI.printAddTaskMessage(task);


    }

    public static void deleteTask (int taskIdNumber){
        TaskDTO tempTask = null;

        try {


            for(TaskDTO task : taskList){
                if (taskIdNumber == task.getTaskId()) {
                    tempTask = task;
                }
            }

            taskList.remove(tempTask);
            UI.printDeleteTaskMessage(tempTask);

            taskList.forEach(task -> {
                if (taskIdNumber < task.getTaskId()) {
                    task.setTaskId(task.getTaskId() - 1);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        taskId--;

    }

    public static void writeToFile(){
        try {
            FileWriter myWriter = new FileWriter("DukeFile.txt");
            taskList.forEach(task -> {
                try {
                    myWriter.write(task.getPrintFileString());
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            });

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
