<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Todo Register</h1>
  <form action="/todo/add" method="post">
   타이틀<br><textarea name="title"></textarea><br><hr>
   <button type="submit">확인</button>
   <button type="reset" onclick="self.location='./list'">취소</button>
  </form>
</body>
</html>