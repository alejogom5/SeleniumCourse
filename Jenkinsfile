pipeline {
    agent any
    tools {
        maven 'mvn3'   // el nombre exacto que configuraste en Jenkins
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Desplegando la aplicación…'
            }
        }
    }
}
