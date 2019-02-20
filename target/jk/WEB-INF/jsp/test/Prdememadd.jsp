<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>参加竞标</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/prodetamem/insertPrdemem" method="post" enctype="multipart/form-data">
参加竞标：
<table width="100%" border=1>
<tr>
	<td>项目id</td>
	<td><input type="text" name="proId" value=""/></td>
</tr>
<tr>
	<td>参加竞标的人员(工作室)id</td>
	<td><input type="text" name="prdememId" value=""/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>