$(document).ready(function ()
{
	var pathname = window.location.pathname;
	var page = pathname.split("/").pop().match(/[a-z0-9\-_]+/i);

	$("#"+page).css({color:"red"});

});