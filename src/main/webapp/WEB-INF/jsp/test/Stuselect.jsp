<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询工作室</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/studio/selectStu" method="post" enctype="multipart/form-data">

查询工作室信息：
<table width="100%" border=1>
<tr>
	<td>工作室id</td>
	<td><input type="text" name="stuId" value=""/></td>
</tr>
<tr>
	<td>负责人的id</td>
	<td><input type="text" name="devId" value=""/></td>
</tr>
<tr>
	<td>工作室名字</td>
	<td><input type="text" name="stuName" value=""/></td>
</tr>
<tr>
	<td>特长</td>
	<td><input type="text" name="stuSpeciality" value=""/></td>
</tr>
<tr>
	<td>所在城市</td>
	<td><input type="text" name="stuLocation" value=""/></td>
</tr> 
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>