package ru.inbox.savinov_vu.controller.constructor.questionvar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inbox.savinov_vu.service.constructor.questionVar.QuestionVarService;

@RestController
@RequestMapping(value = "/constructor/questionVar", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionVarRestController {

    @Autowired
    private QuestionVarService service;
    private static final Logger LOG = LoggerFactory.getLogger(QuestionVarRestController.class);

  /*  @GetMapping(value = "/all")
    public List<QuestionKit> getAllQuestionKits() {
        LOG.info("get all questionkits");
        return service.getAllQuestionKits();

    }

    @PutMapping
    public List<QuestionKit> addQuestionKit(@RequestBody QuestionKit questionKit) {
        LOG.info("put questionKit {}", questionKit);
        service.addQuestionKit(questionKit);
        return service.getAllQuestionKits();

    }

    @DeleteMapping
    public List<QuestionKit> deleteQuestionKit(@RequestBody QuestionKit questionKit) {
        LOG.info("delete questionKit {}", questionKit);
        service.deleteQuestionKit(questionKit);
        return service.getAllQuestionKits();

    }*/

}
