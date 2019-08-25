$(document).ready(agentInit = function(e) {
	$('.agentPanel').hide();
	if ($('.checkboxAgent').prop('checked') == true) {
		$('.agentPanel').show();
	}
	$('.checkboxAgent').change(function(e) {
		//$("#agentSelect option:first").prop("selected", 'selected');
		$('.agentPanel').hide();
		if ($(this).prop('checked') == true) {
			$('.agentPanel').show();
		}else{
//			$("input[name='agentMsg']").val("");
			$('.agentMsg').val("");
			$('.agentSelect').each(function(){     
				$(this).find("option").eq(0).prop("selected",true);
				var msg = $(this).find('option:selected').text();
				$(this).val(msg).trigger("change");
			});
		}
	});
});