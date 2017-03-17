package ru.inbox.savinov_vu.service.constructor.questionVar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.constructor.question.QuestionVar;
import ru.inbox.savinov_vu.repository.constructor.QuestionVarRepository;

import java.util.List;
import java.util.Objects;

@Service
public class QuestionVarServiceImpl implements QuestionVarService {
    @Autowired
    QuestionVarRepository repository;

    @Override
    public QuestionVar findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<QuestionVar> getQuestionVarWithQuestionKit(Integer id) {
        return repository.getQuestionVarWithQuestionKit(id);
    }

    @Override
    public List<QuestionVar> getQuestionVarWithSuperQuestionVar(Integer id) {
        return repository.getQuestionVarWithSuperQuestionVar(id);
    }

    @Override
    public void addQuestionVar(QuestionVar questionVar) {
        repository.saveAndFlush(setNumber(questionVar));
    }

    private QuestionVar setNumber(QuestionVar questionVar) {
        if (Objects.isNull(questionVar.getId()))
            if (Objects.isNull(questionVar.getSuperQuestionVarId())) {
                questionVar.setNumber(Math.toIntExact(repository.getCountQuestionVarWithQuestionKit(questionVar.getQuestionKit().getId())) + 1);
            } else {
                questionVar.setNumber(Math.toIntExact(repository.getCountQuestionVarWithSuperQuestionVar(questionVar.getSuperQuestionVarId())) + 1);
            }
        return questionVar;
    }


    @Override
    public void deleteQuestionVar(QuestionVar questionVar) {
        changeCountBecauseDeleteInMiddle(questionVar);
        repository.delete(questionVar.getId());
    }

    private void changeCountBecauseDeleteInMiddle(QuestionVar questionVar) {
        if (Objects.isNull(questionVar.getSuperQuestionVarId())) {
            List<QuestionVar> listWithIdMoreThat = repository.getListWithIdMoreThatWithQuestionKit(questionVar.getId(), questionVar.getQuestionKit().getId());
            setNumberAfterDelete(listWithIdMoreThat);
        } else {
            List<QuestionVar> listWithIdMoreThat = repository.getListWithIdMoreThatWithQuestionVar(questionVar.getId(), questionVar.getSuperQuestionVarId());
            setNumberAfterDelete(listWithIdMoreThat);
        }

    }

    private void setNumberAfterDelete(List<QuestionVar> listWithIdMoreThat) {
        for (QuestionVar questionVar : listWithIdMoreThat) {
            repository.saveAndFlush(questionVar.setNumber(questionVar.getNumber() - 1));

        }
    }


}
