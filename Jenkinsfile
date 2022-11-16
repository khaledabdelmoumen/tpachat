pipeline {
    agent {label 'maven'}
    

    stages {
            stage('Git Checkout ') {
                  steps {
                      sh 'rm -fr tpachat'
                        git branch: 'khaled', credentialsId: 'GitAccessLogin', url: 'https://github.com/khaledabdelmoumen/tpachat.git'
                  }
            }
                     stage('run application ') {
                   steps {
                   
                      sh ' sudo docker compose up -d '
                    }
            }
                  stage('Maven Clean ') {
                   steps {
                        sh 'mvn clean '
                    }
            }
            stage('JUnit Test ') {
                   steps {
                        sh 'mvn test -Ptest'
                    }
            }
             stage('MVN COMPILE')
                {
                    steps {
                         sh 'mvn compile -Ptest'
                         }
                 }
            /*stage('MVN deploy')
              {
                steps
                {
                    sh 'mvn clean deploy '
                    }
                }*/
                   stage('MVN SONARQUBE')
                {
                steps{
                         sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=root -Ptest'
                     }
                }
            stage('Build Package ') {
                   steps {
                        sh 'mvn clean install -'
                    }
            }
            stage('Build Image Docker') {
                   steps {
                      sh 'sudo docker build -t devimage .'
                    }
            }
    }
}
