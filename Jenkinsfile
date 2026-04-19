pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh '.\\mvnw.cmd -B -DskipTests clean package'
            }
        }

        stage('Test & Code Coverage') {
            steps {
                sh '.\\mvnw.cmd -B test jacoco:report'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deliver') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy to Dev') {
            steps {
                echo 'Deploying to Dev...'
            }
        }

        stage('Deploy to QAT') {
            steps {
                echo 'Deploying to QAT...'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to Staging...'
            }
        }

        stage('Deploy to Production') {
            steps {
                echo 'Deploying to Production...'
            }
        }
    }
}
