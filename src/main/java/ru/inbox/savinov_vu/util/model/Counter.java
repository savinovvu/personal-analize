package ru.inbox.savinov_vu.util.model;

public class Counter {

    private static int questionNumber = 0;
    private static int questionnaireNumber = 0;
    private static int answercount = 0;

    public static int getQuestionNumber() {
        return ++questionNumber;
    }

    public static int getQuestionnaireNumber() {
        return ++questionnaireNumber;
    }

    public static int getAnswerNumber() {
        return ++answercount;
    }
}
