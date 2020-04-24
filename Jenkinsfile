pipeline{
   agent any
tools{
     maven 'Maven'
   }
   environment {
    registry = "vkgarg/training"
    registryCredential = 'Docker'
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
                     stage('Building image') {
                           steps{
                              script {
                                   dockerImage= docker.build registry + ":$BUILD_NUMBER"
                                     }
                                }
                               }
                       stage('Push image to dockerhub') {
                           steps{
                                    bat "docker push vkgarg/training:%BUILD_NUMBER%"
                                    }
                               }
      
                  stage('Deploy to tomcat'){
                                 steps{
                                       bat "copy target\\MVC.war \"C:\\Users\\vinitgarg\\apache-tomcat-8.5.51\\webapps\""                                   
                                }
                                   }
                      stage('Deploy to localhost'){
                         steps{  
                                 bat "docker rm -f MVC"
                                 bat "docker run -d --name MVC -p 80:8080 vkgarg/training:%BUILD_NUMBER%"
                         }
                      }
      
      
}
}
