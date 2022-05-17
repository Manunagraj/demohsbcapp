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
      withMaven(maven: 'mvn') {
            sh "mvn clean package"
        }
    }
    
     
      stage("Docker build"){

        //sh 'docker version'
        sh 'docker build -t demohsbcapp .'
        sh 'docker image list'
        sh 'docker tag demohsbcapp weirdoo/demohsbcapp:v1'
    }
    stage("Docker Login"){
        withCredentials([string(credentialsId: 'DOCKER_PASSWORD', variable: 'PASSWORD')]) {
            sh 'docker login -u weirdoo -p $PASSWORD'
        }
    }
    stage("Pushing Image to Docker Hub"){
        sh 'docker push  weirdoo/demohsbcapp:v1'
    }
      
}

