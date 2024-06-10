<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">
$(function() {
	$('#b1').click(function() {
	    var id = $('#id').val();
	    var pw = $('#pw').val();
	    var name = $('#name').val();
		
	    if(id !=''){
	    	if(pw != ''){
	    		if(name != ''){
	    			$.ajax({
	    				url: "insert",
	    				type:"post",
	    				data:{
	    					id: id,
	    					pw: pw,
	    					name: name
	    				},
	    				success: function(result){
	    					if (result == 1) {
								location.href="main.jsp"
							} else {
	    					console.log(error)
							}
	    					console.log(result)
	    				},
	    				error:function(error){
	    					console.log(error)
	    				}
	    			})
	    		}
	    	}
	    }
	});
})
</script>
</head>
<body>
<div class="sign_up">
	<input id="id" type="text"  placeholder="아이디를 입력해주세요."> <br>
	<input id="pw" type="password" placeholder="비밀번호를 입력해주세요."><br>			
	<input id="name" type="text" placeholder="이름을 입력해주세요.">			
	<button type="submit" id="b1">회원가입</button>
</div>
</body>
</html>