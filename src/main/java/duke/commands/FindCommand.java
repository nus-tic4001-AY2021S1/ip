package duke.commands;

import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to print out all tasks that matches the search word.
 */

public class FindCommand extends Command {
    public static final String word = "find";

    public FindCommand(String line, TaskList tasks, Ui ui) {
        super(line, tasks, ui);
    }

    @Override
    public String execute()  {
        String searchWord = line.trim();
        if (tasks.size() == 0) {
            return "You don't have any tasks you dolt, so you can't find any!/r"
                + "Go create one first!";
        }
        if (searchWord.isEmpty()) {
            return "Type in the 'find <word>' format, you dolt!";
        }
        String matches = "Here's the tasks that contains '" + searchWord + "'. Satisfied?\r";
        boolean hasMatch = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().toLowerCase().contains(searchWord)) {
                matches = matches.concat((i + 1) + ". " + tasks.get(i).getDescription()) + System.lineSeparator();
                hasMatch = true;
            }
        }
        if (!hasMatch) {
            matches = "There's no matches for '" + searchWord + "'!\r"
                + "Go find something else!";
        }
        return matches;
    }
}