pipeline {
  agent {
    docker {
      image 'apunreddy/gradle:latest'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x gradlew
./gradlew clean build jib
'''
      }
    }

  }
}