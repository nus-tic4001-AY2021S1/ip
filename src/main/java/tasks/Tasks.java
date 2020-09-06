package tasks;

public class Tasks {

    protected String status;
    protected String description;
    protected String time;
    protected boolean isDone;
    protected String type;


    public Tasks(String description, String time){

        this.description=description;
        this.status="[x]";
        this.time=time;
        this.isDone=false;
    }


    public String toString(){

        return status +" "+description;
    }


}
