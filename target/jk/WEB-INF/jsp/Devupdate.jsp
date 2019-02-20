<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改开发人员信息</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/forumImg/insertforumImg" method="post" enctype="multipart/form-data">
修改开发人员信息：
<table width="100%" border=1>
<!-- <tr>
	<td>开发人员id</td>
	<td><input type="text" name="devId"/></td>
</tr>
<tr>
	<td>登录密码</td>
	<td><input type="text" name="devPassword"/></td>
</tr> -->
<tr>
	<td>用户名</td>
	<td><input type="text" name="devName"/></td>
</tr>
<tr>
	<td>学号</td>
	<td><input type="text" name="devNumber"/></td>
</tr>
<tr>
	<td>学校</td>
	<td><input type="text" name="devSchool"/></td>
</tr>
<!-- <tr>
	<td>身份证</td>
	<td><input type="text" name="devIdcard"/></td>
</tr> -->
<tr>
	<td>所在地</td>
	<td><input type="text" name="devLocation"/></td>
</tr> 
<!-- <tr>
	<td>电话</td>
	<td><input type="text" name="devPhone"/></td>
</tr>
<tr>
	<td>邮箱</td>
	<td><input type="text" name="devEmail"/></td>
</tr>  -->
<tr>
	<td>特长</td>
	<td><input type="text" name="devSpeciality"/></td>
</tr> 
<tr>
	<td>图片</td>
	<td>
		<input type="file"  name="forumPic"/>
	</td>
</tr>
<tr>
	<td>个人简介</td>
	<td>
	<textarea rows="3" cols="30" name="devInfo"></textarea>
	</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>