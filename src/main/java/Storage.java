import Task.Tasks;
import Task.Deadlines;
import Task.Events;
import Task.ToDos;
import Exceptions.DukeException;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Storage {

    static final String CURRENTWORKINGDIR = System.getProperty("user.dir");
    private String path;
    private File f;

    public Storage(String path) {
        this.path = CURRENTWORKINGDIR+path;
        this.f = new File(path);
    }

    public void loadFromFile(TaskList tasks) throws IOException,DukeException {
        if(f.exists()){
            Scanner s = new Scanner(f);

            while (s.hasNext()) {
                String line = s.nextLine();
                String[] TaskDetail= line.split("\\|");

                String taskDate = "unknown date";
                String taskType = TaskDetail[0];
                boolean taskStatus = checkStatus(TaskDetail[1]);
                String taskDescription = TaskDetail[2];
                if(TaskDetail.length == 4){
                    taskDate = TaskDetail[3];
                }
                try {
                    switch (taskType) {
                        case "T":
                            tasks.add(createToDoTask(taskDescription,taskStatus));
                            break;
                        case "D":
                            tasks.add(createDeadlineTask(taskDescription,taskDate,taskStatus));
                            break;
                        case "E":
                            tasks.add(createEventTask(taskDescription,taskStatus,taskDate));
                            break;
                        default:
                            throw new DukeException("☹ OOPS!!!There are undefined task type in the file.");
                    }
                }catch(Exception e){
                    throw new DukeException("☹ OOPS!!!I am unable to read from the file,please make sure the file is in the correct format.");
                }
            }
        }else{
            createDataFile(path);
        }
    }

    private static ToDos createToDoTask(String taskDescription, boolean tasStatus) {
        ToDos todo= new ToDos(taskDescription);
        todo.setTaskStatus(tasStatus);
        return todo;
    }

    private static Events createEventTask(String taskDescription, boolean tasStatus, String taskDate) {
        Events event = new Events(taskDescription,taskDate);
        event.setTaskStatus(tasStatus);
        return event;
    }

    private static Deadlines createDeadlineTask(String taskDescription, String taskDate, boolean tasStatus) {
        Deadlines ddl = new Deadlines(taskDescription, taskDate);
        ddl.setTaskStatus(tasStatus);
        return ddl;
    }


    private static boolean checkStatus(String content) {
        return content.equalsIgnoreCase("1");
    }


    public void saveToFile(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(path);

        Iterator<Tasks> i = tasks.iterator();
        while (i.hasNext()) {
            fw.write(i.next().saveToString());
            fw.write("\n");
        }
        fw.close();
    }

    private static void createDataFile(String path) throws IOException {
        String folderPath = CURRENTWORKINGDIR + "/data";
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        FileWriter fw = new FileWriter(path);
        fw.close();
    }
}
