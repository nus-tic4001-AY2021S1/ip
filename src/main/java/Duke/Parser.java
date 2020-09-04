package Duke;

public class Parser {
    private Task[] tasks;
    private int arrSize;
    private int actualSize;

    public Parser(Task[] tasks,int arrSize){
        this.tasks = tasks;
        this.arrSize=arrSize;

    }
    public void storeInArray(Task t,int index) {
        tasks[index]=t;
        this.actualSize=index+1;
    }

}