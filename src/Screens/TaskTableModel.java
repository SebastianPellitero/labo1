package Screens;

import Task.Task;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {

    private List<Task> content;

    private static final int COLUMN_TASKID = 0;
    private static final int COLUMN_TITLE = 1;
    private static final int COLUMN_DESCRIPTION = 2;


    private String[] nombresColumnas = {"taskId","title","description"};
    private Class[] tiposColumnas = {int.class, String.class, Integer.class};


    public TaskTableModel() {
        content = new ArrayList<Task>();
    }

    public TaskTableModel(List<Task> contentInicial) {
        content = contentInicial;
    }

    public int getColumnCount() {
        return nombresColumnas.length;
    }
    public int getRowCount() {
        return content.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        super.setValueAt(value, rowIndex, columnIndex);
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task u = content.get(rowIndex);
        Object result = null;
        switch(columnIndex) {
            case COLUMN_TASKID:
                result = u.getTaskId();
                break;
            case COLUMN_TITLE:
                result = u.getTitle();
                break;
            case COLUMN_DESCRIPTION:
                result = u.getDescription();
                break;
            default:
                result = new String("");
        }

        return result;
    }

    public String getColumnName(int col) {
        return nombresColumnas[col];
    }
    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }


    public List<Task> getContent() {
        return content;
    }
    public void setContent(List<Task> content) {
        this.content = content;
    }
}
