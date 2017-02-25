CREATE SEQUENCE SURVEY_SEQ
  AS INTEGER START WITH 1000;


CREATE TABLE surveys
(
  id      INTEGER GENERATED BY DEFAULT AS SEQUENCE SURVEY_SEQ  PRIMARY KEY,
  comment  VARCHAR(1000),
  createDate Date NOT NULL ,
   questionkit_id INTEGER,

  FOREIGN KEY (questionkit_id) REFERENCES questionkits (id)
    ON DELETE CASCADE
);


CREATE TABLE questionnaires
(
  id      INTEGER GENERATED BY DEFAULT AS SEQUENCE SURVEY_SEQ  PRIMARY KEY,
  number INTEGER,
  createDate Date NOT NULL ,
  survey_id INTEGER,

  FOREIGN KEY (survey_id) REFERENCES surveys (id)
    ON DELETE CASCADE
);

CREATE TABLE questions
(
  id      INTEGER GENERATED BY DEFAULT AS SEQUENCE SURVEY_SEQ  PRIMARY KEY,
  name VARCHAR(255),
  questionnaire_id INTEGER,

  FOREIGN KEY (questionnaire_id) REFERENCES questionnaires (id)
    ON DELETE CASCADE
);

CREATE TABLE answers
(
  id      INTEGER GENERATED BY DEFAULT AS SEQUENCE SURVEY_SEQ  PRIMARY KEY,
  name VARCHAR(255),
  question_id INTEGER,

  FOREIGN KEY (question_id) REFERENCES questions (id)
    ON DELETE CASCADE
);