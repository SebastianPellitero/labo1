package Task;

import DB.DBManager;
import Exceptions.*;
import Exceptions.DAOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImplH2 implements TaskDAO {

    public TaskDAOImplH2 () {}

    private void executeSql(String sqlQuery) throws Exception  {
        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            s.executeUpdate(sqlQuery);
            c.commit();
        } catch (SQLException e) {
            try {
                switch(e.getErrorCode()) {
                    case 23505:
                        //e.printStackTrace();
                        c.rollback();
                        throw new ClaveDuplicadaException();
                    case 21002:
                       // e.printStackTrace();
                        c.rollback();
                        throw new ColumnCountNotMatchException();
                    case 23502:
                        //e.printStackTrace();
                        c.rollback();
                        throw new ColumnNotNullException();
                    default:
                        //e.printStackTrace();
                        c.rollback();
                        throw new sqlException();
                }
            } catch (SQLException e1) {
                System.out.println("ei");
                e.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    @Override
    public void createTask(Task unTask) throws Exception {
        String title = unTask.getTitle();
        String description = unTask.getDescription();
        int estimation = unTask.getEstimation();
        int realHs = unTask.getRealHours();
        String sql =  "INSERT INTO task (title, description, estimation, realHours, employeeId) VALUES ('" +title+ "','" + description + "',"+ estimation + ","+realHs+ ", 'id1')";
        executeSql(sql);
    }

    @Override
    public void deleteTask(int taskId) throws Exception {
        String sql = "DELETE FROM task where taskId=" +taskId;
        executeSql(sql);
    }

    @Override
    public void updateTask(Task unTask) throws Exception {
        int taskId = unTask.getTaskId();
        String title = unTask.getTitle();
        String description = unTask.getDescription();
        int estimation = unTask.getEstimation();
        int realHs = unTask.getRealHours();
        String sql = "UPDATE task set title ='"+title+"', description='"+description+"', estimation="+estimation+",realHours="+realHs+" WHERE taskId="+taskId;
        executeSql(sql);
    }

    @Override
    public Task getTaskDetails(int taskId) throws DAOException {
        Connection c = DBManager.connect();

        String sql = "SELECT * FROM task WHERE taskId="+taskId;
        Task result = new Task();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()) {
                result.setTaskId(rs.getInt("taskId"));
                result.setTitle( rs.getString("title"));
                result.setDescription(rs.getString("description"));
                result.setEstimation(rs.getInt("estimation"));
                result.setRealHours(rs.getInt("realHours"));
                result.setEmployeeId(rs.getString("employeeId"));
            }

        } catch (SQLException e) {
            System.out.println("SQLException "+e);
            try {
                c.rollback();
            } catch (SQLException e1) {
                throw new DAOException();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Task> getAllTasks() throws DAOException {
        Connection c = DBManager.connect();
        List<Task> resultado = new ArrayList<>();
        String sql = "SELECT * FROM task";
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int taskId = rs.getInt("taskId");
                String titleTask = rs.getString("title");
                String descriptionTask = rs.getString("description");
                Task u = new Task(taskId, titleTask,  descriptionTask);
                resultado.add(u);
            }
        } catch (SQLException e) {
            System.out.println("SQLException"+e);
            try {
                c.rollback();
            } catch (SQLException e1) {
                throw new DAOException();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return resultado;
    }
}
