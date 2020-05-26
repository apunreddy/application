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
mkdir /.docker
docker login -u apunreddy -p A@sand0421 docker.io
./gradlew clean build jib
'''
      }
    }

  }
}