function createCRUDGroup(gid) {
	$(gid).find('.glyphicon-remove-sign').hide();
	$(gid).find('.edit-mode').hide();
	$(gid).find('.edit-mode').click(function(e) {
		$(this).hide();
		$(gid).find('.glyphicon-remove-sign').hide();
		$(gid).find('.del-mode').fadeIn();
		$(gid).find('.create').fadeIn();
		$(gid).find('.seq').each(function(index, elem) {
			$(elem).text((index + 1) + '');
		});
		$(gid).find('.seq').fadeIn();
		e.preventDefault();
	});
	$(gid).find('.del-mode').click(function(e) {
		$(this).hide();
		$(gid).find('.create').hide();
		$(gid).find('.seq').hide();
		$(gid).find('.edit-mode').fadeIn();
		$(gid).find('.glyphicon-remove-sign').fadeIn();
		e.preventDefault();
	});
}