<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<h1>
  Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!-- 
<button type="button" onclick="self.location='./login/admin'">어드민 로그인</button><br>
<button type="button" onclick="self.location='./login/member'">멤버 로그인</button><br> -->
<button type="button" onclick="self.location='./todo/intro'">Todo 홈</button><br>

</body>
</html>
