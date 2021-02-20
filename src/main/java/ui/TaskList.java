package ui;

import duke.Deadlines;
import duke.DukeException;
import duke.Events;
import duke.Global;
import duke.RecurrTask;
import duke.Task;
import duke.ToDos;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * This class in charge of performing action related to TaskList (only RAM, not related to Memory)
 * Adding new Task, delete task.
 */
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

    public static void deleteTask(ArrayList<Task> tasks, String command) throws DukeException {
        int index;
        if (command.contains(" ")) {
            index = Integer.parseInt(command.substring(7));
        } else {
            index = Integer.parseInt(command.substring(6));
        }

        try {
            Ui.replyDeleteTask(tasks, index);
            tasks.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            String indexOutErrMsg = Global.PATTERNLINE + "\nFriend, You do not have so much task in the list\n";
            throw new DukeException(indexOutErrMsg);
        }
    }

    public static String addTodo(ArrayList<Task> tasks, String input, int count) throws
            DukeException, IOException {

        String emptyErrMsg = "☹ OOPS!!! The description of a Todo cannot be empty.\n"
                + "Please re-input or enter bye to terminate the program\n";
        int index;
        String taskName;
        String remarks;

        if (input.length() < 6) {   //Check if the input is a valid
            throw new DukeException(emptyErrMsg);
        } else if (input.contains("/memo")) {
            index = input.indexOf("/memo");
            taskName = input.substring(5, index - 1);
            remarks = input.substring(index + 6);
            tasks.add(new ToDos(taskName, remarks));
        } else {
            tasks.add(new ToDos(input.substring(5)));
        }

        Storage.addToFile(tasks);
        return Ui.replyLine(tasks, input, count);
    }

    public static String addDeadlines(ArrayList<Task> tasks, String input, int count) throws
            DukeException, IOException {

        if (!input.contains(" ")) {     //Check if the input is a valid
            throw new DukeException(Ui.deadlineErrEmpty());
        } else if (input.length() - 1 == input.indexOf(" ")) {
            throw new DukeException(Ui.deadlineErrEmpty());
        } else if (!input.contains("/by")) {
            throw new DukeException(Ui.deadlineNoBy());
        } else if (input.contains("/memo")) {
            int indexS = input.indexOf(" ");
            int indexD = input.indexOf("/by");
            int indexM = input.indexOf("/memo");

            String taskName = input.substring(indexS + 1, indexD - 1);
            String memo = input.substring(indexM + 7);
            String schedule;

            if ((indexM - indexD) > 16) {
                int timeIndex = input.indexOf(" ",indexD + 7);
                LocalTime timeline = LocalTime.parse(input.substring(timeIndex + 1, indexM - 1));
                schedule = input.substring(indexD + 4, timeIndex);
                LocalDate dateline = LocalDate.parse(schedule);
                tasks.add(new Deadlines(taskName, dateline, timeline, memo));
            } else {
                schedule = input.substring(indexD + 4, indexM - 1);
                LocalDate dateline = LocalDate.parse(schedule);
                tasks.add(new Deadlines(taskName, dateline, memo));
            }

            //return Ui.replyLine(tasks, input, count);

        } else {
            int index = input.indexOf("/by");
            String taskName = input.substring(input.indexOf(" ") + 1, index - 1);

            if (input.indexOf(" ",index + 7) != -1) {
                int timeIndex = input.indexOf(" ",index + 7);
                LocalTime timeline = LocalTime.parse(input.substring(timeIndex + 1));
                String schedule = input.substring(index + 4, timeIndex);
                LocalDate dateline = LocalDate.parse(schedule);
                tasks.add(new Deadlines(taskName, dateline, timeline));
            } else {
                String schedule = input.substring(index + 4);
                LocalDate dateline = LocalDate.parse(schedule);
                tasks.add(new Deadlines(taskName, dateline));
            }
            //return Ui.replyLine(tasks, input, count);
        }

        Storage.addToFile(tasks);
        return Ui.replyLine(tasks, input, count);
    }

    public static String addEvents(ArrayList<Task> tasks, String input, int count) throws DukeException, IOException {
        String schedule;
        String taskName;

        if (!input.contains(" ")) {
            throw new DukeException(Ui.eventErrEmpty());
        } else if (input.length() - 1 == input.indexOf(" ")) {
            throw new DukeException(Ui.eventErrEmpty());
        } else if (!input.contains("/at")) {
            throw new DukeException(Ui.eventNoAt());
        } else if (input.contains("/memo")) {
            int indexA = input.indexOf("/at");
            int indexM = input.indexOf("/memo");
            schedule = input.substring(indexA + 4, indexM - 1);
            taskName = input.substring(input.indexOf(" ") + 1, indexA - 1);
            String memo = input.substring(indexM + 6);
            tasks.add(new Events(taskName, schedule, memo));
            //return Ui.replyLine(tasks, input, count);
        } else {
            int index = input.indexOf("/at");
            schedule = input.substring(index + 4);
            taskName = input.substring(input.indexOf(" ") + 1, index);
            tasks.add(new Events(taskName, schedule));
            //return Ui.replyLine(tasks, input, count);
        }

        Storage.addToFile(tasks);
        return Ui.replyLine(tasks, input, count);
    }

    public static String addRecurringTasks(ArrayList<Task> tasks, String input, int count) throws DukeException {

        String errReply = "☹ OOPS!!! The description of a Todo cannot be empty.\n"
                + "Please re-input or enter bye to terminate the program\n";

        if (input.length() < 7) {
            throw new DukeException(errReply);
        } else if (input.contains("/memo")) {
            int indexS = input.indexOf(" ");
            int indexM = input.indexOf("/memo");
            String taskType = input.substring(0, indexS);
            String taskName = input.substring(indexS + 1);
            String memo = input.substring(indexM + 5);
            tasks.add(new RecurrTask(taskName, taskType, memo));
            return Ui.replyLine(tasks, input, count);
        } else {
            int index = input.indexOf(" ");
            tasks.add(new RecurrTask(input.substring(index + 1), input.substring(0, index)));
            return Ui.replyLine(tasks, input, count);
        }
    }

    public static boolean isDuplicates(ArrayList<Task> tasks, String input) {
        int index = input.indexOf(" ");
        String taskName;
        String newInputTaskName;

        if (input.contains("/by")) {
            int indexBy =  input.indexOf("/by");
            newInputTaskName = input.substring(index + 2, indexBy - 2);
        } else if (input.contains("/at")) {
            int indexAt = input.indexOf("/at");
            newInputTaskName = input.substring(index + 2, indexAt - 2);
        } else if (input.contains("/memo")) {
            int indexM = input.indexOf("/memo");
            newInputTaskName = input.substring(index + 2, indexM - 2);
        } else {
            newInputTaskName = input.substring(index + 2);
        }

        for (int i = 0; i < tasks.size(); i++) {
            taskName = tasks.get(i).getTask();
            if (taskName.contains(newInputTaskName)) {
                return true;
            }
        }
        return false;
    }
}
