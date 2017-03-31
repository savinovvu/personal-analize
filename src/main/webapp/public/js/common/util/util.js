function convertAnswerTypeToText(answerType, dataIndex) {
    /*CHECKBOX, RADIO, SELECT , FREE, EMPTY, NAME*/
    switch (answerType) {
        case 'CHECKBOX':
            return  '<p id="answerType-' + dataIndex.id + '">Несколько ответов</p>';
        case 'RADIO':
            return  '<p id="answerType-' + dataIndex.id + '">Единственный ответ</p>';
        case 'SELECT':
            return  '<p id="answerType-' + dataIndex.id + '">Вылетающий список</p>';
        case 'FREE':
            return  '<p id="answerType-' + dataIndex.id + '">Свободный ввод</p>';
        case 'EMPTY':
            return '<p id="answerType-' + dataIndex.id + '">Пустой</p>';
        case 'NAME':
            return '<p id="answerType-' + dataIndex.id + '">База имен</p>';
    }
}