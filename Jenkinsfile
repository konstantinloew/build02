pipeline {
    agent any
    tools{
        maven 'my_maven'
    }
    stages {
        stage('Build') {
            steps {
                echo 'This is the build'
                sh 'mvn clean'
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                echo 'This is the testing stage'
                sh 'mvn test'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'This is the analysis'
                sh ' mvn clean verify sonar:sonar   -Dsonar.projectKey=HelloWorldTest   -Dsonar.projectName=”HelloWorldTest”   -Dsonar.host.url=http://localhost:9000   -Dsonar.token=sqp_843a2c9abadfba5dda5e0c36100a867e0246c976'
            }
        }
        stage('Deploy to Nexus') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'nexus-credentials',
                        usernameVariable: 'NEXUS_USER',
                        passwordVariable: 'NEXUS_PASS'
                    )
                ])
                {
                    sh """
                    curl -v -u $NEXUS_USER:$NEXUS_PASS \
                    --upload-file /var/lib/jenkins/workspace/IntegrationTest/target/HelloWorld-0.0.2.jar \
                    http://localhost:8081/repository/maven-releases3/com/example/HelloWorld/0.0.2/HelloWorld-0.0.2.jar
                    """
                }
            }
        }
    }
}