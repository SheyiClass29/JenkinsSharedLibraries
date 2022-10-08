def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn deploy"
     }
  else if ("${stageName}" == "Deploy To UAT")
  {
    sh "echo 'deploy to UAT'  "
   deploy adapters: [tomcat9(credentialsId: 'Tomcat-cred', path: '', url: 'http://34.229.84.67:8080/')], contextPath: null, war: 'target/*war'
  }
}

