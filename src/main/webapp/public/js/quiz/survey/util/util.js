function getUpdateModal(id) {
    getDepartments();
    $(".delGroup").remove();
    document.getElementById('dateUpdate').value = $('#date-' + id).text().split("-").reverse().join("-");
    document.getElementById('idUpdate').value = $('#id-' + id).text();
    document.getElementById('nameUpdate').value = $('#name-' + id).text();
    document.getElementById('commentUpdate').value = $('#comment-' + id).text();
    document.getElementById('questionKitIdUpdate').value = $('#questionKitId-' + id).text();

}

function groupViewOptions(id) {
    $(".delGroup2").remove();
    if ($('#' + id).children(':selected').attr('value') == "noChange") {
        var output = '<option value="noChange" class="delGroup2" selected>Не менять</option>';
        $("#groupUpdate").append(output);
    }
}