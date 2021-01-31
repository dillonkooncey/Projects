// Function to add to history.
function addToHistory() {
  var table = document.getElementById("historyTable");
  var row = table.insertRow(3);
  var cell1 = row.insertCell(0);
  var cell2 = row.insertCell(1);
  var cell3 = row.insertCell(2);
  var cell4 = row.insertCell(3);
  cell1.innerHTML = "Tuesday";
  cell2.innerHTML = "Spotify";
  cell3.innerHTML = "3:30 - 4:45";
  cell4.innerHTML = "Living Room";
}

// Function to add to schedule.
function addToSchedule() {
	var table = document.getElementById("currentScheduleTable");

	var days = [];
	if(document.getElementById("checkmonday").checked) {
		days.push("Monday");
	} if (document.getElementById("checktuesday").checked) {
		days.push("Tuesday");
	} if (document.getElementById("checkwednesday").checked) {
		days.push("Wednesday");
	} if(document.getElementById("checkthursday").checked) {
		days.push("Thursday");
	} if(document.getElementById("checkfriday").checked) {
		days.push("Friday");
	} if(document.getElementById("checksaturday").checked) {
		days.push("Saturday");
	} if(document.getElementById("checksunday").checked) {
		days.push("Sunday");
	}

	if(!document.getElementById("checkmonday").checked && !document.getElementById("checktuesday").checked
		&& !document.getElementById("checkwednesday").checked && !document.getElementById("checkthursday").checked
		&& !document.getElementById("checkfriday").checked && !document.getElementById("checksaturday").checked
		&& !document.getElementById("checksunday").checked) {
		alert("Must select a least one day!");
		return;
	}

	var time;
	var startTime = document.getElementById("addstarttime").value;
	var endTime = document.getElementById("addendtime").value;

	if(startTime == "" || endTime == "") {
		alert("Must include both a start and end time!");
		return;
	}
	time = startTime + " - " + endTime;

	var media = [];
	if(document.getElementById("checkspotify").checked) {
		media.push("Spotify");
	} if(document.getElementById("checkapple").checked) {
		media.push("Apple Music");
	} if(document.getElementById("checkcabletv").checked) {
		media.push("Cable TV");
	} if(document.getElementById("checkcableradio").checked) {
		media.push("Cable Radio");
	} if(document.getElementById("checkinstagram").checked) {
		media.push("Instagram");
	} if(document.getElementById("checkfacebook").checked) {
		media.push("Facebook");
	} if(document.getElementById("checktwitter").checked) {
		media.push("Twitter");
	} if(document.getElementById("checkgames").checked) {
		media.push("Games");
	}
	if(!document.getElementById("checkspotify").checked && !document.getElementById("checkapple").checked
		&& !document.getElementById("checkcabletv").checked && !document.getElementById("checkcableradio").checked
		&& !document.getElementById("checkinstagram").checked && !document.getElementById("checkfacebook").checked
		&& !document.getElementById("checktwitter").checked && !document.getElementById("checkgames").checked) {
		alert("Must include at least one type of media!");
		return;
	}

	var location = [];
	if(document.getElementById("checklivingroom").checked) {
		location.push("Living Room");
	} if(document.getElementById("checkdiningroom").checked) {
		location.push("Dining Room");
	} if(document.getElementById("checkkitchen").checked) {
		location.push("Kitchen");
	} if(document.getElementById("checkmasbedroom").checked) {
		location.push("Master Bedroom");
	} if(document.getElementById("checklisabedroom").checked) {
		location.push("Lisa Bedroom");
	} if(document.getElementById("checkguestbedroom").checked) {
		location.push("Guest Bedroom");
	}
	if(!document.getElementById("checklivingroom").checked && !document.getElementById("checkdiningroom").checked
		&& !document.getElementById("checkkitchen").checked && !document.getElementById("checkmasbedroom").checked
		&& !document.getElementById("checklisabedroom").checked && !document.getElementById("checkguestbedroom").checked) {
		alert("Must designate at least one location!");
		return;
	}

	
	var row = table.insertRow(3);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);

	cell1.innerHTML = days;
  	cell2.innerHTML = time;
  	cell3.innerHTML = media;
  	cell4.innerHTML = location;
	}

	// Function to remove from schedule.
	function removeFromTable() {
		var table = document.getElementById("currentScheduleTable");
    	var rowCount = table.rows.length;

    table.deleteRow(rowCount -2);
	}

	// Function to set a preset channel.
	function setPreset(preset, channel) {
		var element = document.getElementById(preset);
		var newChannel = document.getElementById(channel).innerHTML;
		element.innerHTML = newChannel;
	}

	// Function to set the channel using a preset.
	function setChannel(channel) {
		var newChannel = document.getElementById(channel);
		var oldChannel = document.getElementById("demo");
		oldChannel.innerHTML = newChannel.innerHTML;
	}

	// Function that changes the TV channel.
	function changeTVChannel(number) {
		var num = document.getElementById(number);
		var channel = document.getElementById("currentChannel");
		channel.innerHTML = num.innerHTML;
	}

	// Function that sets the TV preset channels.
	function setChPreset(preset) {
		var newChannel = document.getElementById("currentChannel").innerHTML;
		var oldChannel = document.getElementById(preset)
		oldChannel.innerHTML = newChannel;
	}

	// Function to add a show to the desired recorded shows slot.
	function recordChannel(slot) {
		var newSlot = document.getElementById(slot);
		var currentChannel = document.getElementById("currentChannel").innerHTML;
		newSlot.innerHTML = currentChannel;
	}

	