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
docker login -u apunreddy -p A@sand0421 docker.io
./gradlew clean build jib
'''
      }
    }

  }
}