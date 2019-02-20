$(function () {
	var stuId = GetRequest(['id']);
 	$.ajax({
		type:"post",
		url:"/Maker/studio/selectStu",//查询某个工作室URL
		data: {
		    stuId: stuId.id
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                 row = data.data[0];
            if(row.stuImg !=undefined && row.stuImg !="" && row.stuImg !=null && row.stuImg !=unknown){
                     $('#IdstuImg').attr({
                         "src" : "/Maker/user/img/studioImg/"+row.stuImg,
                         "alt" : row.stuName,
                         "title" : row.stuName
                     });
                 }else{
                     $('#IdstuImg').attr({
                         "src" : "/Maker/user/img/touxiang.jpg",
                         "alt" : row.stuName,
                         "title" : row.stuName
                     });
                 }
                 $('#IpstuId').val(row.stuId);
                 $('#IpstuName').val(row.stuName);
                $('#IpstuPhone').val(row.stuPhone);
                $('#IpstuEmail').val(row.stuEmail);
                 $('#IpstuLocation').val(row.stuLocation);
                  $('#IdstuInfo').val(row.stuInfo);
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 	
     // 给文章类型下拉框动态加载数据
    $.ajax({
        cache: false,
        type: "POST",
        url: "/Maker/type/selectType" ,
        // data: $('').serialize(),
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                // 给评委下拉框动态加载数据
                var select1 = $("#IpstuSpeciality");
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
$(function () {
        $("#upDevPic").click(function () {
            $('#myModal').modal({backdrop: "static"});
        });
uploadImg("IdUpstuImg");
    });
$(function(){
	$("#UpdateStudioFrom").validate({
    rules: {
      stuName: "required",
      stuPhone: "required",
      stuEmail: "required",
      stuLocation: "required",
      stuName: {
        required: true,
        rangelength:[3,15]
      },
	  stuPhone: {
        required: true,
        mobile:true
      },
      stuEmail: {
        required: true,
        rangelength:[1,20],
        email:true
      },
      stuLocation: {
        required: true,
        rangelength:[1,20]
      }
    },
    messages: {
     
    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/studio/updateStu", //修改后的数据提交URL
                        data: $('#ReStudioFrom').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                alert("创建成功");
                                window.location.reload();
                            }else{
                                alert(data.msg);//出错执行
                                /* window.location.reload();*/
                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   })
	});

/*图片文件上传*/
function uploadImg(img) {
    var control = $('#' + img);
    control.fileinput({
        language: 'zh',
        theme: 'explorer',
        uploadUrl: '/Maker/studio/updateStuImg', //上传工作室头像URL
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
        dropZoneTitle:"可拖拽文件...<br/>支持JPG、GIF、PNG、BMP格式...<br/>请不要上传大于2m的文件",
        uploadExtraData: function(previewId, index) {   //额外参数的关键点
                 var data={
                 stuId : $('#IpstuId').val()
                 };
                    return data;
                }
    }).on("fileuploaded", function (event, data) {
        if (data.code == 1) {
            window.location.reload();
        }else if (data.code == 0){
            alert("上传失败!")
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