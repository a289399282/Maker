<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改成员的权限</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/studiomem/updateStumem" method="post" enctype="multipart/form-data">
更改成员的权限：
<table width="100%" border=1>
<tr>
	<td>开发人员id</td>
	<td><input type="text" name="devId" value=""/></td>
</tr>
<tr>
	<td>工作室Id</td>
	<td><input type="text" name="stuId" value=""/></td>
</tr>
<tr>
	<td>是否批准开发人员入会</td>
	<td><input type="text" name="stumemIs" value=""/></td>
</tr>
<tr>
	<td>开发人员的权限</td>
	<td><input type="text" name="stumemPower" value=""/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>