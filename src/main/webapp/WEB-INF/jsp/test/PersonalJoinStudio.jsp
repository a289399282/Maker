<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/content_css/bootstrap-table.min.css"/>
		<script src="${pageContext.request.contextPath}/content_js/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/content_js/jquery.mmenu.all.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/nav_left.js" type="text/javascript" charset="utf-8"></script>
    	<script src="${pageContext.request.contextPath}/js/PersonalJoinStudioJS.js" type="text/javascript" charset="utf-8"></script>
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
		<!--
        	描述：查看详情模态框
        -->
		    <div class="modal fade" id="CheckDetailsModel" tabindex="-1" role="dialog"
                         aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">工作室详情</h4>
                                </div>
                                <div class="modal-body">
                                    <form  class="form-horizontal" id="updateCompetition">
                                 	<div class="form-group" >
										<label class="col-sm-3 col-md-3 col-lg-3 control-label">工作室头像：</label>
										<div class="col-sm-5 col-md-5 col-lg-5" >
											<div class="input-group mid">
												<div class="touxiang"><img src="" id="IdstuImg" title="" alt="" /></div>
											</div>
										</div>
									</div>   		
						<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>电话号码：</label>
							<div class="col-sm-6 col-md-6 col-lg-6" style="padding-right: 0">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
									<input class="form-control input_public" disabled="disabled" id="IpstuPhone" type="text" name="stuPhone" value="">
								</div>
							<label id="IpstuPhone-error" class="red error" for="IpstuPhone"></label>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>邮箱：</label>
							<div class="col-sm-6 col-md-6 col-lg-6" style="padding-right: 0">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
									<input class="form-control input_public" disabled="disabled" id="IpstuEmail" type="email" name="stuEmail" value="" >
								</div>
							<label id="IpstuEmail-error" class="red error" for="IpstuEmail"></label>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label"><span class="red">*</span>所在地：</label>
							<div class="col-sm-6 col-md-6 col-lg-6" style="padding-right: 0">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
									<input class="form-control input_public" disabled="disabled" id="IpstuLocation" type="text" name="stuLocation" value="" >
								</div>
							<label id="IpstuLocation-error" class="red error" for="IpstuLocation"></label>
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-3 col-md-3 col-lg-3 control-label">工作室简介：</label>
							<div class="col-sm-8 col-md-8 col-lg-8">
								<textarea class="form-control" id="IdstuInfo" disabled="disabled" name="stuInfo" cols="" rows="5"></textarea>
								<label></label>
							</div>
						</div> 
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">关闭
                                            </button>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
		<div id="container">

			<header class="clearfix" id="header-sec">

				<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
					<div class="container">
						<div class="navbar-header">
							<a class="navbar-toggle collapsed mmenu-btn" href="#mmenu"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
							<a class="navbar-brand" href="javascript:;"><span>创客平台</span></a>
						</div>
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav navbar-right" id="navigation">
								<li class="Lev1">
									<a href="#" class='menu1'>找项目 </a>
								</li>
								<li class="Lev1">
									<a href="#" class='menu1'>找服务 </a>
								</li>
								<li class="Lev1">
									<a href="#" class='menu1'>找工作 </a>
								</li>
								
								<li class="Lev1">
									<a href="#" class="menu1 ">创客讲堂</a>

								</li>
								<li class="Lev1">
									<a href="#" class="menu1 ">原创中心</a>

								</li>
								<li class="Lev1">
									<a href="#" class="menu1 ">找工作室</a>
								</li>
								<li class="Lev1">
									<a href="#" class="menu1 ">荣誉中心</a>
								</li>
								<li class="Lev1">
									<a href="#" class="menu1 ">
										<i class="fa fa-user"></i></a>
									<ul class="drop-down sub-menu2">
										<li role="presentation"><a role="menuitem" tabindex="-1" href="personalIndex" ><i class="fa fa-home"></i> 个人中心</a></li>
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
					<a href="javascript:" class="closemenu noblock">X</a>
				</div>
				<ul>
					<li class="m-Lev1 m-nav_4">
						<a href="javascript:;" class="m-menu1">	<i class="fa fa-user"></i></a>
						<ul class="m-submenu">

							<li role="presentation"><a role="menuitem" tabindex="-1" href="personalIndex" ><i class="fa fa-home"></i> 个人中心</a></li>
							<li role="presentation" class="divider"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1" onclick="loginout()" href="javacript:void(0)"><i class="fa fa-sign-out"></i> 退出</a></li>
						</ul>
					</li>
					<li class="m-Lev1 m-nav_0">
						<a href="#">找项目</a>
					</li>

					<li class="m-Lev1 m-nav_0">
						<a href="#">找工作</a>
					</li>

					<li class="m-Lev1 m-nav_0">
						<a href="#">原创中心</a>
					</li>
					<li class="m-Lev1 m-nav_0">
						<a href="#">找工作室</a>
					</li>
					<li class="m-Lev1 m-nav_0">
						<a href="#">荣誉中心</a>
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
                    <a href="personalIndex">个人主页</a>
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
					<a href="PublishTheProject">项目订单</a>
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

				<li class="current">
					<a href="PersonalStudio">我的工作室
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
                        <a href="personalTheArticle">我的文章</a>
                    </li>
                    <li>
                        <a href="personalVideo">我的视频</a>
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
					工作管理

					<i id="ulmenusBtn6" class="pull-right pick-up fa fa-minus"></i>
				</a></layer>
			<ul id="myFavorite" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
				<li>
					<a href="PersonalTheWork">我的工作</a>
				</li>
				<li>
					<a href="PublishTheWork">发布工作</a>
				</li>
			</ul>
		</li>




        <li >
        	<layer id="ulmenus7">
            <a href="#safety" class="nav-header nav-title" data-toggle="collapse">
      			          安全
                <i id="ulmenusBtn7" class="pull-right pick-up fa fa-minus"></i>
            </a></layer>
            <ul id="safety" class="nav nav-list collapse secondmenu list-unstyled twolevel in">
                <li class="">
                    <a href="#">修改登录密码</a>
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
					<h1 class="lead pd-t-20">我的加入工作室
						<span class="pull-right">
							<!--<a href="javacript:void(0)" onclick="removeMuch()" class="btn btn-primary btn-primary-white btn-sm">关闭多个工作室</a>-->
							<!--<a href="javacript:void(0)" class="btn btn-primary btn-primary-white btn-sm">修改支付密码</a></span>-->
					</h1>	
					<table id="JoinStudioTable"></table>
						
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
    <div class="container">
        
    </div>
</footer>

</body>
</html>


