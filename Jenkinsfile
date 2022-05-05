#!/usr/bin/env groovy

node('maven') {

    // default Java version
    sh "java -version"


stage('Checkout') {
    
        try {
             checkout([$class: 'GitSCM', branches: [[name: '*/feature/jenkins']],
             userRemoteConfigs: [[url: 'https://github.com/Manunagraj/demohsbcapp.git']]])
        } catch (Exception error) {
            notifyStash("FAILED")
            throw error
        }
    }
 

    stage('Build') {
        def v = version()
        def commitAuthor = commitAuthor()
        def commitMessage = commitMessage()

        if (v) {
            echo "Building version ${v}"
        }

        echo "Building branch $feature/jenkins"

        try {
                sh """
                mvn -B -s clean package
                """
                notifyStash("SUCCESS")
        } catch (Exception error) {
            notifyStash("FAILED")
            throw error
        }
    }
}

