Management Project

# Synopsis
------------------------
Management project is visual management software which boosts your productivity by applying lean principles to your work. We help you design your workflow, and track important metrics out of the box.

# Requirements
 - [MySQL] (http://www.mysql.com/ "MySQL") or [H2](http://www.h2database.com/html/main.html/ "H2")
 - [Maven](http://maven.apache.org/ "Maven")
 
# Build

|	mvn clean package

	
# Running the Application


| mvn tomcat:run (in module branch(web-interface))

## Configuration
 Configure database connection properties in `config.properties`
 
## Comments
The development of own mvc framevork is conducted in module branch
