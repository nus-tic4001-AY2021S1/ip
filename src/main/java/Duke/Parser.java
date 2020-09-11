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
    public  void deleteInArray(int index) throws DukeException{
        if(index < 0 | index >= actualSize){
            throw new DukeException("OOPS!!! The selected index is invalid!");
        }
        for(int i = index;i <= this.actualSize-2;i++ ){
            tasks[i] = tasks[i+1];
        }
        tasks[actualSize-1]=null;
        this.actualSize--;
    }

}