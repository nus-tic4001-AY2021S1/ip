import java.util.*;

public class Duke {
    public static void main(String[] args) {

        String tab = "\t";
        String newLine = "\n";
        String line = tab + "_____________________________________________" + newLine;
        String logo = tab + " ____        _        \n"
                + tab + "|  _ \\ _   _| | _____ \n"
                + tab + "| | | | | | | |/ / _ \\\n"
                + tab + "| |_| | |_| |   <  __/\n"
                + tab + "|____/ \\__,_|_|\\_\\___|\n";

        String greetings = line
                + logo + newLine
                + tab + "Hello! I'm Duke" + newLine
                + tab + "What can I do for you?" + newLine
                + line;

        String closing = line
                + tab + "Bye. Hope to see you again soon!" + newLine
                + line;

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

                String command, details;

                if(input.contains(" ")){
                    command = input.split(" ",2)[0];
                    details = input.split(" ",2)[1];
                }
                else{
                    command = input;
                    details = "";
                }

                switch(command){

                    case "list":
                        if(arrlist.size() == 0){
                            System.out.println(line
                                    + tab + "No record added" + newLine
                                    + line);
                        }
                        else{
                            System.out.println(line
                                    + tab + "Here are the tasks in your list:" + newLine);
                            for(int i=0; i<arrlist.size(); i++){
                                System.out.println(tab+ tab + (i+1) + ". "
                                        + arrlist.get(i).toString());
                            }
                            System.out.println(line);
                        }
                        break;


                    case "done":
                        int i = Integer.parseInt(details);
                        arrlist.get(i-1).markAsDone();
                        System.out.println(line
                                + tab + "Nice! I've marked this task as done:" + newLine
                                + tab + tab + arrlist.get(i-1).toString() + newLine
                                + line);
                        break;


                    case "todo":
                        //add to array
                        Todo newTodo = new Todo(details);
                        arrlist.add(newTodo);

                        //print reply
                        System.out.println(line
                                + tab + "Got it. I've added this task:" + newLine
                                + tab + tab + arrlist.get(arrlist.size()-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        break;


                    case "deadline":
                        //add
                        String dDescription = details.split(" /by ")[0];
                        String by = details.split(" /by ")[1];
                        Deadline newDeadline = new Deadline(dDescription, by);
                        arrlist.add(newDeadline);

                        //print reply
                        System.out.println(line
                                + tab + "Got it. I've added this task:" + newLine
                                + tab + tab + arrlist.get(arrlist.size()-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        break;


                    case "event":
                        //add
                        String eDescription = details.split(" /at ")[0];
                        String at = details.split(" /at ")[1];
                        Event newEvent = new Event(eDescription, at);
                        arrlist.add(newEvent);


                        //print reply
                        System.out.println(line
                                + tab + "Got it. I've added this task:" + newLine
                                + tab + tab + arrlist.get(arrlist.size()-1).toString() + newLine
                                + tab + "Now you have " + arrlist.size() + " tasks in the list." + newLine
                                + line);
                        break;


                    default:
                        System.out.println(line
                                + tab + "OOPS!!! I'm sorry, but I don't know what that means :-(" + newLine
                                + line);
                        break;
                }
            }
        } while(sc.hasNext());
    }
}