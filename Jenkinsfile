pipeline{
   agent any
tools{
     maven 'Maven'
   }
   

 
   stages {

              stage("Code Checkout") {
                                steps {
                                       git url: 'https://github.com/vinitgarg/Project.git'
                                      }
                                     }
              stage('Build Stage') {
                               steps{
                                        bat 'mvn package'
                                     }
                                    }
             
             stage(' SonarQube analysis')
                                         {
                              steps {
                                    withSonarQubeEnv('Sonarqube') {
                                         bat 'mvn sonar:sonar -Dsonar.projectKey=Training -Dsonar.host.url=http://localhost:9000 -Dsonar.login=9e7e67d09d7459d89034ffecffca99209f7f38a9'
                                           }
                                      }
                                   }
               
                          stage('Deploy to artifactory'){
                                steps{
                                       bat 'mvn deploy'
                                      }
                                     }
}
}
