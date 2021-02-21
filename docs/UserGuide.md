## User Guide

Welcome to Duke System, Duke is an app for managing daily task and scheduler, optimized for use via a Command Line in User Interface 
while still having the benefits of a Graphical User Interface (GUI). 

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest NUS.Duke.Launcher.jar from [here](https://github.com/timmyly7/ip/releases).
3. Open a command prompt / terminal window in that directory.
4. Run the command ```java -jar NUS.Duke.Launcher.jar``` to open up the application.
5. Type the ```help``` in the command box and press ```Enter``` to execute it.

## Features
```Help```: Lists the commands the user can use to interact with the application. <br/>
```Todo```: Create todo task. <br/>
```Event```: Create event task.  <br/>
```Done```: Mark task as done. <br/>
```List```: List all the tasks. <br/>
```Find```: Find tasks with matching task description. <br/>
```Delete```: Delete task by task id. <br/>
```Delete All```: Delete all tasks. <br/>
```Save```: Save the tasks to file. <br/>


<div style="page-break-after: always;"></div>

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
 
 ## Special Handle
 When user use command promt to run the jar file, they should use the following command.
 1. in command promt, type `chcp` and enter, you will see this `Active code page: 65001`
 2. type `java -jar -Dfile.encoding=UTF-8 Duke.jar`
 
### Support or Contact <br/>
Having trouble with executing the program? Contact me at E0261620@u.nus.edu and I'll help you sort it out. 