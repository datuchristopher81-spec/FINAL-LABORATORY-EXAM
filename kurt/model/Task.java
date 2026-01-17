package model;

public class Task extends AbstractTask {

    private String status;

    // Allowed values
    public static final String NOT_STARTED = "Not Started";
    public static final String ONGOING = "Ongoing";
    public static final String DONE = "Completed";

    public Task(int taskId, String taskName, String taskDescription, String status) {
        super(taskId, taskName, taskDescription);
        this.status = status;
    }

    // Override abstract methods
    @Override
    public int getTaskId() {
        return taskId;
    }

    @Override
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    // Override status getter and setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals(NOT_STARTED) || status.equals(ONGOING) || status.equals(DONE)) {
            this.status = status;
        }
    }
}