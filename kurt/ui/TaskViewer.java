package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TaskViewer extends JFrame {

    private TaskManager manager;
    private JTable table;
    private DefaultTableModel model;
    private TaskForm form;

    public TaskViewer(TaskManager manager) {
        this.manager = manager;

        setTitle("To-Do List Viewer");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(e -> {
            if (form == null || !form.isVisible()) {
                form = new TaskForm(this, manager);
                form.setVisible(true);
            }
        });

        model = new DefaultTableModel(new String[]{
                "Task ID", "Task Name", "Task Description", "Status"
        }, 0);

        table = new JTable(model);

        add(addButton, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void refreshTable() {
        model.setRowCount(0);
        for (Task t : manager.getTasks()) {
            model.addRow(new Object[]{
                    t.getTaskId(),
                    t.getTaskName(),
                    t.getTaskDescription(),
                    t.getStatus()
            });
        }
    }
}