import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {

    private final List<Task> tasks;
    private List<TaskObserver> observers;

    private static ScheduleManager instance = null;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public ScheduleManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        if (validateTask(task)) {
            tasks.add(task);
            tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
            System.out.println("Task added successfully.");
        } else {
            notifyObservers("Error: Task conflicts with existing tasks.");
        }
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    public boolean validateTask(Task newTask) {
        for (Task task : tasks) {
            if (newTask.getStartTime().isBefore(task.getEndTime()) && newTask.getEndTime().isAfter(task.getStartTime())) {
                return false;
            }
        }
        return true;
    }

    public void registerObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (TaskObserver observer : observers) {
            observer.notify(message);
        }
    }
}
