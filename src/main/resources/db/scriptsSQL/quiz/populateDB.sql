DELETE FROM answers;
DELETE FROM questions;
DELETE FROM questionnaires;
DELETE FROM surveys;


INSERT INTO surveys (id, comment, createDate, questionkit_id) VALUES
  (1, 'комментарий1', '2011-01-11', 1),
  (2, 'комментарий2', '2012-02-12', 2);


INSERT INTO questionnaires (id, number, createDate, survey_id) VALUES
  (1, '1', '2011-01-11', 1),
  (2, '2', '2012-02-12', 1),
  (3, '1', '2013-03-13', 2),
  (4, '2', '2014-04-14', 2);


INSERT INTO questions (id, name, questionnaire_id) VALUES
  (1, 'Как дела?',  1),
  (2, 'Хороший сегодня день?', 1),
  (3, 'Как дела?',  2),
  (4, 'Хороший сегодня день?', 2),
  (5, 'Как вас зовут?', 3),
  (6, 'Из какого вы города?', 3),
  (7, 'Как вас зовут?', 4),
  (8, 'Из какого вы города?', 4);

INSERT INTO answers (id, name, question_id) VALUES
  (1, 'хорошо',  1),
  (2, 'прекрасный', 2),
  (3, 'так себе',  3),
  (4, 'холодновато', 4),
  (5, 'Иван Федорович Крузенштерн', 5),
  (6, 'Из Бангладеша', 6),
  (7, 'Миклухо Маклай', 7),
  (8, 'Из Тамбова', 8);



