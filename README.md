Table of contents 


A - Introduction

B - Project Structure

C - Module Description

D - Technology Stack

E - How To Build

F - Local Setup

G - Version Control

H - Code quality


-  Description in brief

A	-	Introduction

		This is the project for simple practice challenge.
		It is a single module project which uses maven for build and Java as language.
		It also utilize the Spring framework for implementation.

B	-	Project Structure 

		1	-	Main Module
		        With two packages as java and test

C	-	Module Description

		1 - Main Module
			This project have two packages, java which contains all the code changes.
			test package contains test classes for JUnit.
	
D	-	Technology Stack 

		1 - Java 1.8
		2 - Spring framework - 3.1.2
		5 - Mockito 1.9.5
		6 - powerMock 1.6.1
		7 - log4j 2.0.2

E	-	How to Build 

		As the project is maven project 
		- it can be build using tool like Eclipse / IntelliJ
		- it can also be build from command prompt using below command
				clean --> mvn clean
				install --> mvn install
				To build the module in one go 
                you simply run build on parent project.      
                

F	-	Local Setup
              
        Pre-requisite:
        
            - Any IDE- IntelliJ/Eclipse etc.
            - Java 8
            - Maven 3.x.x
                		
        Code Base Setup:
        
            - Clone repository: https://github.com/rohitpatidar313/veyor-pratice.git
            - Run maven clean install.
            - Run application. 

                
G	-	Version Control
              
        for version control and repository management Git is used
                		
        Git URL for this application is: 
        
H	-	Code quality

		For code quality management Sonar is used.
		
		Sonar is used to measure 
		1 - number of code Bugs
		2 - Vulnerability
		3 - Code Smell
		4 - Code coverage
		5 - Duplicate code
        
