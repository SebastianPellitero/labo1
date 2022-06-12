package Project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import Exceptions.*;
import DB.*;

public class ProjectDAOImplH2 implements ProjectDAO {
    @Override
    public void createProject(Project unProject) throws ClaveDuplicadaException {
            String name = unProject.getName();
            String description = unProject.getdescription();

            Date d = new Date();


            Connection c = DBManager.connect();
            try {
                Statement s = c.createStatement();


                String sql = "INSERT INTO projects (name, description) VALUES ('CA', 'My project')";
                s.executeUpdate(sql);
                c.commit();
            } catch (SQLException e) {
                try {
                    if(e.getErrorCode() == 23505) {
                        throw new ClaveDuplicadaException();
                    }
                    e.printStackTrace();
                    c.rollback();
                } catch (SQLException e1) {
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
    public void deleteProject(String projectName) throws DAOException {

    }

    @Override
    public void updateProject(Project unProject) {

    }

    @Override
    public Project showProject(String projectName) {
        return null;
    }

    @Override
    public List<Project> listAllProjects() throws DAOException {
        return null;
    }
}
