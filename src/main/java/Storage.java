import java.util.ArrayList;

public class Storage {
    private ArrayList<Task> tempStorage;
    private boolean isExit;
    Storage(){
        tempStorage = new ArrayList<Task>(100);
        isExit = false;
    }
    public void addToTemp(String toAdd){
        tempStorage.add(new Task(toAdd));
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
