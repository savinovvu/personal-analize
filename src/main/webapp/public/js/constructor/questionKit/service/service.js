function downloadPage() {
    getAll();
}

function getAll() {
    send("/constructor/questionKit/all", "GET");
}