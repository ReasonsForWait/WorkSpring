<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <p>data1 : ${param.data1}</p>
  <p>data2 : ${param.data2}</p>
  <!-- <p>data3 : ${paramValues.data3[0]}</p>
  <p>data3 : ${paramValues.data3[1]}</p> -->
  <c:forEach items="${paramValues.data3}" var="n">
    <!-- <c:out value="data3: ${n}" /> -->
    <p>data3 : ${n}</p>
  </c:forEach>
</body>
</html>