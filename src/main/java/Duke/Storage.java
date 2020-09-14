package Duke;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String path;
    private TaskList tasks;
    public Storage (String path){
        this.path=path;
    }
    public void saveToFile(TaskList tasks) throws DukeException{
        try {
            FileWriter fw = null;
            fw = new FileWriter(path, false);
            PrintWriter pw = new PrintWriter(fw);
            for (Task t : tasks.getTasks()) {
                pw.println(t.printToFIle());
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new DukeException("problem encountered while writing data: " + e.getMessage());
        }
    }
    private static Task createTask(String line){
        String[] taskInfo = line.split("\\|");
        Task task;
        boolean isDone = (Integer.parseInt(taskInfo[1].trim())==1);
        if(taskInfo[0].trim().equals("D"))
            task=new Deadline(taskInfo[2],'D',taskInfo[3],isDone);
        else if(taskInfo[0].trim().equals("E"))
            task=new Deadline(taskInfo[2],'E',taskInfo[3],isDone);
        else
            task=new Todo(taskInfo[2],'T',isDone);
        return task;
    }


    public ArrayList<Task> loadTasks() throws DukeException{
        int count=0;
        ArrayList<Task> ts = new ArrayList<Task>();
        try {
            File tasksFile = new File(path);
            Scanner rf= new Scanner(tasksFile);
            while(rf.hasNextLine()) {
                String line= rf.nextLine().trim();
                if(line.trim().isEmpty())continue;
                ts.add(createTask(line));
                count++;
            }
            rf.close();
        }catch (FileNotFoundException e){
            throw new DukeException(e.getMessage());
        }
        return ts;
    }
}
