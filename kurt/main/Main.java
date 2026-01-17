package main;

import controller.TaskManager;
import ui.TaskViewer;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        TaskViewer viewer = new TaskViewer(manager);
        viewer.setVisible(true);
    }
}