pipeline {
    agent {
        docker {
			image 'docker:dind' 
			args '--privileged -v /var/run/docker.sock:/var/run/docker.sock' 
		}
    }
	environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub-mhggpo')
	}
    stages {
        stage('Login') {
			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}
        stage('Push') {
			steps {
				sh 'docker push mhggpo/hotelmanagement:latest'
			}
		}
    }
	post {
		always {
			sh '/usr/local/bin/docker logout'
		}
	}
}