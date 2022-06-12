package Screens;
import Task.*;

import javax.swing.*;

public class LayoutManager extends JFrame {

    private JFrame frame;
    private TaskManager tm;
    private TaskTableScreen listTask;
    private TaskForm newTaskForm;
    private TaskService taskService ;
    private TaskDetailsScreen taskDetails ;

    public LayoutManager(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskService getTask1() {
        return taskService;
    }

    public void armarManager() {
        frame = new JFrame();
        frame.setTitle("Manager");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void mostrarTaskManager() {
        tm = new TaskManager(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(tm);
        frame.setVisible(true);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

    }

    public void showListTaskScreen(){
        listTask = new TaskTableScreen(this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(listTask);
        frame.setVisible(true);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

    }

    public void showAddTaskScren(){
        newTaskForm = new TaskForm( this);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newTaskForm);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

    }

    public void mostrarTaskDetailsScreen(Task taskToShow){
        taskDetails = new TaskDetailsScreen( this);
        frame.getContentPane().removeAll();
        taskDetails.setTask(taskToShow);
        frame.getContentPane().add(taskDetails);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

    }

    public void showFrame() {
        frame.setVisible(true);
    }

}
