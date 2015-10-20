CREATE TABLE iterations (
  it_id INT NOT NULL ,
  it_name VARCHAR(45) NOT NULL ,
  it_description VARCHAR(45) NULL ,
  it_startDate DATE NULL  ,
  it_endDate DATE NULL,
  it_status VARCHAR(45) NULL ,
  PRIMARY KEY (it_id)  );