/**
 * 
 */
	
	
	function deleteOk(admin_board_id){
		var yn= confirm( '글을 삭제하시겠습니까?');
		
		if(yn==true){
			alert('글 ' + admin_board_id +'를 삭제합니다.');
			location.href='delete?admin_board_id='+admin_board_id;
		}
	}
	
