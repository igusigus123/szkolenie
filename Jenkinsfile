pipeline {
    agent any

     triggers {
                cron('0 0 * * 0')
                githubPush()
            }

    parameters {
     choice(name: 'ENVIRONMENT', choices: ['dev', 'test', 'stage', 'sandbox'], description: 'Choose environment')
     choice(name: 'TAG', choices: ['junit', 'paramTest', 'string', 'wordpress','word', 'frontend', 'login'], description: 'Choose tag')
     choice(name: 'EXTAG', choices: ['', 'junit', 'paramTest', 'string', 'wordpress','word'], description: 'Choose tag')
     choice(name: 'BROWSER', choices: ['chrome','firefox', 'edge'], description: 'Choose browser type.')
     choice(name: 'MACHINE', choices: ['remote','local'], description: 'Choose machine type.')
     string(name: 'REMOTE_URL', defaultValue: 'http://172.20.192.1:4444/wd/hub', description: 'Remote selenium grid url.')
    }
    stages {
        stage('checkout') { 
            steps {
               git 'https://github.com/igusigus123/szkolenie.git'
            }
        }
        stage('run') { 
            steps {
                sh "mvn clean test -Dgroups=${params.TAG} -DexcludedGroups=${params.EXTAG} -DENVIRONMENT=${params.ENVIRONMENT} -DBROWSER=${params.BROWSER} -DMACHINE=${params.MACHINE} -DREMOTE_URL=${params.REMOTE_URL}"
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
                              results: [[path: 'szkolenieJunit/target/allure-results'], [path: 'szkolenieGui/target/allure-results']]
                              ])
                      }
             }
}