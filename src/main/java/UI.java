class UI {

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
        String done = "____________________________________________________________\n"
                + "\033[33mTask [" + index + "] "
                + tasks.get(index - 1).getDescription() + " has been set as completed.\033[0m"
                + "\n____________________________________________________________\n";
        System.out.println(done);
    }

    void showTotal(TaskList tasks) {

        String total = "Tasks in the list: " + tasks.size()
                + "\n____________________________________________________________\n";
        System.out.println(total);
    }

    void printError(String s) {
        System.out.println(colorRed(s));
    }

    String colorRed(String input) {
        return "\033[31m" + input + "\033[0m";
    }

    void invalidCommand() {
        printError("Please enter a valid command.");
    }

    public void taskAdded(String line, TaskList tasks) {
        String added = "____________________________________________________________\n"
                + "Great! You have entered a proper task as shown below:\n"
                + line;
        System.out.println(added);
        showTotal(tasks);
    }
}
