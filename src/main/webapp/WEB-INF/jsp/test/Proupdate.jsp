<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改项目信息</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/project/updatePro" method="post" enctype="multipart/form-data">

修改项目信息：
<table width="100%" border=1>
<tr>
	<td>项目id</td>
	<td><input type="text" name="proId"/></td>
</tr>

<tr>
	<td>创建人(工作室)id</td>
	<td><input type="text" name="proPublisher" value=""/></td>
</tr>
<tr>
	<td>创建人(工作室)名字</td>
	<td><input type="text" name="proPubname" value=""/></td>
</tr>
<tr>
	<td>标题名</td>
	<td><input type="text" name="proName" /></td>
</tr>
<tr>
	<td>类型</td>
	<td><input type="text" name="proType"/></td>
</tr>
<tr>
	<td>Money</td>
	<td><input type="text" name="proMoney" /></td>
</tr> 
<tr>
	<td>项目结束时间</td>
	<td><input type="text" name="proEndtime"/></td>
</tr>
<tr>
	<td>发布时间</td>
	<td><input type="text" name="proReltime"/></td>
</tr>
<tr>
	<td>人气</td>
	<td><input type="text" name="proHeat"/></td>
</tr> 
<!-- <tr>
	<td>Money2</td>
	<td><input type="text" name="money2" value=""/></td>
</tr>  -->
<tr>
	<td>城市</td>
	<td><input type="text" name="proCity"/></td>
</tr> 
<tr>
	<td>状态</td>
	<td><input type="text" name="proState"/></td>
</tr> 
<tr>
	<td>项目简介</td>
	<td>
	<textarea rows="3" cols="30" name="proInfo"></textarea>
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