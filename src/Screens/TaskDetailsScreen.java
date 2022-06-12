package Screens;

import Exceptions.ServiceException;
import Task.Task;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskDetailsScreen extends JPanel {
    private LayoutManager panelManager;
    private JTextField  titleTxt;
    private JTextField descTxt;
    private JSpinner estimationTxt;
    private JSpinner realHsTxt;
    private JButton buttonSubmit;
    private JTextField employeeTxt;

    private Task task;

    public TaskDetailsScreen(LayoutManager panelManager){
        super();
        this.panelManager = panelManager;

    }

    public void setTask(Task task){
        try {
            this.task = panelManager.getTask1().getTaskDetailsService(task.getTaskId());
            armarPanel();
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void armarPanel() {
        this.setLayout(new GridLayout(6, 2));
        JLabel textLbl = new JLabel("Detalle tarea");
        JLabel descLbl = new JLabel("Descripcion:");
        JLabel estimationLbl = new JLabel("Estimacion:");
        JLabel realHsLbl = new JLabel("Horas reales:");
        JLabel employeeIdLbl = new JLabel("Empleado:");

        SpinnerModel estimationModel = new SpinnerNumberModel(task.getEstimation(), 0, 50,1);
        SpinnerModel hsModel = new SpinnerNumberModel(task.getRealHours(), 0,  70,  1);

        titleTxt = new JTextField(task.getTitle());
        descTxt = new JTextField(task.getDescription());
        estimationTxt = new JSpinner(estimationModel);
        realHsTxt = new JSpinner(hsModel);
        employeeTxt = new JTextField(task.getEmployeeId());

        JButton buttonBack = new JButton("Volver a tareas");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.showListTaskScreen();
            }
        });

        buttonSubmit = new JButton("Guardar cambios");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onEdit();
            }
        });

        titleTxt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkBtn();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkBtn();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                checkBtn();
            }
        });
        buttonSubmit.setEnabled(false);

        this.add(textLbl);
        this.add(titleTxt);
        this.add(descLbl);
        this.add(descTxt);
        this.add(estimationLbl);
        this.add(estimationTxt);
        this.add(realHsLbl);
        this.add(realHsTxt);
        this.add(employeeIdLbl);
        this.add(employeeTxt);
        this.add(buttonBack);
        this.add(buttonSubmit);
    }

    private void checkBtn() {
        boolean value = !titleTxt.getText().trim().isEmpty();
        buttonSubmit.setEnabled(value);
    }

    private void onEdit(){
        int taskId = task.getTaskId();
        String title = titleTxt.getText();
        String description = descTxt.getText();
        int estimation = (int) estimationTxt.getValue();
        int realHs = (int) realHsTxt.getValue();

        try {
            panelManager.getTask1().updateTaskService(taskId, title, description, estimation, realHs);
            JOptionPane.showMessageDialog(null, "Tarea editada");
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
