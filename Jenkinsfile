pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'apunreddy/agent:latest'
        }

      }
      steps {
        sh '''./gradlew build jib
kubectl get pods --all-namespaces'''
      }
    }

  }
}