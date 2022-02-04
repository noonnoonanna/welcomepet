function go_order(cNum) {
	var c =cNum;
	  document.formm.action = "MypetServlet?command=order_insert&cNum="+c;
	  document.formm.submit();
}



function goCancle(odNum,user_state){
   var state = user_state
   var state2 ="결제완료";
   if(state == state2){
   var result = confirm("취소하시겠습니까??");
      if(result){
         document.formm.action = "MypetServlet?command=order_cancle&odNum="+odNum;
         document.formm.submit();
      }else{
         alert("주문취소 요청을 취소했습니다.");
      }
   }else{
      alert("이미 취소 요청을 하셨습니다.");
   }
}