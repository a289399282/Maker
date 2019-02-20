
$(function(){
	$("#ReStudioFrom").validate({
    rules: {
      stuName: "required",
      stuPhone: "required",
      stuEmail: "required",
      stuLocation: "required",
      stuSpeciality: "required",
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
      },
      stuSpeciality: {
            required: true,
            rangelength:[3,15]
        }
    },
    messages: {
     
    },
     submitHandler: function (form) {                    
                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/studio/insertStu", //json URL
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
