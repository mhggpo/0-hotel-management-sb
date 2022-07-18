pipeline {
	agent none
	environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub-mhggpo')
	}
    stages {
        stage('Build') { 
			agent {
				docker {
					image 'registry.cn-hangzhou.aliyuncs.com/acs/maven' 
					args '-v /home/.m2:/root/.m2' 
				}
			}
            steps {
                sh 'mvn -B -DskipTests clean package docker:build' 
            }
        }
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
}