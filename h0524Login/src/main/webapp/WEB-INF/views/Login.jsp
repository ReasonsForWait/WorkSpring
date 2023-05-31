<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <form action="result1" method="post">
            <h1>1. 기본정보</h1>
            이름 : <br>
            <input type="text" name="name" id="name" /><br>
            Email : <br>
            <input type="email" name="email" id="email" /><br>
            비밀번호 : <br>
            <input type="password" name="pw" id="pw" /><br>

            나이 : <br>
            <input type="radio" name="age" value="over_13" /> 13살 이상
            <input type="radio" name="age" value="under_13" /> 13살 미만

            <h1>2. 추가정보</h1>
            주요 업무 : <br>
            <textarea name="career" id="career" cols="30" rows="10"></textarea><br>
            주요 직업 : <br>
            <select name="major" id="major">
                <option value="front">front-end</option>
                <option value="back">back-end</option>
                <option value="dev">dev-ops</option>
            </select>
            <br>
            관심 분야 : <br>
            <input type="checkbox" name="interest" value="development"/> Development <br>
            <input type="checkbox" name="interest" value="design"/> Design <br>
            <input type="checkbox" name="interest" value="business" /> Business <br>

            <button>가입하기</button>
        </form>
    </div>
</body>
</html>