package duke;

import jdk.jfr.Event;
import org.junit.jupiter.api.Test;
import ui.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class DukeTest {
    @Test
    public void duke() throws IOException, DukeException {
        //String filePath = "ip/record.txt";
        String command = "Todo Adding New";

        ArrayList<Task> expectedTasks = new ArrayList<> ();
        expectedTasks.add(new ToDos("Adding New"));

        ArrayList<Task> actualTasks = new ArrayList<> ();
        Parser parser = new Parser(command);
        TaskList tasklist = new TaskList(actualTasks);
        parser.processInput(command,actualTasks);
        actualTasks = tasklist.getTasksArr();


        assertEquals(expectedTasks,actualTasks);



        //String err = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
        //        "Please re-input or enter bye to terminate the program");


       // tasks.set(0, new parser.validateCommand("Testing"));

        //.input(new Scanner(this.getClass().getResourceAsStream("/input.txt")));

        //(Array.asList("Steel Man of", "Fast and Furious",
        //        "Day after Tomorrow The", "Man of Steel", "Tomorrow The Day after", "Furious Fast and"));
        //assertEquals(2,2);
    }

    @Test
    public void checkDeleteFunction() throws IOException, DukeException {
        //String filePath = "record.txt";
        //Storage storage = new Storage(filePath);
        //Duke duke = new Duke(filePath);

        ArrayList<Task> expectedTasks = new ArrayList<> ();
        expectedTasks.add(new ToDos("Adding New One"));
       // expectedTasks.add(new Deadlines("Adding New Two", "2/12/2019"));


        ArrayList<Task> actualTasks = new ArrayList<> ();
        String commandAdd = "Todo Adding New One";
        String commandAdd2 = "Deadlines Adding New 2 /by 2/12/2019";
        String deleteCommand = "delete 2";
        Parser parser = new Parser(commandAdd);
        TaskList tasklist = new TaskList(actualTasks);
        parser.processInput(commandAdd,actualTasks);
        parser.processInput(commandAdd2, actualTasks);
        actualTasks = tasklist.getTasksArr();

        parser.processInput(deleteCommand, actualTasks);

        //expectedTasks.add(new ToDos("Adding Todo"));
        //expectedTasks.add(new Deadlines("Adding Deadlines", "2020=08-21"));
        //expectedTasks.add(new Events("Adding Events", "2020-09-01"));

        //storage.createFile();
        //ArrayList<Task> actualTasks = new ArrayList<> ();
        //actualTasks = storage.load();

        assertEquals(expectedTasks,actualTasks);
    }
}