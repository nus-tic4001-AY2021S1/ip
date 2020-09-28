# User Guide

## Getting Started

With the A0177810A_Duke.jar downloaded. Navigate to the directory it is contained in and open the command prompt or terminal window.

Run the jar file using the following:
```
java -jar A0177810A_Duke.jar
```

---

## Features 

### Help
The 'help' function displays a list of available commands the user can input to interact with the system.

### Todo

The 'todo' feature allows the user to create and store a simple task with description.

### Event

The 'event' feature allows the user to create and store a task with an additional time frame or period input.

### Deadline

The 'deadline' feature allows the user to create and store a task with an additional deadline or 'do by' date and time.

### Remove

The 'remove' feature allows the user to remove a task from the list.

### Done
The 'done' feature allows the user to mark a task as complete or done.

### Undone
The 'Undone' feature allows the user to mark a task as incomplete or undone.

### Find
The 'find' feature allows the user to find task(s) where the descriptions contain a certain keyword.

---

## Usage

#### `Help` - View help

Format: `help`

:bulb: Help will be shown if an incorrect command is entered. e.g. `1234abcd`

Example:
`Unknown command! Please try again. Type "help" to view a list of commands.`
---
#### `Todo` -  Add a Todo Task

Format: `todo <TASK NAME>`

Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required. 

Example:

`todo Return overdue books`

Expected outcome:
```
Got it. I've added this task:
[E] [is done ? No] Return overdue books
Now you have 5 tasks in the list.
```
---

#### `Event` - Add a Event (Task with a time frame)

Format: `event <TASK_NAME> </at TIME_FRAME>`

Example:`event TIC4001 Class /at 6.30 - 9.30 PM`

Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required.`/at` is required to specify the time frame for the task.

Expected outcome:
```
Got it. I've added this task:
[E] [is done ? No] TIC4001 Class (at: 6.30 - 9.30 PM)
Now you have 6 tasks in the list
```
---
#### `Deadline` - Add a Deadline (Task with a deadline)

Format: `deadline <TASK_NAME> </by DEADLINE>`

Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required.`/by` is required to specify the deadline for the task.

Example: `deadline TIC4001 IP Assignment /by 28th Sep 2020 2359`

Expected outcome:

```
Got it. I've added this task:
[D] [is done ? No] TIC4001 IP Assignment (by: 28th Sep 2020 2359)
Now you have 7 tasks in the list.
```
---
#### `View` - View all tasks in the list

Format: `view`

Example: `view`

Expected outcome:
```
Here are the tasks in your list:

1.[T] [is done ? No] Return overdue books
2.[E] [is done ? No]  TIC4001 Class  (at:  6.30 - 9.30 PM)
3.[D] [is done ? No] TIC4001 IP Assignment (by: 28th Sep 2020 2359)
```
---
#### `Remove` - Remove a task from the list

Format: `remove <INTEGER_OF_TASK_NUMBER>`

Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required.`INTEGER_OF_TASK_NUMBER` is an integer `(1,2,3 etc...)` and is required to specify the task in the list to be removed.
###### Negative integers (-1, -2, -3 etc... are not acceptable inputs).

Example: `remove 4`

Expected outcome:
```
Now you have 3 tasks in the list.
```

##### List Before
```
1.[T] [is done ? Yes] Return overdue books
2.[E] [is done ? No]  TIC4001 Class  (at:  6.30 - 9.30 PM)
3.[D] [is done ? No] TIC4001 IP Assignment (by: 28th Sep 2020 2359)
4.[T] [is done ? No] Sample Task
```
##### List After
```
1.[T] [is done ? Yes] Return overdue books
2.[E] [is done ? No]  TIC4001 Class  (at:  6.30 - 9.30 PM)
3.[D] [is done ? No] TIC4001 IP Assignment (by: 28th Sep 2020 2359)
```
---
#### `Done` - Set a task to 'done' status in the list

Format: `done <INTEGER_OF_TASK_NUMBER>`

Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required.`INTEGER_OF_TASK_NUMBER` is an integer `(1,2,3 etc...)` and is required to specify the task in the list to be marked as done.
###### Negative integers (-1, -2, -3 etc... are not acceptable inputs).

Example: `done 1`

Expected outcome:
```
Nice! I've marked this task as done:
[T] [is done ? Yes] Return overdue books
```
##### List Before
```
1.[T] [is done ? No] Return overdue books
2.[E] [is done ? No]  TIC4001 Class  (at:  6.30 - 9.30 PM)
3.[D] [is done ? No] TIC4001 IP Assignment (by: 28th Sep 2020 2359)
```
##### List After
```
1.[T] [is done ? Yes] Return overdue books
2.[E] [is done ? No]  TIC4001 Class  (at:  6.30 - 9.30 PM)
3.[D] [is done ? No] TIC4001 IP Assignment (by: 28th Sep 2020 2359)
```
 ---
 
 #### `Undone` - Set a task to 'not done' status in the list
 
 Format: `undone <INTEGER_OF_TASK_NUMBER>`
 
 Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required.`INTEGER_OF_TASK_NUMBER` is an integer `(1,2,3 etc...)` and is required to specify the task in the list to be marked as done.
 ###### Negative integers (-1, -2, -3 etc... are not acceptable inputs).
 
 Example: `undone 1`
 
 Expected outcome:
 ```
I've marked this task as not done:
[T] [is done ? No] anothertask
 ```
 ##### List Before
 ```
1.[T] [is done ? Yes] anothertask
2.[T] [is done ? No] yetanothertask
 ```
 ##### List After
 ```
 1.[T] [is done ? No] anothertask
 2.[T] [is done ? No] yetanothertask
 ```
  ---
#### `Find` - Find task(s) containing a input keyword

Format: `find <KEYWORD>`

Words in `UPPER_CASE` are the parameters, items in `ANGLED_QUOTATIONS <>` are required. `KEYWORD` is a "String" input and is required to search through the list for task descriptions containing the keyword.

Example: `find book`

Expected outcome:
```
Here are the matching tasks in your list:
1.[T] [is done ? Yes] Return overdue books
```
---
#### `Save` - Save current tasks in the list to a plain text file

Format: `save`

Each time the list is modified, all tasks are saved to the plain text file data/tasks.txt. The `save` function is provided in case the user wishes to prompt the system to save the list of tasks again manually.

Example: `save`

Expected outcome:

##### List of tasks
```
Here are the tasks in your list:

1.[E] [is done ? No]  TIC4001 Class  (at:  6.30 - 9.30 PM)
2.[D] [is done ? No]  TIC4001 IP Assignment  (by:  28th Sep 2020 2359)
```

```
Now you have 2 tasks in the list.
Your tasks have been saved to data/tasks.txt
```
---

