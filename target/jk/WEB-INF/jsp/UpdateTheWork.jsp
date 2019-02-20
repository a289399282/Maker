<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人中心</title>

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content_css/bootstrap.min.css"/>
		<script src="${pageContext.request.contextPath}/content_js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content_css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content_css/jquery.mmenu.all.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personalStyle.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/application.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content_css/bootstrap-select.min.css" media="all"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content_css/bootstrap-datetimepicker.min.css"/>
		<script src="${pageContext.request.contextPath}/content_js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/additional-methods.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/jquery.mmenu.all.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/bootstrap-select.min.js" type="text/javascript" charset="utf-8" media="all"></script>
		<script src="${pageContext.request.contextPath}/content_js/defaults-zh_CN.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/bootstrap-datetimepicker.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/nav_left.js" type="text/javascript" charset="utf-8"></script>
    	<script src="${pageContext.request.contextPath}/js/UpdateTheWorkJS.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			.mmDiv {
				display:none;
				}
			.modal-backdrop{
				display: none;	
				}
		</style>
	</head>

	<body>
		<div id="container">

			<header class="clearfix" id="header-sec">

				<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
					<div class="container">
						<div class="navbar-header">
							<a class="navbar-toggle collapsed mmenu-btn" href="#mmenu"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
							<a class="navbar-brand" href="LookProject"><span>创客平台</span></a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right" id="navigation">
								<li class="Lev1">
									<a href="LookProject" class='menu1'>找项目 </a>
								</li>
								<li class="Lev1">
									<a href="LookWork" class='menu1'>找职位 </a>
								</li>
								<li class="Lev1">
									<a href="javacript:void(0)" class="menu1 ">原创中心 <i class="fa fa-chevron-down"></i></a>
								<ul class="drop-down sub-menu2">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="LookVideo" >视频中心</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" href="LookArticle">文章中心</a></li>

									</ul>
								</li>
								<li class="Lev1">
									<a href="LookSudio" class="menu1 ">找工作室</a>
								</li>
								<li class="Lev1">
									<a href="javacript:void(0)" class="menu1 ">荣誉中心  <i class="fa fa-chevron-down"></i></a>
									<ul class="drop-down sub-menu2">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="LookHonorSudio" >工作室榜单</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" href="LookHonorPersonal">个人榜单</a></li>

									</ul>
								</li>
								<li class="Lev1">
									<a href="javacript:void(0)" class="menu1 ">
										<i class="fa fa-user-circle-o"></i></a>
									<ul class="drop-down sub-menu2">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="PersonalIndex" ><i class="fa fa-home"></i> 个人中心</a></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" href="login" ><i class="fa fa-sign-in"></i> 登录|注册</a></li>
										<li role="presentation" class="divider"></li>
										<li role="presentation"><a role="menuitem" tabindex="-1" onclick="loginout()" href="javacript:void(0)"><i class="fa fa-sign-out"></i> 退出</a></li>

									</ul>
								</li>
							</ul>
						</div>
					</div>

				</nav>

			</header>

		</div>

		<nav id="mmenu" class="noDis">
			<div class="mmDiv">
				<div class="MMhead">
					<a href="javacript:void(0)" class="closemenu noblock">X</a>
				</div>
				<ul>
					<li class="m-Lev1 m-nav_4">
						<a href="javacript:void(0)" class="m-menu1">	<i class="fa fa-user"></i></a>
						<ul class="m-submenu">

							<li role="presentation"><a role="menuitem" tabindex="-1" href="PersonalIndex" ><i class="fa fa-home"></i> 个人中心</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="login" ><i class="fa fa-sign-in"></i> 登录|注册</a></li>
							<li role="presentation" class="divider"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" onclick="loginout()" href="javacript:void(0)"><i class="fa fa-sign-out"></i> 退出</a></li>
						</ul>
					</li>
					<li class="m-Lev1 m-nav_0">
						<a href="LookProject">找项目</a>
					</li>
					<li class="m-Lev1 m-nav_0">
						<a href="LookWork">找职位</a>
					</li>
					<li class="m-Lev1 m-nav_3">
						<a href="javacript:void(0)">原创中心</a>
						<ul class="m-submenu">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="LookVideo" >视频中心</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="LookArticle">文章中心</a></li>
						</ul>
					</li>
					<li class="m-Lev1 m-nav_0">
						<a href="LookSudio">找工作室</a>
					</li>
					<li class="m-Lev1 m-nav_2">
						<a href="javacript:void(0)">荣誉中心</a>
						<ul class="m-submenu">
							<li role="presentation"><a role="menuitem" tabindex="-1" href="LookHonorSudio" >工作室榜单</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" href="LookHonorPersonal">个人榜单</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>

<script type="text/javascript">
  $(function(){
    $('ul.dropdown-menu-search li a').click(function(){
      var value = $(this).attr('data');
      var data = $(this).html();
      $('#sousuoleixing').val(value);
      $('#datashowarea').html(data);
      $('.dropdown-menu-search').hide();
    });
    $('.dropdown-toggle-search').click(function(){
      $('.dropdown-menu-search').show();
    });
    $('.select').hover(function(){
      $('.dropdown-menu-search').show();
    },function(){
      $('.dropdown-menu-search').hide();
    });
    var viewWidth = $(window).innerWidth();
    if (viewWidth < 1200) {
      $('.navbar-meun li').css('padding', '0 10px');
    }
  });
</script>
  <div class="row main-user">
    <div class="container main-user-container">
        <div class="row main-user-container-row">
<div class="col-xs-3 col-sm-3 col-md-3 nopadding-left main-user-slider">
            <!--    <div class="role">-->
    <!--        <a href="/my/user">--><!--账户</a>-->
    <!--    </div>-->
	<ul class="list-unstyled onelevel">

		<li>
			<layer id="ulmenus1"><a href="#personalCenter" class="nav-header nav-title" data-toggle="collapse">
				个人中心
				<i id="ulmenusBtn1" class="pull-right pick-up fa fa-minus"></i>
			</a></layer>
			<ul id="personalCenter" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
				<li>
					<a href="PersonalIndex">个人主页</a>
				</li><li>
				<a href="UpdatePersonal">修改用户信息</a>
			</li>
			</ul>
		</li>
		<li>

			<layer id="ulmenus2"><a href="#serviceManagement" class="nav-header nav-title" data-toggle="collapse">
				项目管理
				<i id="ulmenusBtn2" class="pull-right pick-up fa fa-minus"></i>
			</a></layer>
			<ul id="serviceManagement" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
				<li>
					<a href="PersonalTheProject">我的项目</a>
				</li>
				<li>
					<a href="PublishTheProject">发布项目</a>
				</li>
				<li>
					<a href="PersonalProjectOrders">项目订单</a>
				</li>
			</ul>
		</li>

		<li >
			<layer id="ulmenus3">
				<a href="#orderManagement" class="nav-header nav-title" data-toggle="collapse" style="font-size: 15px;">
					工作室管理
					<i id="ulmenusBtn3" class="pull-right pick-up fa fa-minus"></i>
				</a></layer>
			<ul id="orderManagement" class="nav nav-list collapse secondmenu list-unstyled twolevel in">

				<li>
					<a href="ReleaseStudio">创建工作室
					</a>
				</li>

				<li>
					<a href="PersonalStudio">我的工作室
					</a>
				</li>
				<li>
					<a href="PersonalJoinStudio">我加入的工作室
					</a>
				</li>
				<li>
					<a href="PersonalApplyStudio">我申请的工作室
					</a>
				</li>
			</ul>
		</li>


		<li >
			<layer id="ulmenus5">
				<a href="#valueManagement" class="nav-header nav-title" data-toggle="collapse">
					原创管理

					<i id="ulmenusBtn5" class="pull-right pick-up fa fa-minus"></i>
				</a></layer>
			<ul id="valueManagement" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
				<li>
					<a href="PersonalTheArticle">我的文章</a>
				</li>
				<li>
					<a href="PersonalVideo">我的视频</a>
				</li>
				<li>
					<a href="UploadTheArticle">上传文章</a>
				</li>
				<li>
					<a href="UploadVideo">上传视频</a>
				</li>
			</ul>
		</li>

		<li>
			<layer id="ulmenus6">
				<a href="#myFavorite" class="nav-header nav-title" data-toggle="collapse">
					职位管理

					<i id="ulmenusBtn6" class="pull-right pick-up fa fa-minus"></i>
				</a></layer>
			<ul id="myFavorite" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
				<li>
					<a href="PersonalJoinWork">我的职位</a>
				</li>
				<li>
					<a href="PublishTheWork">发布职位</a>
				</li>
				<li>
					<a href="PersonalApplyWork">我申请的职位</a>
				</li>
				<li>
					<a href="PersonalTheWork">我发布的职位</a>
				</li>
			</ul>
		</li>

		<li>
			<layer id="ulmenus7">
				<a href="#safety" class="nav-header nav-title" data-toggle="collapse">
					安全
					<i id="ulmenusBtn7" class="pull-right pick-up fa fa-minus"></i>
				</a></layer>
			<ul id="safety" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
				<li>
					<a href="UpdatePassword">修改登录密码</a>
				</li>
				<li>
					<a href="UpdatePhone">修改手机</a>
				</li>
			</ul>
		</li>
	</ul>
</div>
	

<div class="col-sm-12 col-md-12 col-lg-12 main-user-content nopadding-right bg-color-f">
	<div class="main-content">
		<div class="col-md-12 nopadding">
			<div class="col-sm-12 col-md-12 col-lg-12 nopadding">
				<div class="refound-account fund-account board">
					<h1 class="lead pd-t-20">修改职位信息
						<span class="pull-right">
							<!--<a href="javacript:void(0)" class="btn btn-primary btn-primary-white btn-sm">修改密码</a>
							<a href="javacript:void(0)" class="btn btn-primary btn-primary-white btn-sm">修改支付密码</a></span>-->
					</h1>
					<form class="form-horizontal" method="post" id="UpWorkFrom">
						<div class="form-group">
		    					<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>职位名称: </label>
		   							 <div class="col-sm-5 col-md-5 col-lg-5" style="padding-right: 0">
		                        	<input type="text" value="" id="IdposName" name="posName"  class="form-control " placeholder="请输入职位名称..." >
		       						<label id="IdposName-error" class="red error" for="IdposName"></label>
		   					</div>
						</div>
					<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>招聘人数：</label>
							<div class="col-sm-5 col-md-5 col-lg-5" style="padding-right: 0">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
									<input class="form-control"  id="IdposAmount" type="text" name="posAmount" value="" placeholder="请输入招聘人数...">
								</div>
							<label id="IdposAmount-error" class="red error" for="IdposAmount"></label>
							</div>
							
						</div>

						<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>截止时间：</label>
							<div class="col-sm-5 col-md-5 col-lg-5" style="padding-right: 0">
							<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
									<input class="form-control input_public" id="IdposEndtime" type="text" name="posEndtime" value="" placeholder="请输入截止时间...">
								</div>
							<label id="IdposEndtime-error" class="red error" for="IdposEndtime"></label>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>职位要求：</label>
							<div class="col-sm-8 col-md-8 col-lg-8">
							<div>
								<textarea id="IdposInfo" class="form-control" required="required" name="posInfo" cols="" rows="5" maxlength="300" onchange="this.value=this.value.substring(0, 300)" onkeydown="this.value=this.value.substring(0, 300)" onkeyup="this.value=this.value.substring(0, 300)" placeholder="可输入300字.."></textarea>
								</div>
								<label id="IdposInfo-error" class="red error" for="IdposInfo"></label>
							</div>
						</div> 
							<div class="form-group">
								<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>选择个人或工作室发布：</label>
								<div class="col-sm-3 col-md-3 col-lg-3">
								<select id="IdposMemId" name="posMemId" required="required" class="selectpicker" data-live-search="true">
									<option disabled>---请选择---</option>
									<option value="null">个人</option>
								</select>
								<label id="IdposMemId-error" class="red error" for="IdposMemId"></label>
								</div>
							</div>

					  <div class="form-group"><br>
						<label class="col-sm-3 col-md-3 control-label"></label>
							<div class="col-sm-5 col-md-5">
							<input class="col-md-6 btn btn-primary" id="Subtn" type="submit" value="保存">
							</div>
						</div>
					</form>
				</div>
			</div>

			
		</div>
	</div>
</div>


      </div>
    </div>
</div>
<!-- /container -->
<footer>
      <div class="container" align="center">
            <span>   版权所有 2009 广东理工职业学院　|　联系电话: (020)83505073　|　粤ICP备05008834号-4
<p>学院信箱: xb@gdrtvu.edu.cn　|　党委信箱: dw@gdrtvu.edu.cn　|　校长信箱: xz@gdrtvu.edu.cn </p></span>
    </div>
</footer>

</body>

</html>


