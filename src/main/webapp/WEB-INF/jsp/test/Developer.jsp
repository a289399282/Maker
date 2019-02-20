<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加开发人员</title>

</head>
<body> 
开发人员登录：
<c:if test="${sessionScope.developer == null}">
  		欢迎光临,游客
  		<a href="${pageContext.request.contextPath }/Devadd">注册</a>
  		<a href="${pageContext.request.contextPath }/Devlogin">登录</a>
</c:if>
<c:if test="${sessionScope.developer != null}">
	欢迎回来,${sessionScope.developer.devTruename } <a href="${pageContext.request.contextPath }/developer/logoutDev">注销</a>
<br/>
		开发人员信息：
		<table width="100%" border=1>
		<tr>
			<td>开发人员Id</td>
			<td><input type="text" name="devId" value="${sessionScope.developer.devId }"/></td>
		</tr>
		<tr>
			<td>开发人员真实姓名</td>
			<td><input type="text" name="devTruename" value="${sessionScope.developer.devTruename }"/></td>
		</tr>
		<tr>
			<td>登录密码</td>
			<td><input type="text" name="devPassword" value="${sessionScope.developer.devPassword }"/></td>
		</tr>
		<tr>
			<td>学号</td>
			<td><input type="text" name="devNumber" value="${sessionScope.developer.devNumber }"/></td>
		</tr>
		<tr>
			<td>学校</td>
			<td><input type="text" name="devSchool" value="${sessionScope.developer.devSchool }"/></td>
		</tr>
		<tr>
			<td>身份证</td>
			<td><input type="text" name="devIdcard" value="${sessionScope.developer.devIdcard }"/></td>
		</tr>
		<tr>
			<td>所在地</td>
			<td><input type="text" name="devLocation" value="${sessionScope.developer.devLocation }"/></td>
		</tr> 
		<tr>
			<td>电话</td>
			<td><input type="text" name="devPhone" value="${sessionScope.developer.devPhone }"/></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="devEmail" value="${sessionScope.developer.devEmail }"/></td>
		</tr> 
		<tr>
			<td>特长</td>
			<td><input type="text" name="devSpeciality" value="${sessionScope.developer.devSpeciality }"/></td>
		</tr> 
		<tr>
			<td>图片</td>
			<td>
				<img alt="" src="${request.getSession().getServletContext().getRealPath('/') }WEB-INF/img/developerImg/${sessionScope.developer.devImg }">
			</td>
		</tr>
		<tr>
			<td>个人简介</td>
			<td>
			<textarea rows="3" cols="30" name="devInfo" value="${sessionScope.developer.devInfo }"></textarea>
			</td>
		</tr>

		</table>
</c:if>
</body>

</html>