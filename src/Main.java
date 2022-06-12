import Screens.*;
import Task.*;
import DB.*;
import Project.*;
import java.sql.SQLException;

public class Main {

	public static void main(String [] args) throws SQLException {
		System.out.println("start");
	 	 TableManager tm = new TableManager();
		// tm.createProjectTable();
		// ProjectDAO daoH2 = new ProjectDAOImplH2();
		// Project newP = new Project("CA", "My project");
 //tm.createTaskTable();


		TaskService task1 = new TaskService();
		LayoutManager bl = new LayoutManager(task1);
	    bl.armarManager();
		bl.mostrarTaskManager();


		System.out.println("finish");

		// tm.dropProjectTable();

	}
	
}
