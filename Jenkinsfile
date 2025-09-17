pipeline {
    agent any

    tools {
        maven 'mvn3'   // 👈 Nombre de la instalación de Maven en "Global Tool Configuration"
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
                // Aquí puedes poner comandos de despliegue reales, por ejemplo:
                // sh './deploy.sh'
            }
        }
    }
}
