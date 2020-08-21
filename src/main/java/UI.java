public class UI {

    void greet() {
        String greeting = "____________________________________________________________\n"
                + "Hello! I'm Duke\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(greeting);
    }
    void farewell() {
        String farewell = "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";
        System.out.println(farewell);
    }
    void markedAsDone(int index, TaskList tasks) {
        System.out.println("\033[33mTask [" + index + "] "
                + tasks.get(index - 1).getDescription() + " has been set as completed.\033[0m");
    }
    void printError(String s) {
        System.out.println(s);
    }
    String colorRed(String input) {
        return "\033[31m" + input + "\033[0m";
    }
}
