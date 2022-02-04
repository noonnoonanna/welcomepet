function NumFormat(t) // 원 단위, 찍어주기
{
	s = t.value;
	s = s.replace(/\D/g, '');
	l = s.length - 3;
	while (l > 0) {
		s = s.substr(0, l) + ',' + s.substr(l);
		l -= 3;
	}
	t.value = s;
	return t;
}

function go_mov()
{
	var theForm = document.frm;
	theForm.action = "MypetServlet?command=admin_product_list";
	theForm.submit();
}
//projectList.jsp
function go_search() {
	var theForm = document.frm;
	theForm.action =  "MypetServlet?command=admin_product_search";
	theForm.submit();
}

function go_total() {
	var theForm = document.frm;
	theForm.key.value = "";
	theForm.action =  "MypetServlet?command=admin_product_list";
	theForm.submit();
}

function go_wrt() {
	var theForm = document.frm;
	theForm.action = "MypetServlet?command=admin_product_write_form";
	theForm.submit();
}
// **************** productDetail.jsp
function go_list(tpage) {
	var theForm = document.frm;
	//상품 리스트로 이동하되 현재 페이지를 쿼리 스트링으로 넘긴다.
	theForm.action = "MypetServlet?command=admin_product_list&tpage=" + tpage;
	theForm.submit();
}
// **************** productDetail.jsp
function go_mod(tpage, pseq) {
	var theForm = document.frm;
	//현재 페이지를 쿼리 스트링으로 넘긴다.
	theForm.action = "MypetServlet?command=admin_product_update_form&tpage=" + 
		              tpage+"&pNum="+pseq;
	theForm.submit();
}

function go_mod_save(tpage, pseq) {
	var theForm = document.frm;

	if (theForm.kind.value == '') {
		alert('상품분류를 선택하세요');
		theForm.kind.focus();
	} else if (theForm.name.value == '') {
		alert('상품명을 입력하세요');
		theForm.name.focus();
	} else if (theForm.pPrice.value == '') {
		alert('가격를 입력하세요');
		theForm.pPrice.focus();
	} else if (theForm.pInfo.value == '') {
		alert('상품상세를 입력하세요');
		theForm.pInfo.focus();
	} else {
		if (confirm('수정하시겠습니까?')) {
			// [1]추가해야할것   카테고리에 cateName -> 강아지면 cateCode 1 고양이 2 조류3 파충류4로 셋팅할것
			
			theForm.encoding = "multipart/form-data";
			// theForm.seq.value=seq;
						
			// [2] products 테이블의 상품 정보를 수정하는 처리를 하는 product_modsave.jsp 페이지로
			// 이동하되 상품 코드를 전달해준다. 상품코드로 폴더를 생성해서 그곳에 이미지 파일을 업로드하기 때문이다.			
			theForm.action = "MypetServlet?command=admin_product_update";
			theForm.submit();
		}
	}
}

function go_mod_mov(tpage, pseq) {
	var theForm = document.frm;
	theForm.action = 'MypetServlet?command=admin_product_detail&tpage=' + tpage + "&pseq=" + pseq;
	theForm.submit();
}

