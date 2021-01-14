/**
 * 
 */


function verifica() {

	if (document.getElementById("user").value == "" && document.getElementById("pass").value == "") {
		alert("Inserire username e password");
	}
	else if (document.getElementById("user").value == "") {
		alert("Inserire username.");
	}
	else if (document.getElementById("pass").value == "") {
		alert("Inserire password.");
	}
}