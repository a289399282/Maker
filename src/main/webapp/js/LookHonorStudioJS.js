//入口
$(document).ready(function(){
	AjaxAllProject();
});





/*
 * 请求列表
 * 参数:fenye   第几页
 * 	  fieldSearch 搜索字段(选填)
 */
function AjaxAllProject(){
	
	$.ajax({
		url:'/Maker/studio/rankingsStu',
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
                  +'<img src="picText" alt="NameText" title="NameText" class="project-header-img touxiang"> <div class="project-title"><h2 class="post-title"><a class="post-link" href="StudioDetails?id=IdText">NameText</a></h2><p style="margin-top: 10px;"><i class="fa fa-home" title="所在地"></i> LocationText</p></div>'
				  +'<div class="hidden-sm project-indicators"><span class="project-people-number"><span class="red"></span><span class="project-score"></span>'
				  +'<div class=" hidden-xs project-technology-label">TypeText</div>'
				  +'</div>'
				  +'<div class="project-introduction"><div class="hidden-box"><span>InfoText</span></div></div></div>';
	var Type = '';
	var tempType = data.stuSpeciality;
	if(tempType != null && tempType != ""){
			Type += '<span>'+tempType+'</span>'
	}
	var Info = '';
	var tempInfo = data.stuInfo;
	if(tempInfo == null && tempInfo == ""){
		
			Info = '暂无简介'
	}else{
		Info=tempInfo;
	}
	var pic = '';
	var temppic = data.stuImg;
	if(temppic != null && temppic != ""){
        pic='/Maker/user/img/studioImg/'+temppic;
	}else{
        pic = '/Maker/user/img/touxiang.jpg'
	}
	var html = template.replace(/IdText/g,data.stuId)
        .replace(/picText/g,pic)
        .replace(/NameText/g,data.stuName)
        .replace(/LocationText/g,data.stuLocation)
        .replace(/TypeText/g,Type)
        .replace(/InfoText/g,Info)
	return html;
}



/*
 * 分页模板
 */
//function GenerProjectPageOfTemplate(fenye,pageSize,totalSize){
//	var totalPage = Math.ceil(totalSize / pageSize);
//		var html = '';
//		for(var i = 0;i<totalPage;i++){
//			 // if((i+1) == fenye){
//			 // 	html += '<li class="active"><span class="pageCommon" fenye="'+(i+1)+'">'+(i+1)+'</span></li>';
//			 // }else{
//				html += '<li><span class="pageCommon" fenye="'+(i+1)+'">'+(i+1)+'</span></li>';
//			 // }
//			
//		}
//	var pageHtml = '<li><span class="pageCommon" fenye="'+1+'" > &lt;&lt; </span></li>' //首页
//				+ html +'<li><span class="pageCommon" fenye="'+totalPage+'"> &gt;&gt; </span></li>'; //尾页
//	$(".pagination").html(pageHtml);
//  var spanWidth = 0;
//  $("#paging-div span").each(function () {
//      spanWidth = spanWidth + $(this).outerWidth(true);
//  });
//  $("#paging-div > ul").css("padding-left", ($("#paging-div").width()-spanWidth)/2.0+"px");
//	registerEvent();
//}



