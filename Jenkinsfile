pipeline {
    agent any
    tools {
        gradle 'Gradle-8.13'  // Ensure it's properly configured in Jenkins
    }
    environment {
        GRADLE_USER_HOME = "${WORKSPACE}/.gradle"
    }
    stages {
        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh './gradlew assemble'
                    } else {
                        bat 'gradlew.bat assemble'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh './gradlew test'
                    } else {
                        bat 'gradlew.bat test'
                    }
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
