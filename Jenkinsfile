#!/usr/bin/env groovy

node('maven') {

    // default Java version
    sh "java -version"


stage('Checkout') {
        echo "${PULL_REQUEST_FROM_HASH}"
        echo "${PULL_REQUEST_TO_BRANCH}"
        try {
            step([$class: 'WsCleanup'])
            checkout scm
            [$class: 'GitSCM', branches: [[name: "$PULL_REQUEST_FROM_HASH"]], doGenerateSubmoduleConfigurations: false, extensions:
                    [[
                             $class: 'PreBuildMerge', options: [fastForwardMode: 'FF', mergeRemote: 'origin', mergeStrategy: 'default', mergeTarget: "$PULL_REQUEST_TO_BRANCH"]
                     ]],
             submoduleCfg: [], userRemoteConfigs:[[credentialsId: 'JenkinsAdmin', url: "https://github.com/Manunagraj/demohsbcapp.git"]]
            ]
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

        echo "Building branch $demohsbcapp"

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

