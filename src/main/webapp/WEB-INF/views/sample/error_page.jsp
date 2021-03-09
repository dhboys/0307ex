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
	<!-- c:out을 사용하는 이유 = XSS 방어에 유리 -->
	<h4>
	<c:out value="${exception.getMessage() }"></c:out>
	</h4>
	
	<ul>
	<c:forEach items="${exception.getStackTrace() }" var="stack">
		<li><c:out value="${stack }"></c:out></li>
	</c:forEach>
	</ul>
</body>
</html>