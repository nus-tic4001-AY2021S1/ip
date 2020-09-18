package duke;

import duke.tasks.TaskList;

import java.io.IOException;

public class FindCommand {
    protected TaskList findResult;
    FindCommand(){
        findResult=new TaskList();
    }
    public void execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException {
        if(others.isEmpty()){
            throw new DukeException("The find term cannot be empty.");
        }
        for(int i=0;i<taskList.getSize();i++){
            if(taskList.getTask(i).getDescription().contains(others)){
                findResult.addTask(taskList.getTask(i));
            }
        }
        ui.indentPrint("Here are the matching tasks in your list:");
        for(int j=0;j<findResult.getSize();j++){
            ui.indentPrint((j+1)+". "+findResult.getTask(j).toString());
        }
    }
}
