public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        GreetNote("welcome");
        GreetNote("bye");
    }

    private static void GreetNote(String hi_bye) {

        String welcome = "____________________________________________________________\n"
                        + "Hello! I'm Duke\n"
                        + "What can I do for you?\n"
                        + "____________________________________________________________\n";

        String farewell = "Bye. Hope to see you again soon!\n"
                        + "____________________________________________________________";

        if(hi_bye.equals("welcome")) {
            System.out.println(welcome);
        } else {
            System.out.println(farewell);
        }
    }
}
