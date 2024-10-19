pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // Checkout the code from your repository
                checkout scm
            }
        }
        stage('Load and Run Groovy Script') {
            steps {
                script {
                    // Define the Groovy code as a string
                    def myScript = """
                        import jenkins.model.Jenkins

                        // Specify the package you want to search for
                        def packageName = "jenkins" // The jenkins package
                        
                        // Get all loaded classes in the Jenkins class loader
                        def classes = Jenkins.class.classLoader.getLoadedClasses().findAll { 
                            it.package.name == packageName 
                        }
                        
                        // Return the names of the classes as a list
                        return classes.collect { it.name }
                    """
                    
                    // Evaluate the Groovy script and store the result
                    def classNames = evaluate(myScript)
                    
                    // Print the class names
                    echo "Loaded classes in the 'jenkins' package: ${classNames.join(', ')}"
                }
            }
        }
    }
}
