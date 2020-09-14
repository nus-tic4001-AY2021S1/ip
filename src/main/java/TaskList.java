import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;


import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
 * TaskList: contains the task list e.g., it has operations to add/delete tasks in the list
 * TodoList
 */

/////Level 8. Dates and Times
/////Level 8. Dates and Times
/////Level 9. Find
public class TaskList {

    // An array list of task objects
    private static ArrayList<Task> taskList;

    /**
     * creating an TodoList object
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    public static ArrayList<Task> getList() {
        return taskList;
    }


    /**
     * A method to list done all the tasks from the list and show the list to user.
     * Show the message to user and notify the user that "Here are the tasks in your list"
     */
    public static void listAllTasks() {
        Ui.showMessage("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Ui.showMessage((i + 1) + "." + taskList.get(i).toString());
        }
    }

    public static boolean isValidDateTimeFormat(String format, String value, Locale locale) {
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                    // Debugging purposes
                    //e2.printStackTrace();
                }
            }
        }

        return false;
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Todo"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addToDoType(String toAddTaskDetails) {
        taskList.add(new Todo(toAddTaskDetails));
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Deadline"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addDeadlineType(String toAddTaskDetails) throws DukeException {
        if (!toAddTaskDetails.toLowerCase().contains(" /by")) {
            throw new DukeException("Cannot find '/by' in command.Please enter valid task details.");
        }

        if (toAddTaskDetails.split("(?i)/by").length < 2) {
            throw new DukeException("No deadline time found after keyword /by.Please enter valid task details.");
        }

        String taskDescription = (toAddTaskDetails.split("(?i)/by")[0]).trim();// splits case insensitive
        String taskDeadline = (toAddTaskDetails.split("(?i)/by")[1]).trim();// splits case insensitive

        boolean dateTimeFormatChecker = isValidDateTimeFormat("yyyy-MM-dd", taskDeadline, Locale.ENGLISH); // to check if the user enter the correct date format
        if (!dateTimeFormatChecker) {
            throw new DukeException("Please enter correct deadline Due Date yyyy-MM-dd, example: 2019-12-31");
        }

        LocalDate dueDate = LocalDate.parse(taskDeadline);
        taskList.add(new Deadline(taskDescription, dueDate));


    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Event"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addEventType(String toAddTaskDetails) throws DukeException {
        if (!toAddTaskDetails.toLowerCase().contains(" /at")) {
            throw new DukeException("Cannot find '/at' in command.Please enter valid task details.");
        }

        if (toAddTaskDetails.split("(?i)/at ").length < 2) {
            throw new DukeException("No event time found after keyword /at.Please enter valid task details.");
        }

        String taskDescription = (toAddTaskDetails.split("(?i)/at")[0]).trim();// splits case insensitive
        String taskEventDate = (toAddTaskDetails.split("(?i)/at")[1]).trim();// splits case insensitive

        boolean dateTimeFormatChecker = isValidDateTimeFormat("yyyy-MM-dd HH:mm", taskEventDate, Locale.ENGLISH); // to check if the user enter the correct date format
        if (!dateTimeFormatChecker) {
            throw new DukeException("Please enter correct event Date yyyy-MM-dd HH:mm, example: 2019-12-31 11:10");
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(taskEventDate, formatter);
        taskList.add(new Event(taskDescription, formatDateTime));


    }

    /**
     * A method to read the value from user.
     * Show the message to user and notify the user that a current task is added in the list
     *
     * @param input A String that holds the user input from the terminal
     */
    public void readTaskFromUser(String input) {
        Ui.showMessage("Got it. I've added this task:");
        int currentNewAddedTaskIndex = (taskList.size() - 1);
        Ui.showMessage("  " + taskList.get(currentNewAddedTaskIndex).toString());
        Ui.showMessage("Now you have " + taskList.size() + " tasks in the list.");
    }


    /**
     * A method to delete the task as the user requested.
     * Show the message to user and notify the user that a current task is deleted in the list
     *
     * @param selectedTask A String that holds the user input from the terminal
     */

    public void markSelectedTaskDelete(String selectedTask) {
        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM cannot be found in the task list: Returning to Main Menu");
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (i == taskIndex) {

                    Ui.showMessage("Noted. I've removed this task: ");
                    Ui.showMessage("  " + taskList.get(i).toString());
                    taskList.remove(i);

                }

            }
            Ui.showMessage("Now you have " + taskList.size() + " tasks in the list.");


        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }
    }


    /**
     * A method to mark the selected task as completed
     * update value of the task field:isDone = true
     *
     * @param selectedTask A String that holds the ID (number) of a task
     * @throws NullPointerException           If TASK NUM is Empty/Null: Returning to Main Menu
     * @throws ArrayIndexOutOfBoundsException If TASK NUM is invalid, TASK NUM cannot be found in the task list: Returning to Main Menu
     */
    public void markSelectedTaskDone(String selectedTask) {

        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM cannot be found in the task list: Returning to Main Menu");
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (i == taskIndex) {
                    Ui.showMessage("Nice! I've marked this task as done: ");
                    taskList.get(i).setDone();

                    Ui.showMessage("[" + taskList.get(i).getStatusIcon() + "] " + taskList.get(i).getDescription());
                }

            }


        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }
    }

    /**
     * This method will auto create relevant task from the data file
     * the task could be event task, deadline task, todo task
     *
     * @param line get the task content from txt file, which contains task type, task description, task status
     */
    private void createTaskFromFile(String line) throws ParseException {

        String taskDescription;
        String taskSchedule = null;

        String[] line_arr = line.split("\\|");
        /* get the value of TaskDetail & TaskDeadlineDetail */
        taskDescription = line_arr[2].trim();
        if (line_arr.length > 3) {
            taskSchedule = line_arr[3].trim();
        }

        Task task = new Task("default");
        DateTimeFormatter formatterEventSchedule = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        /* pass the value to Task:  todo / deadline /event, and lable the task status */
        if (line_arr[0].equals("D ") & line_arr[1].equals(" 1 ")) {
            task = new Deadline(taskDescription, LocalDate.parse(taskSchedule));
            task.setDone();
            taskList.add(task);
        } else if (line_arr[0].equals("D ") & line_arr[1].equals(" 0 ")) {
            taskList.add((new Deadline(taskDescription, LocalDate.parse(taskSchedule))));
        } else if (line_arr[0].equals("E ") & line_arr[1].equals(" 1 ")) {
            task = new Event(taskDescription, LocalDateTime.parse(taskSchedule, formatterEventSchedule));
            task.setDone();
            taskList.add(task);
        } else if (line_arr[0].equals("E ") & line_arr[1].equals(" 0 ")) {
            taskList.add(new Event(taskDescription, LocalDateTime.parse(taskSchedule, formatterEventSchedule)));
        } else if (line_arr[0].equals("T ") & line_arr[1].equals(" 1 ")) {
            task = new Todo(taskDescription);
            task.setDone();
            taskList.add(task);
        } else if (line_arr[0].equals("T ") & line_arr[1].equals(" 0 ")) {
            taskList.add(new Todo(taskDescription));
        }


    }


    /**
     * A method to find a task by searching for a keyword.
     * Show the message to user and notify the user that "Here are the matching tasks in your list"
     *
     * @param line get the task content from txt file, which contains keyword
     */
    public void findTaskByKeyword(String line) {
        String taskDescription;
        ArrayList<Task> taskListKeywordFound = new ArrayList<>();

        int matchedCount = 0;
        for (Task task : taskList) {
            taskDescription = task.toString();
            if (taskDescription.toLowerCase().contains(line.toLowerCase())) {
                matchedCount = matchedCount + 1;
//                Ui.showMessage((matchedCount) + "." + taskList.get(i).toString());
                taskListKeywordFound.add(task);  // once there is a match to a task, add this task to the new task list:taskListKeywordFound
            }
        }
        if (matchedCount == 0) {
            Ui.showMessage("Sorry! Cannot find any matched tasks in your list.");
        } else {
            Ui.showMessage("Here are the matching tasks in your list:");
            for (int i = 0; i < taskListKeywordFound.size(); i++) {
                Ui.showMessage((i + 1) + "." + taskListKeywordFound.get(i).toString());  // display the matched tasks to user from the task list:taskListKeywordFound
            }
        }


    }


}










