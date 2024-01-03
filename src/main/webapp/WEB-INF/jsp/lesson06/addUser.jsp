<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
		
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>

		<form method="post" action="/lesson06/ex01/add-user">
			<div class="form-group">
				<label for="name">이름</label> <input type="text" id="name"
					name="name" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label> <input type="text" id="yyyymmdd"
					name="yyyymmdd" class="form-control col-3" placeholder="20030409">
			</div>
			<div class="form-group">
				<label for="email">이메일</label> <input type="text" id="email"
					name="email" class="form-control col-3">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control"></textarea>
			</div>
			
			<%-- AJAX로 할 때는 submit이 되면 안 되기 때문에 button으로 변경 --%>
			<button type="button" id="joinBtn" class="btn btn-primary">회원가입</button>
		</form>
	</div>
	
<script>
	$(document).ready(function() {
		// 1) jquery의 submit 기능 이용하기
		/* $("form").on("submit", function(e) {
			// e.preventDefault(); // submit 기능 중단
			// alert("submit");
			
			// validation check
			let name = $("#name").val();
			if (name.length < 1) {
				alert("이름을 입력하세요");
				return false;
				// on click 에선 return만 해도 빠져나가지만 on submit에선 return false를 해야 함
			} 
			
			let yyyymmdd = $("#yyyymmdd").val();
			if (yyyymmdd == "") {
				alert("생년월일을 입력하세요");
				return false;
			}
			
			let email = $("#email").val();
			if (!email) {
				alert("이메일을 입력하세요");
				return false;
			}
			
			// 여기까지 도달하면 submit (화면 이동)
		}); */
		
		// 2) jquery의 AJAX 통신을 이용하기
		$("#joinBtn").on("click", function() {
			// alert("click");
			
			// validation check
			let name = $("#name").val();
			if (name.length < 1) {
				alert("이름을 입력하세요");
				return;
			} 
			
			let yyyymmdd = $("#yyyymmdd").val();
			if (yyyymmdd == "") {
				alert("생년월일을 입력하세요");
				return;
			}
			
			let email = $("#email").val();
			if (!email) {
				alert("이메일을 입력하세요");
				return;
			}
			
			let introduce = $("#introduce").val();
			
			console.log(name);
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			
			// AJAX: 비동기로 서버에 요청
			$.ajax({
				// request
				type:"post"
				, url:"/lesson06/ex01/add-user"
				, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
				
				// response
				, success:function(data) { //call-back 함수, data in param = 응답값
					alert(data); // "성공"
					if (data == "성공") {
						location.href = "/lesson06/ex01/after-add-user-view"; // GET 요청 (화면 이동)
					}
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				}
				, complete:function(data) {
					// 앞으로는 안 씀
					alert("성공이든 실패든 완료");
				}
			});
		});
		
	})
</script>
</body>
</html>