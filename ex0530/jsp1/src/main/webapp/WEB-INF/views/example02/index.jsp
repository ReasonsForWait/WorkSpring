<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <h1>요청 응답 파라미터 예제</h1>
  <hr>
  <h2>첫번째 예제</h2>
  <a href="example02/test1?data1=100&data2=200&data3=300&data3=400">test1 get</a>
  <hr>
  <h2>두번째 예제</h2>
  <form action="example02/test2" method="post">
    <label for="data1">data1 : </label><input type="text" id="data1" name="data1"><br>
    <label for="data2">data2 : </label><input type="text" id="data2" name="data2"><br>
    <label>data3 : 
      <input type="checkbox" value="300" name="data3">data3 300<br>
      <input type="checkbox" value="400" name="data3">data3 400<br>
    </label>
    <button>test2 post</button>
    <hr>
    <h2>세번째 예제</h2>
    <a href="example02/test3/100/200/300">test3 get</a>
    <hr>
    <h2>네번째 예제</h2>
    <a href="example02/test4/100,200,300">test4 get</a>
    <hr>
    <h2>다섯번째 예제</h2>
    <a href="example02/test5?data1=100&data2=200&data3=300&data3=400">test5 get</a>
    <hr>
    <h2>여섯번째 예제</h2>
    <a href="example02/test6?data1=100">test6 get</a>
  </form>
</body>
</html>