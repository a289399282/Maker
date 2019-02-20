$(function () {
	var Id = GetRequest(['id']);
	$('#uppositionId').val(Id.id);
 	$.ajax({
		type:"post",
		url:"/Maker/position/selectPosById",//查询某个项目URL
		async: false,
		data: {
		    positionId: Id.id
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                com = data.data;
                $('#uppositionmemId').val(com.positionmemId)
                $('#Idname').html(com.positionmemIdName);
                $('#IdposName').html(com.positionName);
                $('#IdHeat').html(com.positionHeat);
                $('#IdAmount').html(com.positionAmount);
 				$('#IdReltime').html(com.positionReltime);
                $('#IdInfo').html(com.positionInfo);
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
		   zhanghao: $('#uppositionmemId').val()
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
   
   //申请职位
function Bidding(){
	$.ajax({
		type:"post",
		url:"/Maker/positionmem/insertPosmem",//申请职位URL
		data: $('#ProFrom').serialize(),
         
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