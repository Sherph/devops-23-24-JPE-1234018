# Build Tools with Gradle

This README provides a step-by-step guide to build tools with Gradle.

## Add a new task to execute the server.

1. **Navigate to your Project Directory**: Open Git Bash or your terminal and navigate to the directory where your Gradle project is located using the `cd` command.

2. **Define the Server Execution Task**: Open your `build.gradle` file in a text editor. Add a new task definition for executing the server. For example:
    ```groovy
    task executeServer {
        // Define commands to execute the server
        doLast {
            // Insert server startup command here
        }
    }
    ```
3. **Save the Changes**: Save the changes made to your `build.gradle` file.

4. **Execute the Task**: In Git Bash or your terminal, run the following command to execute the server task:
    ```bash
    ./gradlew executeServer
    ```

## Adding a Simple Unit Test and Updating Gradle Script

1. **Define the Unit Test**: Create a new Java file for your unit test in the appropriate test directory (e.g., `src/test/java`). Write your unit test code inside this file. Ensure that you have JUnit 4.12 dependency added to your project.

2. **Update Gradle Script**: Open your `build.gradle` file again. Add the JUnit 4.12 dependency to your `dependencies` block if it's not already included. For example:
    ```groovy
    testImplementation 'junit:junit:4.12'
    ```

3. **Configure Gradle to Execute Tests**: Ensure that Gradle is configured to execute your unit tests. By default, Gradle's Java plugin should handle this. If not, ensure that your `test` task includes your unit tests.

4. **Save and Close**: Save your `build.gradle` file.

5. **Run the Unit Tests**: In Git Bash or your terminal, run the following command to execute your unit tests:
    ```bash
    ./gradlew test
    ```

6. **Review the Results**: After running the tests, review the output in the terminal to ensure that your tests ran successfully.

By following these steps, you've successfully added a new task to execute the server and integrated a simple unit test into your Gradle project. Adjust the instructions according to your project structure and requirements.


## Adding a New Task of Type Copy

### Step 1: Define the Copy Task

Open your build.gradle file in a text editor. This file is located in the root directory of your Gradle project.

Add a new task definition of type Copy to make a backup of the sources. You can name the task as per your preference. For example:

    task backupSources(type: Copy) {
        from 'src'
        into 'backup'
    }

In the above task definition:

-from 'src' specifies the source directory from which files will be copied.

-into 'backup' specifies the destination directory where the files will be copied.

### Step 2: Save the Changes

Save the changes made to your `build.gradle` file.

### Step 3: Execute the Task

In Git Bash or your terminal, run the following command to execute the backup task:

      ./gradlew backupSources

This command will execute the newly defined task, which will copy the contents of the src folder to a new backup folder.

### Step 4: Verify the Backup

After running the task, navigate to the backup folder in your project directory to verify that the contents of the src folder have been successfully copied.

## Adding a New Task of Type Zip

### Step 1: Define the Zip Task

Open your build.gradle file: Open your build.gradle file in a text editor. This file is located in the root directory of your Gradle project.

Add a new task definition: Add a new task definition of type Zip to create an archive of the sources. You can name the task as per your preference. For example:

      task zipSources(type: Zip) {
      from 'src'
      archiveFileName = 'sources.zip'
      destinationDir = file('zip')
      }

In the above task definition:

-from 'src' specifies the source directory from which files will be included in the zip file.

-archiveFileName = 'sources.zip' specifies the name of the zip file to be created.

-destinationDir = file('zip') specifies the destination directory where the zip file will be created.

### Step 2: Save the Changes

Save the changes made to your build.gradle file.

### Step 3: Execute the Task

Run the task: In Git Bash or your terminal, run the following command to execute the zip task:

      ./gradlew zipSources

This command will execute the newly defined task, which will create a zip file containing the contents of the `src` folder.

### Step 4: Verify the Zip File

Navigate to the zip folder: After running the task, navigate to the zip folder in your project directory to verify that the `zip` file has been successfully created.





### Implementing Changes
#### Part 1: Adding the runServer task

For this first section, goal is to add a new task in the build.gradle file to start the server. The steps to do so are:

1. Open the build.gradle file (located in the root of the project) and navigate to the end of the file and add the new task:
   ```gradle
   task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a chat server that listens on localhost:59001"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'}

    ```

   - The task is of type JavaExec, which means it will execute a Java class. It depends on the classes task, which means it will only run after the classes task is completed. The group and description are used to describe the task. The classpath is set to the runtime classpath of the main source set. The mainClass is set to the ChatServerApp class, and the args are set to 59001, which is the port the server will listen to.


#### Part 2: Adding the test class and unit test

For this part of the assignment, a new test class will be created and a unit test will be added. The steps to do so are:

1. Create a new test folder and a new test class:
   ```bash
   mkdir -p src/test/java/basic_demo
   touch src/test/java/basic_demo/ChatServerAppTest.java
   ```
   - command mkdir creates a new directory, the '-p' notation allows for the creation of multiple directories at once, and the touch command creates a new file.


2. Setup the test class:
```java
package basic_demo;


import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
}
```
3. Add the unit test:
```java
   @Test public void testAppHasAGreeting() {
      App classUnderTest = new App();
      assertNotNull("app should have a greeting", classUnderTest.getGreeting());
   }
```
4. Add the dependencies in the build.gradle file:
```gradle
dependencies {
    // Use Apache Log4J for logging
    implementation group: 'org.apache.logging.log4j', name: 'log4j-api', version: '2.11.2'
    implementation group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.11.2'
    testImplementation 'junit:junit:4.12'
}
```

5. Compile the project in the terminal(first navigate to the project folder):
```bash
./gradlew build
```
*Note*: It is also possible to run the task independently by using the command:
```bash
./gradlew runServer
```
6. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add test class and unit test"
```
7. Push the changes to the remote repository:
```bash
git push
```

#### Part 3: Adding the Copy task
The goal is to create a new task that will create a backup of the source of the application and copy it into a 'backup' folder in the application root. The steps to do so are:

1. Open the build.gradle file and add the new task:
```gradle
task copySources (type: Copy){
    group = "DevOps"
    description = "Copy source files to the target directory"

    from 'src/'
    into 'backup/'
}
```
5. Compile the project in the terminal(first navigate to the project folder):
```bash
./gradlew build
```
*Note*: It is also possible to run the task independently by using the command:
```bash
./gradlew copySources
```

6. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add copy task"
```
7. Push the changes to the remote repository:
```bash
git push
```

#### Part 4: Adding the Zip task
The goal is to create a new task that will create a .zip backup of the source of the application and copy it into a 'backup' folder in the application root. The steps to do so are:

1. Open the build.gradle file and add the new task:
```gradle
task zipSources (type: Zip){
    group = "DevOps"
    description = "Zip source files to the target directory"

    from 'src/'
    archiveFileName = 'src.zip'
    destinationDir = file('backup/')
}
```
5. Compile the project in the terminal(first navigate to the project folder):
```bash
./gradlew build
```
*Note*: It is also possible to run the task independently by using the command:
```bash
./gradlew zipSources
```
6. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add zip task"
```
7. Push the changes to the remote repository:
```bash
git push
```
8. Add a tag to mark the end of the first part of this assignment:
```bash
git tag ca2-part1
git push --tags
```
