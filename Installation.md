# **Setup and Installation**

### **Prerequisites**
Before you start, ensure you have the following installed:
- **JDK 11 or above**
- **Apache Maven 3.6+**
- **A servlet container** like Tomcat (version 9 or above is recommended)
- **Git** (optional, if you want to clone the project)

### **Steps to Set Up the Project**

1. **Clone the Repository:**
   If you have a GitHub repository, clone it to your local machine using:
   ```bash
   git clone https://github.com/your-username/your-repository.git
   cd your-repository

2. **Install Dependencies: Run the following Maven command to install all the required dependencies specified in the pom.xml file:**
     ```bash
    mvn clean install

3. **Build the Project: To build the project, run the Maven build command:**
     ```bash
      mvn clean package
  -This will create a .war (Web Archive) file in the target directory. This file can be deployed to any servlet container like Apache Tomcat.

4.  Deploy to Tomcat:
  
  - Copy the .war file from the target/ directory to the webapps/ directory of your Tomcat installation.
  - Start Tomcat by running the startup.sh (Linux/Mac) or startup.bat (Windows) script from the Tomcat bin/ directory.
  - Access the application by visiting http://localhost:8080/your-project-name/.

**Running the Project Locally with Maven Plugin:**

Alternatively, you can run the project directly from the command line using the Maven Tomcat Plugin. To do this, use the following command:
   ```bash
    mvn tomcat7:run.
```
-This will start the Tomcat server locally and make your web app available at http://localhost:8080/.
