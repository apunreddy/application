pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'apunreddy/agent:latest'
        }

      }
      environment {
        registry = 'apunreddy/test:1'
        registryCredential = 'dockerhub'
      }
      steps {
        sh '''./gradlew clean build jib
'''
      }
    }

  }
}