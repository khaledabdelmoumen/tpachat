pipeline {
    agent {label 'maven'}
    
/*environment {
        registry = "saharr/dockertpachat-pipeline"
        registryCredential = "dockerhub"
        dockerImage = ''
    }*/
    stages {
            stage('Git Checkout ') {
                  steps {
                  git branch: 'khaled', credentialsId: 'gitacceslogin', url: 'https://github.com/khaledabdelmoumen/tpachat.git'
           
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
            stage('MVN COMPILE')
                {
                    steps {
                         sh 'mvn compile -Ptest'
                         }
                 }
        stage('MVN SONARQUBE')
                 {
                 steps{
                          sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=21091520a -Ptest'
                      }
                 }
            stage('JUnit Test ') {
                   steps {
                        sh 'mvn test -Ptest'
                    }
            }
     
             stage('Mokito')
                {
                    steps {
                         sh 'mvn clean test -Dtest=com.esprit.examen.services.ProduitServiceImplMocktest -Ptest'
                         }
                 }
       
                 
            stage('Build Package ') {
                   steps {
                        sh 'mvn clean install'
                    }
            }
            stage('Build Image Docker') {
                   steps {
                      sh 'sudo docker build -t devimage .'
                    }
            }
              /*   stage('MVN deploy jar ')
              {
                steps
                {
                    sh 'mvn clean deploy '
                    }
                }*/
                /*
                     stage('docker deploy image ')
              {
                steps
                {
                    sh 'mvn clean deploy '
                    }
                }*/
                
                
              /*  stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }*/
        /*stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }*/
                
                
    }
}
