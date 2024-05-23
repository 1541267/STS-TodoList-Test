<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
  table {
  margin : 30px;
  text-align : center;
  }
  
  a:hover{
    color: #ff0063;
  }
  a:active{
    color: gray;
  }
</style>
<body>
  <h1>Admin's Member List</h1>
  <h2>유저 아이디를 클릭하면 수정 페이지로 이동합니다.</h2>
  <hr>
 
<h1>Test User</h1> 


<hr>

	<table border=1>
		<tr>
      <th>유저 아이디</th>
      <th>유저 이름</th>
      <th>전화번호</th>
      <th>등록 날짜</th>
      <th>수정 날짜</th>
      <th>로그인 가능 여부</th>
      <th>유저 삭제</th>
		</tr>
		<c:forEach var="members" items="${allMember}">
			<c:if test="${fn:contains(members.userid, 'user') && !fn:contains(members.userid, 'test')}">
				<tr>
					<td><a href="./memberModify?userid=${members.userid}">${members.userid}</a></td>
					<td>${members.userName}</td>
					<td>${members.tel}</td>
					<td>${members.regDate}</td>
					<td>${members.updateDate}</td>
					<td><c:choose>
							<c:when test="${members.enabled == 1}">
                    가능
                </c:when>
							<c:otherwise>
                    불가능
                </c:otherwise>
						 </c:choose>
				  </td>
				  <td>
            <a href="./memberDelete?userid=${members.userid}">삭제하기</a>
          </td>
				</tr>
			</c:if>
    </c:forEach>
	</table>
<hr>

<h1>Manager</h1>
<hr>
	<table border=1>
		<tr>
      <th>유저 아이디</th>
      <th>유저 이름</th>
      <th>전화번호</th>
      <th>등록 날짜</th>
      <th>수정 날짜</th>
      <th>로그인 가능 여부</th>
      <th>유저 삭제</th>
		</tr>
		<c:forEach var="members" items="${allMember}">
			<c:if test="${fn:contains(members.userid, 'manager')}">
				<tr>
					<td><a href="./memberModify?userid=${members.userid}">${members.userid}</a></td>
					<td>${members.userName}</td>
					<td>${members.tel}</td>
					<td>${members.regDate}</td>
					<td>${members.updateDate}</td>
          <td><c:choose>
              <c:when test="${members.enabled == 1}">
                    가능
                </c:when>
              <c:otherwise>
                    불가능
                </c:otherwise>
             </c:choose>
          </td>
          <td>
            <a href="./memberDelete?userid=${members.userid}">삭제하기</a>
          </td>
				</tr>
			</c:if>
    </c:forEach>
	</table>
<hr>
<h1>Admin</h1>
<hr>
	<table border=1>
		<tr>
			<th>유저 아이디</th>
			<th>유저 이름</th>
			<th>전화번호</th>
			<th>등록 날짜</th>
			<th>수정 날짜</th>
			<th>로그인 가능 여부</th>
			<th>유저 삭제</th>
		</tr>
		<c:forEach var="members" items="${allMember}">
			<c:if test="${fn:contains(members.userid, 'admin') && !fn:contains(members.userid, 'test')}">
				<tr>
					<td><a href="./memberModify?userid=${members.userid}">${members.userid}</a></td>
					<td>${members.userName}</td>
					<td>${members.tel}</td>
					<td>${members.regDate}</td>
					<td>${members.updateDate}</td>
          <td><c:choose>
              <c:when test="${members.enabled == 1}">
                    가능
                </c:when>
              <c:otherwise>
                    불가능
                </c:otherwise>
             </c:choose>
          </td>
          <td>
            <a href="./memberDelete?userid=${members.userid}">삭제하기</a>
          </td>
				</tr>
			</c:if>
    </c:forEach>
	</table>

<hr>
<h1>Test Member</h1>
<hr>
  <table border=1>
    <tr>
      <th>유저 아이디</th>
      <th>유저 이름</th>
      <th>전화번호</th>
      <th>등록 날짜</th>
      <th>수정 날짜</th>
      <th>로그인 가능 여부</th>
      <th>유저 삭제</th>
    </tr>
    <c:forEach var="members" items="${allMember}">
      <c:if test="${fn:contains(members.userid, 'test')}">
        <tr>
          <td><a href="./memberModify?userid=${members.userid}">${members.userid}</a></td>
          <td>${members.userName}</td>
          <td>${members.tel}</td>
          <td>${members.regDate}</td>
          <td>${members.updateDate}</td>
          <td><c:choose>
              <c:when test="${members.enabled == 1}">
                    가능
                </c:when>
              <c:otherwise>
                    불가능
                </c:otherwise>
             </c:choose>
          </td>
          <td>
            <a href="./memberDelete?userid=${members.userid}">삭제하기</a>
          </td>
        </tr>
      </c:if>
    </c:forEach>
  </table>
<hr>
<h1>일반 유저</h1>
<hr>
  <table border=1>
    <tr>
      <th>유저 아이디</th>
      <th>유저 이름</th>
      <th>전화번호</th>
      <th>등록 날짜</th>
      <th>수정 날짜</th>
      <th>로그인 가능 여부</th>
      <th>유저 삭제</th>
    </tr>
    <c:forEach var="members" items="${allMember}">
      <c:if test="${!fn:contains(members.userid, 'admin') && !fn:contains(members.userid, 'test') &&
                  !fn:contains(members.userid, 'manager') && !fn:contains(members.userid, 'user')}">
        <tr>
          <td><a href="./memberModify?userid=${members.userid}">${members.userid}</a></td>
          <td>${members.userName}</td>
          <td>${members.tel}</td>
          <td>${members.regDate}</td>
          <td>${members.updateDate}</td>
          <td><c:choose>
              <c:when test="${members.enabled == 1}">
                    가능
                </c:when>
              <c:otherwise>
                    불가능
                </c:otherwise>
             </c:choose>
          </td>
          <td>
            <a href="./memberDelete?userid=${members.userid}">삭제하기</a>
          </td>
        </tr>
      </c:if>
    </c:forEach>
  </table>
  
  <button onclick="self.location='./intro'">Todo 홈으로</button>
  <button onclick="self.location='./logout'">로그아웃</button>
</body>
</html>