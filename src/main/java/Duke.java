import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);

        String hello = " Hello! I'm Duke\n" +
                " What can I do for you?";

        String bye = " Bye. Hope to see you again soon!";
        System.out.println("________________________________________________________");
        System.out.println(hello);
        System.out.println("________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> ss = new ArrayList<>();

        while(true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("bye")){
                break;
            }else if(input.equalsIgnoreCase("list")){
                for(String s: ss){
                    System.out.println(s);
                }
            }else{
                ss.add(ss.size()+1+". "+input);
                System.out.println("added: "+ input);
            }
            System.out.println("________________________________________________________");
        }

        System.out.println("________________________________________________________");
        System.out.println(bye);
        System.out.println("________________________________________________________");

    }
}
