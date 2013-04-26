/**
 * @author manishveerwal
 */

function onClickButton(obj){
	var arr = document.getElementsByClassName("category");
	for (var i = 0; i < arr.length; i++){
	  arr[i].style.backgroundColor = "#FFFFFF";
	}
	obj.style.backgroundColor = "#3079ED";
	
	drawSubCatTable(obj);
	
	 var table1 = document.getElementById("subcategory");
	 table1.style.float = "right";
}

var data = {"housing":["a","b","c","d"], "daily":["e","f","g","h"], "transport":["i","j","k","l","m","n","o"], "fun":["p","q","r","s","t"]};
function drawSubCatTable(obj){
	var divElem = document.getElementById("subcategory");
	divElem.removeChild(divElem.firstChild);
	var table = document.createElement("table");
	table.setAttribute("border", "1");
	
	var tr;
	var td;
	var arr;
	if (obj.name == "housing") {
		arr = data.housing;
	} else if(obj.name == "daily"){
		arr = data.daily;
	}else if(obj.name == "transport"){
		arr = data.transport;
	}else if(obj.name == "fun"){
		arr = data.fun;
	};
	
	for (var i = 0; i < arr.length; i++){
		tr = document.createElement("tr");
		td = document.createElement("td");
		td.innerText = arr[i];
		td.style.padding = "5px 10px";
		tr.appendChild(td);
		table.appendChild(tr);
	};
	table.style.borderCollapse = "collapse";
	divElem.appendChild(table);
}
