# Jojo User Guide
Jojo is a Java-based desktop app that helps the users keep track of the tasks they need to do. 
It comes with a Command Line Interface (CLI) that allows users to enter their commands while 
retaining the benefits of a Graphical User Interface (GUI). This allows users who type fast to 
complete their desired actions quicker than using traditional GUI apps.

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest ip.jar [here](https://github.com/daiweinus/ip/releases).
3. Open the Terminal/Command Prompt.
4. Navigate to the project’s out\artifacts\ip_jar.
5. Launch the Jojo Chat-bot by running the command java -jar ip.jar.
6. Type the command in the CLI program and press Enter to execute it.  
   Some example commands you can try:
   + ` todo borrow book `
   + `deadline return book /by 2020-09-25`
   + `event project meeting /at meeting room #1-12`
7. Refer to Features below for details of each command.

### Command Summary
+ Adding a Todo task: todo
+ Adding a Deadline task: deadline
+ Adding an Event task: event
+ Listing all tasks: list
+ Finding a task containing any keyword: find KEY_WORD
+ Deleting a task : delete INDEX
+ Marking as Done of a task: done INDEX
+ Exiting the program : bye
+ Saving the tasks to local: save
+ Show the command use manual: Help

## Features
Notes about the command format:
+ Words in UPPER_CASE are the parameters to be supplied by the user.  
  ` E.g. DESCRIPTION in the command todo DESCRIPTION. `

## Feature 1: Adding a Todo task: todo 
Adds a Todo task in the list. ToDos: tasks without any date/time attached.

### Usage
Example of usage:
```
todo Read book
```

Expected outcomes:
```
Got it. I've added this task:
  [T][✘] borrow book
Now you have 1 tasks in the list.
```

## Feature 2: Adding a Deadline task: deadline
Adds a Deadline task. Deadlines: tasks that need to be done before a specific date(yyyy-mm-dd)

### Usage
Example of usage:
```
deadline return book /by 2020-09-25
```

Expected outcomes:
```
Got it. I've added this task:
  [D][✘] return book (by: Sep 25 2020)
Now you have 2 tasks in the list.
```

## Feature 3: Adding an Event task: event
Adds an Event task. Events: tasks that start at a address.

### Usage
Example of usage:
```
event project meeting /at meeting room #1-12
```

Expected outcomes:
```
Got it. I've added this task:
  [E][✘] project meeting (at: meeting room #1-12)
Now you have 3 tasks in the list.
```

## Feature 4: Listing task information: list
Lists all tasks in Jojo.

### Usage
Example of usage:
```
list
```

Expected outcomes:
```
Here are the tasks in your list:
  1. [T][✘] Read book
  2. [D][✘] return book (by: Sep 25 2020)
  3. [E][✘] project meeting (at: meeting room #1-12)
```

## Feature 5: Finding tasks: find KEY_WORD
Find tasks in Jojo that match any of the specified keywords.

### Usage
Example of usage:
```
find book
```

Expected outcomes:
```
Here are the matching tasks in your list:
  1. [T][✘] Read book
  2. [D][✘] return book (by: Sep 25 2020)
```

## Feature 6: Deleting a task : delete INDEX
Deletes the specified task in Duke.

### Usage
Example of usage:
```
delete 2
```

Expected outcomes:
```
Noted. I've removed this task:
  [D][✘] return book (by: Sep 25 2020)
Now you have 2 tasks in the list.
```

## Feature 7: Deleting a task : delete INDEX
Mark specified task as done.

### Usage
Example of usage:
```
done 1
```

Expected outcomes:
```
Nice! I've marked this task as done:
[✓] Read book
```

## Feature 8: Exiting the program : bye
Exits the program.

### Usage
Example of usage:
```
bye
```

Expected outcomes:
```
Bye. Hope to see you again soon!
```

## Feature 9: Saving the tasks to local: save
Save the tasks in the hard disk automatically whenever the task list changes. Load the data from the hard disk when Duke starts up. 

### Usage
Example of usage:
```
save
```

Expected outcomes:
```
Tasks save to disk Jojo.txt

## Feature 10: Show the commands use manual: Help
Show the commands use manual to users.
```

### Usage
Example of usage:
```
help
```

Expected outcomes:

```
List of commands:
-> list: lists out all tasks.\n"
-> todo {detail}: add a todo item.\n"
-> event {detail} /at {address}: add an event item.\n"
-> deadline {detail} /at {datetime yyyy-MM-dd HHmm format}: add a deadline item.\n"
-> delete {index}: removes the item(s) at the specified position(s).\n"
-> done {index}: marks the item as done.\n"
-> find {detail}: searches for a task contain that detail.\n"
-> help: show user the app commands use manual.\n"
-> save: save all change to filepath data.txt.\n";
```


Hello from
```
  __          __ 
  | | ____    | | ____
  | |/ __ \   | |/ __ \
__/ | |__| |__/ | |__| |
\__/ \____/ \__/ \____/

```