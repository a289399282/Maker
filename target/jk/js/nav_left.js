	function loginout(){
		$.ajax({ 
		  	type:"POST",//为post请求
		  	url:"/Maker/developer/logoutDev",//这是我在后台接受数据的文件名
		    error: function (request) {
	            alert("连接超时");
	        },
		  	success:function(data){
		  		if(data.code=="1"){
		  		  alert(data.msg);
		  			 location.href ="login";  //成功执行 ,跳转页面
		  		} 
		  
		  	} 
		  });
	}

var $ = jQuery.noConflict();

$(document).ready(function($) {

	$('#container').delay(400).addClass('active');

	/*-------------------------------------------------*/
	/* =  Search animation
	/*-------------------------------------------------*/
	
	var searchToggle = $('.open-search'),
		inputAnime = $(".form-search"),
		body = $('body');

	searchToggle.on('click', function(event){
		event.preventDefault();

		if ( !inputAnime.hasClass('active') ) {
			inputAnime.addClass('active');
		} else {
			inputAnime.removeClass('active');			
		}
	});

	body.on('click', function(){
		inputAnime.removeClass('active');
	});

	var elemBinds = $('.open-search, .form-search');
	elemBinds.bind('click', function(e) {
		e.stopPropagation();
	});



	/* ---------------------------------------------------------------------- */
	/*	Header animate after scroll
	/* ---------------------------------------------------------------------- */

	(function() {

		var docElem = document.documentElement,
			didScroll = false,
			changeHeaderOn = 50;
			document.querySelector( 'header' );
		function init() {
			window.addEventListener( 'scroll', function() {
				if( !didScroll ) {
					didScroll = true;
					setTimeout( scrollPage, 100 );
				}
			}, false );
		}
		
		function scrollPage() {
			var sy = scrollY();
			if ( sy >= changeHeaderOn ) {
				$( 'header' ).addClass('active');
			}
			else {
				$( 'header' ).removeClass('active');
			}
			didScroll = false;
		}
		
		function scrollY() {
			return window.pageYOffset || docElem.scrollTop;
		}
		
		init();
		
	})();

});

	$(function(){
				$("#btn").click(function(){
					$(".mmDiv").css("display","block");
				});
			});
			jQuery(document).ready(function($) {
				var mmenu = $('nav#mmenu').mmenu({
					slidingSubmenus: true,
					classes: 'mm-white', //mm-fullscreen mm-light
					extensions: ["theme-white"],
					offCanvas: {
						position: "right", //left, top, right, bottom
						zposition: "front" //back, front,next
						//modal		: true
					},
					searchfield: false,
					counters: false,
					//navbars		: {
					//content : [ "prev", "title", "next" ]
					//},
					navbar: {
						title: "网站导航"
					},
					header: {
						add: true,
						update: true,
						title: "网站导航"
					}
				});
				$(".closemenu").click(function() {
					var mmenuAPI = $("#mmenu").data("mmenu");
					mmenuAPI.close();
				});
			});

$(function(){
	$("#ulmenus1").click(function(){
		if($("#ulmenusBtn1").hasClass("fa-minus")){
			$("#ulmenusBtn1").removeClass("fa fa-minus");
			$("#ulmenusBtn1").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn1").removeClass("fa fa-plus");
			$("#ulmenusBtn1").addClass("fa fa-minus");
			
		}
	});
	$("#ulmenus2").click(function(){
		if($("#ulmenusBtn2").hasClass("fa-minus")){
			$("#ulmenusBtn2").removeClass("fa fa-minus");
			$("#ulmenusBtn2").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn2").removeClass("fa fa-plus");
			$("#ulmenusBtn2").addClass("fa fa-minus");
			
		}
	});
	$("#ulmenus3").click(function(){
		if($("#ulmenusBtn3").hasClass("fa-minus")){
			$("#ulmenusBtn3").removeClass("fa fa-minus");
			$("#ulmenusBtn3").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn3").removeClass("fa fa-plus");
			$("#ulmenusBtn3").addClass("fa fa-minus");
			
		}
	});
	$("#ulmenus4").click(function(){
		if($("#ulmenusBtn4").hasClass("fa-minus")){
			$("#ulmenusBtn4").removeClass("fa fa-minus");
			$("#ulmenusBtn4").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn4").removeClass("fa fa-plus");
			$("#ulmenusBtn4").addClass("fa fa-minus");
			
		}
	});
	$("#ulmenus5").click(function(){
		if($("#ulmenusBtn5").hasClass("fa-minus")){
			$("#ulmenusBtn5").removeClass("fa fa-minus");
			$("#ulmenusBtn5").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn5").removeClass("fa fa-plus");
			$("#ulmenusBtn5").addClass("fa fa-minus");
			
		}
	});
	$("#ulmenus6").click(function(){
		if($("#ulmenusBtn6").hasClass("fa-minus")){
			$("#ulmenusBtn6").removeClass("fa fa-minus");
			$("#ulmenusBtn6").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn6").removeClass("fa fa-plus");
			$("#ulmenusBtn6").addClass("fa fa-minus");
			
		}
	});
	$("#ulmenus7").click(function(){
		if($("#ulmenusBtn7").hasClass("fa-minus")){
			$("#ulmenusBtn7").removeClass("fa fa-minus");
			$("#ulmenusBtn7").addClass("fa fa-plus");
		}else{
			$("#ulmenusBtn7").removeClass("fa fa-plus");
			$("#ulmenusBtn7").addClass("fa fa-minus");
			
		}
	});
});