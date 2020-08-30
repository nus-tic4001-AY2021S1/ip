package Task;

public class Tasks {
    protected String type;
    protected String description;
    protected String statusIcon;
    protected boolean isdone;

    public Tasks(String description) {
        this.description = description;
        this.isdone = false;
        this.statusIcon="[✗]";
    }

    public String getTaskDescription() {
        return description;
    }

    public String getTaskStatus() {
        if (isdone ==true){
            return "[✓]";
        }
        else return"[✗]";
    }

    public void setTaskStatus(boolean status){
        this.isdone=status;
        setTaskStatusIcon();

    }

    public void setTaskStatusIcon(){
        if(isdone){
            this.statusIcon="[✓]";
        }
        else{
            this.statusIcon="[✗]";
        }
    }

    @Override
    public String toString() {
        return type + statusIcon + " " + description;
    }
}
