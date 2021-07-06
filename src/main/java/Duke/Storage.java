package Duke;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

//deals with loading tasks from the file and saving tasks in the file
class Storage {
    private String filePath;
    private TaskList taskList;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.taskList = new TaskList();
    }

    public TaskList load(){
        File dukeFile = new File(this.filePath);
        try {
            Scanner myReader = new Scanner(dukeFile);
            while (myReader.hasNextLine()) {
                String instructions = myReader.nextLine();
                String type = instructions.split(" \\| ",4)[0];
                String done = instructions.split(" \\| ",4)[1];
                String description = instructions.split(" \\| ",4)[2];

                switch(type){
                    case "T":
                        Task newTodo = new Todo(description);
                        if(done.equals("1")){
                            newTodo.markAsDone();
                        }
                        this.taskList.getTasks().add(newTodo);
                        break;

                    case "D":
                        String dTime = instructions.split(" \\| ",4)[3];
                        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("MMM d yyyy").toFormatter();
                        Task newDeadline = new Deadline(description, LocalDate.parse(dTime,df));
                        if(done.equals("1")){
                            newDeadline.markAsDone();
                        }
                        this.taskList.getTasks().add(newDeadline);
                        break;

                    case "E":
                        String eTime = instructions.split(" \\| ",4)[3];
                        DateTimeFormatter ef = new DateTimeFormatterBuilder().appendPattern("MMM d yyyy").toFormatter();
                        Task newEvent = new Event(description, LocalDate.parse(eTime,ef));
                        if(done.equals("1")){
                            newEvent.markAsDone();
                        }
                        this.taskList.getTasks().add(newEvent);
                        break;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while loading text file.");
            e.printStackTrace();
        }

        return this.taskList;
    }

    public void saveToFile(TaskList taskList){
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(this.filePath));
            for(int i=0; i<taskList.getSize(); i++){
                myWriter.write(writeToFile(taskList.getTask(i)));
                if(i != taskList.getSize()-1){
                    myWriter.newLine();
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred in saving file.");
            e.printStackTrace();
        }
    }

    public String writeToFile(Task t){
        int done = 0; //default false
        if(t.getIsDone()){
            done = 1;
        }

        //[command] [done] [description] [time]
        if(t instanceof Todo){
            return "T | " + done + " | " + t.getDescription();
        }
        else if(t instanceof Deadline){
            return "D | " + done + " | " + t.getDescription() + " | " + ((Deadline)t).getBy();
        }
        else if(t instanceof Event){
            return "E | " + done + " | " + t.getDescription() + " | " + ((Event)t).getAt();
        }
        else{
            return "";
        }
    }
}

