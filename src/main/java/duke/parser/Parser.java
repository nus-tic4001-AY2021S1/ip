package duke.parser;

import duke.task.TaskList;
import duke.ui.UI;

public class Parser {
    /**
     * @param line The entire user input.
     */
    String getCommandWord(String line) {
        return line.trim().split(" ")[0];
    }

    /**
     * @param line  The entire user input.
     * @param ui    The UI created in the Duke class.
     * @param tasks The TaskList created in the Duke class.
     */
    public boolean parseInput(String line, UI ui, TaskList tasks) {

        String command = getCommandWord(line);
        switch (command) {
            case "list" -> {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
                }
                return true;
            }
            case "done" -> {
                tasks.changeDone(line, ui, tasks);
                return true;
            }
            case "todo" -> {
                tasks.createTodo(line, ui, tasks);
                return true;
            }
            case "deadline" -> {
                tasks.createDeadline(line, ui, tasks);
                return true;
            }
            case "event" -> {
                tasks.createEvent(line, ui, tasks);
                return true;
            }
            // also exit when user input is empty
            case "bye", "" -> {
                ui.farewell();
                return false;
            }
            default -> {
                ui.invalidCommand();
                return true;
            }
        }
    }

}
