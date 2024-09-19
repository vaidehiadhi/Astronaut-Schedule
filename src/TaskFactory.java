import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {

    public Task createTask(String description, String startTime, String endTime, String priority) throws IllegalArgumentException {
        try {
            LocalTime start = LocalTime.parse(startTime);
            LocalTime end = LocalTime.parse(endTime);

            if (start.isAfter(end)) {
                throw new IllegalArgumentException("Error: Start time cannot be after end time.");
            }

            return new Task(description, start, end, priority);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Error: Invalid time format.");
        }
    }
}
