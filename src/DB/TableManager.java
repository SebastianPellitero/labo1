package DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {
	Connection c = DBManager.connect();

	private void createTable(String sql) {
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void createProjectTable() {
		String sql = "CREATE TABLE projects ( projectId int NOT NULL AUTO_INCREMENT name VARCHAR(256) UNIQUE, description VARCHAR(256))";
		createTable(sql);
	}

	public void createTaskTable() {
		String sql = "CREATE TABLE task ( taskId int NOT NULL AUTO_INCREMENT, title VARCHAR(256) NOT NULL, description VARCHAR(256), estimation INTEGER, realHours INTEGER, employeeId VARCHAR(256))";
		createTable(sql);
	}


	
	public void dropProjectTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE projects";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
