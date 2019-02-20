	$(document).ready(function() {
				//动画
				$(".form").slideDown(500);
				
				$("#landing").addClass("border-btn");

				$("#registered,#registeredtxt").click(function() {
					$("#landing").removeClass("border-btn");
					$("#landing-content").hide(500);
					$(this).addClass("border-btn");
					$("#registered-content").show(500);
					
				})

				$("#landing").click(function() {
					$("#registered").removeClass("border-btn");
					$(this).addClass("border-btn");
					
					$("#landing-content").show(500);
					$("#registered-content").hide(500);
				})
			});
$(function(){
	var remname=$.cookie('remname');
	if(remname !=null && remname !=""){
		$('#dev_phone').val(remname);
	}
	$("#autoLogin").click(function(){
		if($("#autoLogin").prop("checked")){
		$("#remPassword").prop("checked","checked");
		}
	});
	
});		
$(function(){
	$("#login_form").validate({
    rules: {
      zhanghao: "required",
      devPassword: "required",
      yzm: "required",
      zhanghao: {
        required: true,
      },
      devPassword: {
        required: true,
      },
      yzm: {
        required: true,
      }
    },
    messages: {
      zhanghao: "请输入手机号码或用户ID",
      devPassword: "请输入密码",
      zhanghao: {
        required: "账号不能为空",
      },
      devPassword: {
        required: "请输入密码",
      },
      yzm: {
        required: "验证码不能为空",
      }
    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/developer/loginDev", //json URL
                        data: $('#login_form').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                location.href ="LookProject";  //成功执行 ,跳转页面
                            }else{
                                alert(data.msg);//出错执行
                                 myRefersh();
                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   }),
	$("#registered_form").validate({
    rules: {
      devPhone: "required",
      devPassword: "required",
      confirm_password: "required",
      devPhone: {
        required: true,
        mobile:true
      },
      devPassword: {
        required: true,
        rangelength:[6,16],
        alnum:true
      },
      confirm_password: {
        required: true,
        rangelength:[6,16],
        alnum:true,
        equalTo: "#dev_password_re"
      }
    },
    messages: {
      devPhone: "请输入手机号码",
      devPassword: "请输入密码",
      devPhone: {
        required: "手机号码不能为空",
      },
      devPassword: {
        required: "请输入密码",
        rangelength:"请输入6-16位的密码"
      },
      confirm_password: {
        required: "请再次输入密码",
        rangelength:"请输入6-16位的密码",
        equalTo: "两次密码输入不一致"
      },
     },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/developer/insertDev", //json URL
                        data: $('#registered_form').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                            	 location.href ="login";  //成功执行 ,跳转页面
                                alert("注册成功");
                            }else{
                                alert(data.msg);//出错执行
                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
    });
});

function myRefersh() {
    var img = document.getElementById("yzmPic");
    const source = img.src; // 获得原来的 src 中的内容

    var index = source.indexOf("?");  // 从 source 中寻找 ? 第一次出现的位置 (如果不存在则返回 -1 )

    if (index > -1) { // 如果找到了 ?  就进入内部
        var s = source.substring(0, index); // 从 source 中截取 index 之前的内容 ( index 以及 index 之后的内容都被舍弃 )

        var date = new Date(); // 创建一个 Date 对象的 一个 实例
        var time = date.getTime(); // 从 新创建的 Date 对象的实例中获得该时间对应毫秒值
        img.src = s + "?time=" + time; // 将 加了 尾巴 的 地址 重新放入到 src 上

    } else {
        var date = new Date();
        img.src = source + "?time=" + date.getTime();
    }
}