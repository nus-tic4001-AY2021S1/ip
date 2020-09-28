package com.example.duke;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DukeTest {
    @Test
    public void dummyTest()
    {

        Todo myTodo=new Todo("todo cut hair",true);
        assertEquals("todo cut hair",myTodo.description);
        assertTrue(myTodo.isDone);

        Deadline myDeadline=new Deadline("Finish Assignment 2","Monday");
        assertEquals("Finish Assignment 2",myDeadline.description);
        assertEquals("Monday",myDeadline.by);
        assertEquals(false,myDeadline.isDone);

        Event myEvent=new Event("Attend seminar","Monday 2-4pm");
        assertEquals("Attend seminar",myEvent.description);
        assertEquals("Attend seminar",myEvent.description);
        assertEquals(false,myEvent.isDone);
    }

}

