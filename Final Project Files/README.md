# README
This is the readme page for the final project of CS& 141. I chose to create a program to track musical practice sessions, in addition to analyzing efficiency and efficacy of the practice sessions. The contents of this README is as follows

- [Notes](##-Notes) These are miscellaneous notes about the project that might offer insight about why I made the decisions that I made.
- [Scope](##-Scope) This is the scope of the project. There will be two scopes listed here; a scope of the project as a whole, and a scope of the project as it relates to the final assignment
- [Goals](##-Goals) These are the goals of the project. The goals listed here may extend beyond the scope of the final project, however I do plan on continuing to develop this app after the assignment is submitted.
- [File List](##-File-List) A file overview of the project, with a summary of each file. I will omit unnecessary files, such as project manager files, IDE files, build files, etc...

## Notes
- I chose to use a project manager (Maven) to organize the project. As I was creating the project outline, I realized that it would be best to split the code into different modules that each have a specific task. Once I started to organize the modules, building and compiling the project became more and more difficult and a manager significantly simplified the process.
- During the course of development, I had to pivot from my usage of the Jackson Library for parsing JSON data to the GSON Library. This was due to Jacksons' inability to append parsed JSON data to an existing JSON array.

## Scope
This is the actual scope of the project, given the timeframe assigned. I fully expect some topics listed in the Goals section of this readme to not be implemented when the assignment is turned in at the end of the quarter. My scope for the assignment itself will be listed below, while the scope of the project itself is listed in the Goals section of the readme.

I had to alter the scope of my project slightly. It took the full two or three weeks to get the basic functionalities like create, delete, edit, and list to work. The only part of my project that I had to trim from the scope was the statistics module. This would have involved creating at least one (possibly three) new commands and all the relevant methods to calculate and display the statistics based on the set of sessions being analyzed.

## Goals
My goal for this project is to have a fully functioning practice tracking application I can personally use on a daily basis. I hope that the project will be feature rich by the time I submit the assignment, however I am intentionally planning the scope of the project to be larger than the scope of the assignment itself.

- **(Complete)** Create, edit, list, and delete Practice Sessions
- **(Reworked)** Create and delete keywords
- **(Incomplete)** Calculate and display statistic for a single sessions
- **(Incomplete)** Calculate and display statistics for a range of sessions
- **(Incomplete)** Calculate and display statistics for the global range of sessions (all)
- **(Complete)** Save and retrieve session data to a JSON file
- **(Complete)** Search for session(s) by keyword
- **(Complete)** Print formatted information to the terminal

## File List
This is a list of all the files that contain the important code you will want to look at during grading. The files I've omitted from the list are related to package management, Github, and VSCode.

#### com.finalproject
- Main.java (The main program launching point and main program loop)
- Global.java (All the global variables used across the program)

#### com.finalproject.command_handler
- Actions.java (Provides the majority of the code related to the commands themselves)
- Command.java (Simple Object to store information relevant to the current command)
- CommandParser.java (Code related to parsing and validating the commands and their arguments)

#### com.finalproject.data_handler
- FileHandler.java (All code related to handling the opening, closing, or creating files and directories)
- ReadWriteData.java (All code related to reading and writing to the persistent data storage file.)


#### com.finalproject.output_formatter
- DateTimeParser.java (Code relating to parsing, serializing, and deserializing date and time strings into storage format)
- OutputFormatter.java (If it has to do with printing to the terminal, it's probably here)

#### com.finalproject.session_manager
- Session.java (Custom Object Data Structure for the representation of a practice session)
- SessionListBuilder.java (Lists of sessions are a large part of the project, building and sorting lists was important)

#### com.finalproject.statistics
- Unused, sadly.

# All Citations Are Found In A Separate Markdown File