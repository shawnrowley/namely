# namemanager

====================
Author: Shawn A. Rowley  
Source: <https://github.com/shawnrowley/namemanager/>  
Application: http://jbosswildfly-shawnrowley.rhcloud.com/namemanager/

Overview
-----------

Create an app that allows you to manage names. Basic CRUD operation. Also include a report which will display all the names, how many times each name has been entered, and query this public API to also show the likely gender and confidence level.

Public API: https://gender-api.com/en/api-docs


Application User Guide
-----------

The application can be accessed at http://jbosswildfly-shawnrowley.rhcloud.com/namemanager/

To use the application simple enter a name (Only the first name is required) and click the Add button

The user will be added to the list. 

Continue to add person names including Duplicate names.

To view the report of names, instances, gender, Accuracy click the Report. 

To update a person information click the update link next to the person info in listing on the main/home page you'll be taken to a update page. Modify the information and click Update.

To delete a person click the delete link next to the person info.


Developer Notes
-----------

For a quick implementation and with limited development time, I decided to go with implementation that would satisfy the assignment but could be expanded upon with more time. 

The persistent store is configured for create-drop, persisting the data for the session. Done for development and demo purpose without dependency a physical database.

RESTful service implementation for flexibility, back-end implementation can be substituted without affecting the client. 

This implementation gave me the opportunity to use AngularJS, Openshift, WildFly and some new JavaEE 7 features. 

Began a golang implmentation of the backend today https://github.com/shawnrowley/namemanagergo. Quick and fairly easy to implement a server, REST Service, and MongoDB.

Added initial localization implementation country.

Technologies
-----------

JAX-RS
JPA
EJB
AngularJS
WildFly (Openshift)


Project/Server
-----------

Eclipse/JBossDevStudio
Server: JBoss/WildFly 


Deployment
-----------

Ant build to to be deployed on JBoss compatible server. Current deployed on WildFly Server

	ant clean
	ant build-war 
	
Enhancements/Ideas
-----------	

	Singleton bean to store/retreive credentials keys for GenderAPI
	Retrieval from GenderAPI to support batch (improve performance and limit request), IP address , and country codes.
	Country Code/IP Address Validation
	Alter back-end implementation (Go, Node.js, etc..) DONE!




	

	
	
	

	
