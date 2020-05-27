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
        sh '''docker login -u apunreddy -p A@sand0421 docker.io
./gradlew clean build jib
'''
      }
    }

  }
}