//入口
$(document).ready(function(){
	getAllProject();
});

//自定义函数

/*
 *分页按钮事件注册
 * */
//function registerEvent(){
//	$(".pageCommon").click(function(){
//		var fenye = $(this).attr("fenye");
//		if(fenye){
//			// $(".pagination").find("li").removeClass("active");
//			// $(this).addClass("active");
//
//              AjaxAllProject(parseInt(fenye),$('#nav-search-input').val());
//			
//			
//		}
//	});
//}







/*
 * 获个人荣誉榜
 * 
 * 
 */
function getAllProject(){
	
	AjaxAllProject();
}
/*
 * 获个人荣誉榜数据
 * 
 * 
 */
function AjaxAllProject(){
	
	$.ajax({
		url:'/Maker/developer/rankingsDev2',
//		dataType:"json",
        type:"GET",
		async:true,
		data:{
			OrderByClause : parseInt('2')
		},
		success:function(data){
			GenerAllProjectList(data);
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
//			GenerProjectPageOfTemplate(1,10,data.count);
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
                  +'<img src="picText" alt="NameText" title="NameText" class="project-header-img touxiang"> <div class="project-title"><h2 class="post-title"><span class="post-link">NameText</span></h2><p style="margin-top: 10px;"><span><i title="所在地" class="fa fa-home"></i> LocationText</span><span style="margin-left: 20px;"><i class="fa fa-envelope-o fa-fw"></i> emailText</span><span style="margin-left: 20px;"><i class="fa fa-volume-control-phone"></i> phoneText</span></p></div>'
				  +'<div class="hidden-sm project-indicators"><span class="project-people-number"><span class="red"><i class="fa fa-heart"></i> </span>PraiseText<span class="project-score"></span>'
				  +'<div class=" hidden-xs project-technology-label">TypeText</div>'
				  +'</div>'
				  +'<div class="project-introduction"><div class="hidden-box"><span>InfoText</span></div></div></div>';
	var Type = '';
	var tempType = data.devSpeciality;
	if(tempType != null && tempType != ""){
		for(var i in tempType.split("、")){
			Type += '<span>'+tempType.split("、")[i]+'</span>'
		}
	}
	var Info = '';
	var tempInfo = data.devInfo;
	if(tempInfo == null && tempInfo == ""){
		
			Info = '暂无简介'
	}else{
		Info=tempInfo;
	}
	var pic = '';
	var temppic = data.devImg;
	if(temppic != null && temppic != "" && temppic != undefined){
        pic='/Maker/img/developerImg/'+temppic;
	}else{
        pic = '/Maker/user/img/touxiang.jpg'
	}
	var html = template.replace(/NameText/g,data.devName)
			.replace(/picText/g,pic)
			.replace(/emailText/g,data.devEmail)
			.replace(/PraiseText/g,data.devPraise)
			.replace(/LocationText/g,data.devLocation)
		    .replace(/phoneText/g,data.devPhone)
			.replace(/TypeText/g,Type)
			.replace(/InfoText/g,Info)
	return html;
}




