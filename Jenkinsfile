pipeline {
    agent any
    environment {
        GRADLE_USER_HOME = "${WORKSPACE}/.gradle"
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    echo '📥 Checking out the repository...'
                    checkout scm
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    echo '🔨 Building the application...'
                    sh './gradlew clean assemble'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    echo '🧪 Running tests...'
                    sh './gradlew test'
                }
            }
        }
        stage('Test Report') {
            steps {
                script {
                    echo '📊 Generating test reports...'
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
    }
    post {
        success {
            echo '✅ Build and tests passed successfully!'
        }
        failure {
            echo '❌ Build or tests failed! Check logs for details.'
            script {
                sh 'exit 1' // Force failure in case of silent errors
            }
        }
    }
}
