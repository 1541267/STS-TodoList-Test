<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/css.jsp" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

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



<%@ include file="../includes/script.jsp" %>
</body>

</html>