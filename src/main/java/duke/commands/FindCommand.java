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
            return "It appears that you have no tasks! Perhaps you should start creating one?";
        }
        if (searchWord.isEmpty()) {
            return ui.printRed("Please type in the 'find <word>' format!");
        }
        String matches = "Here are the tasks that matches '" + searchWord + "'!\n";
        boolean hasMatch = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().toLowerCase().contains(searchWord)) {
                matches = matches.concat((i + 1) + ". " + tasks.get(i).getDescription()) + "\n";
                hasMatch = true;
            }
        }
        if (!hasMatch) {
            matches = "It appears that are no matches for '" + searchWord + "'!\n"
                + "Perhaps you could try searching another word?";
        }
        return matches;
    }
}