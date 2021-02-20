# DUKE User Guide

The DUKE is a Chatbot with Java-based command Line Interface (CLI) to keep track user's daily tasks.  It has the following features:


# Feature 1

_To **add a Todo task**. A Todo task is anything that you might want Duke to remind you. A Todo task does not have time restriction._

### Usage  
Example of usage:  
```  
todo Read book  
```  
Expected outcome:  
```  
Got it. I've added this task:  
 [T][✘] Read bookNow you have 1 tasks in the list.
 ```  


# Feature 2  
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

# Feature 3  
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

# Feature 4  
_To **List down** all existed task(s)._  
  
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

# Feature 5  
_To **Set task** status to be **done**._  
  
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

# Feature 6  
_To **Find (search) tasks** with **Key Word**._  
  
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

# Feature 7  
_To **Delete a task** from the list._  
  
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

# Feature 8  
_To **exit** the program.

### Usage  
Example of usage:  
```  
bye
```  
  
Expected outcome:  
```  
 Bye. Hope to see you again soon!
```  


# Feature 9
_To **Auto Load** from existing task file and **Auto save** changes to task file whenever user makes change._

Example of usage:  
```  
No action is needed from user. 
User need to enter 'list' to list all tasks loaded from data file
```  



# Summary of features and commands

Below is the table to summarise the features and its relevant commands

|                |Features                       |Commands                     |
|----------------|-------------------------------|-----------------------------|
|1.              |Add a todo task                |`'todo'`+task name          |
|2.              |Add a deadline task            |`'deadline'`+(task name)+  `'/by'` + (date)      |
|3.              |Add an event task              |`'event'`+(task name)+  `'/at'` + (date)      |
|4.              |List all tasks                 |`'list'`                     |
|5.              |Set task status as completed   |`'done'` +(task id)          |
|6.              |Find (search) tasks            |`'find'` +(key word)         |
|7.              |Delete a task                  |`'delete'` +(task id)        |
|8.              |Exit the program               |`'bye'`                      |
|9.              |Auto load task or auto save task|no action is needed         |
