DELETE FROM answers;
DELETE FROM questions;
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

INSERT INTO questions (id, number, NAME, questionVarId, survey_id, superQuestionVarId) VALUES
  (1, 1, 'Как дела?', 1, 1, NULL),
  (2, 2, 'Хороший сегодня день?', 2, 1, NULL),
  (3, 3, 'Выберете лишнее?', 3, 1, NULL),
  (4, 4, 'Как ваши дела в коллективе c...?', 4, 1, NULL),
  (5, 5, 'Жить хорошо?', 5, 1, NULL),
  (6, 6, 'А хорошо жить ещё лучше c...?', 6, 1, NULL),
  (7, 7, 'Что вас мотивирует?', 7, 1, NULL),
  (8, 1, 'Как вас зовут?', 8, 2, NULL),
  (9, 2, 'Из какого вы города?', 9, 2, NULL),
  (10, 3, 'Вы каждый день выпиваете?', 10, 2, NULL),
  (11, 4, 'Хорошо или плохо каждый день вставать в 6 утра', 11, 2, NULL),
  (12, 5, 'С кем бы вы пошли в разведку?', 12, 2, NULL),
  (13, 6, 'В "Лошадь"?', 13, 2, NULL),
  (14, 1, 'друзьями?', 14, 1, 4),
  (15, 2, 'коллегами?', 15, 1, 4),
  (16, 1, 'выберете животное', 16, 1, 6),
  (17, 2, 'Согласны что вопрос нормальный?', 17, 2, 6),
  (18, 3, 'Что вы сейчас чувствуете?', 18, 1, 6);



INSERT INTO answers (id, name, questionnaire_id, question_id) VALUES
  (1, 'хорошо', 1, 1),
  (2, 'прекрасный', 1, 2),
  (3, 'Лишняя коза', 2, 3),
  (4, 'дела мои хорошо с коллегами', 2, 14),
  (5, 'А хорошо жить ещё лучше!', 3, 5),
  (6, 'С тортиком', 3, 6),
  (7, 'интересная работа и достойная зарплата', 3, 7),
  (8, 'Иван', 3, 8),
  (9, 'А хорошо жить ещё лучше!', 4, 5),
  (10, 'С тортиком', 4, 6),
  (11, 'интересная работа и достойная зарплата', 4, 7),
  (12, 'Иван', 4, 8);


