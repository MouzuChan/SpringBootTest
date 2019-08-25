$(document).ready(function() {
	$('.panel-heading').click(function() {
		$(this).siblings(".services").toggle(300);
	});
	$('.name').click(function() {
		$(this).siblings(".operations").toggle(300);
	});
	$('.cart-toggle').click(function(){
		$('.cart-list').toggle(300);
	});
	$('.code-form input').keypress(function(e){
		var keycode = (e.keyCode ? e.keyCode : e.which);
		if (keycode == '13' && $(this).val()) {
			alert ($(this).val());
		}
	});
});