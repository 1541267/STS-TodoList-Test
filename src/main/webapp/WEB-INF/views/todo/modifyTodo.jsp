<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User Modify Page</h1>
	<h1>userid : ${userid}</h1>
	<h1>${tno} 번째 Todo를 수정 합니다.</h1>
	<form action="../todo/modify" method="post">
		<table>
			<tr>
				<td>Todo<br><textarea name="title" rows="20" cols="60"></textarea></td>
			</tr>
			<tr>
		</table>
		<button type="submit">확인</button>
		<button type="reset">초기화</button>
		<button type="button" onclick="self.location='../todo/list'">취소(리스트로)</button>
    <input type="hidden" name="tno" value="${tno}"/>
	</form>


</body>
</html>