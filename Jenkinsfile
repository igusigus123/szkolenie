pipeline {
    agent any
    stages {
        stage('checkout') { 
            steps {
               git 'https://github.com/igusigus123/szkolenie.git'
            }
        }
        stage('run') { 
            steps {
                sh "mvn clean test" 
            }
        }
    }
}