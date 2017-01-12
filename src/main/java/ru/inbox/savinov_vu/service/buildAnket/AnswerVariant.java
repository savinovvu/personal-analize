package ru.inbox.savinov_vu.service.buildAnket;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AnswerVariant {

    List<String> answer;

    public AnswerVariant() throws IOException {
        answer = Files.readAllLines(Paths.get("settings/questions"), StandardCharsets.UTF_8);
    }


}
