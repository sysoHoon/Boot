/**
 *   
 */
  //1) 대여일자는 오늘날짜로 자동 출력
    	print_date();
    
 	    var valid='';		//확인한 mem_idx 저장할 전역변수
        
       
        //2)대여버튼 클릭시 반납예정일자 화면 알림 출력
        function valid_check(){
            const frm = document.forms[0];
            const mem_idx = frm.mem_idx.value;  
            const exp_date = frm.exp_date.value;
			console.log(exp_date)	
                
	        if(mem_idx != '' && valid == mem_idx){   //문제: 대여 가능한 경우 동작
				alert('도서대여가 처리 되었습니다.')	          
	        }else {
				alert('대여할수 있는 회원이 아닙니다. 회원idx 를 입력하고 확인 해주세요.')
			}
    	}  //fucn 끝
        
    //비동기 통신
   document.querySelector("#memidx_check").addEventListener('click',function(){
        	const frm = document.forms[0];
            const mem_idx = frm.mem_idx.value;  
            if(mem_idx==""){
          	  	alert('회원번호 입력은 필수입니다.')
                mem_idx.focus();
          	  	return;
            }
        	const xhr = new XMLHttpRequest();   //문제 : 비동기 통신 시작
      		xhr.open('GET','book/bookrent')
      		xhr.setRequestHeader('content-type','application/json;charset=utf-8')
      		var jsob = {"rent_no":rent_no,"mem_idx":mem_idx,"bcode":bcode}
      		xhr.send(JSON.stringify(jsob))
      		xhr.onload = function(){
				  if(xhr.status === 200){
					  const data = JSON.parse(xhr.response)
					  if(data.result ==1)
						  setTimeout("alert('도서대여가 처리되었습니다.')",200)
				  }else{
					  console.error('error'.xhr.status, xhr.statusText)
				  }
			  }



     }) //addEventListener 끝
   
     //대출일 : 현재    //반납일자는 +14일 이후
    function print_date(){
    	var temp=new Date()
        var year = temp.getFullYear();
        var month = (temp.getMonth()+1).toString().padStart(2,0);
        var date_ = temp.getDate().toString().padStart(2,0);
        document.forms[0].rent_date.value=[year,month,date_].join('-')
        //반납일자는 +14일 이후
        temp = new Date(temp.setDate(temp.getDate()+14))
        year = temp.getFullYear();
        month = (temp.getMonth()+1).toString().padStart(2,0);
        date_ = temp.getDate().toString().padStart(2,0);
        document.forms[0].exp_date.value=[year,month,date_].join('-')
    }
        