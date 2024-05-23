<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    text-align: center;
  }
  
  .button-form {
    display : inline-block;
  }
</style>
</head>
<body>
    <h1>To-Do List</h1>
    <h2>반갑습니다, <c:out value="${userid}"/>님</h2>
    <h3>미완료 클릭시 작업을 완료합니다.</h3>
        <table border='1'>
        <thead>
            <tr>
                <th>번호</th>
                <th>내용</th>
                <th>등록자 이름</th>
                <th>등록 시간</th>
                <th>완료 시간</th>
                <th>진행 상황</th>
                <th>삭제 하기</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.tno}</td>
                <td>${user.title}</td>
                <td>${user.userid}</td>
                <td>${user.regDate}</td>
                <td>${user.endDate}</td>
                <c:choose>
                      <c:when test="${user.endDate == null}"><td><a href="./complete?tno=${user.tno}">미완료</a></td></c:when>
                      <c:when test="${user.endDate != null}"><td>완료</td></c:when>
                </c:choose>           
                <td><a href="./delete?tno=${user.tno}">삭제</a></td>
            </tr>
             </c:forEach>
        </tbody>
    </table>

	<button onclick="self.location='./add'">새로 등록</button>
	<button onclick="self.location='./intro'">Todo 홈으로</button>

	<form action="./memberModify" method="get" class="button-form">
		<button type="submit">회원 정보 수정</button>
		<input type="hidden" name="userid" value="${userid}">
	</form>

	<button type="button" onclick="self.location='../todo/logout'">로그아웃</button>

	<form action="./memberDelete" method="get" class="button-form">
		<button type="submit">회원 탈퇴</button>
		<input type="hidden" name="userid" value="${userid}">
	</form>


</body>
</html>