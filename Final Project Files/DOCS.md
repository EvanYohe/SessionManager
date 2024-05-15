# Modules
These are the modules of the project with a description of the specific function the module was designed to handle. Each module has various java files within it to handle the tasks that each module has been assigned.

## File List

#### [Command Handler](#command-handler)
- [CommandParser](#commandparser)
- [ArgumentParser](#argumentparser)
- [SearchOrganizer](#searchorganizer)

#### [Data Pipeline](#data-pipeline)
- [FileHandler](#filehandler)
- [ReadFile](#readfile)
- [WriteFile](#writefile)
- [DataBuilder](#databuilder)

#### [Output Formatter](#output-formatter)
- [OutputBuilder](#outputbuilder)
- [OutputPrinter](#outputprinter)

#### [Session Manager](#session-manager)
- [Session](#session)
- [SessionListBuilder](#sessionlistbuilder)
- [SessionParser](#sessionparser)

#### [Statistics](#statistics)
- [GlobalStatistics](#globalstatistics)
- [StatisticsGenerator](#statisticsgenerator)
- [StatisticsParser](#statisticsparser)
## Command Handler
The Command Handler Module is responsible for handle all user input processing, from identifying user commands to parsing arguments and relaying the criteria of those arguments to other modules.

#### CommandParser
#### ArgumentParser
#### SearchOrganizer?

## Data Pipeline
The Data Pipeline Module is responsible for handle all file processing, reading/writing data from/to files, sending data to the correct modules, retrieving data from the modules.

#### FileHandler
#### DataBuilder?
#### ReadFile
#### WriteFile

## Output Formatter
The Output Formatter Module is responsible for formatting all output that is printed to the console.

#### OutputBuilder
#### OutputPrinter

## Session Manager
The Session Manager Module is responsible for handling the Session datatype, building lists of Sessions, creating, editing, and deleting Session data.

#### Session
#### SessionListBuilder
#### SessionParser

## Statistics
The Statistics Module is responsible for calculating any statistical data that is saved to a file, or displayed in the console.

#### GlobalStatistics
#### StatisticsGenerator
#### StatisticsParser