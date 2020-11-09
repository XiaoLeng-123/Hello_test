<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="hello">哈哈哈</a>


<br>


<!-- 使用rest风格来发送请求 -->
<a href="hello">查询</a>
<br>

<form action="hello1" method="post">
	<input type="submit">添加

</form>
<br>
<form action="hello2" method="post">
	<input name="_method" value="put" type="hidden">
	<input type="submit">更新

</form>
<br>
<form action="hello3" method="post">
	<input name="_method" value="delete"  type="hidden">
	<input type="submit">删除

</form>


</body>
</html>