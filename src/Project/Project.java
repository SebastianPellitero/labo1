package Project;

public class Project {

        private String name;
        private String description;


        public Project() {
        }

        public Project(String name, String description) {
            this.name = name;
            this.description = description;

        }
        public String getdescription() {
            return description;
        }

        public void setdescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) { this.name = name;}

        @Override
        public String toString() {
            return "Project.Project{" +
                    "name='" + name + '\'' +  "description='" + description + '\'' +
                    '}';
        }
    }
