<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <h1>응답 파라미터 예제</h1>
  <hr>
  <h2>첫번째 예제</h2>
  <a href="example03/test1?data1=100&data2=200">test1</a>
  <hr>
  <h2>두번째 예제</h2>
  <form action="example03/test2" method="post">
    Data1 : <input type="text" name="data1" id="data1">
    Data2 : <input type="text" name="data2" id="data2">
    Data3 : <input type="text" name="data3" id="data3">
    Data3 : <input type="text" name="data3" id="data3">
    <button>전송</button>
  </form>
</body>
</html>