package duke.commands;

import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to print out all tasks in the list.
 */
public class FindCommand extends Command {
    public static final String word = "find";

    public FindCommand(String line, TaskList tasks, Ui ui) {
        super(line, tasks, ui);
    }

    @Override
    public void execute() {
        String searchWord = line.trim();
        if (tasks.size() == 0) {
            ui.printBorderlines("It appears that you have no tasks! Perhaps you should start creating one?");
            return;
        }
        if (searchWord.isEmpty()) {
            ui.printBorderlines("Please type in the 'find <word>' format!");
            return;
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
            matches = "It appears that are no matches for '" + searchWord + "'!\n" +
                    "Perhaps you could try searching another word?";
        }
        ui.printBorderlines(matches);
    }
}