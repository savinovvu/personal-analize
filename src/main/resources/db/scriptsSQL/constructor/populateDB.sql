DELETE FROM answerkits;
DELETE FROM questionkits;
DELETE FROM answervars;
DELETE FROM questionvars;


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


INSERT INTO answervars (name, answerkit_id) VALUES
  ('Зарплата', 1),
  ('Почет', 1),
  ('Коллектив', 1),
  ('Да', 2),
  ('Нет', 2),
  ('Затрудняюсь', 2),
  ('Волк', 3),
  ('Корова', 3),
  ('Тигр', 3),
  ('Носорог', 3),
  ('Бегемот', 3);



  INSERT INTO questionvars ( NAME, answerkit_id, questionkit_id) VALUES
('1.Как дела?', 6, 1),
('2. Хороший сегодня день?', 2, 1),
('3.Уберите лишнее?', 3, 1),
('4.Как ваши дела в коллективе c...?', 5, 1),
('4.1. друзьями', 6, 1),
('4.1. коллегами', 6, 1),

('1. Как вас зовут?', 4, 2),
('2. Из какого вы города?', 4, 2),
('3. Вы каждый день выпиваете?', 2, 2),
('4. Хорошо или плохо каждый день вставать в 6 утра', 6 , 2);