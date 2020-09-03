import NUS.Duke.DTO.DeadlineDTO;
import NUS.Duke.DTO.EventDTO;
import NUS.Duke.DTO.TaskDTO;
import NUS.Duke.DTO.TodoDTO;
import NUS.Duke.ProcessingException;
import NUS.Duke.utils.UI;


import java.util.Date;

public class ParserUtil {

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
        Duke.taskList.forEach(task -> {
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
            Duke.taskList.add(task);
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
            Duke.taskList.add(task);
            UI.printAddTaskMessage(task);
        }catch (Exception e){
            UI.printErrorMessage("Please check your input, /by is missing");
        }

    }

    public static void createTodoTask(String details){

        TodoDTO task = new TodoDTO(details,++taskId);
        Duke.taskList.add(task);
        UI.printAddTaskMessage(task);


    }
}
