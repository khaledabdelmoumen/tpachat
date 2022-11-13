pipeline {
  agent any
  stages {
stage('Pulling GIT') {
  steps {
        echo 'pulling...';
          git branch: 'main',
          url : 'https://github.com/khaledabdelmoumen/tpachat.git',
          credentialsId: 'github';
     } 
   }
}
   
}
