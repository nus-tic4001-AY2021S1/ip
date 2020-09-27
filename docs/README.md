# User Guide

## Features 
1. Create todo task.
2. Create event task.
3. Create deadline task.
4. Mark task as done.
5. List all the tasks.
6. Find tasks with matching task description.
7. Delete task by task id.
8. Delete all tasks.
9. Save the tasks to file.

### Feature Description 
Description of feature.

1. Create todo task - User can create the task by enter 'todo (task description)', system will create the task as
todo task and save in system.
2. Create event task - User can create the task by enter 'event (task description) /at (timing description)', system will create the task as
event task and save in system.
3. Create deadline task - User can create the task by enter 'deadline (task description) /by (date: in format of yyyy-mm-dd)', system will create the task as
deadline task and save in system.
4. Mark task as done - User can make the task as already done in system.
5. List all the tasks - User can see all the task created.
6. Find tasks with matching task description - User can find the specific task by description.
7. Delete the task by task id - User can delete the task from system by task id number.
8. Delete all tasks - User can delete all the tasks from system.
9. Save the tasks to file - User can save the task to the file. The file location will be in the same location of jar file.


## Usage

### `Keyword` - Describe action

Describe action and its outcome.

Example of usage: 

#### `todo` - create todo task action
`todo (task description)`
e.g. `todo do homework`

Expected outcome:

` Got it. I've added this task:' 
 [T][✗]do homework
  Now you have 1 tasks in the list`
  
 #### `event` - create event task action
 `event (task description) /at (event timing description)`
 e.g. `event project meeting /at tmr afternoon`
 
 Expected outcome:
 
 `  Got it. I've added this task: 
   [E][✗]project meeting (at: tmr afternoon )
   Now you have 1 tasks in the list`

 #### `deadline` - create deadline task action
 `deadline (task description) /by (deadline date in format of yyyy-mm-dd)`
 e.g. `deadline submit project /by 2020-09-28`
 
 Expected outcome:
 
 `  Got it. I've added this task: 
   [D][✗]submit project (by: 2020 Sep 28 )
   Now you have 1 tasks in the list`

 #### `done` - mark task as done action
 `done (id)`
 e.g. `done 1`
 
 Expected outcome:
 
 `  Nice! I've marked this task as done: 
    [✓]project meeting `
    
 #### `list` - list all tasks action
 `list`
 
 Expected outcome:
 
 `  1. [T][✗]do homework
    2. [E][✓]project meeting (at: tmr afternoon )
    3. [D][✗]submit project (by: 2020 Sep 28 )`
    
 #### `find` - find task by description action
 `find (task description)`
  e.g. `find project`
 Expected outcome:
 
 `  Here are the matching tasks in your list: 
   2:[E][✓]project meeting (at: tmr afternoon )
   3:[D][✗]submit project (by: 2020 Sep 28 )`

 #### `delete` - find task by description action
 `delete (task id)`
  e.g. `delete 1`
 Expected outcome:
 
 ` Noted. I've removed this task: 
  [T][✗]do homework
   Now you have 2 tasks in the list`
   
 #### `deleteall` - delete all tasks action
 `deleteall`
 
 Expected outcome:
 
 ` All the task has been deleted.`

 #### `save` - save task to file action
 `save`
 
 Expected outcome:
 
 ` Successfully wrote to the file.`