
var blocks = [];
var timer1;
var timer2;
var dropValue = 5;

function on_pause() {
	clearInterval(timer1);
	clearInterval(timer2);
	document.removeEventListener("keydown", on_key_down_event);
}

function on_begin() {
	on_pause();
	timer1 = setInterval(createBlock, 1000);
	timer2 = setInterval(dropBlock, 200);
	document.addEventListener("keydown", on_key_down_event);
}

function createBlock() {
	var randomNum = parseInt(Math.random() * 26) + 65;
	var randomChar = String.fromCharCode(randomNum);
	var width = document.documentElement.clientWidth;
	var randomWidth = (width-400) * Math.random() + 200;
	//console.debug(width);
	//console.debug(randomWidth);
	var block = document.createElement("div");
	block.innerHTML = randomChar;
	block.className = "block";
	block.style.left = randomWidth + "px";
	block.style.top = "0px";
	document.documentElement.appendChild(block);
	blocks.push(block);
}

function dropBlock() {
	for (var i = 0; i < blocks.length; i++) {
		var block = blocks[i];		
		var top = parseInt(block.style.top);
		var height = document.documentElement.clientHeight;
		if (top > height - 48) {
			blocks.splice(i, 1);
			document.documentElement.removeChild(block);
			continue;
		}
		block.style.top = top + dropValue + "px";
	}
}

function on_key_down_event(event) {	
	var keyCode = event.keyCode;
	var key = String.fromCharCode(keyCode);
	for (var i = 0; i < blocks.length; i++) {
		var block = blocks[i];	
		if (block.innerHTML == key) {
			blocks.splice(i, 1);
			document.documentElement.removeChild(block);
			var scoreboard = document.getElementById("scoreboard");
			var score = parseInt(scoreboard.innerHTML);
			document.getElementById("plusScore").innerHTML = "+10";
			scoreboard.innerHTML = score + 10;
			return;
		}
		document.getElementById("plusScore").innerHTML = "";
	}
}

