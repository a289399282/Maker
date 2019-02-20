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
		<title>荣誉中心</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/content_css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/content_css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/content_css/jquery.mmenu.all.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/application.css" media="all">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/personalStyle.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/studio.css" media="all"/>
		<script src="${pageContext.request.contextPath }/content_js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/content_js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/content_js/jquery.mmenu.all.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/nav_left.js" type="text/javascript" charset="utf-8"></script>
    	<script src="${pageContext.request.contextPath }/js/LookHonorPersonalJS.js" type="text/javascript" charset="utf-8"></script>
    	
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
 <div class="container" style="padding-top:35px !important;">
        <div class="row not-padding">
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 nopadding-left">
            <!--    <div class="role">-->
    <!--        <a href="/my/user">--><!--账户</a>-->
    <!--    </div>-->
      <div id="tab-html" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 tab-content-container">
            <!--全部-->
          <label><h2><span class="green">|</span> 个人荣誉榜单</h2></label>
            <div class="tab-content-all">
		
	

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
