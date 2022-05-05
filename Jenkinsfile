#!/usr/bin/env groovy

node('maven') {

    // default Java version
    sh "java -version"

    // enable Java 11
    sh "alternatives --set java \$(alternatives --display java | grep java-11 | awk '/family.*x86_64/ { print \$1; }')"
    sh "alternatives --set javac \$(alternatives --display javac | grep java-11 | awk '/family.*x86_64/ { print \$1; }')"
    sh "java --version"


 

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

