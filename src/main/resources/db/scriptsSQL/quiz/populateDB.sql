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

/*INSERT INTO questionvars (id, NAME, answerkit_id, questionkit_id, superQuestionVarId) VALUES
  (1, 'Как дела?', 6, 1, NULL),
  (2, 'Хороший сегодня день?', 2, 1, NULL),
  (3, 'Выберете лишнее?', 3, 1, NULL),
  (4, 'Как ваши дела в коллективе c...?', 5, 1, NULL),
  (5, 'Жить хорошо?', 2, 1, NULL),
  (6, 'А хорошо жить ещё лучше c...?', 5, 1, NULL),
  (7, 'Что вас мотивирует?', 1, 1, NULL),
  (8, 'Как вас зовут?', 4, 2, NULL),
  (9, 'Из какого вы города?', 4, 2, NULL),
  (10, 'Вы каждый день выпиваете?', 2, 2, NULL),
  (11, 'Хорошо или плохо каждый день вставать в 6 утра', 6, 2, NULL),
  (12, 'С кем бы вы пошли в разведку?', 7, 2, NULL),
  (13, 'В "Лошадь"?', 2, 2, NULL),
  (14, 'друзьями?', 6, 1, 4),
  (15, 'коллегами?', 6, 1, 4),
  (16, 'выберете животное', 3, 1, 6),
  (17, 'Согласны что вопрос нормальный?', 1, 2, 6),
  (18, 'Что вы сейчас чувствуете?', 4, 1, 6);*/

