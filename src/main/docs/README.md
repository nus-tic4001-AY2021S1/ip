# DUKE User Guide

## Features

The DUKE is a Chatbot with Java-based Command Line Interface (CLI) to keep track user's daily tasks.
It has the following features:

### Feature 1
_To **add a Todo task**. A Todo task is anything that you might want Duke to remind you. A Todo task does not have time restriction._

### Usage
Example of usage:
```
todo Read book
```

Expected outcome:
```
Got it. I've added this task:
  [T][✘] Read book
Now you have 1 tasks in the list.


### Feature 2
_To **add a Deadline task**. A Deadline task is something that you would like to complete before a specified date._

### Usage
Example of usage:
```
deadline return book /by 2020-09-25
```

Expected outcome:
```
Got it. I've added this task:
  [D][✘] return book (by: 2020-09-25)
Now you have 2 tasks in the list.
```

### Feature 3
_To **add a Event task**. A Event task is some tasks that occur at a specified time and date._

### Usage
Example of usage:
```
event project meeting /at 2020-09-25
```

Expected outcome:
```
Got it. I've added this task:
  [E][✘] project meeting (at: 2020-09-25)
Now you have 3 tasks in the list.
```


### Feature 4
_**List down** all existed task(s)._

### Usage
Example of usage:
```
list
```

Expected outcome:
```
Here are the tasks in your list:
  1. [T][✘] Read book
  2. [D][✘] return book (by: 2020-09-25)
  3. [E][✘] project meeting (at: 2020-09-25)
```

### Feature 5
_**Set task** status to be **done**._

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

### Feature 6
_**Find (search) tasks** with **Key Word**._

### Usage
Example of usage:
```
find book
```

Expected outcome:
```
Here are the matching tasks in your list:
  1. [T][✘] Read book
  2. [D][✘] return book (by: 2020-09-25)
```

### Feature 7
_**Delete a task** from the list._

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


### Feature 8
_**Auto Load** from existing task file and **Auto save** changes to task file whenever user makes change._

