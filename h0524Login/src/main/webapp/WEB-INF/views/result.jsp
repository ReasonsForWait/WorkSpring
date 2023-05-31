<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원가입이 완료되었습니다.</h1>
    <p>이름 : ${name}</p>
    <p>이메일 : ${email}</p>
    <p>비밀번호 : ${pw}</p>
    <p>나이 : ${age}</p>
    <p>주요 업무 : ${career}</p>
    <p>주요 직업 : ${major}</p>
    <c:forEach items="${interest}" var="n">
        <p>관심 분야 : ${n}</p>
    </c:forEach>
</body>
</html>