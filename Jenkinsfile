pipeline {
    agent {label 'maven'}
    

    stages {
            stage('Git pull ') {
                   steps {
                        git branch: 'khaled', credentialsId: 'GitAccessLogin', url: 'https://github.com/khaledabdelmoumen/tpachat.git'
                   }
            }
                  stage('Maven Clean ') {
                   steps {
                        sh 'mvn clean -Pprod'
                    }
            }  
                   
        stage('MOCKITO') {
            steps {
           sh 'mvn clean test -Ptest -Dtest=com.esprit.examen.services.ProduitServiceImplMocktest' 
            }
        }
         stage('JUNIT') {
            steps {
            sh 'mvn clean test -Ptest -Dtest=com.esprit.examen.services.ProduitServiceImplTest -Dmaven.test.failure.ignore=true'  
            }
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
