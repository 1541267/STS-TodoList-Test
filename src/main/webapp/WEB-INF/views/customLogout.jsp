<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Logout Page</h1>
<h2>${userid}님 로그아웃 하시겠습니까?</h2>

    <form action="/customLogout" method='post'>

        <button type="submit">확인</button>
        <button type="button" onclick="self.location='./intro'">취소</button>
        
    </form>
</body>
</html>