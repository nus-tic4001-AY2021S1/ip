package duke;

import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.Todo;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String storageFilePath="../ip/data/duke.txt";
    private ArrayList<Task> tempStorage;
    private boolean isExit;
    Storage(){
        tempStorage = new ArrayList<>(100);
        isExit = false;
        try{
            loadFromFile();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public void loadFromFile() throws IOException{
        File storage=new File(storageFilePath);
        BufferedReader fileReader = new BufferedReader(new FileReader(storage));
        String savedTask;
        while((savedTask = fileReader.readLine())!=null) {
            String taskType = savedTask.split(" \\| ",4)[0];
            String isDone = savedTask.split(" \\| ",4)[1];
            String taskDescription = savedTask.split(" \\| ",4)[2];

            switch(taskType){
                case "T":
                    addToDoToTemp(taskDescription);
                    if(isDone.matches("1")){
                        setDoneAt(getSize()-1);
                    }
                    break;
                case "D":
                    String taskDeadline = savedTask.split(" \\| ",4)[3];
                    tempStorage.add(new Deadline(taskDescription,taskDeadline));
                    if(isDone.matches("1")){
                        setDoneAt(getSize()-1);
                    }
                    break;
                case "E":
                    String taskEventTime = savedTask.split(" \\| ",4)[3];
                    tempStorage.add(new Event(taskDescription,taskEventTime));
                    if(isDone.matches("1")){
                        setDoneAt(getSize()-1);
                    }
                    break;
            }
        }
        fileReader.close();
    }
    public void saveToFile() throws IOException {
        File storage = new File(storageFilePath);
        BufferedWriter toSaveTask = new BufferedWriter(new FileWriter(storage));
        for(int i = 0;i< getSize();i++){
            toSaveTask.write(outputTaskForSave(tempStorage.get(i)));
            if(i!=getSize()-1){
                toSaveTask.newLine();
            }
        }
        toSaveTask.close();
    }
    public String outputTaskForSave(Task toSave){
        int isDone=0;
        if(toSave.getIsDone()){
            isDone=1;
        }
        if(toSave instanceof Deadline){
            return "D | "+isDone+" | "+ toSave.getDescription()+ " | "+((Deadline) toSave).getBy();
        }else if(toSave instanceof Event){
            return "E | "+isDone+" | "+ toSave.getDescription()+ " | "+((Event) toSave).getAt();
        }else if(toSave instanceof Todo){
            return "T | "+isDone+" | "+ toSave.getDescription();
        } else {
            return "";
        }
    }
    public void addToDoToTemp(String toAdd){
        tempStorage.add(new Todo(toAdd));
    }
    public void addDeadlineToTemp(String toAdd) throws DukeException{
        if(!toAdd.contains(" /by ")){
            throw new DukeException("No /by found in command.");
        }
        String description = toAdd.split(" /by ")[0];
        if(toAdd.split(" /by ").length<2){
            throw new DukeException("No event time found after keyword /by .");
        }
        String by = toAdd.split(" /by ")[1];
        tempStorage.add(new Deadline(description,by));
    }
    public void addEventToTemp(String toAdd) throws DukeException{
        if(!toAdd.contains(" /at ")){
            throw new DukeException("No /at found in command.");
        }
        String description = toAdd.split(" /at ")[0];
        if(toAdd.split(" /at ").length<2){
            throw new DukeException("No event time found after keyword /at .");
        }
        String at = toAdd.split(" /at ")[1];
        tempStorage.add(new Event(description,at));
    }
    public Task deleteTaskAt(int i){
        return tempStorage.remove(i);
    }
    public int getSize(){
        return tempStorage.size();
    }
    public Task getTask(int i){
        return tempStorage.get(i);
    }
    public void toExit(){
        isExit=true;
    }
    public boolean getIsExit(){
        return isExit;
    }
    public void setDoneAt(int i){tempStorage.get(i).setDone();}
}
