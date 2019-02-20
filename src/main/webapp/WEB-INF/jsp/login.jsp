<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0033)https://demo.genban.org/demo/566/ -->
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录注册</title>
		<script src="${pageContext.request.contextPath}/content_js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/LoginStyle.css"/>
		<script src="${pageContext.request.contextPath}/content_js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/jquery.cookie.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/additional-methods.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/LoginJS.js" type="text/javascript" charset="utf-8"></script>
	
	</head>

	<body>
		<div class="form" style="display: block;">
			<div id="landing" class="border-btn">登陆</div>
			<div id="registered">注册</div>
			<div class="fix"></div>
			<div id="landing-content">
				<form id="login_form">
				<div class="inp"><input type="text" id="dev_phone" name="zhanghao" placeholder="手机号码"><label for="zhanghao"></label></div>
				<div class="inp"><input type="password" id="dev_password" name="devPassword" placeholder="密码"><label for="devPassword"></label></div>
				<div class="inp yzm"><input class="input-val" name="code" id="yzm" type="text" placeholder="验证码"> <img src="/Maker/checkImg" class="yzm" id="yzmPic" onclick="myRefersh()" title="点击刷新验证码"/><label for="yzm" class="error"></label></div>
				<div class="chbox">
					<div><input type="checkbox" name="remPassword" id="remPassword" value="记住密码" /><span>记住密码</span></div>
					<div><input type="checkbox" name="autoLogin" id="autoLogin" value="自动登录" /><span>自动登录</span></div>
				</div>
				<label><div class="btn"><input type="submit"class="btn_inp" name="login_btn" id="login_btn" value="登录" /></div></label>
				</form>
			</div>
			<div id="registered-content">
				<form id="registered_form">
				<div class="inp"><input type="text" id="dev_phone_re" name="devPhone" placeholder="手机号码"><label for="devPhone"></label></div>
				<div class="inp"><input type="password" id="dev_password_re" name="devPassword" placeholder="密码"><label for="devPassword"></label></div>
				<div class="inp"><input type="password" id="confirm_password" name="confirm_password" placeholder="请再次输入密码"><label for="confirm_password"></label></div>
				<label><div class="btn"><input type="submit"class="btn_inp" name="registered_btn" id="registered_btn" value="立即注册" /></div></label>
				</form>	
			</div>
		</div>
	

</body></html>