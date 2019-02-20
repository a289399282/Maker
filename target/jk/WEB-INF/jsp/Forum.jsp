<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加开发人员</title>
<script type="text/javascript">
	function addOne() {
		var fdiv = document.getElementById("fdiv");
		fdiv.innerHTML += '<div><input type="file" name="video" /><input type="button" value="不要了.." onclick="delOne(this)"/><br><div>';
	}

	function delOne(obj) {
		obj.parentNode.parentNode.removeChild(obj.parentNode);
	}
</script>
</head>
<body>
	开发人员登录：
	<c:if test="${sessionScope.developer == null}">
  		欢迎光临,游客
  		<a href="${pageContext.request.contextPath }/Devadd">注册</a>
		<a href="${pageContext.request.contextPath }/Devlogin">登录</a>
	</c:if>
	<c:if test="${sessionScope.developer != null}">
	欢迎回来,${sessionScope.developer.devTruename } <a
			href="${pageContext.request.contextPath }/developer/logoutDev">注销</a>
		<br />
	</c:if>
	<form
		action="${pageContext.request.contextPath }/download/downloadVideo"
		method="post" enctype="multipart/form-data">
		<h2>下载作品：</h2>
		<table width="100%" border=1>
			<tr>
				<td>名字</td>
				<td><input type="text" name="file" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>

	<br />

	<form action="${pageContext.request.contextPath }/forum/forwardFor"
		method="post" enctype="multipart/form-data">
		<h2>转发作品：</h2>
		<table width="100%" border=1>
			<tr>
				<td>作品Id</td>
				<td><input type="text" name="forumId" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>

	<br />

	<form action="${pageContext.request.contextPath }/forum/addForText"
		method="post" enctype="multipart/form-data">
		<h2>添加文字作品：</h2>
		<table width="100%" border=1>
			<tr>
				<td>forumStart</td>
				<td><input type="text" name="forumStart" /></td>
			</tr>
			<tr>
				<td>forumName</td>
				<td><input type="text" name="forumName" /></td>
			</tr>
			<tr>
				<td>forumInfo</td>
				<td><input type="text" name="forumInfo" />
				</td>
			</tr>
			<tr>
				<td>forumText</td>
				<td><input type="text" name="forumText" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>
	</form>

	<br />

	<form action="${pageContext.request.contextPath }/forum/addForVideo"
		method="post" enctype="multipart/form-data">
		<h2>上传视频作品</h2>
		<hr>
		<input type="button" id="addBut" onclick="addOne()" value="加一个..." />

		<div id="fdiv"><input type="file" name="video" /></div>
		<tr>
			<td>forumStart</td>
			<td><input type="text" name="forumStart" /></td>
		</tr>
		<tr>
			<td>forumName</td>
			<td><input type="text" name="forumName" /></td>
		</tr>
		<tr>
			<td>forumInfo</td>
			<td><input type="text" name="forumInfo" />
			</td>
		</tr>
		<input type="submit" value="上传" />

	</form>
</body>

</html>