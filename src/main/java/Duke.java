import java.util.Scanner;

public class Duke {
    public static int size=100;
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Ui greeting = new Ui();
        greeting.greetInfo();

        Ui ui = new Ui();
        String[] ls = new String[size];
        Paser paser = new Paser(ls, size);
        Scanner in = new Scanner(System.in);
        String str = "";
        int count=0;
        while (!str.equals("bye") & count<size) {
            str = ui.getInput(in);
            if (!str.equals("") & !str.equals("bye") & !str.equals("list")) {
                System.out.println("-----------\nadded: " + str + "\n-----------");
                paser.storeInArray(str,count);
                count++;
            } else if(!str.equals("") & !str.equals("bye") & str.equals("list")){
                paser.printArray();
            }

        }

    }
}