pipeline{
	agent any
	
	stages{
		stage ('Compile Stage'){
			
			steps {
				withMaven(maven : 'maven_3_5_0') {
					sh 'mvn clean compile'
					
					}
				}
		}
		
		stages{
		stage ('Build Stage'){
			
			steps {
				withMaven(maven : 'maven_3_5_0') {
					sh 'mvn test'
					
					}
				}
		}
		
		stages{
		stage ('Build Stage'){
			
			steps {
				withMaven(maven : 'maven_3_5_0') {
					sh 'mvn deploy'
					
					}
				}
		}
