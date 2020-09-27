package com.example.duke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Duke (String filePath) {
        ui=new Ui();
        storage=new Storage(filePath);
        try {
            tasks= new TaskList(storage.load());
        } catch (DukeException e) {
           ui.showLoadingError();
           tasks=new TaskList();
        }

    }
    public void run (){
        ui.printWelcome();
        boolean isExit=false;
        while(!isExit) {
            String fullCommand = ui.readCommand();
            //System.out.println(fullCommand);
            Command c = Parser.parse(fullCommand);
            c.execute(tasks,ui);
            isExit=c.isExit();
        }
    }

    public static void main(String[] args) {
        new Duke("/Users/januariusjang/Downloads/iP/data/tasks.txt").run();
    }


    /*public static void main(String[] args) throws IOException {

        ArrayList<Task> taskList = new ArrayList<Task>();
        String commandKeyword;
        taskList=CreateTaskFromFile.getTasksFromFile("/Users/januariusjang/Downloads/iP/data/tasks.txt");
        System.out.println(taskList.size() + " tasks have been preloaded in the system\n");
        System.out.println("Hello! I'm Duke\n" );
        System.out.println("What can I do for you?\n" );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textInput = reader.readLine();

        while(!textInput.equals("bye")) {

                String[]arrayOfStr=textInput.split(" ",2);


            switch (arrayOfStr[0]) {
                case "list":
                    if( taskList.size()<1){
                        System.out.println("Sorry, no Tasks to list");
                    }
                    for (int i = 0; i < taskList.size();i++)
                    {
                        System.out.println(i+1 + taskList.get(i).toString());
                    }
                    break;

                case "done":
                    int index=Integer.parseInt(arrayOfStr[1])-1;
                    taskList.get(index).markAsDone();
                    System.out.println("Nice! I've marked this task as done: "+ "[" +taskList.get(index).getStatusIcon() +"] "  +taskList.get(index).toString());

                    break;

                case "deadline":
                    try{
                        String[]arrayOfDoneDetails=arrayOfStr[1].split("by ",2);
                        Task d=new Deadline(arrayOfDoneDetails[0],arrayOfDoneDetails[1] );
                        taskList.add((d));
                        System.out.println("Got it. I've added this task: \n" + d.toString());
                        System.out.println("Now you have " + taskList.size()+ " tasks in the list");
                    }
                    catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println("Sorry, you will need to enter a description of the Todo task");
                    }
                    break;

                case "event":
                    try{
                        String[]arrayOfEventDetails=arrayOfStr[1].split("at ",2);
                        Task e=new Event(arrayOfEventDetails[0],arrayOfEventDetails[1] );
                        taskList.add((e));
                        System.out.println("Got it. I've added this task: \n" + e.toString());
                        System.out.println("Now you have " + taskList.size()+ " tasks in the list");
                    }
                    catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println("Sorry, you will need to enter a description or details for the Event");
                    }
                    break;
                case "todo":
                    try{
                        Task t=new Todo(arrayOfStr[1]);
                        taskList.add((t));
                        System.out.println("Got it. I've added this task: \n" + t.toString());
                        System.out.println("Now you have " + taskList.size()+ " tasks in the list");
                    }
                    catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println("Sorry, you will need to enter a description of the Todo task");
                    }
                    break;

                case "delete":{
                    int taskNumToDelete=Integer.parseInt(arrayOfStr[1]);
                    if (taskNumToDelete>taskList.size()){
                        System.out.println("Sorry. The index number seems wrong. Pls retry the command\n");
                    }
                    else{
                        taskNumToDelete=taskNumToDelete-1;
                        System.out.println("Noted. I've removed this task:\n");
                        System.out.println(taskList.get(taskNumToDelete).toString());
                        taskList.remove(taskNumToDelete);
                        System.out.println("\nyou have " +taskList.size()+ " tasks in the list");
                    }
                    break;
                 }
                case "save":{
                    SaveTaskToFile.saveFile(taskList);
                }

                default:
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

            textInput = reader.readLine();
        }

        System.out.println(" Bye.Hope to see you again soon!\n" );

    }*/
}
