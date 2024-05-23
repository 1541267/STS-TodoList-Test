<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
  <h1>Member Delete Page</h1>
  <h2>${userid}, 삭제 합니까?</h2>
    <form action="./memberDelete" method="post">
     <button type="submit" name="userid" value="${userid}">확인</button>
     <button onclick="self.location='./intro'">취소(메인화면으로)</button>
     </form>
</body>
</html>