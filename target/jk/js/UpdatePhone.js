$(function(){
	$("#UpPhoneFrom").validate({
    rules: {
      devPhone: "required",
      devPassWord: "required",
      
      devPassWord: {
        required: true,
      },
        devPhone: {
        required: true,
        mobile:true
      },
    },
    messages: {

    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/developer/updaPhoneDev", //json URL
                        data: $('#UpPhoneFrom').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                location.href ="UpdatePhone";  //成功执行 ,跳转页面
                                alert(data.msg);
                            }else{
                                alert(data.msg);//出错执行
                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   })

});

