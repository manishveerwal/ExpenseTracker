// JavaScript Document

function init() {
	draw();
}

window.onload = init;

var data = { values:[
{X:"Jan", Y:12000}
//, {X:"Feb", Y:18000} 
, {X:"Mar", Y:10000} , 
{X:"Apr", Y:15000}, 
{X:"May", Y:17000}, 
{X:"Jun", Y:13000}, 
{X:"Jul", Y:12000}
, {X:"Aug", Y:5000}
, {X:"Sep", Y:15000}
, {X:"Oct", Y:12000}
]};

function draw() {
	var canvas = document.getElementById("graph");
	var ctx = canvas.getContext("2d");
	var width = canvas.getAttribute("width");
	var height = canvas.getAttribute("height");
	
	//create x and y axis
	var startPointX = width * 10/100;
	var startPointY = height * 10/100;
	var endPointX = width * 90/100;
	var endPointY = height * 90/100;
	
	ctx.beginPath();
	ctx.lineWidth = 2;
	ctx.moveTo(startPointX, startPointY);
	ctx.lineTo(startPointX, endPointY);
	ctx.lineTo(endPointX, endPointY);
	ctx.stroke();
	//end of x&y axis
	
	//start of section y axis
	var eachSectionX = width * 80/(100 * data.values.length);
	var maxValue = 0;
	for (i=0; i < data.values.length; i++) {
		arr = data.values[i];
		if (arr.Y > maxValue) {
			maxValue = arr.Y;
		}
	}
	var maxValueY = Math.round(maxValue/10000) * 10000;
	//alert(maxValueY);
	var sectionsY = 10;
	var eachSectionY = (height * 80/100) / sectionsY;
	var eachSectionValueY = maxValueY / sectionsY;
	var tmp;
	var tmpy = endPointY;
	var textPaddingX = 50;
	ctx.font= "bold 14px Arial";
	for (i=0; i < sectionsY; i++) {
		tmp = eachSectionValueY * (i+1);
		tmpy = tmpy - eachSectionY;
		ctx.fillText(tmp, startPointX - textPaddingX, tmpy);		
	}
	//end of section y axis
	
	//draw bar graph
	var rectStartX = startPointX;
	var rectStartY = endPointY - 1;
	
	ctx.font= "bold 15px Arial";
	var arr;
	var paddingX = 10;
	for (i=0; i < data.values.length; i++) {
		arr = data.values[i];
		//ctx.fillStyle = "#FF6600";
		ctx.fillStyle = "#09F";
		ctx.fillRect(rectStartX + paddingX, rectStartY -  (arr.Y * (eachSectionY/eachSectionValueY)), eachSectionX - paddingX, arr.Y * (eachSectionY/eachSectionValueY));
		ctx.fillStyle = "#000000";
		ctx.fillText(arr.X, rectStartX + (eachSectionX /2), rectStartY + 20);
		rectStartX = rectStartX + eachSectionX;
	}
	//end of bar graph
}