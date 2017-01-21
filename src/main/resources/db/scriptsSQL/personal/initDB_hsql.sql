

DROP TABLE persons
IF EXISTS;

DROP TABLE groups
IF EXISTS;

DROP TABLE department
IF EXISTS;



DROP SEQUENCE GLOBAL_SEQ
IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ
  AS INTEGER START WITH 1;


CREATE TABLE department
(
  id      INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ  PRIMARY KEY,
  name  VARCHAR(255)

);



CREATE TABLE groups
(
  id      INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ  PRIMARY KEY,
  name  VARCHAR(255),
  department_id      INTEGER,
  FOREIGN KEY (department_id) REFERENCES department (id)
    ON DELETE CASCADE
);




CREATE TABLE persons
(
    id      INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ  PRIMARY KEY,
  name  VARCHAR(255),
  group_id      INTEGER,
  FOREIGN KEY (group_id) REFERENCES groups (id)
    ON DELETE CASCADE
);






