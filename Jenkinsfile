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

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube static analysis...'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw -B -DskipTests clean package'
            }
        }

        stage('Test & Code Coverage') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw -B test jacoco:report'
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
                echo 'Launching app in Dev...'
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
