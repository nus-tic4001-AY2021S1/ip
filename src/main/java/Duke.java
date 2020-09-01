import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String line = "\t_____________________________________________\n";

        String greetings = line + "\t Hello! I'm Duke\n"
                + "\t What can I do for you?\n" + line;

        String closing = line + "\t Bye. Hope to see you again soon!\n" + line;

        List<Task> arrlist = new ArrayList<Task>();
        String input;
        Scanner sc = new Scanner(System.in);

        //Greet
        System.out.println(greetings);

        //Waiting for user input
        do{
            input = sc.nextLine();
            //Exit
            if (input.equals("bye")){
                System.out.println(closing);
                break;
            }
            //Process commands
            else {

                String command, taskNo;

                if(input.contains(" ")){
                    String[] words = input.split(" ");
                    command = words[0];
                    taskNo = words[1];
                }
                else{
                    command = input;
                    taskNo = "";
                }

                switch(command){

                    case "list":
                        if(arrlist.size() == 0){
                            System.out.println(line + "\t No record added\n" + line);
                        }
                        else{
                            System.out.println(line + "\t Here are the tasks in your list: \n");
                            for(int i=0; i<arrlist.size(); i++){
                                System.out.println("\t\t" + (i+1) + ". "
                                        + arrlist.get(i).taskToString());
                            }
                            System.out.println(line);
                        }
                        break;

                    case "done":
                        int i = Integer.parseInt(taskNo);
                        arrlist.get(i-1).markAsDone();
                        System.out.println(line + "\t Nice! I've marked this task as done: \n\t\t"
                                + arrlist.get(i-1).taskToString() + "\n" + line);
                        break;

                    case "bye":
                        System.out.println(closing);
                        break;
                    default:
                        Task newTask = new Task(input);
                        arrlist.add(newTask);
                        System.out.println(line + "\t added: " + input + "\n" + line);
                        break;
                }
            }
        } while(sc.hasNext());
    }
}
