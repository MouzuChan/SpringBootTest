function syncValues(from, to) {
	$(from).blur(function(){
		var srcVal = $(from).prop('value');
		var toVal = $(to).prop('value');
		if (toVal == ''){
			$(to).prop('value', srcVal);
		}
	});				
}