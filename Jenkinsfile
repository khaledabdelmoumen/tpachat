pipeline {
    agent {label 'maven'}
    

    stages {
            stage('Git pull ') {
                   steps {
                        git branch: 'main', credentialsId: 'GitAccessLogin', url: 'https://github.com/khaledabdelmoumen/tpachat.git'
                   }
            }
                  stage('Maven Clean ') {
                   steps {
                        sh 'mvn clean -Pprod'
                    }
            }  
            stage('MVN SONARQUBE')
        {
        steps{
        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=21091520a'
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
                         sh 'mvn compile'
                         }
                 }
            stage('Build Package ') {
                   steps {
                        sh 'mvn clean install -Pprod'
                    }
            }
            stage('Build Image Docker') {
                   steps {
                      sh 'sudo docker build -t devimage .'
                    }
            }
    }
}
