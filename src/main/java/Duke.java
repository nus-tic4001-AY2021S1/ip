import Task.Deadlines;
import Task.Events;
import Task.Tasks;
import Task.ToDos;
import Exceptions.DukeException;

import java.io.IOException;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        //ArrayList<Tasks> tasks = new ArrayList<>();
        TaskList tasks= new TaskList();
        Storage storage = new Storage("/Users/yiheng/school_project/ip-master/data/duke.txt");
        Scanner scanner = new Scanner(System.in);


        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        /*
        1. Check if a data file is existed.
           If Existed, load the task from the data file, otherwise create a data file.
         */
        try {
            storage.loadFromFile(tasks);
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
        }

         /*
        2. Normal user command to interact with DUKE
           Save updates to data file whenever user make changes
         */
        while(true){
            String userInput = scanner.nextLine();
            String[] cmd = userInput.split("\\s+");

            try{
                if(cmd[0].equalsIgnoreCase("bye")){
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                }
                else{
                    switch (cmd[0]){
                        case"list": {
                            printTaskList(tasks);
                            break;
                        }
                        case "done":
                            try{
                            changeTaskStatus(tasks,true,userInput);
                            updateDataFile(tasks);
                            } catch (IndexOutOfBoundsException e){
                                throw new DukeException ("☹ OOPS!!! I cannot find the task.");
                            } catch (NumberFormatException e){
                                throw new DukeException ("☹ OOPS!!! The task does not exist.");
                            }
                            break;
                        case"todo":
                            try{
                            ToDos todo=new ToDos(userInput.substring(5));
                            tasks.add(todo);
                            printTask(todo,tasks);
                            updateDataFile(tasks);
                            }catch (StringIndexOutOfBoundsException e){
                                throw new DukeException ("☹ OOPS!!! The description of a todo cannot be empty.");
                            }
                            break;
                        case"deadline":
                            try{
                            String[] ddlDetail=userInput.split("/by");
                            String ddlName=ddlDetail[0].substring(9);
                            String ddlDate=ddlDetail[1];
                            Deadlines ddl=new Deadlines(ddlName,ddlDate);
                            tasks.add(ddl);
                            printTask(ddl,tasks);
                            updateDataFile(tasks);
                            }catch (StringIndexOutOfBoundsException e){
                                throw new DukeException ("☹ OOPS!!! The description of a deadline cannot be empty.");
                            }catch(ArrayIndexOutOfBoundsException e){
                                throw new DukeException("☹ OOPS!!! The keyword /by is missing.");
                            }
                            break;
                        case"event":
                            try{
                            String[] eventDetail=userInput.split("/at");
                            String eventName=eventDetail[0].substring(6);
                            String eventDate=eventDetail[1];
                            Events event = new Events(eventName,eventDate);
                            tasks.add(event);
                            printTask(event,tasks);
                            updateDataFile(tasks);
                            } catch (StringIndexOutOfBoundsException e){
                                throw new DukeException ("☹ OOPS!!! The description of a event cannot be empty.");
                            } catch (ArrayIndexOutOfBoundsException e){
                                throw new DukeException("☹ OOPS!!! The keyword /at is missing");
                            }
                            break;
                        case"delete":
                            try{
                                deleteTask(tasks,userInput);
                                updateDataFile(tasks);
                            } catch (IndexOutOfBoundsException e){
                                throw new DukeException ("☹ OOPS!!! I cannot find the task.");
                            } catch (NumberFormatException e){
                                throw new DukeException ("☹ OOPS!!! The task does not exist.");
                            }
                            break;
                        default:
                            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                }
            }
            catch (DukeException e){
                System.out.println(e.getMessage());
                continue;
            }catch (Exception e){
                System.out.println("Sorry,Invalid command. Please enter a valid command.\n");
                continue;
            }
        }
    }

    public static void changeTaskStatus(TaskList tasks,boolean status, String userInput){
        int index = Integer.parseInt(userInput.split(" ")[1]);
        tasks.get(index - 1).setTaskStatus(status);
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println(tasks.get(index - 1).toString());
    }

    public static void printTask(Tasks task, TaskList tasks){
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
    }

    public static void printTaskList(TaskList tasks){
        int index=1;
        for(Tasks task:tasks.getAllTaskList()){
            System.out.println(index+"." +task.toString());
            index++;
        }
    }

    public static void deleteTask(TaskList tasks, String userInput){
        int index = Integer.parseInt(userInput.split(" ")[1]);
        String deletedTask=tasks.get(index - 1).toString();
        tasks.remove(index - 1);
        System.out.println(" Noted. I've removed this task:  ");
        System.out.println(deletedTask);
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");

    }

    public static void updateDataFile(TaskList tasks){
        Storage storage = new Storage("/data/duke.txt");
        try {
            storage.saveToFile(tasks);
        } catch (IOException e) {
            System.out.println("☹ OOPS!!!Update failed. Something went wrong when save data to the data file, please try again.");
        }
    }

}
