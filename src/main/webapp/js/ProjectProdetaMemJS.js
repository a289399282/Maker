    $(function () {
    var proId = GetRequest(['id']).id;
     $('#IdproId').val(proId);
            //初始化Table
            var oTable = new TableInit();
            oTable.Init();
        });
        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#ProjectMenTable').bootstrapTable({
                    url: '/Maker/prodetamem/selectPrdememMe',//请求后台的URL（*）
                    method: 'post',//请求方式（*）
                    toolbar: '#toolbar',//工具按钮用哪个容器
                    striped: true,//是否显示行间隔色
                    cache: false,//是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    pagination: true,//是否显示分页（*）
                    sortable: false,//是否启用排序
                    sortOrder: "asc",//排序方式
                    queryParams: oTableInit.queryParams,//传递参数（*）
                    sidePagination: "server",//分页方式：client客户端分页，server服务端分页（*）
                    pageNumber: 1,//初始化加载第一页，默认第一页
                    pageSize: 10,//每页的记录行数（*）
                    pageList: [10, 25],//可供选择的每页的行数（*）
                    search: false,//是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                    contentType: "application/x-www-form-urlencoded",
                    strictSearch: true,
                    showColumns: true,//是否显示所有的列
                    showRefresh: true,//是否显示刷新按钮
                    minimumCountColumns: 2,//最少允许的列数
                    clickToSelect: true,//是否启用点击选中行
//                  height: 700,//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                    uniqueId: "prdememId",//每一行的唯一标识，一般为主键列
                    showToggle: false,//是否显示详细视图和列表视图的切换按钮
                    cardView: false,//是否显示详细视图
                    detailView: false,//是否显示父子表
                    search: true,
                    responseHandler: function(res) {
			                return {
                                "total": res.count,//总页数
			                    "rows": res.data   //数据
			                 };
			            },
                    columns: [
                       	{
                            align: 'center',
                            checkbox: true,// 显示复选框
                            
                        },{
                            field: 'proName',
                            title: '项目名称',
                        },{
                            field: 'prdeIswinName',
                            title: '竞标人名称',
                        },{
                            field: 'prdememTime',
                            title: '竞标时间',
                        },{
                            field: 'prdememState',
                            title: '竞标状态',
	                        formatter: function (value, row, index) {
	                          var a="";
	                          if(row.prdememState == "0"){
	                          	a="竞标失败";
	                          }else if(row.stumemIs == "1"){
	                          	a="参加竞标"
	                          }else if(row.stumemIs == "2"){
	                          	a="竞标成功"
	                          }else{
	                          	a="错误"
	                          }
	                            return a;
	                        }
                        },{
                            field: 'CheckDetails',
                            title: '查看竞标人员信息',
                              formatter: function (value, row, index) {
                              var a='<a href="javascript:void(0)" title="查看详情" onclick="CheckDetails (\''+row.prdememId+'\')">查看详情</a>';

                                return a;
                            }
                        },{
                            field: 'operate',
                            title: '通过或否决',
                            formatter: function (value, row, index) {
                                var e = '<a href="javascript:void(0)" onclick="UpDateStudioTeam(\''+row.proId+'\',\''+row.proName+'\',\''+row.prdememId+'\',\''+row.prdeIswinName+'\')" style="cursor: pointer">修改竞标状态</a> ';
                                return e;
                            }
                        },
                    ],
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    proId : $('#IdproId').val(),
                    pageSize: params.limit,//页面大小
                    fenye: (params.offset / params.limit) + 1,//页码

//                  offset: params.offset,
                    prdeIswinName:params.search
                };
                return temp;
            };
            return oTableInit;
        };

        window.operateEvents = {
		
//          'click .remove': function (e, value, row, index) {
//          	var r = confirm('确定要删除选中的记录？');
//          	if(r==true){
//          	$.ajax({
//                  type: "post",
//                  url: "",
//                  data: {
//                      stuId: row.stuId,
//                       },
//                  success: function (data) {
//                    if (data.code == 1) {
//                          alert("删除成功");
//                     $('#ProjectMenTable').bootstrapTable('remove', {
//		                    field: 'stuId',
//		                    values: [row.stuId]
//		                });
//                    }else{
//                    	alert(data.msg);
//                    }
//                     
//                  },
//                  error: function () {
//                      alert("连接超时");
//                  },
//              });
//          	}
//          }
//         'click .edit': function (e, value, row, index) {
//              $.ajax({
//                  type: "post",
//                  url: "",
//                  data: {strJson: row.studentid},
//                  success: function (data, status) {
////                      if (status == "success") {
//                          alert("删除成功");
////                      }
//                      $('#table').bootstrapTable('remove', {
//		                    field: 'publicId',
//		                    values: [row.publicId]
//		                });
//                  },
//                  error: function () {
//                      alert("Error");
//                  },
//              });
                

//          }
        };

        /*删除多条信息*/
//      function removeMuch() {
//          var rows = $('#ProjectMenTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
//          if (rows.length == 0) {
//              confirm("请选择要开除的组员");
//              return;
//          }
//          var r = confirm("确认要开除选中的'" + rows.length + "'个组员吗?");
//          if (r == true) {
//              var ids = new Array();
//              // 遍历所有选择的行数据，取每条数据对应的ID
//              $.each(rows, function (i, row) {
//                  ids[i] = row['stuId'];
//              });
//              $.ajax({
//                  type: 'POST',
//                  url: '',
//                  data: {
//                      stuId: ids,
//                  },
//                  success: function (data) {
//                      if (data.code == 1) {
//                          alert("关闭"+rows.length+"个工作室成功！")
//                          reLoad();
//                      } else {
//                          alert(data.msg);
//                      }
//                  }
//              });
//          }
//      }

        /*刷新table*/
        function reLoad() {
            $('#ProjectMenTable').bootstrapTable('refresh');
        }

        /*删除功能*/
//      function remove(id) {
//          var r = confirm('确定要删除选中的记录？');
//          if (r == true) {
//              $.ajax({
//                  url: '',
//                  type: "post",
//                  data: {
//                      'publicId': id
//                  },
//                  success: function (r) {
//                      if (r.code == 0) {
//                          confirm("删除成功");
//                          reLoad();
//                      } else {
//                          confirm(r.msg);
//                      }
//                  }
//              });
//          }
//      }
           

function UpDateStudioTeam(proId,proname,pmeId,name){
	   $('#UpdateModel').modal({backdrop: "static"})
        console.log(proId)
    console.log(pmeId)
    console.log(name)
	    $('#IdproId').val(proId);
        $('#IdprdememId').val(pmeId);
    $('#Idproname').val(proname);
         $('#IpprdeIswinName').val(name);
       $('#Subtn').click(function(){
       $.ajax({
        type: "post",
        url: "/Maker/prodetamem/updatePrdemem",   //修改状态URL
	    data: $('#updateTeam').serialize(),
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
            	alert('修改成功');
            } else {
                alert(data.msg);
            }
        }
    }); 	
    });
	 
}
//点击查看详情方法
function CheckDetails(Id){
	   $('#CheckDetailsModel').modal({backdrop: "static"})
	    $.ajax({
        type: "post",
        url: "/Maker/developer/selectDevByIdPhone",   //查看某个组员详情URL
        data: {
            'zhanghao': Id
        },
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                row = data.data;
              if(row.devId !=undefined || row.devId !="" || row.devId!=null || row.devId !=unknown){
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
                $('#IpName').val(row.devName);
                $('#IpEmail').val(row.stuEmail);
                $('#IpPhone').val(row.devPhone);
                $('#IpLocation').val(row.devLocation);
                 $('#IpSpeciality').val(row.devSpeciality);
                  $('#IpInfo').val(row.devInfo);
              }else if(row.stuId !=undefined || row.stuId !="" || row.stuId !=null || row.stuId !=unknown){
              	if(row.stuImg !=undefined && row.stuImg !="" && row.stuImg !=null && row.stuImg !=unknown){
                     $('#IdstuImg').attr({
                         "src" : "/Maker/user/img/studioImg/"+row.stuImg,
                         "alt" : row.stuName,
                         "title" : row.stuName
                     });
                 }else{
                     $('#IpdevPic').attr({
                         "src" : "/Maker/user/img/touxiang.jpg",
                         "alt" : row.stuName,
                         "title" : row.stuName
                     });
                 }
              $('#IpName').val(row.stuName);
                $('#IpPhone').val(row.stuPhone);
                $('#IpEmail').val(row.stuEmail);
                 $('#IpLocation').val(row.stuLocation);
                  $('#IdInfo').val(row.stuInfo);
              }
            } else {
                alert(data.msg);
            }
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