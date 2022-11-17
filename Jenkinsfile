pipeline {
    agent {label 'maven'}
    

    stages {
            stage('Git Checkout ') {
                  steps {
                      sh 'rm -fr tpachat'
                        git branch: 'khaled', credentialsId: 'gitacceslogin', url: 'https://github.com/khaledabdelmoumen/tpachat.git'
                  }
            }
                     stage('run application ') {
                   steps {
                        sh 'pwd'
                      sh ' sudo docker compose up -d '
                    }
            }
                  stage('Maven Clean ') {
                   steps {
                        sh 'mvn clean install -Pprod'
                    }
            }
        stage('MOK Test ') {
                   steps {
                        sh 'mvn clean test -Dtest=com.esprit.examen.services.ProduitServiceImplMocktest -Ptest'
                    }
            }
        /*stage('MVN SONARQUBE')
                {
              steps{
                         sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=21091520a'
                     }
                }*/
             stage('MVN COMPILE')
                {
                    steps {
                         sh 'mvn compile -Ptest'
                         }
                 }
       
            stage('Build Package ') {
                   steps {
                        sh 'mvn clean install -Ptest'
                    }
            }
            stage('Build Image Docker') {
                   steps {
                      sh 'sudo docker build -t devimage .'
                    }
            }
       /* stage('MVN deploy')
              {
                steps
                {
                    sh 'mvn clean deploy -Pprod'
                    }
                }
         */
    
       /*    stage('MVN SONARQUBE')
                {
              steps{
                         sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=21091520a -Ptest'
                     }
                }*/
           /* stage('JUnit Test ') {
                   steps {
                        sh 'mvn clean test -Dtest=com.esprit.examen.services.ProduitServiceImplMocktest -Ptest'
                    }
            }*/
}
}
