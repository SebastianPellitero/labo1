package Screens;

import Exceptions.ServiceException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskForm  extends JPanel {
    private LayoutManager panelManager;
    private  JTextField  titleTxt;
    private JTextField descTxt;
    private JSpinner estimationTxt;
    private JSpinner realHsTxt;
    private  JButton buttonSubmit;

    public TaskForm(LayoutManager panelManager){
        super();
        this.panelManager = panelManager;
         armarPanel();
    }

    private void armarPanel() {
        this.setLayout(new GridLayout(6, 2));
        JLabel textLbl = new JLabel("Agregar nueva tarea");
        JLabel emptytextLbl = new JLabel();
        JLabel titleLbl = new JLabel("Titulo:");
        JLabel descLbl = new JLabel("Descripcion:");
        JLabel estimationLbl = new JLabel("Estimacion:");
        JLabel realHsLbl = new JLabel("Horas reales:");

        SpinnerModel estimationModel = new SpinnerNumberModel(0,0, 50,1);
        SpinnerModel hsModel = new SpinnerNumberModel(0, 0,  70,  1);

        titleTxt = new JTextField("");
        descTxt = new JTextField("");
        estimationTxt = new JSpinner(estimationModel);
        realHsTxt = new JSpinner(hsModel);

        JButton buttonBack = new JButton("Volver");
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarTaskManager();
            }
        });

        buttonSubmit = new JButton("Guardar");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSubmit();
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
        this.add(emptytextLbl);
        this.add(titleLbl);
        this.add(titleTxt);
        this.add(descLbl);
        this.add(descTxt);
        this.add(estimationLbl);
        this.add(estimationTxt);
        this.add(realHsLbl);
        this.add(realHsTxt);
        this.add(buttonBack);
        this.add(buttonSubmit);
    }

    private void checkBtn() {
        boolean value = !titleTxt.getText().trim().isEmpty();
        buttonSubmit.setEnabled(value);
    }

    private void onSubmit(){
        String title = titleTxt.getText();
        String description = descTxt.getText();
        int estimation = (int) estimationTxt.getValue();
        int realHs = (int) realHsTxt.getValue();

        try {
            panelManager.getTask1().crearTaskService(title, description, estimation, realHs);
            titleTxt.setText("");
            descTxt.setText("");
            estimationTxt.setValue(0);
            realHsTxt.setValue(0);
            JOptionPane.showMessageDialog(null, "Tarea creada");
            panelManager.mostrarTaskManager();
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
