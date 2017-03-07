DELETE FROM answers;
DELETE FROM questionnaires;
DELETE FROM surveys;


INSERT INTO surveys (id, comment, createDate, questionkit_id, department_id, group_id) VALUES
  (1, 'Самый большой в мире комментарий призванный обрадовать любителя читать самые большие в мире комментарии',
   '2011-01-11', 1, NULL, NULL),
  (2, 'комментарий2', '2012-02-12', 2, 2, 2);


INSERT INTO questionnaires (id, number, createDate, survey_id) VALUES
  (1, '1', '2011-01-11', 1),
  (2, '2', '2012-02-12', 1),
  (3, '1', '2013-03-13', 2),
  (4, '2', '2014-04-14', 2);


INSERT INTO answers (id, name, questionnaire_id, questionvar_id) VALUES
  (1, 'хорошо', 1, 1),
  (2, 'прекрасный', 1, 2),
  (3, 'так себе', 2, 3),
  (4, 'холодновато', 2, 4),
  (5, 'Иван Федорович Крузенштерн', 3, 5),
  (6, 'Из Бангладеша', 3, 6),
  (7, 'Миклухо Маклай', 4, 7),
  (8, 'Из Тамбова', 4, 8);



