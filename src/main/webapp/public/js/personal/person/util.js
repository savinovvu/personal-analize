
function getModal(id) {
    document.getElementById('name').value = "";
    document.getElementById('personId').value = id;
}

function getSelectedValue() {
   // alert(document.getElementById('group').options[document.getElementById('group').options.selectedIndex].value);
    alert($('#group option:selected').text()
    );
  document.getElementById('group-id').value=document.getElementById('group').options[document.getElementById('group').options.selectedIndex].value;
}




