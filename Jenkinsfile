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
                     stage('JUnit Test ') {
                   steps {
                        sh 'mvn test -Ptest'
                    }
            }
            stage('MVN SONARQUBE')
                  {
                          steps{
                                 withSonarQubeEnv (installationName:'sonarqube'){
              sh """./mvnw sonar:sonar \
  -Dsonar.projectKey=sonarqube \
  -Dsonar.host.url=http://192.168.33.10:9000""" 
}
                                      
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
