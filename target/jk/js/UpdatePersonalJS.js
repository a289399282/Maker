$(function(){

		  $.ajax({ 
		  	cache:true,//保留缓存数据 
		  	type:"POST",//为post请求
		  	url:"/Maker/developer/selectDevById2",//这是我在后台接受数据的文件名
		  	data:{},
		  	async:true,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
		  	error:function(request){//请求失败之后的操作 
		  		alert("连接超时")
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
                $('#IpdevName').text(row.devName);
		  		$('#Idpraise').text(row.devPraise);
		  		$('#Idback').text(row.devBack);
                $('#IpdevNumber').val(row.devNumber);
                $('#IpdevTruename').val(row.devTruename);
                if(row.devTrue=="1"){
                		$('#idcardP').append('<span >已进行实名认证.... </span>');
                }else if(row.devTrue=="0"){
                	$("#idcardDiv").html(' <div class="input-group">'
            					+'<span class="input-group-addon"><i class="fa fa-id-card"></i></span>'
                        		+'<input type="text" value="" id="IpdevIdcard"  name="devIdcard" class="form-control" placeholder="请输入身份证...">'
                    		+'</div>'
       						+ '<label id="IpdevIdcard-error" class="red error" for="IpdevIdcard"></label>');
                }
                $('#IpdevSchool').val(row.devSchool);
                $('#IpdevPhone').val(row.devPhone);
                $('#IpdevLocation').val(row.devLocation);
                $('#IpdevSpeciality').val(row.devSpeciality);
                $('#IpdevInfo').val(row.devInfo);
		  		} 
		  
		  	} ,
              error: function () {
                  alert("连接错误");
              }
		  });
});

			

$(function () {
        $("#upDevPic").click(function () {
            $('#myModal').modal({backdrop: "static"});
        });

    });
$(function () {
    uploadImg("IpUpdevPic");
});

/*图片文件上传*/
function uploadImg(img) {
    var control = $('#' + img);
    control.fileinput({
        language: 'zh',
        theme: 'explorer',
        uploadUrl: '/Maker/developer/updateDevImg',
        allowedFileExtensions: ['jpg', 'jpeg', 'gif', 'png'],
        showUpload: true, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        //dropZoneEnabled: false,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        maxFileSize: 2000,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        dropZoneTitle:"可拖拽文件...<br/>支持JPG、GIF、PNG、BMP格式...<br/>请不要上传大于2m的文件"
    }).on("fileuploaded", function (event, data) {
        if (data.code == 1) {
            window.location.reload();
        }else if (data.code == 0){
            alert("上传失败!")
        }
    });
}

//$(function(){
//	$("#idcardA").click(function(){
//		$("#idcardDiv").html(' <div class="input-group">'
//          					+'<span class="input-group-addon"><i class="fa fa-id-card"></i></span>'
//                      		+'<input type="text" value="" id="IpdevIdcard"  name="devIdcard" class="form-control" placeholder="请输入身份证...">'
//                  		+'</div>'
//     						+ '<label id="IpdevIdcard-error" class="red error" for="IpdevIdcard"></label>');
//	});
//});
$(function(){
	  $.ajax({
        cache: false,
        type: "POST",
        url: "/Maker/type/selectType" ,
        // data: $('').serialize(),
        async: true,
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                // 给评委下拉框动态加载数据
                var select1 = $("#IpdevSpeciality");
                var html1 = '';
                var rows = data.data;
                var selected = '';
                //选择已勾选
                for (var i = 0; i < rows.length; i++) {
                    html1 += '<option value="' + rows[i].tpId + '">' + rows[i].tpName + '</option>';
                }
                select1.append(html1);

                select1.selectpicker('refresh');
            } else {
                // alert(msg);//出错执行
            }
        }
    });
});
$(function(){
	$("#updatePersonal").validate({
    rules: {
      devNumber: "required",
      devEmail: "required",
      devTruename: "required",
      devName: "required",
      devPhone: "required",
      devLocation: "required",
      devSpeciality: "required",
      devNumber: {
        required: true,
        rangelength:[3,15],
        digits:true
      },
      devEmail: {
        required: true,
        email:true
      },
      devTruename: {
        required: true,
        rangelength:[1,15]
      },
        devName: {
            required: true,
            rangelength:[1,15]
        },
       devSchool: {
        rangelength:[1,20]
      },
       devLocation: {
        required: true,
        rangelength:[1,20]
      },
      devIdcard: {
        isIdCardNo: true
      }
    },
    messages: {
     
    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/developer/updateDev", //json URL
                        data: $('#updatePersonal').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                alert("修改成功");
                                window.location.reload();
                            }else{
                                alert(data.msg);//出错执行
                                 window.location.reload();
                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   })
	});
