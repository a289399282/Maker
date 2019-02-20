$(function(){
		  $.ajax({
		  	cache:true,//保留缓存数据
		  	type:"POST",//为post请求
		  	url:"/Maker/developer/selectDevById2",//这是我在后台接受数据的文件名
		    error: function (request) {
	            alert("连接超时");
	        },
		  	success:function(data){
                if(data.code=="1"){
                    row = data.data;
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
                $('#IpdevId').val(row.devId);
                $('#IpdevName').text(row.devName);
		  		$('#Idpraise').text(row.devPraise);
                $('#IpdevNumber').val(row.devNumber);
                $('#IpdevTruename').val(row.devTruename);
                if(row.devTrue=="1"){
                		$('#idcardP').append('<span >已进行实名认证.... </span>');
                }else if(row.devTrue=="0"){
                	$('#idcardP').append('<a href="UpdatePersonal" >点击进行实名认证.... </a>');
                }
                $('#IpdevSchool').val(row.devSchool);
                $('#IpdevPhone').val(row.devPhone);
                $('#IpdevLocation').val(row.devLocation);
                $('#IpdevSpeciality').val(row.devSpeciality);
                $('#IpdevInfo').val(row.devInfo);
		  		}

		  	}
		  });
});
