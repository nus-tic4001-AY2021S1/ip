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

        List<String> arrlist = new ArrayList<String>();
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
                switch(input){

                    case "list":
                        if(arrlist.size() == 0){
                            System.out.println(line + "\t No record added\n" + line);
                        }
                        else{
                            System.out.println(line);
                            for(int i=0; i<arrlist.size(); i++){
                                System.out.println("\t" + (i+1) + ". " + arrlist.get(i));
                            }
                            System.out.println(line);
                        }
                        break;

                    case "bye":
                        System.out.println(closing);
                        break;

                    default:
                        arrlist.add(input);
                        System.out.println(line + "\t added: " + input + "\n" + line);
                        break;
                }
            }
        } while(sc.hasNext());
    }
}