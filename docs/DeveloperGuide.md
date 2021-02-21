# Developer Guide
* [Setting Up and Getting Started](#Setting-Up-and-Getting-Started)
* [Design](#Design)
  * [Architecture](#Architecture)
  * [UI component](#Component)
  * [Storage component](#Storage-Component)
  * [Common classes](#Component)
* [Implementation](#Implementation)
* [Appendix: Requirements](#Appendix:-Requirements)
  * [Product scope](#Product-scope)
  * [User stories](#User-Stories)
  * [User Cases](#Use-Cases)
  * [Non-Functional Requirements](#Non-Functional-Requirements)
  * [Glossary](#Glossary)

<div style="page-break-after: always;"></div>

## Setting Up and Getting Started
:heavy_exclamation_mark: **Caution** Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.

First, **fork** this repo, and **clone** the fork into your computer.
If you plan to use Intellij IDEA (highly recommended):

1. **Configure the JDK:**
  * Ensure you have the correct JDK version installed in your computer.
  * Open IntelliJ (if you are not in the welcome screen, click File → Close Project to close the existing project dialog first).
  * Set up the correct JDK version for Gradle.
   * Click Configure → Project Defaults → Project Structure
   * Click New…​ and set it to the directory of the JDK.
2. **Import the project as a Gradle project:**
  * IntelliJ IDEA by default has the Gradle plugin installed. If you have disabled it, go to File → Settings → Plugins to re-enable them.
  * If your project involves GUI programming, similarly ensure the JavaFX plugin has not been disabled.
  * Click Import Project (or Open or Import in newer version of Intellij).
  * Locate the `build.gradle` file (not the root folder as you would do in a normal importing) and select it. Click OK.
  * If asked, choose to Open as Project (not Open as File).
  * Click OK to accept the default settings but do ensure that the selected version of Gradle JVM matches the JDK being used for the project.
  * Wait for the importing process to finish (could take a few minutes).
  * :heavy_exclamation_mark: **Note**: Importing a Gradle project is slightly different from importing a normal Java project.
3. **Verify the setup:**
  * Run the `Launcher.java` and try a few commands.
  
<div style="page-break-after: always;"></div>
  
## Design

##### Architecture

The ***Architecture Diagram*** shown gives an overview of the high-level design.

The program is started with `Launcher`. It would perform the following functions:

- At launch: Initialize the components in the correct sequence, and connect them up with each other.

<div style="page-break-after: always;"></div>

The application then consists of components:

- `UI`: The output prompt related to the interface
- `Parser`: The command executor. 
- `TaskList`: Handle tasks during program execution
- `Storage`: Read data from, and writes data to the hard disk.


<div style="page-break-after: always;"></div>

## Implementation
This section describes some noteworthy details on how certain features were implemented.

##### Remarks Feature

The purpose of `Remark` function is to allow user to add any memo to Tasks for easy understanding

1. `\memo` - Optional for user to add this to input line will allow memo to attach to Todo, Deadline adn Events. 


##### Add Recurring Feature

The purpose of `Remark` function is to allow user to add any memo to Tasks for easy understanding

1. `weekly anytask` - Give tasks a recurring frequency, such as weekly, monthly.


##### Check Duplication Feature

The purpose of `Check Duplication` function is to ensure to duplicated tasks entered to the system

Whenever user input any `Todo`, `Deadline`, `Event`, system will check for duplication.

`Similar or Duplicated Task has been entered` - Error Message will be prompt if duplication is detected.


<div style="page-break-after: always;"></div>

## Appendix: Requirements
### Product scope
##### Target user profile

* Has a need to manage his/her tasks
* Is able to use command line interface (CLI)
* Can type fast
* Prefers typing to interaction with a graphical user interface (GUI)
* Is comfortable using CLI apps

##### Value proposition: 
To manage all tasks faster than a typical excel tasks spreadsheet.

### User Stories
###### *Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`*

|Priority| As a ... | I want to ... | So that I can ...|
|--------|--------|----------|---------------|------------------|
|`* * *`|User|add tasks to the system|to keep track of all my tasks|
|`* * *`|User|view tasks|all the tasks in my list|
|`* * *`|User|delete tasks|delete tasks that are not needed|
|`* * *`|User|find tasks|locate related tasks with specified keywords|
|`* * *`|User|mark tasks as completed|keep track of the status of all tasks|
|`* *`|Users|make sure no duplicate tasks|be clear of all on-hand tasks|


### Non Functional Requirements

1. Should work on any mainstream OS as long it has Java ```11``` or above installed.
2. User will be able to interact with the systems with regular english text. For example: (```
todo submit assignment /memo TIC4002. ```).
3. Will be able to handle up to 1000 expenses without noticeable slowness in performance for typical usage.
4. User will be able to interact with their record.txt if they wish to make amendment. 

### Glossary

- *MainStream OS* - Windows, Linux, Unix, OS-X
- JDK - Java Development Kit - [Java SE](https://www.oracle.com/sg/java/technologies/javase-downloads.html "Java SE Downloads")
- Gradle - Gradle Build Tool - [Gradle User Manual](https://docs.gradle.org/current/userguide/userguide.html "Build Automation Tool - Docs")
- Intellij / IDE - Intellij Integrated Development Environment - [IntelliJ IDEA](https://www.jetbrains.com/idea/ "JVM IDE") 
- Plugin - IDE Plugins - [Intellij IDEA Plugins](https://www.jetbrains.com/help/idea/managing-plugins.html "Manage plugins")