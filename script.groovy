def buildApp() {
    echo 'building the application...'
}

def testApp() {
    echo 'building the application...'
}

// def deployApp() {
//     echo 'deploying the application...'
//     echo "deploying version ${params.VERSION}"
// }

def deployApp() {
    echo "Building Jar File"
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PWD', usernameVariable: 'USERNAME')]) {
        
        sh 'docker build -t donfortune1/my-repo:bukky-90.1 .'
        sh "docker login -u $USERNAME -p $PWD"
        sh 'docker push donfortune1/my-repo:bukky-90.1'
    }
}
