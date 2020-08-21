import java.util.ArrayList;

public class Storage {
    private ArrayList<String> tempStorage;
    private boolean isExit;
    Storage(){
        tempStorage = new ArrayList<String>(100);
        isExit = false;
    }
    public void addToTemp(String toAdd){
        tempStorage.add(toAdd);
    }
    public int getSize(){
        return tempStorage.size();
    }
    public String getTask(int i){
        return tempStorage.get(i);
    }
    public void toExit(){
        isExit=true;
    }
    public boolean getIsExit(){
        return isExit;
    }
}
