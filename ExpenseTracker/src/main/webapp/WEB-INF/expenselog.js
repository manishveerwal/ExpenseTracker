// JavaScript Document

function deleteRow(id) {
	var v1 = confirm("Do you really want to delete this entry?");
	if (v1 == true){
		var table = document.getElementById("dataTable");
		var row = document.getElementById(id);
		var rowIndex = row.rowIndex;
		table.deleteRow(rowIndex);	
	}
	altRowColor();
}

function altRowColor() {
	var table = document.getElementById("dataTable");
	for(i=1; i < table.rows.length; i++) {
		var row = table.rows[i];
		if (i%2 == 0){
			row.style.backgroundColor = "#80FF80";	
		} else {
			row.style.backgroundColor = "#FFFFFF";	
		}		
	}
}

function init() {
	altRowColor();
}

window.onload = init;