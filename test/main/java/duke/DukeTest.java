package main.java.duke;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    @Test
    public void createTodo(){
        Task taskA = new Todo("a todo task",'T',true);
        Task taskB = new Storage().createTask("T|1|a todo task");
        assertEquals(taskB.toString(),taskA.toString());
    }
    public void createEvent(){
        Task taskA = new Event("a todo task",'T', LocalDate.parse("2020-09-30"),false);
        Task taskB = new Storage().createTask("E|0|a todo task|2020-09-30");
        assertEquals(taskB.toString(),taskA.toString());
    }
    public void createDeadline(){
        Task taskA = new Deadline("a todo task",'T', LocalDate.parse("2020-09-30"),false);
        Task taskB = new Storage().createTask("D|0|a todo task|2020-09-30");
        assertEquals(taskB.toString(),taskA.toString());
    }

    public String getOutput(String in){
        Ui ui = new Ui();
        try {
            ui.getInputForTestOnly(in);
        }catch (DukeException e){
            return e.getMessage();
        }
        return "Didn't catch error";
    }
    public void testCatchInputException(){
       String msg = getOutput("deadline a deadline task");
        assertEquals("OOPS!!! The date of deadline cannot be empty",msg);
       msg = getOutput("todo");
        assertEquals("OOPS!!! The description of a todo cannot be empty",msg);
        msg = getOutput("anything");
        assertEquals("OOPS!!! I'm sorry, but I don't know what that means :-(",msg);
    }
    public void testMarkAsDone(){
        Task taskA = new Todo("a todo task",'T',true);
        Task taskB = new Todo("a todo task",'T',false);
        taskB.markAsDone();
        assertEquals(taskB.toString(),taskA.toString());
    }
}
