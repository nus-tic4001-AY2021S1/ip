package ui;

import duke.*;

import java.util.ArrayList;

public class TaskList {

    ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        ArrayList<Task> tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasksArr() {
        return tasks;
    }

    public static void deleteTask (ArrayList<Task> tasks, String command) {
        int index = 0;
        if(command.contains(" ")) {
            index = Integer.parseInt(command.substring(7));
        } else {
            index = Integer.parseInt(command.substring(6));
        }

        try {
            Ui.replyDeleteTask(tasks, index);
            tasks.remove(index-1);
        } catch (IndexOutOfBoundsException e) {
            Ui.errIndexOutOfBoundsException();
        }
    }

    public static void addTodo(ArrayList<Task> tasks, String input, int count) throws DukeException {
        if (input.length() < 6) {
            throw new DukeException("☹ OOPS!!! The description of a Todo cannot be empty.\n" +
                    "Please re-input or enter bye to terminate the program\n");
        } else {
            tasks.add(new ToDos(input.substring(5)));
            Ui.replyLine(tasks, input, count);
        }
    }
    public static void addDeadlines(ArrayList<Task> tasks, String input, int count) throws DukeException{
        String errorEmpty = "☹ OOPS!!! The description of a Deadlines cannot be empty.\n " +
                "Please re-input or enter bye to terminate the program\n";
        String errorMissing = "You have input your Schedule or Wrong format\nPlease include -> /by when\n";

        if(!input.contains(" ")) {
            throw new DukeException(errorEmpty);
        } else if(input.length()-1 == input.indexOf(" ")) {
            throw new DukeException(errorEmpty);
        } else if(!input.contains("/by")) {
            throw new DukeException(errorMissing);
        } else {
            int index = input.indexOf("/by");
            String schedule = input.substring(index + 4);
            String taskName = input.substring(input.indexOf(" ")+1, index);
            tasks.add(new Deadlines(taskName, schedule));
            Ui.replyLine(tasks, input, count);
        }

    }
    public static void addEvents(ArrayList<Task> tasks, String input, int count) throws DukeException{
        String errorEmpty = "☹ OOPS!!! The description of a Events cannot be empty.\n " +
                "Please re-input or enter bye to terminate the program\n";
        String errorMissing = "You have not input your Schedule or Wrong format. \nPlease include -> /at when\n";
        String schedule, taskName;

        if(!input.contains(" ")) {
            throw new DukeException(errorEmpty);
        } else if(input.length()-1 == input.indexOf(" ")) {
            throw new DukeException(errorEmpty);
        } else if(!input.contains("/at")) {
            throw new DukeException(errorMissing);
        } else {
            int index = input.indexOf("/at");
            schedule = input.substring(index + 4);
            taskName = input.substring(input.indexOf(" ")+1, index);
            tasks.add(new Events(taskName, schedule));
            Ui.replyLine(tasks, input, count);
        }
    }
}
