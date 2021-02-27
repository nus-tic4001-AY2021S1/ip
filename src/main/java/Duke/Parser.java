package Duke;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Parser {
    private Ui ui;
    private TaskList tasks;

    public Parser(Ui ui,TaskList tasks){
        this.ui = ui;
        this.tasks = tasks;
    }

    public String handleCommands(String str) throws DukeException{
        String response="";
        Task singleTask;
        int selectedIn;
        String keyword;
        if (!str.equals("") & !str.equals("bye")) {
            if (str.equals("list")) {
                response=ui.printList(tasks.getTasks());
            } else if (str.contains("done")) {
                selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                tasks.getTasks().get(selectedIn).markAsDone();
                response=ui.printMarkAsDone(tasks.getTasks().get(selectedIn));
            } else {
                if (str.split(" ")[0].equals("todo")) {
                    singleTask = new Todo(str.substring(5), 'T');
                    tasks.storeInArray(singleTask);
                    response=ui.printTask(singleTask.toString(), tasks.getSize());
                } else if (str.split(" ")[0].equals("deadline")) {
                    String[] deadline = str.substring(9).split(" /by ");
                    if (deadline.length == 2) {
                        if(checkDateFormat(deadline[1])) {
                            singleTask = new Deadline(deadline[0], 'D', LocalDate.parse(deadline[1]));
                            tasks.storeInArray(singleTask);
                            response=ui.printTask(singleTask.toString(), tasks.getSize());
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
                            response=ui.printTask(singleTask.toString(), tasks.getSize());
                        }else
                            throw new DukeException("OOPS!!! The format of date is not valid");
                    }
                } else if (str.contains("delete")) {
                    selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                    System.out.println("selectedIn:" + selectedIn);
                    singleTask = tasks.getTasks().get(selectedIn);
                    tasks.deleteFromList(selectedIn);
                    response=ui.printDeleteMsg(singleTask, tasks.getSize());
                } else if(str.contains("find")){
                    ArrayList<Task> temp = new  ArrayList<Task>();
                    keyword=str.split(" ")[1];
                    for(Task t:tasks.getTasks()){
                        if(t.getDescription().contains(keyword)){
                            temp.add(t);
                        }
                    }
                    response=ui.printFind(temp);

                }else if(str.equals("help")){
                    response="`list` - List all Tasks from Task List\n" +
                            "`event <description> /at <date>` - Add event to Task List. \nExample: event team meeting /at 2021-01-30\n\n" +
                            "`deadline <description> /by <date>` - Add deadline to Task List. \nExample: deadline return book /by 2021-01-30\n\n"+
                            "`todo <description>` - Add todo to Task List. \nExample: todo read book\n\n"+
                            "`delete <index of task>` - Delete a Task from Task List. \nExample: delete 1\n\n" +
                            "`done <index of task>` - Set a Task's status to done. \nExample: done 1\n\n" +
                            "`find <keyword>` - Find Tasks contains search term stated. \nExample: find book\n\n" +
                            "`help` - Show Help Menu\n\n";
                }
            }
        }
        if(str.equals("bye")) {
            response =ui.exitMessage();
        }
        return response;
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