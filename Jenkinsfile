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
 

     stage('Maven Build') {
      
        echo 'Build jar file'
        sh 'mvn spring-boot:run'
      
    }
}

