CREATE TABLE tasks (
t_id INT NOT NULL AUTO_INCREMENT ,
t_kategory VARCHAR(45) NULL ,
t_description VARCHAR(45) NULL ,
t_estimatedHours DATE NULL ,
it_id INT NOT NULL  ,
PRIMARY KEY (t_id) );