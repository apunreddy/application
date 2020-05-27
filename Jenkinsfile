pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'apunreddy/agent:latest'
          args '--env DOCKER_HOST=tcp://docker:2376'
        }

      }
      environment {
        registry = 'apunreddy/test:1'
        registryCredential = 'dockerhub'
      }
      steps {
        sh '''docker login -u apunreddy -p A@sand0421 docker.io
'''
      }
    }

  }
}