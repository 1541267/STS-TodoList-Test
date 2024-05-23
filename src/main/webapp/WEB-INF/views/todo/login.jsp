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

<!-- 로그인페이지는 security context로 customLogin 없이 정상적으로 작동하는데
     로그아웃은 작동이 안됨.      -->
  <h1>Todo Login Page</h1>
  <h2><c:out value="${error}"></c:out></h2>
  <h2><c:out value="${logout}"></c:out></h2>
  
  <form action="/todo/login" method='post'>
    <div>
      <input type='text' name='username'>
    </div>
    <div>
      <input type='password' name='password'>
    </div>
    <div>
      <input type='checkbox' name='remember-me'> Remember Me
    </div>
    <div>
      <input type='submit'>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />    
  </form>
</body>
</html>