
$(function () {
	
	var test=new Vcity.CitySelector({input:'IdproCity'});

	$("#IdproEndtime").datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',//显示格式
        todayHighlight: 1,//今天高亮
        minView: "month",//设置只显示到月份
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        autoclose: 1,//选择后自动关闭
        language: 'zh-CN'
    });
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
                // 给评委下拉框动态加载数据
                var select1 = $("#IdproType");
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
    //给工作室下拉框加载数据
      $.ajax({
        cache: false,
        type: "POST",
        url: "/Maker/studiomem/selectStumemMe" ,
         data: {
             stumemIs : 2
         },
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {

                // 给评委下拉框动态加载数据
                var select1 = $("#IdproPublisher");

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
               console.log();
            }
        }
    });
$("#PuProjectFrom").validate({
    rules: {
      proName: "required",
      proCity: "required",
      proMoney: "required",
      proEndtime: "required",
      stuName: {
        required: true,
        rangelength:[3,15]
      },
	   proCity: {
        required: true,
         rangelength:[1,20]
      },
      proMoney: {
        required: true,
        rangelength:[1,20],
       number:true
      },
       proEndtime: {
        required: true,
      }
    },
    messages: {
     
    },
     submitHandler: function (form) {

                    $.ajax({  
                        type: 'post',  
                        url: "/Maker/project/insertPro", //json URL
                        data: $('#PuProjectFrom').serialize(),
                        async: false,
                        error: function (request) {
				            alert("连接超时");
				        },
                        success:function(data){
                            if(data.code==1){
                                alert("创建成功");
                                 // window.location.reload();
                            }else{
                                alert(data.msg);//出错执行

                            }
                        }   
                    }); 
                    return false; // 阻止表单自动提交事件
                }
   });
});

