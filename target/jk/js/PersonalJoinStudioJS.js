    $(function () {
    	$('#JoinStudioTable').bootstrapTable('destroy'); 
            //初始化Table
            var oTable = new TableInit();
            oTable.Init();
        });
        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#JoinStudioTable').bootstrapTable({
                    url: '/Maker/studiomem/selectStumemMe',//请求后台的URL（*）
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
                    uniqueId: "stuId",//每一行的唯一标识，一般为主键列
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
                            field: 'stuName',
                            title: '工作室名称'
                        },{
                            field: 'stumemTime',
                            title: '入会时间',
                        },{
                            field: 'stumemIs',
                            title: '状态',
                              formatter: function (value, row, index) {
                              var a="";
                              if(row.stumemIs == "0"){
                              	a="已撤销申请";
                              }else if(row.stumemIs == "1"){
                              	a="等待批准"
                              }else if(row.stumemIs == "2"){
                              	a="已加入"
                              }else if(row.stumemIs == "3"){
                              	a="已被拒绝"
                              }else if(row.stumemIs == "4"){
                              	a="已退出"
                              }else if(row.stumemIs == "6"){
                              	a="已被拉黑"
                              }else if(row.stumemIs == "7"){
                              	a="工作室已注销"
                              }
                                return a;
                            }
                        },{
                            field: 'CheckTeam',
                            title: '查看组员信息',
                            formatter: function (value, row, index) {
                                var a='<a href="StudioTeam?id='+row.stuId+'&name='+row.stuName+'" style="cursor: pointer">查看组员信息</a>';

                                return a;
                            }
                        },{
                            field: 'CheckDetails',
                            title: '查看详情',
                              formatter: function (value, row, index) {
                              var a='<a href="javascript:void(0)" title="查看详情" onclick="CheckDetails(\''+row.stuId+'\')">查看详情</a>';
                            	
                                return a;
                            }
                        },{
                            field: 'operate',
                            title: '操作',
                            formatter: function (value, row, index) {
                            	var d='';
                            if(row.stumemIs == "1"){
                              	d='<a class="undo" title="撤销申请" style="cursor: pointer">撤销申请</a>';
                              }else if(row.stumemIs == "2"){
                              	d='<a onclick="removeID(\''+row.stuId+'\',\''+row.stumemSum +'\')" title="退出工作室" style="cursor: pointer">退出工作室</a> ';
                              }else if(row.stumemIs == "0" || row.stumemIs == "3" || row.stumemIs == "4" ||row.stumemIs == "6" || row.stumemIs == "7"){
                               d = '<a class="remove" title="删除记录" style="cursor: pointer">删除记录</a> ';
                               }
                                return d;
                            }
                        },
                    ],
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    pageSize: params.limit,//页面大小
                    fenye: (params.offset / params.limit) + 1,//页码
					stumemIs : 2,
//                  offset: params.offset,
                    forumName:params.search
                };
                return temp;
            };
            return oTableInit;
        };

    function removeID(id,sum) {
            	var r = confirm('确定要退出工作室？');
            	if(r==true){
            	$.ajax({
                    type: "post",
                    url: "/Maker/studiomem/updateStumemMe",
                    data: {
                        stuId: id,
                        stumemIs  : 4,
                        stumemSum : sum
                         },
                    success: function (data) {
                      if (data.code == 1) {
                            alert("退出成功");
                     	 reLoad();
                      }else{
                      	alert(data.msg);
                      }
                       
                    },
                    error: function () {
                        alert("连接超时");
                    },
                });
            	}

//          'click .remove': function (e, value, row, index) {
//          	var r = confirm('确定要删除记录？');
//          	if(r==true){
//          	$.ajax({
//                  type: "post",
//                  url: "",
//                  data: {
//                      stuId: row.stuId,
//                      stumemIs : 5
//                       },
//                  success: function (data) {
//                    if (data.code == 1) {
//                          alert("删除成功");
//                     $('#JoinStudioTable').bootstrapTable('remove', {
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

        };

        /*删除多条信息*/
//      function removeMuch() {
//          var rows = $('#TheVideoTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
//          if (rows.length == 0) {
//              confirm("请选择要删除的数据");
//              return;
//          }
//          var r = confirm("确认要删除选中的'" + rows.length + "'个视频吗?");
//          if (r == true) {
//              var ids = new Array();
//              // 遍历所有选择的行数据，取每条数据对应的ID
//              $.each(rows, function (i, row) {
//                  ids[i] = row['forumId'];
//              });
//              $.ajax({
//                  type: 'POST',
//                  url: '',
//                  data: {
//                      forumId: ids,
//                      forumStart : 2
//                  },
//                  success: function (data) {
//                      if (data.code == 1) {
//                          alert("删除"+rows.length+"个视频成功！")
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
            $('#JoinStudioTable').bootstrapTable('refresh');
        }


           

//点击查看详情
function CheckDetails(stuId){
	   $('#CheckDetailsModel').modal({backdrop: "static"})
	    $.ajax({
        type: "post",
        url: "/Maker/studio/selectStu",   //查看详情URL
        data: {
            'stuId': stuId
        },
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                row = data.data[0];
            if(row.stuImg !=undefined && row.stuImg !="" && row.stuImg !=null && row.stuImg !=unknown){
                     $('#IdstuImg').attr({
                         "src" : "/Maker/user/img/studioImg/"+row.stuImg,
                         "alt" : row.stuName,
                         "title" : row.stuName
                     });
                 }else{
                     $('#IdstuImg').attr({
                         "src" : "/Maker/user/img/touxiang.jpg",
                         "alt" : row.stuName,
                         "title" : row.stuName
                     });
                 }
                $('#IpstuPhone').val(row.stuPhone);
                $('#IpstuEmail').val(row.stuEmail);
                 $('#IpstuLocation').val(row.stuLocation);
                  $('#IdstuInfo').val(row.stuInfo);
            } else {
                alert(data.msg);
            }
        }
    }); 
}
