# User Guide

## Features 

The Duke applet is a task management applet. It supports the following features

### Feature 1 
_To **add a Todo task**. A Todo task is a basic type of task which is without time restriction._ 

### Feature 2 
_To **add a Deadline task**. A Deadline task is the task with a expiration date._

### Feature 3 
_To **add a Event task**. A Event task is the task with a specific time that the event occurs._

### Feature 4 
_**List down** all task exist._

### Feature 5 
_**Set task** status to be **done**._

### Feature 6 
_**Delete a task** from the list._

### Feature 7 
_**Find specific tasks** with **keyword** entered._

### Feature 8 
_**Auto saving** and **loading** existing task file._


## Usage

### `todo <something>` - add a todo task in the list

This command will add a todo task in the list with specific content

Example of usage: 
```
todo read a book
```

Expected outcome:
```
Got it. I've added this task:
[T][✗] read a book
Now you have 1 tasks in the list.
```

### `deadline <something> /by <sometime>` - add a deadline task in the list

This command will add a deadline task in the list with specific content and deadline time. The time is supposed to be in format "yyyy-MM-dd".

Example of usage: 
```
deadline read a book /by 2019-09-20
```

Expected outcome:
```
Got it. I've added this task:
[D][✗] read a book (by: Sep 20 2019)
Now you have 2 tasks in the list.
```

### `event <something> /at <sometime>` - add a event task in the list

This command will add a event task in the list with specific content and occuring time. The time is supposed to be in format "yyyy-MM-dd".

Example of usage: 
```
event read a book /at 2019-09-20
```

Expected outcome:
```
Got it. I've added this task:
[E][✗] read a book (at: Sep 20 2019)
Now you have 3 tasks in the list.
```



### `list` - list down all tasks in the list

This command will list down all tasks in the list.

Example of usage: 
```
list
```

Expected outcome:
```
Here are the tasks in your list:
1.[T][✗] read a book
2.[D][✗] read a book (by: Sep 20 2019)
3.[E][✗] read a book (at: Sep 20 2019)
```



### `done <index>` - set the status of the specific task to be done. 

This command will set the task to be done.

Example of usage: 
```
done 2
```

Expected outcome:
```
Nice! I've marked this task as done: 
[D][✓] read a book (by: Sep 20 2019)
```


### `delete <index>` - delete the task with the specific index. 

This command will delete the task with the specific index in the list.

Example of usage: 
```
delete 2
```

Expected outcome:
```
Noted. I've removed this task: 
[D][✓] read a book (by: Sep 20 2019)
Now you have 2 tasks in the list.
```


### `find <something>` - find the tasks with the keyword. 

This command will find all the tasks with the keyword specified in the list.

Example of usage: 
```
find book
```

Expected outcome:
```
Here are the matching tasks in your list:
1.[T][✗] read a book
2.[E][✗] read a book (at: Sep 20 2019)
```


