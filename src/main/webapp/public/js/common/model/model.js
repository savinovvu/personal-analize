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

function QuestionVar(id, name, answerKit, questionKit) {
    this.id = Number(id);
    this.name = name;
    this.answerKit = answerKit;
    this.questionKit = questionKit;
}



