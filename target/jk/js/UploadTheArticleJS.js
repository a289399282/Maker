$(function () {
	
     $("#md").markdown({
        language: 'zh',
        fullscreen: {
            enable: true
        },
        resize:'vertical',
        localStorage:'md',
        imgurl: '/Maker/forumImg/insertforumImg',
        base64url: '/Maker/forumImg/insertforumImg'
    });
    $("#uploadImage").click(function() {
		$.ajax({
		    url: '/Maker/forumImg/insertforumImg',
		    type: 'POST',
		    cache: false,
		    data: new FormData($('#uploadformid')[0]),
		    processData: false,
		    contentType: false,
		    success: function(data){
		    	var mdcontent=$("#md").val();
		    	 $("#md").val(mdcontent + "\n![](/Maker/img/forumImg/"+data.msg +") \n");
 
	         }
		}).done(function(res) {
			$('#file').val('');
		}).fail(function(res) {});
 	})
     // 给文章类型下拉框动态加载数据
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
                // 给下拉框动态加载数据
                var select1 = $("#IpdevSpeciality");
                var html1 = '';
                var rows = data.data;
                var selected = '';
                //选择已勾选
                for (var i = 0; i < rows.length; i++) {
                    html1 += '<option value="' + rows[i].tpName + '">' + rows[i].tpName + '</option>';
                }
                select1.append(html1);

                select1.selectpicker('refresh');
            } else {
                // alert(msg);//出错执行
            }
        }
    });
    $('#Subtn').click(function(){
    	$.ajax({
		type:"post",
		url:"/Maker/forum/addForText",
		data: {
			forumName : $('#IpforumName').val(),
			forumInfo : $('#IdforumInfo').val(),
			forumType : $('#IpdevSpeciality').val(),
			forumStart : $('#IpforumStart').val(),
			forumText : $('#md').val(),
		},
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

