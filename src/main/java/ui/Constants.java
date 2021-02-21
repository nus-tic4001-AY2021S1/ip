package ui;

public class Constants {
    public enum TaskDisplayType {
        ADD,
        DONE,
        UNDONE
    }
    public static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    //System.out.println("Hello from\n" + logo);

    public static final String H_LINE = "______________________________";

    public static final String GREETING = LOGO + "\n" + H_LINE + "\n" + "Hello I'm Duke :) What can I do for you ?"
            + "\n" + H_LINE + "\n";

    public static final String FAREWELL = "\nBye. Hope to see you again soon!\n";

    public static final String DISPLAY_TASK_LIST = "\nHere are the tasks in your list:\n";

    public static final String NUMBER_OF_TASKS = "Now you have %s tasks in the list.";

    public static final String NO_TASKS = "There are currently no tasks in your list. Please add some :)";

    public static final String SAVE_TASKS_ACKNOWLEGEMENT = "Your tasks have been saved to data/tasks.txt ";

    public static final String ACKNOWLEDGEMENT = "Got it. I've added this task:";

    public static final String ACKNOWLEDGEMENT_AS_DONE = "Nice! I've marked this task as done:";

    public static final String ACKNOWLEDGEMENT_AS_UNDONE = "I've marked this task as not done:";

    public static final String FILE_NOT_READABLE_EXCEPTION = "There was an issue with reading from the save file."
            + " Loading Duke with an empty task list";

    public static final String INVALIDIDXINPUT = "Invalid input. Please specify the "
            + "correct index of the task you wish to modify";

    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String SAVE = "save";
    public static final String PRINT = "view";
    public static final String DONE = "done";
    public static final String REMOVE = "remove";
    public static final String EXIT = "exit";

    public static final String TODO_HELP_STATEMENT = "Type \"todo\" \"description of task\""
            + " and press 'Enter' to create a new Todo Task."
            + " E.g. todo Return textbook";

    public static final String DEADLINE_HELP_STATEMENT = "Type \"deadline\" \"description of task\" "
            + "/by \"description of deadline\" and press 'Enter' to create a new Deadline Task. E.g. "
            + "deadline Hand in Homework /by Monday 10am ";


    public static final String PRINT_HELP_STATEMENT = "Type \"view\" and press 'Enter'"
            + " to print out the current list of tasks.";

    public static final String DONE_HELP_STATEMENT = "Type \"done\" and the number of the task from the list,"
            + " then press 'Enter'."
            + "Use \"print\" to display the tasks and their corresponding number first. E.g. done 1\n"
            + "\t\t\t   [This will set that task's status to done/ complete]";

    public static final String REMOVE_HELP_STATEMENT = "Type \"remove\" and the number of the task to"
            + " be removed from the list.\n"
            + "\t\t\t   Use \"print\" to display the tasks and their corresponding number first. E.g. remove 1\n"
            + "\t\t\t   [This will remove that task from the list.]";

    public static final String FOUND_MATCHING_TASKS = "Here are the matching tasks in your list:";

    public static final String NO_MATCHING_TASKS = "____________________________________________________________\n"
            + "There are no "
            + "matching tasks in your list :(\n____________________________________________________________";

    public static final String EXIT_HELP_STATEMENT = "Type \"exit\" and press 'Enter' in order"
            + " to exit the Duke chatbot.";
    public static final String HELP_MESSAGE = String.format("\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n\n%-15s%s\n",
            Constants.TODO, Constants.TODO_HELP_STATEMENT,
            Constants.DEADLINE, Constants.DEADLINE_HELP_STATEMENT,
            Constants.PRINT, Constants.PRINT_HELP_STATEMENT,
            Constants.DONE, Constants.DONE_HELP_STATEMENT,
            Constants.REMOVE, Constants.REMOVE_HELP_STATEMENT,
            Constants.EXIT, Constants.EXIT_HELP_STATEMENT);
}
