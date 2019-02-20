$(function () {
	var forumId = GetRequest(['id']);
 	$.ajax({
		type:"post",
		url:"/Maker/forum/selectForumMe",
		data: {
		    forumId: forumId.id
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                 row = data.data[0];
                $('#IpforumId').val(row.forumId);
                $('#IpforumName').val(row.forumName);
                $('#IdforumInfo').val(row.forumInfo);
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
    //提交修改后的数据给后台
    $('#Subtn').click(function(){
    	$.ajax({
		type:"post",
		url:"/Maker/forum/updateForum",
		data: $('#UpdateVideoFrom').serialize(),
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                window.location.reload();  //成功执行 ,跳转页面
                alert(data.msg);
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 	
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