package ru.inbox.savinov_vu.model.constructor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AnswerVariant {

    private  List<String> answer;


    private AnswerVariant(){
        answer = StaticInstance.answer;
   }

   public static AnswerVariant getInstance(){
       return new AnswerVariant();
   }

    public List<String> getAnswer() {
        return answer;
    }

    private static class StaticInstance {

        private static List<String> answer = getAnswer() ;


        private static List<String> getAnswer()  {
            try {
                return Files.readAllLines(Paths.get("settings/questions"), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();

        }

    }


}
