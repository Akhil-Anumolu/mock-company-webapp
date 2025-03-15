pipeline {
    agent any
    tools {
        gradle 'Gradle-8.13'  // Auto-installs Gradle
    }
    environment {
        GRADLE_USER_HOME = "${WORKSPACE}/.gradle"
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh './gradlew assemble'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
                }
            }
        }
    }
    post {
        success {
            echo '✅ Build and tests passed successfully!'
        }
        failure {
            echo '❌ Build or tests failed!'
        }
    }
}
