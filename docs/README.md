# Jojo User Guide
Jojo, a Personal Assistant Chatbot with Java-based Command Line Interface (CLI), that helps users to keep track of various things. 

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest ip.jar [here](https://github.com/daiweinus/ip/releases).
3. Open the Terminal/Command Prompt.
4. Navigate to the project’s out\artifacts\ip_jar.
5. Launch the Jojo Chatbot by running the command java -jar ip.jar.
6. Type the command in the CLI program and press Enter to execute it.  
   Some example commands you can try:
   + ` todo borrow book `
   + `deadline return book /by 2020-09-25`
   + `event project meeting /at meeting room #1-12`

## Features 
+ Adding a Todo task: todo
+ Adding a Deadline task: deadline
+ Adding an Event task: event
+ Listing all tasks: list
+ Finding a tasks containing any keyword: find KEY_WORD
+ Deleting a task : delete INDEX
+ Marking as Done of a task: done INDEX
+ Exiting the program : bye
+ Saving the tasks to local: save

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

Expected outcome:
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

Expected outcome:
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

Expected outcome:
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

Expected outcome:
```
Here are the tasks in your list:
  1. [T][✘] Read book
  2. [D][✘] return book (by: Sep 25 2020)
  3. [E][✘] project meeting (at: meeting room #1-12)
```

## Feature 5: Finding tasks: find KEY_WORD
Finds tasks in Jojo that match any of the specified keywords.

### Usage
Example of usage:
```
find book
```

Expected outcome:
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

Expected outcome:
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

Expected outcome:
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

Expected outcome:
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

Expected outcome:
```
Tasks save to disk Jojo.txt
```
```
Hello from
  __          __ 
  | | ____    | | ____
  | |/ __ \   | |/ __ \
__/ | |__| |__/ | |__| |
\__/ \____/ \__/ \____/
```