
$(function () {
	
	$("#IdposEndtime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',//显示格式
        todayHighlight: 1,//今天高亮
        minView: "month",//设置只显示到月份
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        autoclose: 1,//选择后自动关闭
        language: 'zh-CN'
    });
  var Id = GetRequest(['id']);
  
  $.ajax({
        type: "post",
        url: "/Maker/",   //查看某个详情URL
        data: {
            'positionId': Id
        },
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                com = data.data;
                $('#IdposName').val(com.positionNames);
                $('#IdposAmount').val(com.positionAmount);
                $('#IdposEndtime').val(com.positionEndtime);
                $('#IdposInfo').val(com.positionInfo);
            } else {
                alert(data.msg);
            }
        }
    }); 
    //给下拉框加载数据
      $.ajax({
        cache: false,
        type: "POST",
        url: "/Maker/studiomem/selectStumemMe" ,
         data: {
           
         },
        async: true,
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                // 给评委下拉框动态加载数据
                var select1 = $("#IdposMemId");

                var html1 = '';
                var rows = data.data;
                var selected = '';
                //选择已勾选
                for (var i = 0; i < rows.length; i++) {
                    html1 += '<option value="' + rows[i].stuId + '">' + rows[i].stuName + '</option>';
                }
                select1.append(html1);

                select1.selectpicker('refresh');
            } else {
               alert(msg);//出错执行
            }
        }
    });
$("#UpWorkFrom").validate({
    rules: {
      posName: "required",
      posAmount: "required",
      posEndtime: "required",
      posName: {
        required: true,
        rangelength:[1,15]
      },
	    posAmount: {
        required: true,
        rangelength:[1,10],
        digits:true
      },
      posEndtime: {
        required: true,
      },
    },
    messages: {
     
    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "", //json URL
                        data: $('#UpWorkFrom').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                alert("发布成功");
                                 window.location.reload();
                            }else{
                                alert(data.msg);//出错执行

                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   });
});

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