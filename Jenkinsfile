pipeline {
    agent {
        docker {
            image 'registry.cn-hangzhou.aliyuncs.com/acs/maven' 
            args '-v /home/.m2:/root/.m2' 
            reuseNode true
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Deliver') {
            steps {
				checkout scm
				 def testImage = docker.build("mhggpo/hotelmanagement", "./src/main/docker/Dockerfile")
				 testImage.push()
            }
        }
    }
}