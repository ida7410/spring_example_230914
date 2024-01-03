<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		<div class="form-group">
			<label for="name"><b>이름</b></label>
			
			<div class="d-flex">
				<input type="text" id="name" class="form-control col-3">
				<button type="button" id="nameStatusBtn" class="btn btn-info ml-2">중복확인</button>
			</div>
			
			<small id="nameStatusArea"></small>
		</div>

		<input type="button" id="addBtn" class="btn btn-success" value="회원가입">
	</div>
	
	
	<script>
		$(document).ready(function() {
			let isDuplicated = true;
			
			// 중복 확인 버튼 클릭
			$("#nameStatusBtn").on("click", function() {
				// nameStatusArea 하위 태그들 초기화
				$("#nameStatusArea").empty(); // 자식 태그들을 모두 비운다
				
				let name = $("#name").val();
				
				// validation check
				if (name == "") {
					$("#nameStatusArea").append('<span class="text-danger">이름을 입력해주세요.</span>');
					return;
				}
				
				// AJAX 통신 - 중복된 이름인지 DB에서 확인
				$.ajax({
					type:"get"  // 생략 가능 (type이 없으면 기본 get)
					, url:"/temp/lesson06/ex02/is-duplicated-name"
					, data:{"name":name}
					
					, success:function(data) {
						// {"code": 200, "is_duplicated":true/false}
						if (data.is_duplicated) {
							$("#nameStatusArea").append('<span class="text-danger">중복된 이름입니다.</span>');
							isDuplicated = true;
							return;
						}
						isDuplicated = false;
					}
					, error:function(request, status, error) {
						alert("이름 중복 확인에 실패했습니다.");
					}
				});
			});
			
			
			// 회원가입 버튼 클릭
			$("#addBtn").on("click", function() {
				// nameStatusArea에 아무 자식 태그가 없으면 가입 진행
				if ($("#nameStatusArea").children().length < 1 && !isDuplicated) {
					alert("회원가입 진행");
				}
				else {
					alert("회원가입 불가");
				}
			});
		});
	</script>
</body>
</html>