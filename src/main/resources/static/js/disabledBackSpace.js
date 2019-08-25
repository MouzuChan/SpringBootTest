$(document).ready(function(){
	//禁止后退键 作用于Firefox、Opera
	document.onkeypress=disabledBackspace;
	//禁止后退键  作用于IE、Chrome
	document.onkeydown=disabledBackspace;
});

function disabledBackspace(event){
	event=event?event:window.event;
	if ((event.altKey)
			|| ((event.keyCode == 8) && (event.srcElement.type != "text"
					&& event.srcElement.type != "textarea" && event.srcElement.type != "password"))
			|| ((event.ctrlKey) && ((event.keyCode == 82)))
			|| ((event.ctrlKey) && ((event.keyCode == 78)))) {
		return false;
	}
}

