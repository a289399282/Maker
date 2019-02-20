$(function () {
	var Id = GetRequest(['id']);
	$('#upId').val(Id.id);
 	$.ajax({
		type:"post",
		url:"/Maker/studio/selectStuById",//查询某个项目URL
		async: false,
		data: {
		    stuId: Id.id
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
            	
                com = data.data;
                $('#updevId').val(com.devId);
                $('#IdstuName').html(com.stuName);
                $('#Idlocation').html(com.stuLocation);
                if(com.stuImg !=undefined && com.stuImg !="" && com.stuImg !=null && com.stuImg !=unknown){
                    $('#IdstuImg').attr({
                        "src" : "/Maker/img/developerImg/"+com.stuImg,
                        "alt" : com.stuName,
                        "title" : com.stuName
                    });
                }else{
                    $('#IdstuImg').attr({
                        "src" : "/Maker/user/img/touxiang.jpg",
                        "alt" : com.stuName,
                        "title" : com.stuName
                    });
                }
				var Type = '';
				var tempType = com.stuSpeciality;
				if(tempType != null && tempType != ""){
				for(var i in tempType.split("、")){
					Type += '<li class="pull-left keyword-item"><a>'+tempType.split("、")[i]+'</a></li>'
					}
				}
                $('.keyword-area').append(Type);
                $('#Idphone').html(com.stuPhone);
 				$('#Idemail').html(com.stuEmail);
                $('#IdInfo').html(com.stuInfo);
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 
	$.ajax({
		type:"post",
		url:"/Maker/developer/selectDevByIdPhone",//查询负责人目URL
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
                    $('#Idname').html(row.devName);
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
   
   //申请职位
function Bidding(){
	$.ajax({
		type:"post",
		url:"/Maker/studiomem/insertStumem",//查询某个项目URL
		data: {
		   stuId: $('#upId').val()
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