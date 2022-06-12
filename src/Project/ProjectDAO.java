package Project;

import java.util.List;
import Exceptions.*;
public interface ProjectDAO  {

    void createProject(Project unProject) throws ClaveDuplicadaException;

    void deleteProject(String projectName) throws DAOException;

    void updateProject(Project unProject);

    Project showProject(String projectName);

    List<Project> listAllProjects() throws DAOException;

}
