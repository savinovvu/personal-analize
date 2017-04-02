# personal-analize
ENG

The purpose of this project is to create a service for counting and storing the results of testing staff, as well as
the study of back-end and front-end technologies.
To achieve this goal, the following tasks were identified and implemented:
1. Building a database for staff with the ability to organize staff in groups, and groups in departments.
2. Creating a methodology with flexible configuration and editing options for answers and questions, with the possibility of highlighting sub-questions, the possibility of re-use of existing groups of answers.
3. Answers with questions should be grouped in questionnaires, and questionnaires in survey.
4. The ability to conduct several tests with one technique without mixing the result.
5. Ability to save incompletely filled questionnaires with the calculation of answers
   as well as options without answers ("no answer").
6. Working with answers:

6.1 Automated text erase "no answer" when focusing on the window.
  
  
 
 6.2 Automating the addition of "no answer" text when leaving a window without text.
  
 
 
 6.3 Automated removal of the "no answer" flag CHECKBOX when selecting any other answer.
  
  
 
 6.4 Automatically removing other flags of the CHECKBOX question if the "no answer" flag is selected.
  
 
 
 6.5 Automatically adding the "no answer" flag to CHECKBOX if the other questions are not selected in the question.
  
 
 
 6.6 When the new test starts, the answers "no answer" are automatically placed.
  
7. Ability to edit the questionnaire after filling out.
8. Output of test results in pdf format.
9. Output of the entire database in pdf format, in the form prepared for insertion into the sql database (INSERT INTO).
10. Implementation of two independent groups of profiles to run the program:

10.1 The first group of profiles determines whether to save(infile) or not to save (inmemory,for the demo) the test results.
  
  
10.2 The second group of profiles determines whether to populate(populate) or not to populate(inizialize) the database from popularization scripts.

11. Implementation of scripts to run the program of all 4 configurations under Windows (*. Bat) and Linux (bash).

   To run the program will require a minimum of pre installed programs on the computer (JRE 8 and a modern browser), when you first switch on, you will also need the Internet.
        
  
  Technologies used:
  
  Back-end:
  
  Tomcat, Spring MVC, Spring context, Stream API, java 8 DateTime API, logback-classic, SLF4J-API, Lombook.

Work with the database: HSQLDB, Hibernate / Spring-data-JPA.
 
 PDF: Itext.
   
 
 WEB: webjars, jsp.
   
   
   Front-end:
   
  
  JS (ECMASCRIPT 6), html 5, CSS, Bootstrap 3, jQuery 3, DataTables 1.
    
   
   Build the project: gradle.
   
  
  To start Tomcat is used 'com.bmuschko.tomcat' plugin.

RUS

Целью данного проекта является создание сервиса для подсчета и хранения результатов тестирования персонала, а также 
изучение back-end и front-end технологий.
Для достижения данной цели были выделены и реализованы следующие задачи:
1. Построение базы данных для персонала с возможностью организации персонала в группы, а группы в подразделения.
2. Создание методики с гибкой возможностью конфигурирования и редактирования вариантов ответов и вопросов, с возможностью выделения подвопросов, возможностью переиспользования существующих групп ответов.
3. Ответы с вопросами должны быть сгруппированы в анкеты, а анкеты в тестирование(процесс). 
4. Возможность проводить несколько тестирований одной методикой без перемешивания результата.
5. Возможность сохранять не полностью заполненные анкеты с подсчетом ответов 
   а также вариантов без ответов ("нет ответа").
6. Работа с ответами:

6.1 Автоматизированное стирание текста "нет ответа" при фокусировки на окно.
  
  6.2 Автоматизирование добавление текста "нет ответа" при оставлении окна без текста.
  
  6.3 Автоматизированное снятия флага "нет ответа" CHECKBOX при выборе любого другого ответа.
  
  6.4 Автоматизированное снятия других флагов вопроса CHECKBOX, если выбран флаг  "нет ответа".
  
  6.5 Автоматизированное добавление флага "нет ответа" CHECKBOX, если у в вопросе не выбрано других ответов.
  
  6.6 При начале нового тестирования автоматически расставлены ответы "нет ответа".

7. Возможность редактировать анкету после заполнения.
8. Вывод результатов тестирования в формате pdf.
9. Вывод всей базы данных в формате pdf, в виде подготовленном для вставки в sql базу данных(INSERT INTO).
10. Реализация двух независимых групп профилей для запуска программы:

  10.1 Первая группа профилей определяет сохранять(infile) или не сохранять(inmemory,для демо) результаты тестирования.
  
  10.2 Вторая группа профилей определяет популиризовать(populate) или нет(initialize) базу данных из скриптов популяризации.

11. Реализация скриптов для запуска программы всех 4-х конфигураций под системами Windows(*.bat) и Linux(bash).

    Для запуска программы потребуется минимум предустановленных программ на компьютере (JRE 8 и современный браузер), при первом включении вам также понадобится Интернет.
    
    Использованные технологии:
    Серверная сторона: 
    Tomcat, Spring MVC, Spring context, Stream API, java 8 DateTime API, logback-classic,SLF4J-API,Lombook.
    Работа с базой данных: HSQLDB, Hibernate/Spring-data-JPA.
    PDF: Itext.
    WEB: webjars, jsp.
    
    Клиентская сторона:
    JS (ECMASCRIPT 6), html 5, CSS, Bootstrap 3, jQuery 3, DataTables 1.
    
    Сборка проекта: gradle.
    Для старта Tomcat используется 'com.bmuschko.tomcat' плагина.
