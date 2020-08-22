import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> taskList;


    /**
     * creating an TodoList object
     */
    public TodoList() {
        taskList = new ArrayList<>();
    }

//    public void addTask() {
//        this.taskList.add(new Task(description));
//    }


    public void listAllTasks() {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("" + (i + 1) + ". " + taskList.get(i).getDescription());
        }
    }

    public void readTaskFromUser(String input) {
        this.taskList.add(new Task(input));
        System.out.println("added: " + input);
    }


}
