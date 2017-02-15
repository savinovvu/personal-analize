DELETE FROM answerkits;
DELETE FROM questionkits;
DELETE FROM answervars;
DELETE FROM questionvars;
DELETE FROM questionsubs;


INSERT INTO answerkits (id, name, answerType) VALUES
  (1, 'факторы', 'CHECKBOX'),
  (2, 'да/нет', 'RADIO'),
  (3, 'лишнее животное', 'SELECT'),
  (4, 'набор ответов3', 'FREE'),
  (5, 'пустой набор', 'EMPTY'),
  (6, 'хорошо, плохо', 'RADIO');

INSERT INTO questionkits (id, name) VALUES
  (1, 'набор вопросов1'),
  (2, 'набор вопросов2');


INSERT INTO answervars (id,name, answerkit_id) VALUES
  (1,'Зарплата', 1),
  (2,'Почет', 1),
  (3,'Коллектив', 1),
  (4,'Да', 2),
  (5,'Нет', 2),
  (6,'Затрудняюсь', 2),
  (7,'Волк', 3),
  (8,'Корова', 3),
  (9,'Тигр', 3),
  (10,'Носорог', 3),
  (11,'Бегемот', 3);



  INSERT INTO questionvars (id, NAME, answerkit_id, questionkit_id) VALUES
(1,'1.Как дела?', 6, 1),
(2,'2. Хороший сегодня день?', 2, 1),
(3,'3.Уберите лишнее?', 3, 1),
(4,'4.Как ваши дела в коллективе c...?', 5, 1),
(5,'1. Как вас зовут?', 4, 2),
(6,'2. Из какого вы города?', 4, 2),
(7,'3. Вы каждый день выпиваете?', 2, 2),
(8,'4. Хорошо или плохо каждый день вставать в 6 утра', 6 , 2);

INSERT INTO questionsubs (id, NAME, answerkit_id, questionvar_id) VALUES
  (1,'4.1. друзьями', 6, 4),
  (2,'4.1. коллегами', 6, 4);
