package command;

import tasks.Tasks;

import java.util.ArrayList;

public class Storage {



    private ArrayList commandName;

    public Storage(){

        this.commandName = new ArrayList(100);

    }

    public void setCommandName(Tasks obj){
        commandName.add(obj);
    }


    public ArrayList getCommandName(){
            return commandName;
    }

}
