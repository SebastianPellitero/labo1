package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManager extends JPanel {

    private LayoutManager panelManager;
    private JButton listTaskBtn;
    private JButton addTaskBtn;
    public TaskManager(LayoutManager panelManager) {
        super();
        this.panelManager = panelManager;
         armarPantallaPanel();
    }

    public void armarPantallaPanel() {
        this.setLayout(new FlowLayout());
        JLabel title = new JLabel("Task Manager:");
        this.add(title);
        this.listTaskBtn = new JButton("Listar tareas");
        this.addTaskBtn = new JButton("Agregar tarea nueva");

        this.add(listTaskBtn);
        this.add(addTaskBtn);

        //escuchar evento del ok, mandar a grabar
        this.listTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.showListTaskScreen();
            }
        });
        this.addTaskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.showAddTaskScren();
            }
        });

    }
}