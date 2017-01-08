DELETE FROM department;
DELETE FROM groups;
DELETE FROM persons;


INSERT INTO department (name) VALUES
  ('department1'),
  ('department2'),
  ('Департамент3');



INSERT INTO groups (name, department_id) VALUES
  ('otdel1',1),
  ('otdel2',2),
  ('Отдел3',3),
  ('Отдел4',3);


INSERT INTO persons (name, group_id) VALUES
  ('name1', 4),
  ('name2', 5),
  ('name3', 5),
  ('name4', 6),
  ('Имя4', 7),
  ('name4', 7);






