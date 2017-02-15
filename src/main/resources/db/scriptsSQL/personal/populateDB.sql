DELETE FROM department;
DELETE FROM groups;
DELETE FROM persons;


INSERT INTO department (id, name) VALUES
  (1,'department1'),
  (2,'department2'),
  (3,'Департамент3');



INSERT INTO groups (id, name, department_id) VALUES
  (1,'otdel1',1),
  (2,'otdel2',2),
  (3,'Отдел3',3),
  (4,'Отдел4',3);


INSERT INTO persons (id, name, group_id) VALUES
  (1,'name1', 1),
  (2,'name2', 2),
  (3,'name3', 2),
  (4,'name4', 3),
  (5,'Имя4', 4),
  (6,'name4', 4);






