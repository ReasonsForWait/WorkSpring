<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <h1>test1 커스텀 폼태그 예제</h1>
  <!-- <form action="example04/result" method="post">
    <label for="username">이름 : </label><input type="text" name="username" id="username" value="${userDataDTO.username}" /><br>
    <label for="userid">아이디 : </label><input type="text" name="userid" id="userid" value="${userDataDTO.userid}" /><br>
    <label for="userpw">비밀번호 : </label><input type="text" name="userpw" id="userpw" value="${userDataDTO.userpw}" /><br>
    <label for="userPostcode">우편번호 : </label><input type="text" name="userPostcode" id="userPostcode" value="${userDataDTO.userPostcode}" /><br>
    <label for="userAddr1">주소1 : </label><input type="text" name="userAddr1" id="userAddr1" value="${userDataDTO.userAddress1}" /><br>
    <label for="userAddr2">주소2 : </label><input type="text" name="userAddr2" id="userAddr1" value="${userDataDTO.userAddress2}" /><br>
    <button>확인</button>
  </form> -->
  <form:form modelAttribute="userDataDTO" action="example04/result" method="post">
    <form:input path="username" />
    <form:input path="userid" />
    <form:input path="userpw" />
    <form:input path="userPostcode" />
    <form:input path="userAddress1" />
    <form:input path="userAddress2" />
  </form:form>
</body>
</html>