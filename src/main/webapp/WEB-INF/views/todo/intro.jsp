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
  <h1>Todo 앱 입니다.</h1>
  <h2> 현재 시간 : ${serverTime}.</h2>

<!-- 로그인 유무 + 권한별 버튼 출현 -->

<c:if test="${isLoggedIn && pageContext.request.isUserInRole('ROLE_ADMIN')}">
<button  type="button" id="adminBtn" onclick="self.location='./memberList'">어드민 멤버 리스트 페이지</button><br></c:if>

<c:if test="${!isLoggedIn}">
<button type="button" onclick="self.location='./login'">로그인</button><br></c:if>

<c:if test="${!isLoggedIn}">
<button type="button" onclick="self.location='./register'">회원가입</button><br></c:if>

<c:if test="${isLoggedIn && pageContext.request.isUserInRole('ROLE_MEMBER')}">
<button type="button" onclick="self.location='./list'">리스트</button><br></c:if>

<c:if test="${isLoggedIn}"><button type="button" onclick="self.location='./logout'">로그아웃</button></c:if>


</body>
</html>