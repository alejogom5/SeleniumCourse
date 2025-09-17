pipeline {
    agent any

    environment {
        // Asegura que Jenkins vea los binarios de Chrome y Chromedriver
        PATH = "/usr/local/bin:/opt/homebrew/bin:$PATH"
    }

    tools {
        maven 'mvn3'
    }

    stages {
        stage('Check Chrome') {
            steps {
                echo '🔍 Verificando instalación de Chrome y Chromedriver...'
                sh 'which chromedriver || echo "❌ chromedriver not found"'
                sh 'chromedriver --version || echo "❌ chromedriver not working"'
                sh '/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome --version || echo "❌ chrome not found"'
            }
        }

        stage('Build') {
            steps {
                echo '⚙️ Compilando proyecto...'
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Ejecutando pruebas con Selenium...'
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Desplegando la aplicación…'
            }
        }
    }

    post {
        always {
            echo '✅ Pipeline finalizado (con o sin errores).'
        }
        failure {
            echo '❌ El pipeline falló. Revisa los logs arriba.'
        }
    }
}
