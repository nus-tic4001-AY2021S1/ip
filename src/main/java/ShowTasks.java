import java.util.ArrayList;

public class ShowTasks {


    private ArrayList commandName;
    private ArrayList check;
    private ArrayList type;
    private ArrayList time;

    int tick1 = 10003;
    int cross1 = 9587;
    private String tick;
    private String cross;



    public ShowTasks(){

        this.commandName = new ArrayList(100);
        this.check = new ArrayList(100);
        this.type = new ArrayList(100);
        this.time = new ArrayList(100);
        this.tick= Character.toString((char)tick1);
        this.cross= Character.toString((char)cross1);

    }

    public void setCommandName(String obj){
        commandName.add(obj);
    }
    public void setCheck(){
        check.add(cross);
    }
    public void setCheck(int obj){
        check.set(obj-1,tick);
    }
    public void setType(String obj){
        type.add(obj);
    }
    public void setTime(String obj){
        time.add(obj);
    }

    public ArrayList getCommandName() {
        return commandName;
    }

    public ArrayList getCheck() {
        return check;
    }

    public ArrayList getType() {
        return type;
    }

    public ArrayList getTime(){
        return time;
    }
}
