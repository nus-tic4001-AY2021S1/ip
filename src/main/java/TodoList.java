import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> taskList;


    /**
     * creating an TodoList object
     */
    public TodoList() {
        taskList = new ArrayList<>();
    }

    public void listAllTasks() {
        for (int i = 0; i < taskList.size(); i++) {

            Ui.showMessage((i + 1) + "." + "[" + taskList.get(i).getStatusIcon() + "] " + taskList.get(i).getDescription());
        }
    }

    public void readTaskFromUser(String input) {
        this.taskList.add(new Task(input));

        Ui.showMessage("added: " + input);
    }


    public void markSelectedTaskDone(String selectedTask) {

        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("") || selectedTask == null) {
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
}
