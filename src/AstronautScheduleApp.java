import java.util.Scanner;

public class AstronautScheduleApp {

    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();
        ConsoleNotifier consoleNotifier = new ConsoleNotifier();
        scheduleManager.registerObserver(consoleNotifier);

        try (Scanner scanner = new Scanner(System.in)) {
            String command;
            
            do {
                System.out.println("\nEnter a command (add, remove, view, exit): ");
                command = scanner.nextLine().toLowerCase();
                
                switch (command) {
                    case "add" -> {
                        try {
                            System.out.println("Enter task description: ");
                            String description = scanner.nextLine();
                            System.out.println("Enter start time (HH:MM): ");
                            String startTime = scanner.nextLine();
                            System.out.println("Enter end time (HH:MM): ");
                            String endTime = scanner.nextLine();
                            System.out.println("Enter priority (Low, Medium, High): ");
                            String priority = scanner.nextLine();
                            
                            Task task = taskFactory.createTask(description, startTime, endTime, priority);
                            scheduleManager.addTask(task);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                        
                    case "remove" -> {
                        System.out.println("Enter task description to remove: ");
                        String descToRemove = scanner.nextLine();
                        scheduleManager.removeTask(descToRemove);
                    }
                        
                    case "view" -> scheduleManager.viewTasks();
                        
                    case "exit" -> System.out.println("Exiting application.");
                        
                    default -> System.out.println("Invalid command.");
                }
                
            } while (!command.equals("exit"));
        }
    }
}
