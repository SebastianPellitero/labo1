package Task;
import java.util.List;
import Exceptions.*;

public interface TaskDAO  {

    void createTask(Task unTask) throws Exception;

    void deleteTask(int taskId) throws Exception;

    void updateTask(Task unTask) throws Exception;

    Task getTaskDetails(int taskId) throws DAOException;

    List<Task> getAllTasks()  throws DAOException;

}
