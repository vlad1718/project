 CREATE TABLE projects (
   idProject int(11) NOT NULL AUTO_INCREMENT,
   projectName varchar(45) NOT NULL,
   startDate date DEFAULT NULL,
   completeDate date DEFAULT NULL,
   PRIMARY KEY (idProject)
 )