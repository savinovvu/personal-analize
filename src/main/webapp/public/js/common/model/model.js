function Department(id, name) {
    this.id = Number(id);
    this.name = name;
}

function Group(id, name, department) {
    this.id = Number(id);
    this.name = name;
    this.department = department;
}

function Person(id, name, group) {
    this.id = Number(id);
    this.name = name;
    this.group = group;

}


function AnswerKit(id, name, answerType) {
    this.id = Number(id);
    this.name = name;
    this.answerType = answerType;
}

function QuestionKit(id, name) {
    this.id = Number(id);
    this.name = name;
}

function AnswerVar(id, name, answerKit) {
    this.id = Number(id);
    this.name = name;
    this.answerKit = answerKit;
}

function QuestionVar(id, name, answerKit, questionKit, questionVar) {
    this.id = Number(id);
    this.name = name;
    this.answerKit = answerKit;
    this.questionKit = questionKit;
    this.questionVar = questionVar;
}

function Survey(id) {
    this.id = Number(id);
}

function Questionnaire(id, number, createDate, survey) {
    this.id = Number(id);
    this.number = Number(number);
    this.createDate = createDate;
    this.survey = survey;
}

function Answer(id, name, questionVar, questionnaire) {
    this.id = Number(id);
    this.name = name;
    this.questionVar = questionVar;
    this.questionnaire = questionnaire;
}





