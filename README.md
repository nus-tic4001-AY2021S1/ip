# Duke - Tasks Handler

The project template for a greenfield Java project provided by Lecturer. It's named after the Java mascot _Duke_. 
Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

## Project Overview and Operations

This project is to manage Tasks with CLI. It is able to handle some simple tasks, such as add, delete, find and set task as completed. 

Below are some basic command to manage Tasks
1. Add Todo Your Task
1. Add Deadlines Your Task /by 19-9-2020 18:00
1. Add Events Your Task /at 19-9-2020 18:00-20:00
1. List (View current existing tasks listing)
1. Done 1 (Set item no 1 as completed Task)
1. Delete 4 (Deleting item no 4 from the list)
1. Find keywords 

