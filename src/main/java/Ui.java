import java.util.Scanner;

public class Ui {


    public Ui(){

    }

    public void welcome(){
            String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
            System.out.println("Hello from\n" + logo);

            System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }

    public void divider(){
        System.out.println("-----------------------------------------------------------------");
    }

    public void tasks() {
        divider();
        System.out.println("todo task press 1");
        System.out.println("event current task press 2");
        System.out.println("deadline task press 3");
        System.out.println("list task press 4");
        System.out.println("mark done task press 5");
        System.out.println("Show current task press 6");
        divider();

    }

    public void time(){
        System.out.println("please add time");

    }

    public String input(){

        Scanner myObj = new Scanner(System.in);
        String obj1 = myObj.nextLine().toLowerCase();
        return obj1;

    }


}
