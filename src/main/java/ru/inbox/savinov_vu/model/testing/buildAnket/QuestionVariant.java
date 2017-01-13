package ru.inbox.savinov_vu.model.testing.buildAnket;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionVariant {

    private Map<String, AnswerSource> questions;

    private QuestionVariant()  {
        List<String> fileStrings = null;
        try {
            fileStrings = Files.readAllLines(Paths.get("settings/questions"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        questions = new HashMap<>();
        for (int i = 0; i < fileStrings.size(); i=i+2){
            questions.put(fileStrings.get(i), AnswerSource.valueOf(fileStrings.get(i+1).toUpperCase()));
        }
    }

    public static QuestionVariant  getInstance(){
        return new QuestionVariant();
    }



    public Map<String, AnswerSource> getQuestions() {
        return questions;
    }
}
