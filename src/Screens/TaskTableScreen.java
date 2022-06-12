package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Exceptions.ServiceException;
import Task.*;

public class TaskTableScreen extends JPanel {

        private JTable tablaTasks;
        private TaskTableModel modelo;
        private LayoutManager panelManager;
        private JScrollPane scrollPaneParaTabla;
        private JButton fillTableBtn;
        private JButton deleteBtn;
        private JButton backBtn;
        private JButton taskDetailsBtn;

        public TaskTableScreen(LayoutManager panelManager) {
            super();
            this.panelManager = panelManager;
            armarPanel();
        }

        private void armarPanel() {
            this.setLayout(new FlowLayout());

            modelo = new TaskTableModel();
            tablaTasks = new JTable(modelo);
            scrollPaneParaTabla = new JScrollPane(tablaTasks);
            deleteBtn = new JButton("Borrar tarea");
            fillTableBtn = new JButton("Actualizar Tabla");
            backBtn = new JButton("Volver");
            taskDetailsBtn = new JButton("Ver detalle tarea");

            fillTable();

            fillTableBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fillTable();
                }
            });
            deleteBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    onDelete();
                }
            });
            backBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelManager.mostrarTaskManager();
                }
            });
            taskDetailsBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int filaSeleccionada = tablaTasks.getSelectedRow();
                    Task task = modelo.getContent().get(filaSeleccionada);
                    panelManager.mostrarTaskDetailsScreen(task);
                }
            });


            this.add(scrollPaneParaTabla);
            this.add(fillTableBtn);
            this.add(deleteBtn);
            this.add(backBtn);
            this.add(taskDetailsBtn);
        }

        private void fillTable() {
            modelo.setContent(null);
            List<Task> lista = panelManager.getTask1().getAllTasksService();
            modelo.setContent(lista);
            modelo.fireTableDataChanged();
        }

        private void onDelete(){
            int filaSeleccionada = tablaTasks.getSelectedRow();
            Task taskToDelete = modelo.getContent().get(filaSeleccionada);
            try {
                panelManager.getTask1().deleteTaskService(taskToDelete.getTaskId());
                modelo.getContent().remove(filaSeleccionada);
                modelo.fireTableDataChanged();
            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }
