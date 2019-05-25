<%--
  Created by IntelliJ IDEA.
  User: gwonbyeong-yun
  Date: 2019-05-24
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="/print" method="post">
    <div>
        URL : <input id="url" name="url" type="text" value=""/>
    </div>
    <div>
        TYPE : <select id="type" name="type">
        <option value="html">Html</option>
        <option value="text">Text</option>
    </select>
    </div>
    <div>
        출력묶음단위(자연수) : <input id="num" name="num" type="text" value="">
    </div>
    <div>
        <button type="submit">출력</button>
    </div>
    <div>
        몫 : ${content.quotient}
    </div>
    <div>
        나머지: ${content.remainder}
    </div>
</form>

</body>
</html>
