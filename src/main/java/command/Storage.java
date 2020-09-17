package command;

import tasks.Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    String filePath="/Users/linbinhui/Documents/TIC4001/data/duke.txt";

    private ArrayList commandName;

    public Storage(){

        this.commandName = new ArrayList(100);

    }

    public void setCommandName(Tasks obj){
        commandName.add(obj);
    }

    public void setCommandName(String obj){
        commandName.add(obj);
    }


    public ArrayList getCommandName(){
            return commandName;
    }


    public ArrayList getCommandName1(){
        return new ArrayList(commandName);
    }

    private void fileChecker() {
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void saveToFile() {
        try {
            fileChecker();
            FileWriter myWriter = new FileWriter(filePath, false);
            System.out.println();
            for (Object task : commandName) {
                System.out.println(task.toString());
                String obj = task.toString().replace("][", "|").replace("[", "")
                        .replace("]", "|").replace("(", "|").replace(")", "")
                        .replace("x", "0").replace("c", "1");
                System.out.println(obj);
                myWriter.write(obj);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                divider(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void divider(String data){
        String[] words=data.split("\\|");
        String word0=words[0];
        String word1=words[1];
        if(word1.equals("0")){
            word1="x";
        }
        else {
            word1="c";
        }
        String word2=words[2];

        if(words.length<=2){
            data = "[" + word0 + "]" + "[" + word1 + "] " + word2;
        }
        else{
            String word3=words[3];
            data = "[" + word0 + "]" + "[" + word1 + "] " + word2 + "(" + word3 + ")";

        }


        setCommandName(data);
    }

}
