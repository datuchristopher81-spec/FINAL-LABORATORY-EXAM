package controller;

import java.util.ArrayList;
import model.Task;

public class TaskManager {

    private ArrayList<Task> taskList = new ArrayList<>();
    private int lastId = 0;

    public int generateTaskId() {
        lastId++;
        return lastId;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public ArrayList<Task> getTasks() {
        return taskList;
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }
}