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
        System.out.println("____________________________________________________________");
        if (command.equalsIgnoreCase("list")){
            StringBuilder output = new StringBuilder("");

            output.append(" Here are the tasks in your list:\n");
            for (TaskDTO task : taskList){

                output.append(task.getTaskId()+". [");
                int ascii = 0;
                if (task.getDoneInd()==0){
                    ascii = 0x2717;
                }else {
                    ascii = 0x2713;

                }
                String sign = Character.toString((char)ascii);

                output.append(sign +"]");
                output.append(task.getTaskName());
                output.append("\n");

            }
            System.out.println(output.toString());
        }else if(command.toLowerCase().startsWith("done ")){
            String[] spitList = command.split("done ");
            for (TaskDTO task:taskList){
                if (Integer.parseInt(spitList[1]) == task.getTaskId()){
                    task.setDoneInd(1);
                    System.out.println(" Nice! I've marked this task as done: \n" +
                            "[✓]"+task.getTaskName());
                }
            }

        }else if (command.equalsIgnoreCase("bye")){
            System.out.println("Bye. Hope to see you again soon!");
        }else {
            TaskDTO task = new TaskDTO();
            task.setDoneInd(0);
            task.setRecordDate(new Date());
            task.setTaskName(command);
            task.setTaskId(++taskId);
            taskList.add(task);
            System.out.println("Added : "+command);
        }
        System.out.println("____________________________________________________________\n");
        processCommand(scanner);
    }


}
