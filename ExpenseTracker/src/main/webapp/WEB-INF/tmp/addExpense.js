// JavaScript Document
var mat1 = 2;
var mat2 = 0;
function addRow() {
	var hiddenRow = document.getElementById("hiddenRow");
	var table = document.getElementById("table");
	//var length = table.rows.length;
	//var newRow = table.rows[length -1].cloneNode(true);
	var newRow = hiddenRow.cloneNode(true);
	newRow.style.visibility = "visible";
	table.appendChild(newRow);
}