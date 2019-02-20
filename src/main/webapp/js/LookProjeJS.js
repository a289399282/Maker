//入口
$(document).ready(function(){
	getAllProject();
    $('#nav-search-input').change(function() {
        AjaxAllProject(1,$('#nav-search-input').val());
    });
});

//自定义函数

/*
 *分页按钮事件注册
 * */
function registerEvent(){
	$(".pageCommon").click(function(){
		var fenye = $(this).attr("fenye");
		if(fenye){
			// $(".pagination").find("li").removeClass("active");
			// $(this).addClass("active");

                AjaxAllProject(parseInt(fenye),$('#nav-search-input').val());
			
			
		}
	});
}







/*
 * 获取项目全部项目
 * 
 * 
 */
function getAllProject(){
	
	AjaxAllProject(1,"");
	 AjaxAllProjectRank();
}
/*
 * 请求项目列表
 * 参数:fenye   第几页
 * 	  fieldSearch 搜索字段(选填)
 */
function AjaxAllProject(fenye,fieldSearch){
	var object = new Object();
	
		object.fenye = fenye;
    object.proName = (fieldSearch?fieldSearch:"");
	$.ajax({
		url:'/Maker/project/selectProAll',
//		dataType:"json",
		type:"POST",
		async:true,
		data:object,
		success:function(data){
			GenerAllProjectList(data);
		},
		error:function(error){
			alert('请求异常');
		}
	});
}
//排行榜
function AjaxAllProjectRank(){

	$.ajax({
		url:'/Maker/project/selectProAll',
//		dataType:"json",
		type:"POST",
		async:true,
		data:{
			OrderByClause : parseInt('2')
		},
		success:function(data){
			var proRank = '';
			var tempproRank = data.data;
	if(tempproRank != null && tempproRank != ""){
		for(var i in tempproRank){
			proRank += '<li><span>'+(parseInt(i)+1)+'、&nbsp;</span><a href="ProjectDetails?id='+tempproRank[i].proId+'">'+tempproRank[i].proName+'</a></li>'
		}
		$('#latest').append(proRank)
	}
		},
		error:function(error){
			alert('请求异常');
		}
	});
	$.ajax({
		url:'/Maker/project/selectProAll',
//		dataType:"json",
		type:"POST",
		async:true,
		data:{
			OrderByClause : parseInt('4')
		},
		success:function(data){
			var proRank = '';
			var tempproRank = data.data;
	if(tempproRank != null && tempproRank != ""){
		for(var i in tempproRank){
			proRank += '<li><span>'+(parseInt(i)+1)+'、&nbsp;</span><a href="ProjectDetails?id='+tempproRank[i].proId+'">'+tempproRank[i].proName+'</a></li>'
		}
		$('#hot').append(proRank)
	}
		},
		error:function(error){
			alert('请求异常');
		}
	});
}

/*
 * 项目列表生成
 * 
 */
function GenerAllProjectList(data){
	if(data){
			GenerProjectPageOfTemplate(1,10,data.count);
			if(data.data){
				$(".tab-content-all").html("");
				for(var i in data.data){
					$(".tab-content-all").append(GenerProjectOfTemplate(data.data[i]));
				}
			}
			if(data.count==0 ){
                $(".tab-content-all").empty();
	            $(".tab-content-all").append('<div class="notedata"><p style="font-size: 20px;margin-top: 15px;">没有找到与"<span></span>"相关的结果</p></div>');
	            $(".notedata").find("span").text($("#nav-search-input").val());
			}
		
		
	}
}



/*
 * 
 *项目列表模板
 */
function GenerProjectOfTemplate(data){
	var template = '<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 not-padding project-container ">'
                  +' <div class="project-title"><h2 class="post-title"><a class="post-link" href="ProjectDetails?id=proIdText">proNameText</a></h2><p style="margin-top: 10px;">proReltimeText</p><span class="projectmoney">￥proMoneyText</span></div>'
				  +'<div class="hidden-sm project-indicators"><span class="project-people-number"><span class="red"><i class="fa fa-fire"></span></i> proHeatText</span><span class="project-score"></span>'
				  +'<div class=" hidden-xs project-technology-label">proTypeText</div>'
				  +'</div>'
				  +'<div class="project-introduction"><div class="hidden-box"><span>proInfoText</span></div></div></div>';
	var proType = '';
	var tempproType = data.proType;
	if(tempproType != null && tempproType != ""){
		for(var i in tempproType.split("、")){
			proType += '<span>'+tempproType.split("、")[i]+'</span>'
		}
	}
	var proInfo = '';
	var tempproInfo = data.proInfo;
	if(tempproInfo == null && tempproInfo == ""){
		
			proInfo = '暂无简介'
	}else{
		proInfo=tempproInfo;
	}
	var html = template.replace(/proIdText/g,data.proId)
			.replace(/proNameText/g,data.proName)
			.replace(/proReltimeText/g,data.proReltime)
			.replace(/proMoneyText/g,data.proMoney)
			.replace(/proHeatText/g,data.proHeat)
			.replace(/proTypeText/g,proType)
			.replace(/proInfoText/g,proInfo)
	return html;
}

//
//function NumTrans(_this){
//	if ($(_this).hasClass("fa-angle-left")){
//      $(_this).removeClass("fa-angle-left");
//      $(_this).addClass("fa-angle-right");
//      $(_this).siblings(".max3").hide();
//
//      $(".navbar").show();
//      $(".footer").show();
//
//      $("#course-list").show();
//      $(".expand-course").hide();
//	}else{
//      $(_this).removeClass("fa-angle-right");
//      $(_this).addClass("fa-angle-left");
//      $(_this).siblings(".max3").show();
//      $("#course-list").hide();
//      var thisParent = $(_this).parent().clone();
//      $(thisParent).css("border-top","0px");
//      $(thisParent).children(".level-switch").css("left","0px");
//      $(thisParent).children(".level-switch").css("top","-22px");
//      $(thisParent).children(".level-title").css("margin","10px 0px 10px 25px");
//      $(".expand-course").html(thisParent);
//      $(".expand-course").show();
//
//      $(".navbar").hide();
//      $(".footer").hide();
//
//      $(_this).removeClass("fa-angle-left");
//      $(_this).addClass("fa-angle-right");
//      $(_this).siblings(".max3").hide();
//
//  }
//}
//
//function GenerLabelBylabelType(labelType){
//	if(IsPC()){
//		if(labelType === null){
//			return '<span class="free-symbol">免费</span>'
//		}else if(labelType == 2){
//			return '<span class="limite-free-symbol">限时免费</span>'
//		}else if(labelType == 3){
//			//return '<span class="free"><span class="dollar-price">￥</span><span class="origin-price">299</span></span>'
//			return '';
//		}else{
//			return '';
//		}
//	}else{
//      if(labelType === null){
//          return '<span class="free-symbol-mobile">免费</span>'
//      }else if(labelType == 2){
//          return '<span class="free-symbol-mobile">限时免费</span>'
//      }else if(labelType == 3){
//          //return '<span class="free"><span class="dollar-price">￥</span><span class="origin-price">299</span></span>'
//          return '';
//      }else{
//          return '';
//      }
//	}
//	return '';
//	
//}

//function GenerLabelBylabelTypeMobile(labelType){
//	
//		if(labelType === null){
//			return '<span class="free-symbol-mobile">免费</span>'
//		}else if(labelType == 2){
//			return '<span class="limite-free-symbol-mobile">限时免费</span>'
//		}else if(labelType == 3){
//			//return '<span class="free"><span class="dollar-price">￥</span><span class="origin-price">299</span></span>'
//			return '';
//		}else{
//			return '';
//		}
//	
//}
/*
 * 判断系列颜色
 * */
//function GenerSeriesBGColor(seriesName){
//	if(seriesName == "JAVA系列课程"){
//		return "#ff6160";
//	}else if(seriesName == "Android系列课程"){
//		return "#81d13a";
//	}else if(seriesName == "Python系列课程"){
//		return "#3394d8";
//	}else if(seriesName == ".net系列课程"){
//		return "#aa7ce7";
//	}else if(seriesName == "测试系列课程"){
//		return "#35c3a9";
//	}else{
//		return "#f9ba39";
//	}
//}

/*
 * 分页模板
 */
function GenerProjectPageOfTemplate(fenye,pageSize,totalSize){
	var totalPage = Math.ceil(totalSize / pageSize);
		var html = '';
		for(var i = 0;i<totalPage;i++){
			 // if((parseInt(i)+1) == fenye){
			 // 	html += '<li class="active"><span class="pageCommon" fenye="'+(i+1)+'">'+(i+1)+'</span></li>';
			 // }else{
				html += '<li><span class="pageCommon" fenye="'+(i+1)+'">'+(i+1)+'</span></li>';
			 // }
			
		}
	var pageHtml = '<li><span class="pageCommon" fenye="'+1+'" > &lt;&lt; </span></li>' //首页
				+ html +'<li><span class="pageCommon" fenye="'+totalPage+'"> &gt;&gt; </span></li>'; //尾页
	$(".pagination").html(pageHtml);
    var spanWidth = 0;
    $("#paging-div span").each(function () {
        spanWidth = spanWidth + $(this).outerWidth(true);
    });
    $("#paging-div > ul").css("padding-left", ($("#paging-div").width()-spanWidth)/2.0+"px");
	registerEvent();
}
/*
 * 分页模板-移动端
 */



