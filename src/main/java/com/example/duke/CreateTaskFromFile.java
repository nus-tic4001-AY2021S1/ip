package com.example.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreateTaskFromFile {
    public static ArrayList<Task> getTasksFromFile(String filepath) {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        try {
            List<String> lines = getLines(filepath);
            for (String line : lines) {
                if (line.trim().isEmpty()) { //ignore empty lines
                    continue;
                }
                loadedTasks.add(createTask(line)); //convert the line to a task and add to the list
            }
        } catch (FileNotFoundException e) {
            printError("problem encountered while loading data: " + e.getMessage());
        }
        return loadedTasks;
    }

    private static List<String> getLines(String data) throws FileNotFoundException{
        File f = new File(data);
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        List <String> myStrings=new ArrayList<>();
        while (s.hasNext()) {
            myStrings.add(s.nextLine());
        }
        return myStrings;
    }

    private static Task createTask(String myTask){
        String taskType=myTask.split("\\|")[0].trim();
        String doneOrNot=myTask.split("\\|")[1].trim();
        String taskDescription=myTask.split("\\|")[2].trim();


        //System.out.println(taskType);
        if (taskType.contains("T")){
            boolean done=false;
            if (Integer.parseInt(doneOrNot)==1)
                done=true;

            // System.out.println(doneOrNot);
            return new Todo(taskDescription, done);

        }
        else if (taskType.contains("D")){
            String Deadline=myTask.split("\\|")[3].trim();

            boolean done=false;
            if (doneOrNot=="1")
                done=true;
            return new Deadline(taskDescription, Deadline, done);

        }
        else if (taskType.contains("E")){
            String Duration = myTask.split("\\|")[3].trim();
            boolean done=false;
            if (doneOrNot=="1")
                done=true;
            return new Deadline(taskDescription, Duration, done);

        }
        else {
            return null;
        }
    }

    private static void printError(String errorMsg) {
        System.out.println(errorMsg+ " error! please try again");
    }



}
