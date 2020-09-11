package Duke;

import java.io.*;
import java.util.*;

public class Parser {
    private ArrayList<Task> tasks;
    private int arrSize;
    private int actualSize;

    public Parser(ArrayList<Task> tasks,int arrSize){
        this.tasks = tasks;
        this.arrSize=arrSize;

    }
    public void storeInArray(Task t) {
       tasks.add(t);
    }
    public void deleteFromList(int index) {
        tasks.remove(index);
    }
    public void saveToFile(ArrayList<Task> tasks) throws DukeException{
        try {
            FileWriter fw = null;
            fw = new FileWriter("Duke.txt", false);
            PrintWriter pw = new PrintWriter(fw);
            for (Task t : tasks) {
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

    public int loadTasks(ArrayList<Task> tasks) throws DukeException{
        int count=0;
        try {
            File tasksFile = new File("Duke.txt");
            Scanner rf= new Scanner(tasksFile);
            while(rf.hasNextLine()) {
                String line= rf.nextLine().trim();
                if(line.trim().isEmpty())continue;
                tasks.add(createTask(line));
                count++;
            }
            rf.close();
        }catch (FileNotFoundException e){
            throw new DukeException(e.getMessage());
        }
        return count;
    }
}