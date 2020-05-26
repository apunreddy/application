pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'apunreddy/gradle:latest'
        }

      }
      steps {
        sh '''./gradlew clean build jib
'''
      }
    }

  }
}