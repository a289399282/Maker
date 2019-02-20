<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开发人员登录</title>

</head>
<body> 

<form action="${pageContext.request.contextPath }/developer/loginDev" method="post" enctype="multipart/form-data">
开发人员登录：
<c:if test="${sessionScope.developer == null}">
  		欢迎光临,游客
  		<a href="${pageContext.request.contextPath }/Devadd">注册</a>
  		
  	</c:if>
  	<c:if test="${sessionScope.developer != null}">
  		欢迎回来,${sessionScope.developer.devTruename }
  		
  	</c:if>

<table width="100%" border=1>
<tr>
	<td>开发人员id或电话号码</td>
	<td><input type="text" name="zhanghao"/></td>
</tr>
<tr>
	<td>登录密码</td>
	<td><input type="text" name="devPassword" value=""/></td>
</tr>
<tr>
	<td><img src="/Maker/checkImg" onclick="" title="点击刷新验证码"/></td>
	<td><input type="text" name="code" value=""/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>