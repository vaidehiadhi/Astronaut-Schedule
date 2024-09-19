# Astronaut Daily Schedule Organizer

## Overview

The **Astronaut Daily Schedule Organizer** is a console-based Java application that helps astronauts organize their daily tasks. The application allows users to add, remove, and view tasks for the day. Each task has a description, start time, end time, and priority level. This project demonstrates key programming concepts such as design patterns (Singleton, Factory, Observer) and CRUD operations.

### Features

- **Add a New Task**: Create a task by specifying a description, start time, end time, and priority level.
- **Remove a Task**: Delete an existing task from the schedule.
- **View All Tasks**: View tasks sorted by their start time.
- **Conflict Checking**: Ensure tasks do not overlap with each other.

### Design Patterns Used

- **Singleton Pattern**: The `ScheduleManager` class ensures that there is only one instance managing all tasks.
- **Factory Pattern**: The `TaskFactory` is used to create task objects.
- **Observer Pattern**: Notifies users if there are scheduling conflicts or updates.


### Installation
1. **Clone the repository**:
```bash
git clone https://github.com/vaidehiadhi/AstronautSchedulerApp.git

cd AstronautSchedulerApp
```
2. **Open in VS Code**: Open the project folder in VS Code by selecting File -> Open Folder....

3. **Compile and Run**:

- If you have the Java Extension Pack installed, simply open AstronautSchedulerApp.java and click the Run button near the main method.

Alternatively, you can run the project from the terminal:

```bash
cd src/
javac *.java
java AstronautScheduleApp
```
### Usage
When the application is running, it will present the following command prompt:

```bash
Enter a command (add, remove, view, exit): 
```
### Commands:
1. **Add a Task**:

- Type add and follow the interactive prompts to enter the task details:
```bash
Enter task description: Morning Exercise
Enter start time (HH:MM): 07:00
Enter end time (HH:MM): 08:00
Enter priority (Low, Medium, High): High
```
- If there is no conflict, the task will be added successfully.

2. **Remove a Task**:

- Type remove and enter the task description to remove it:
```bash
Enter task description to remove: Morning Exercise
```
3. **View Tasks**:

- Type view to display all tasks sorted by start time.
4. **Exit**:

- Type exit to close the application.

### Error Handling
- **Task Overlap**: If you try to add a task that overlaps with an existing task, the application will notify you:

```bash
Error: Task conflicts with existing task "Team Meeting".
````
- **Invalid Time Format**: If an invalid time format is provided, the application will notify you:
```bash
Error: Invalid time format.
```
- **Task Not Found**: If you try to remove a task that doesn't exist:

```bash
Error: Task not found.
````

### Design Considerations
- **Performance**: The task list is optimized for quick lookup and sorting by start time.
- **Logging**: You can extend the application by implementing a logging mechanism for tracking operations and errors.
- **Exception Handling**: All errors are handled gracefully with user-friendly messages.

### Future Improvements
- Add a graphical user interface (GUI) for easier interaction.
- Implement persistent storage (e.g., saving tasks to a file or database).
- Add support for recurring tasks.

## License

[MIT](https://choosealicense.com/licenses/mit/)
