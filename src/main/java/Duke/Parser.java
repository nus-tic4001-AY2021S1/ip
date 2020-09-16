package Duke;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Ui ui;
    private TaskList tasks;

    public Parser(Ui ui,TaskList tasks){
        this.ui = ui;
        this.tasks = tasks;
    }

    public void handleCommands(String str) throws DukeException{
        Task singleTask;
        int selectedIn;

        if (!str.equals("") & !str.equals("bye")) {
            if (str.equals("list")) {
                ui.printList(tasks.getTasks());
            } else if (str.contains("done")) {
                selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                tasks.getTasks().get(selectedIn).markAsDone();
                ui.printMarkAsDone(tasks.getTasks().get(selectedIn));
            } else {
                if (str.split(" ")[0].equals("todo")) {
                    singleTask = new Todo(str.substring(5), 'T');
                    tasks.storeInArray(singleTask);

                    ui.printTask(singleTask.toString(), tasks.getSize());
                } else if (str.split(" ")[0].equals("deadline")) {
                    String[] deadline = str.substring(9).split(" /by ");
                    if (deadline.length == 2) {
                        if(checkDateFormat(deadline[1])) {
                            singleTask = new Deadline(deadline[0], 'D', LocalDate.parse(deadline[1]));
                            tasks.storeInArray(singleTask);
                            ui.printTask(singleTask.toString(), tasks.getSize());
                        }else {

                            throw new DukeException("OOPS!!! The format of date is not valid");
                        }
                    }
                } else if (str.split(" ")[0].equals("event")) {
                    String[] event = str.substring(6).split(" /at ");
                    if (event.length == 2) {
                        if(checkDateFormat(event[1])) {
                            singleTask = new Event(event[0], 'E', LocalDate.parse(event[1]));
                            tasks.storeInArray(singleTask);
                            ui.printTask(singleTask.toString(), tasks.getSize());
                        }
                    }
                } else if (str.contains("delete")) {
                    selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                    System.out.println("selectedIn:" + selectedIn);
                    singleTask = tasks.getTasks().get(selectedIn);
                    tasks.deleteFromList(selectedIn);
                    ui.printDeleteMsg(singleTask, tasks.getSize());
                }
            }
        }
        if(str.equals("bye")) {
            ui.exitMessage();
        }
    }
    private boolean checkDateFormat(String dateStr){
        /*
        Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
        Matcher matcher = pattern.matcher(dateStr);
        if (matcher.matches()) {
            System.out.println("string '"+dateStr + "' contains at least one alphabets/letters");
        } else {
            System.out.println("string '"+dateStr + "' doesn't contains any alphabets/letters value");
        }

         */
        DateFormat sdf = new SimpleDateFormat(dateStr);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}