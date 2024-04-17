# Class Assignment 2

## Getting Started

The first step is to create a new branch called "tut-basic-gradle" in the repository to work on the assignment. To do so, open a git bash and type in the command:
```bash
git branch tut-basic-gradle
```

After creating the branch, switch to it by typing:
```bash
git checkout tut-basic-gradle
```

1. Go to the website given to generate a new gradle spring boot project. Fill in the necessary information and add the needed dependencies according to the image given.

2. Click on the "Generate" button and download the project. Extract the files to the CA2 Part2 folder.

3. Open the project in IntelliJ and delete de **src** folder.

4. Copy the **src** folder from Class Assignment 1 to the project folder.
5. Copy the **webpack.config.js** and the **package.json** files from Class Assignment 1 to the project folder.
6. Delete the **src/main/resources/static/built/** folder.
7. In the **Employee.java** class, change all *javax.persistence* imports to *jakarta.persistence*.

### Part 1: Adding the frontend plugin

1. Open the build.gradle file and add the plugin:
```gradle
 id "org.siouan.frontend-jdk17" version "8.0.0"
```

2. Configure the plugin in the same build.gradle file:
```gradle
 frontend {
nodeVersion = "16.20.2"
assembleScript = "run build"
cleanScript = "run clean"
checkScript = "run check"
}
```

3. Add the dependencies in the package.json file:
```gradle
"scripts": {
"webpack": "webpack",
"build": "npm run webpack",
"check": "echo Checking frontend",
"clean": "echo Cleaning frontend",
"lint": "echo Linting frontend",
"test": "echo Testing frontend"
},
```
4. Add the package manager to the package.json file, before the scripts section:
```gradle
"packageManager": "npm@9.6.7",
```

5. Compile the project in the terminal(first navigate to the project folder):
```bash
./gradlew build
```

### Part 2: Adding the copyJar task

1. Open the build.gradle file and add the task:
```gradle
task copyJar(type: Copy, dependsOn: build) {
	from 'build/libs/'
	into 'dist'
	include '*.jar'
}
```

2. Compile the project in the terminal(first navigate to the project folder):
```bash
./gradlew build
```
3. Add all te files to the staging area:
```bash
git add .
```
4. Commit the changes:
```bash
git commit -m "Added the copyJar task"
```
5. Push the changes to the repository:
```bash
git push
```

### Part 3: Adding the deleteWebpackFiles task

1. Open the build.gradle file and add the task:
```gradle
task deleteWebpackFiles(type: Delete) {
	delete 'src/main/resources/static/built'
}
```

2. Add the following command to make sure this task is executed automatically by the task *clean*:
```gradle
clean.dependsOn(deleteWebpackFiles)
```

3. Compile the project in the terminal(first navigate to the project folder):
```bash
./gradlew build
```
4. Add all te files to the staging area:
```bash
git add .
```
5. Commit the changes:
```bash
git commit -m "Added the deleteWebpackFiles task"
```
6. Push the changes to the repository:
```bash
git push
```

### Part 4: Merging the branches

1. Switch to the main branch:
```bash
git checkout main
```
2. Merge the tut-basic-gradle branch:
```bash
git merge --no-ff tut-basic-gradle
```
3. Push the changes to the repository:
```bash
git push
```
