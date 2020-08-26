import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Duke {

    public static List<TaskDTO> taskList = new ArrayList<>();
    public static int taskId = 0;
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");

        Scanner scanner = new Scanner(System.in);

        processCommand(scanner);

    }

    public static void processCommand (Scanner scanner){
        String command = scanner.nextLine();
        TaskDTO newTask = new TaskDTO();
        System.out.println("____________________________________________________________");
        if (command.equalsIgnoreCase("list")){
            StringBuilder output = new StringBuilder("");

            output.append(" Here are the tasks in your list:\n");
            for (TaskDTO task : taskList){

                output.append(task.toString());

            }
            System.out.println(output.toString());
        }else if(command.toLowerCase().startsWith("done ")){
            String[] spitList = command.split("done ");
            for (TaskDTO task:taskList){
                if (Integer.parseInt(spitList[1]) == task.getTaskId()){
                    task.processDoneTask();
                }
            }

        }else if (command.equalsIgnoreCase("bye")){
            System.out.println("Bye. Hope to see you again soon!");
        }else {
            TaskDTO task = convertCommandToTask(command);
            if (task!=null){
                taskList.add(task);
                System.out.println(" Got it. I've added this task: \n"+ task.toString() +"\n"
                        +" Now you have "+taskList.size()+" tasks in the list");


            }


        }
        System.out.println("____________________________________________________________\n");
        processCommand(scanner);
    }

    public static TaskDTO convertCommandToTask(String command){
        String operation = command.substring(0, command.indexOf(' '));
        String details = command.substring(command.indexOf(' ') + 1);
        TaskDTO taskDTO = new TaskDTO();
        String symbol = "";
        String temp ="";
        if ("todo".equalsIgnoreCase(operation)){
            taskDTO = new TaskDTO(details,new Date(),TaskTypeEnum.TODO,0,++taskId,null);
        }else if ("deadline".equalsIgnoreCase(operation)){
            temp = details.substring(details.indexOf("/") + 1);
            symbol = temp.substring(0, temp.indexOf(" "));
            taskDTO = new TaskDTO(details.substring(0,details.indexOf("/")),new Date(),TaskTypeEnum.DEADLINE,0,++taskId,"("+symbol+": "+temp.substring(temp.indexOf(" ") +1)+")");
        }else if ("event".equalsIgnoreCase(operation)){
            temp = details.substring(details.indexOf("/") + 1);
            symbol = temp.substring(0, temp.indexOf(" "));
            taskDTO = new TaskDTO(details.substring(0,details.indexOf("/")),new Date(),TaskTypeEnum.EVENT,0,++taskId,"("+symbol+": "+temp.substring(temp.indexOf(" ") +1)+")");
        }
        return taskDTO;
    }


}
