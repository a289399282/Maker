$(function () {
	var Id = GetRequest(['id']);
	$('#upforumId').val(Id.id);
 	$.ajax({
		type:"post",
		url:"/Maker/forum/selectForumById",//查询某个项目URL
		async: false,
		data: {
		    forumId: Id.id
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                com = data.data;
                if(com.forumForid != null && com.forumForid !="" && com.forumForid != undefined){
                    $('#updevId').val(com.forumForid);
                    $('#IdforumForid').html('(转发)');
                }else{
                    $('#updevId').val(com.forummemId)
                    $('#IdforumForid').html('(原创)');
                }
            var Type = '';
			var tempType = com.forumType;
			if(tempType != null && tempType != ""){
				for(var i in tempType.split("、")){
					Type += '<li class="pull-left keyword-item"><a>'+tempType.split("、")[i]+'</a></li>'
				}
			}
				$('.keyword-area').append(Type);
                $('#IdArtName').html(com.forumName);
                $('#Idname').html(com.forummemIdName);
                $('#IdHeat').html(com.forumHeat);
 				$('#IdReltime').html(com.forumReltime);
                $('#IdInfo').html(com.forumInfo);
                $('#IdText').html(com.forumTextafter);
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 
	$.ajax({
		type:"post",
		url:"/Maker/devstu/selectDevStuById",//查询负责人目URL
		async: false,
		data: {
		   zhanghao: $('#updevId').val()
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
             if(data.code==1){
                row = data.data;
                if(row.devId){
                    if(row.devPic !=undefined && row.devPic !="" && row.devPic !=null && row.devPic !=unknown){
                        $('#IpdevPic').attr({
                            "src" : "/Maker/img/developerImg/"+row.devPic,
                            "alt" : row.devPhone,
                            "title" : row.devPhone
                        });
                    }else{
                        $('#IpdevPic').attr({
                            "src" : "/Maker/user/img/touxiang.jpg",
                            "alt" : row.devPhone,
                            "title" : row.devPhone
                        });
                    }
                    $('#IduserName').html(row.devName);
                    $('#IddevPhone').html(row.devPhone);
                    $('#IddevEmail').html(row.devEmail);
                    $('#IddevPraise').html(row.devPraise);
                }else if(row.stuId){
                    if(row.stuImg !=undefined && row.stuImg !="" && row.stuImg !=null && row.stuImg !=unknown){
                        $('#IpdevPic').attr({
                            "src" : "/Maker/user/img/studioImg/"+row.stuImg,
                            "alt" : row.stuName,
                            "title" : row.stuName
                        });
                    }else{
                        $('#IpdevPic').attr({
                            "src" : "/Maker/user/img/touxiang.jpg",
                            "alt" : row.stuName,
                            "title" : row.stuName
                        });
                    }
                 	$('#IduserName').html(row.stuName);
                    $('#IddevPhone').html(row.stuPhone);
                    $('#IddevEmail').html(row.stuEmail);
                    $('#IddevPraise').html(row.stuPraise);
                }
       
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 
   }); 
   
   //转发作品
function Bidding(){
	$.ajax({
		type:"post",
		url:"/Maker/forum/forwardFor",  //转发作品URL
		data: {
            forumId: $('#upforumId').val()
         },
         
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                alert(data.msg)
       
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 
}
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}