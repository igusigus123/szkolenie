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
     post {
                 always {
                     allure([
                              includeProperties: false,
                              jdk: '',
                              properties: [[key: 'allure.issues.tracker.pattern', value: 'http://tracker.company.com/%s'],
                              [key: 'allure.tests.management.pattern', value: 'http://tms.company.com/%s'],
                              ],
                              reportBuildPolicy: 'ALWAYS',
                              results: [[path: 'szkolenieJunit/target/allure-results']]
                              ])
                      }
             }
}