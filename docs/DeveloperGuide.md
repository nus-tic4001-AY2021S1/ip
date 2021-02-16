# Developer Guide

## Implementation of Features
This section describes how certain features are implemented.

## Implementation of Todo Feature
The `todo` feature is implemented using `TodoCommand`, which extends `Command`.
Upon receiving an input string that has `todo` as the first word, the `Duke` object will instantiate a
`TodoCommand` object with the `fullCommand` string, which is the input entered by the user. The `Duke`
object will then call the `execute` method in the `TodoCommand` object with the following arguments:
1. `tasks`: a `TaskList` object;
2. `ui`: a `Ui` object;
3. `storage`: a `Storage` object;

Finally, the `execute` method will execute the following steps:
1. Calls `Parser#createTodo(fullCommand)` to get an `Todo` object `todo`;
2. Calls `tasks#addTask(todo)` to add `todo` to `tasks`;
3. Calls `storage#saveTasks(tasks)` to save all tasks to data file;
4. Calls `ui#printAddedTask(tasks)` to generate the output string that will be shown to the user.

The following sequence diagram shows the object interactions when the `Duke` object calls the `execute` method
of the `TodoCommand` object:
<br><img src="images/TodoSequenceDiagram.png" alt="TodoSequenceDiagram" width="800"/><br>

The following activity diagram shows what happens when a user executes a `todo` command:
<br><img src="images/TodoActivityDiagram.png" alt="TodoActivityDiagram" width="500"/><br>
