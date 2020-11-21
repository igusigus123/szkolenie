pipeline {
    agent any
    parameters {
     choice(name: 'TAG', choices: ['junit', 'paramTest', 'string', 'wordpress','word'], description: 'Choose tag')
     choice(name: 'EXTAG', choices: ['junit', 'paramTest', 'string', 'wordpress','word'], description: 'Choose tag')
    }
    stages {
        stage('checkout') { 
            steps {
               git 'https://github.com/igusigus123/szkolenie.git'
            }
        }
        stage('run') { 
            steps {
                sh "mvn clean test -Dgroups=${params.TAG} -DexcludedGroups=${params.EXTAG}"
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