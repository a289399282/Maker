$(function () {
	var Id = GetRequest(['id']);
 	$.ajax({
		type:"post",
		url:"/Maker/project/selectProById",//查询某个项目URL
		async: false,
		data: {
		    proId: Id.id
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                com = data.data;
                $('#upproPublisher').val(com.proPublisher);
                $('#upproId').val(com.proId);
                $('#IdproName').html(com.proName);
                $('#IdproPubname').html(com.proPubname);
                $('#IdproHeat').html(com.proHeat);
                $('#IdproCity').html(com.proCity);
                $('#IdproMoney').html("￥"+com.proMoney);
     var proType = '';
	var tempproType = com.proType;
	if(tempproType != null && tempproType != ""){
		for(var i in tempproType.split("、")){
			proType += '<li class="pull-left keyword-item"><a>'+tempproType.split("、")[i]+'</a></li>'
		}
	}
                $('.keyword-area').append(proType);
                $('#IdproReltime').html(com.proReltime);
                $('#IdproInfo').html(com.proInfo);
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 
	$.ajax({
		type:"post",
		url:"/Maker/developer/selectDevByIdPhone",//查询某个项目URL
		async: false,
		data: {
            zhanghao: $('#upproPublisher').val()
         },
        error: function (request) {
            alert("连接超时");
        },
        success:function(data){
            if(data.code==1){
                row = data.data;
                if(row.devId){
                    if(row.devPic !=undefined && row.devPic !="" && row.devPic !=null && row.devPic !=unknown){
                        $('#IpImg').attr({
                            "src" : "/Maker/img/developerImg/"+row.devPic,
                            "alt" : row.devPhone,
                            "title" : row.devPhone
                        });
                    }else{
                        $('#IpImg').attr({
                            "src" : "/Maker/user/img/touxiang.jpg",
                            "alt" : row.devPhone,
                            "title" : row.devPhone
                        });
                    }
                    $('#IduserName').html(row.devName);
                    $('#IddevPhone').html(row.devPhone);
                    $('#IddevEmail').html(row.devEmail);
                    $('#IddevPraise').html(row.devPraise);
                }else if(row.stuId){
                    if(row.stuImg !=undefined && row.stuImg !="" && row.stuImg !=null && row.stuImg !=unknown){
                        $('#IpImg').attr({
                            "src" : "/Maker/user/img/studioImg/"+row.stuImg,
                            "alt" : row.stuName,
                            "title" : row.stuName
                        });
                    }else{
                        $('#IpImg').attr({
                            "src" : "/Maker/user/img/touxiang.jpg",
                            "alt" : row.stuName,
                            "title" : row.stuName
                        });
                    }
                    $('#IpName').html(row.stuName);
                    $('#IpPhone').html(row.stuPhone);
                    $('#IpEmail').html(row.stuEmail);
                    $('#IddevPraise').html(row.stuPraise);
                }
       
            }else{
                alert(data.msg);//出错执行
            }
        }   
    }); 
   });
$(function () {
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

                // 给工作室下拉框动态加载数据
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
})
function Bidding(){
    $('#UpdateModel').modal({backdrop: "static"})
    $('#Subtn').click(function() {
        $.ajax({
            type: "post",
            url: "/Maker/prodetamem/insertPrdemem",//查询某个项目URL
            data: $('#updateTeam').serialize(),

            error: function (request) {
                alert("连接超时");
            },
            success: function (data) {
                if (data.code == 1) {
                    alert(data.msg)

                } else {
                    alert(data.msg);//出错执行
                }
            }
        });
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