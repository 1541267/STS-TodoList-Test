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
	<form action="../todo/memberModify" method="post">
		<table>
			<tr>
				<td>비밀번호<input type="password" name="userpw" /></td>
			</tr>
			<tr>
				<td>이름<input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>전화번호<input type="text" name="tel" /></td>
			</tr>
		</table>
		<button type="submit">확인</button>
		<button type="reset">초기화</button>
		<button type="button" onclick="self.location='../todo/intro'">취소(메인 페이지로)</button>
    <input type="hidden" name="userid" value="${userid}"/>
	</form>


</body>
</html>