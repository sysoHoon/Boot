/**
 * 
 */
  //1) 대여일자는 오늘날짜로 자동 출력
    	print_date();
    
 
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
        