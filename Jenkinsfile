pipeline {
  agent {
    docker {
      image 'apunreddy/gradle:latest'
      args '-p 3000:3000'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh '''chmod +x gradlew
./gradlew clean build
'''
      }
    }

  }
}