pipeline {
    agent any
    tools {
            maven 'Maven 3.6.3'
            jdk 'jdk17'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}