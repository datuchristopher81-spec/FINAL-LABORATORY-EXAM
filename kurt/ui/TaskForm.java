package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import java.awt.*;

public class TaskForm extends JFrame {

    private TaskViewer viewer;
    private TaskManager manager;

    private JTextField txtId;
    private JTextField txtName;
    private JTextArea txtDesc;
    private JComboBox<String> comboStatus;

    public TaskForm(TaskViewer viewer, TaskManager manager) {
        this.viewer = viewer;
        this.manager = manager;

        setTitle("Add New Task");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setText(String.valueOf(manager.generateTaskId()));

        txtName = new JTextField();
        txtDesc = new JTextArea();

        comboStatus = new JComboBox<>(new String[]{
                Task.NOT_STARTED, Task.ONGOING, Task.DONE
        });

        JButton btnSave = new JButton("Save Task");
        btnSave.addActionListener(e -> saveTask());

        add(new JLabel("Task ID:"));
        add(txtId);
        add(new JLabel("Task Name:"));
        add(txtName);
        add(new JLabel("Task Description:"));
        add(txtDesc);
        add(new JLabel("Status:"));
        add(comboStatus);
        add(new JLabel(""));
        add(btnSave);
    }

    private void saveTask() {
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in Task Name and Status.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Task task = new Task(
                Integer.parseInt(txtId.getText()),
                txtName.getText(),
                txtDesc.getText(),
                comboStatus.getSelectedItem().toString()
        );

        manager.addTask(task);
        viewer.refreshTable();
        dispose();
    }
}