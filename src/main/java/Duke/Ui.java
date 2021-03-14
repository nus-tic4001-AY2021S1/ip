package Duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner in = new Scanner(System.in);
    public void printLogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
    public void greetMessage() {
        System.out.println("Hello! I'm Duke.Duke");
        System.out.println("What can I do for you?");
    }
    public String exitMessage(){
        String exitMsg="";
        exitMsg=("Bye. Hope to see you again soon!");
        return exitMsg;
    }
    public String getInput(Scanner in) throws DukeException{
        String s=in.nextLine().trim();

       if(s.equals("todo") | s.equals("deadline") | s.equals("event") | s.equals("delete") | s.equals("find") )
            throw new DukeException("OOPS!!! The description of a "+s+" cannot be empty");
        else if(!s.startsWith("todo") & !s.startsWith("deadline") & !s.startsWith("event") & !s.startsWith("delete")
              & !s.startsWith("done") & !s.equals("list") & !s.equals("bye") & !s.startsWith("find"))
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        else if(s.startsWith("event") & !s.contains("/at"))
            throw new DukeException("OOPS!!! The date of event cannot be empty");
        else if(s.startsWith("deadline") & !s.contains("/by"))
           throw new DukeException("OOPS!!! The date of deadline cannot be empty");
        else if(s.equals("done") | s.equals("delete"))
           throw new DukeException("OOPS!!! The index of task cannot be empty");
        return s;
    }
    public String getInputForTestOnly(String in) throws DukeException{
        String s=in;

        if(s.equals("todo") | s.equals("deadline") | s.equals("event") | s.equals("delete") | s.equals("find") )
            throw new DukeException("OOPS!!! The description of a "+s+" cannot be empty");
        else if(!s.startsWith("todo") & !s.startsWith("deadline") & !s.startsWith("event") & !s.startsWith("delete")
                & !s.startsWith("done") & !s.equals("list") & !s.equals("bye") & !s.startsWith("find"))
            throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        else if(s.startsWith("event") & !s.contains("/at"))
            throw new DukeException("OOPS!!! The date of event cannot be empty");
        else if(s.startsWith("deadline") & !s.contains("/by"))
            throw new DukeException("OOPS!!! The date of deadline cannot be empty");
        else if(s.equals("done") | s.equals("delete"))
            throw new DukeException("OOPS!!! The index of task cannot be empty");
        return s;
    }
    public String printList(ArrayList<Task> tasks){
        String listStr="";
        int i=1;
        for (Task t:tasks){
            listStr+=((i)+"."+t.toString())+"\n";
            i++;
        }
     return listStr;
    }
    public String printTask(String str,int count){
        String resultStr="";
        resultStr+=("Got it. I've added this task: " + "\n"+str);
        resultStr+=("Now you have "+count+" in the list.");
        return resultStr;
    }
    public String printMarkAsDone(Task t){
        String resultStr="";
        resultStr=( "-----------------\n"+"Nice! I've marked this task as done:\n"+"["+t.getStatusIcon()+"] "+
                t.description);
        return resultStr;
    }
    public void printError(Exception e){
        System.out.println("--------------\n"+e+"\n-------------------");
    }
    public String printDeleteMsg(Task t,int count){
        String resultStr="";
        resultStr=( "Noted. I've removed this task: \n"+"["+t.getStatusIcon()+"]"+
                t.description+"\n Now you have "+count+" tasks in the list.");
        return resultStr;
    }
    public String printFind(ArrayList<Task> tasks){
        String resultStr="";
        resultStr+=("Here are the matching tasks in your list: " + "\n");
        int i=1;
        for (Task t:tasks){
            resultStr+=((i)+"."+t.toString()+"\n");
            i++;
        }
      return resultStr;
    }
}
