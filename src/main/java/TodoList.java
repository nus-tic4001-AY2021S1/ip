import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> taskList;

    public TodoList() {
        taskList = new ArrayList<>();
    }

    public void listAllTasks() {
        Ui.showMessage("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
//            Ui.showMessage((i + 1) + "." + "[" + taskList.get(i).getStatusIcon() + "] " + taskList.get(i).getDescription());
            Ui.showMessage((i + 1) + "." +taskList.get(i).toString());
        }
    }


    public void addToDoType(String toAddTaskDetails){
        taskList.add(new Todo(toAddTaskDetails));
    }


    public void addDeadlineType(String toAddTaskDetails){
        String task_description = (toAddTaskDetails.split("/by")[0]).trim();
        String task_deadline=(toAddTaskDetails.split("/by")[1]).trim();
        taskList.add(new Deadline(task_description,task_deadline));
    }

    public void addEventType(String toAddTaskDetails){
        String task_description = (toAddTaskDetails.split("/at")[0]).trim();
        String task_eventDate=(toAddTaskDetails.split("/at")[1]).trim();
        taskList.add(new Event(task_description,task_eventDate));
    }



    public void readTaskFromUser(String input) {
        Ui.showMessage("Got it. I've added this task:");
        int currentNewAddedTaskIndex=(taskList.size()-1);
        Ui.showMessage("  "+taskList.get(currentNewAddedTaskIndex).toString());
        Ui.showMessage("Now you have "+taskList.size()+" tasks in the list.");
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
