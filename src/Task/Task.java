package Task;

public class Task {

    private int taskId;
    private String title;
    private String description;
    private int estimation;
    private int realHours;
    private String employeeId;

   public Task() {
        this.title = "";
        this.description = "";
        this.estimation=0;
        this.realHours=0;
        this.employeeId="";
    }

    public Task(int taskId, String title, String description) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.estimation=0;
        this.realHours=0;
        this.employeeId="";
    }

    public Task(String title, String description, int estimation, int realHours) {
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.realHours = realHours;
        this.employeeId = "";
    }

    public Task(int taskId, String title, String description, int estimation, int realHours) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.realHours = realHours;
        this.employeeId = "";
    }

    public Task(int taskId, String title, String description, int estimation, int realHours, String employeeId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.realHours = realHours;
        this.employeeId = employeeId;
    }

    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
    public int getEstimation() {
        return estimation;
    }
    public int getRealHours() {
        return realHours;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public int getTaskId() { return taskId; }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitle(String title) { this.title = title;}
    public void setEstimation(int estimation) { this.estimation = estimation;}
    public void setRealHours(int realHours) { this.realHours = realHours;}
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId;}
    public void setTaskId(int taskId) { this.taskId = taskId;}

    @Override
    public String toString() {
        return "Task.Task{" +"TASIK=" + taskId +
        "title='" + title + '\'' +  "description='" + description + '\'' +
                "estimation='" + estimation +
                "realHours='" + realHours + "employee='" + employeeId + '\'' +
                '}';
    }
}
