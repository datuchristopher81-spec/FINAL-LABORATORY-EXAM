package model;

public abstract class AbstractTask {
    protected int taskId;
    protected String taskName;
    protected String taskDescription;

    // Default constructor
    public AbstractTask() {
    }

    // Parameterized constructor
    public AbstractTask(int taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // Abstract getter and setter for taskId
    public abstract int getTaskId();
    public abstract void setTaskId(int taskId);

    // Normal getters and setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}