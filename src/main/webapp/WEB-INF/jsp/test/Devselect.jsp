<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询开发人员信息</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/developer/selectDev" method="post" enctype="multipart/form-data">

查询开发人员信息：
<table width="100%" border=1>
<tr>
	<td>开发人员真实姓名</td>
	<td><input type="text" name="devTruename" value=""/></td>
</tr>
<tr>
	<td>学号</td>
	<td><input type="text" name="devNumber" value=""/></td>
</tr>
<tr>
	<td>学校</td>
	<td><input type="text" name="devSchool" value=""/></td>
</tr>

<tr>
	<td>所在地</td>
	<td><input type="text" name="devLocation" value=""/></td>
</tr> 
<tr>
	<td>电话</td>
	<td><input type="text" name="devPhone" value=""/></td>
</tr>

<tr>
	<td>特长</td>
	<td><input type="text" name="devSpeciality" value=""/></td>
</tr> 
<tr>
	<td>分页</td>
	<td><input type="text" name="page" value=""/></td>
</tr> 
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>