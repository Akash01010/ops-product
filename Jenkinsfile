pipeline {
    agent any
    stages {
        stage('Git-checkout') {
            steps {
                    git credentialsId: '050b94e9-858c-4430-bb20-daac620a72d3', url: 'https://github.com/Akash01010/ops-product.git'
            }
        }
        stage('Build') {
            steps {
                bat label: '', script: 'mvn clean install'
            }
        }
        stage('test') {
            steps {
                echo "Successfully ran test cases"
            }
        }
    }
}
