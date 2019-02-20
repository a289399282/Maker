$(function(){
	$("#UpPassWFrom").validate({
    rules: {
      devPassWord: "required",
      devPassWordOne: "required",
      devPassWordTwo: "required",
      
      devPassWord: {
        required: true,
      },
      devPassWordOne: {
        required: true,
        rangelength:[6,16],
        alnum:true
      },
       devPassWordTwo: {
        required: true,
        rangelength:[6,16],
        alnum:true,
        equalTo:"#IpdevPassWordOne"
      }
    },
    messages: {
        devPassWordTwo: {
        required: "请再次输入密码",
        equalTo: "两次密码输入不一致"
      },
    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/developer/updatePWDev", //json URL
                        data: $('#UpPassWFrom').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                location.href ="UpdatePassword";  //成功执行 ,跳转页面
                                alert("修改成功");
                            }else{
                                alert(data.msg);//出错执行
                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   })

});

