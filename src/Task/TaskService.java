package Task;

import Exceptions.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService  extends JPanel {
    private TaskDAO dao;

    public TaskService() {
        this.dao = new TaskDAOImplH2();
    }
    public void crearTaskService(String title, String desc,int estimation,int realHs) throws ServiceException {
        Task newT = new Task(title, desc, estimation, realHs);

        try {
            dao.createTask(newT);
        } catch (ClaveDuplicadaException e) {
           throw new ServiceException("La tarea ya existe");
        } catch (ColumnCountNotMatchException e1) {
            throw new ServiceException("Faltan datos para crear la tarea");
        }
        catch (ColumnNotNullException e1) {
            throw new ServiceException("Por favor llene los datos requeridos");
        }
        catch (Exception e ) {
            throw new ServiceException("Ocurrio un problema, reintente mas tarde");
        }
    }

    public List<Task> getAllTasksService() {
        List<Task> lista = new ArrayList<Task>();
        try {
            lista =  dao.getAllTasks();
        } catch (DAOException e) {

            // throw new ServiceException("hubo un problema", e);
        }
        return lista;
    }

    public void deleteTaskService(int taskIdToDelete) throws ServiceException {
        try {
            dao.deleteTask(taskIdToDelete);
        }
        catch (ColumnNotNullException e1) {
            throw new ServiceException("Por favor llene los datos requeridos");
        }
        catch (Exception e ) {
            throw new ServiceException("Ocurrio un problema, no se pudo borrar la tarea");
        }
    }

    public void updateTaskService(int taskId, String title, String desc,int estimation,int realHs) throws ServiceException {
        Task newT = new Task(taskId, title, desc, estimation, realHs);
        try {
            dao.updateTask(newT);
        } catch (Exception e ) {
            throw new ServiceException("Ocurrio un problema, no se pudo editar la tarea");
        }
    }

    public Task getTaskDetailsService(int taskId) throws ServiceException {
        Task t = new Task();
        try {
            t = dao.getTaskDetails(taskId);
        } catch (Exception e ) {
            throw new ServiceException("Ocurrio un problema, no se pudo obtener los detalles de la tarea");
        }
        return t;
    }

}
