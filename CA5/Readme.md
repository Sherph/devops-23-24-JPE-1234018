# Class Assignment 5

## Getting started

The first step to complete this assignment is to install Jenkins. To do this, we need to these steps:

1. Download the Jenkins war file from the [Jenkins website](https://www.jenkins.io/download/)(at this time the latest
   version is 2.462).
2. Open a terminal in the same directory where the war file is present and run the following command:

```bash
java -jar jenkins.war
```

3. After that we can access Jenkins by opening a browser and going to the following URL:

http://localhost:8080

Jenkins is now running and we can start creating the pipeline. To do this we can follow the pdf provided by the teacher.

## First Jenkinsfile

After setting up the job and inserting the Github link to the repository, we can start creating the Jenkinsfile. The
Jenkinsfile is responsible for defining the pipeline and the steps that the pipeline will execute. The Jenkinsfile for
the first pipeline is shown below:

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Sherph/devops-23-24-JPE-1234018'
            }
        }

        stage('Assemble') {
            steps {
                dir('CA2_P1/gradle_basic_demo') {
                    sh './gradlew assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA2_P1/gradle_basic_demo') {
                    sh './gradlew test'
                }
            }
            post {
                always {
                    junit '**/build/test-results/**/*.xml'
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
            }
        }
    }
}
```


After creating the pipeline, we can run it and check if it is working correctly. If everything is working correctly, we
can move on to the second pipeline.

## Second Jenkinsfile

The second Jenkinsfile is similar to the first one, but it has an extra stage that pushes the Docker image to Dockerhub.
The Jenkinsfile for the second pipeline is shown below:

```groovy
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Sherph/devops-23-24-JPE-1234018'
            }
        }

        stage('Assemble') {
            steps {
                dir('CA2_P2/react-and-spring-data-rest-basic') {
                    bat './gradlew assemble'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CA2_P2/react-and-spring-data-rest-basic') {
                    bat './gradlew test'
                }
            }
            post {
                always {
                    junit '**/build/test-results/**/*.xml'
                }
            }
        }

        stage('Javadoc') {
            steps {
                dir('CA2_P2/react-and-spring-data-rest-basic') {
                    bat './gradlew javadoc'
                }
            }
            post {
                always {
                    publishHTML(target: [
                            allowMissing         : false,
                            alwaysLinkToLastBuild: false,
                            keepAll              : true,
                            reportDir            : 'CA2_P2/react-and-spring-data-rest-basic/build/docs/javadoc',
                            reportFiles          : 'index.html',
                            reportName           : 'Javadoc'
                    ])
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '**/build/libs/*.war', fingerprint: true
            }
        }

        stage('Publish Image') {
            steps {
                script {
                    dir('CA5/Part2') {
                        bat 'copy ..\\..\\CA2_P2\\react-and-spring-data-rest-basic\\build\\libs\\*.war .'
                        def app = docker.build("luisaremelhe/devops_23_24:${env.BUILD_NUMBER}")
                        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_credentials') {
                            app.push()
                        }
                    }
                }
            }
        }
    }
}
```


