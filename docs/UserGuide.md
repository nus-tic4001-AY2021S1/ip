## User Guide

Big hello to TIC4002 Project Duke. Duke is a personal assistant chatbot that helps us keep track of various things. 

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest DukeProject.jar from [here](https://github.com/e0261618/ip/releases/download/v0.3/DukeProject.jar).
3. Copy the file to the folder you want to use as the home folder for your DukeProject.
4. Open a command window in that folder.
5. Run the command java -jar DukeProject.jar to open up the application.
6. Type the command in the command box and press Enter to execute it.

## Features
Todo: tasks without any date/time attached to it e.g., visit new theme park <br/>
Deadline: tasks that need to be done before a specific date/time e.g., submit report by 11/10/2019 5pm <br/>
Events: tasks that start at a specific time and ends at a specific time e.g., team project meeting on 2/10/2019 2-4pm <br/>
List: list down all the tasks that has been added <br/>
Delete: delete task that you specified <br/>
Find: find keywords in the tasklist <br/>

### Todo
Format: todo <br/>
Example: todo read book <br/>
Output: <br/>
Got it. I've added this task: <br/>
[T][✘] watch movie <br/>
Now you have 1 tasks in the list. <br/>

### Deadline
Format: deadline {task} /by {yyyy-mm-dd}  <br/>
Example: deadline submit homework /by 2020-09-28 <br/>
Output: <br/>
Got it. I've added this task: <br/>
[D][✘] do homework (by: Sep 28 2020) <br/>
Now you have 2 tasks in the list. <br/>

### Events
Format: event {task} /at {yyyy-mm-dd} <br/>
Example: event project meeting /at 2020-09-28 <br/>
Output: <br/>
Got it. I've added this task: <br/>
[E][✘] project meeting (at: Sep 28 2020) <br/>
Now you have 3 tasks in the list. <br/>

### List
Format: list <br/>
Example: list <br/>
Output: <br/>
Here are the tasks in your list: <br/>
    1. [T][✘] watch movie <br/>
    2. [D][✘] do homework (by: Sep 28 2020) <br/>
    3. [E][✘] project meeting (at: Sep 28 2020) <br/>

### Delete
Format: delete {index number} - The index must be a positive integer 1, 2, 3,(...) <br/>
Example: delete 1 <br/>
Output: <br/>
Noted. I've removed this task: <br/>
[T][✘] watch movie <br/>
Now you have 2 tasks in the list. <br/>

### Find
Format: find {keyword} <br/>
Example: find project <br/>
Output: <br/>
Here are the matching tasks in your list: <br/>
1. [E][✘] project meeting (at: Sep 28 2020) <br/>
   
## Saving the data <br/>
Data/Duke.txt is the directory where you can find the list of tasks being saved. <br/>

### Support or Contact <br/>
Having trouble with executing the program? Email me [here](e0261618@u.nus.edu) and I’ll help you sort it out. 
