    $(function () {
    	$('#StudioTable').bootstrapTable('destroy'); 
            //初始化Table
            var oTable = new TableInit();
            oTable.Init();
        });
        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#StudioTable').bootstrapTable({
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
                            field: 'stuSpeciality',
                            title: '特长',
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
                                var e = '<a href="UpdateStudio?id='+row.stuId+'" title="修改工作室信息" style="cursor: pointer"><i class="fa fa-pencil-square-o"></i></a> ';
                                var d = '<a onclick="removeID(\''+row.stuId+'\')" title="注销" style="cursor: pointer"> <i class="glyphicon glyphicon-remove"></i></a> ';
                                return e + d;
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
                    stumemPower : 3,
//                  offset: params.offset,
                    stuName:params.search
                };
                return temp;
            };
            return oTableInit;
        };

    function removeID(id) {
            	var r = confirm('确定要注销该工作室？');
            	if(r==true){
            	$.ajax({
                    type: "post",
                    url: "/Maker/studio/updateStuStart",
                    data: {
                        stuId: id,
                         },
                    success: function (data) {
                      if (data.code == 1) {
                            alert("注销成功");
                            reLoad();
                       $('#StudioTable').bootstrapTable('remove', {
		                    field: 'stuId',
		                    values: [id]
		                });
                      }else{
                      	alert(data.msg);
                      }
                       
                    },
                    error: function () {
                        alert("连接超时");
                    },
                });
            	}

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
/*        function removeMuch() {
            var rows = $('#StudioTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
            if (rows.length == 0) {
                confirm("请选择要关闭的工作室");
                return;
            }
            var r = confirm("确认要关闭选中的'" + rows.length + "'个工作室吗?");
            if (r == true) {
                var ids = new Array();
                // 遍历所有选择的行数据，取每条数据对应的ID
                $.each(rows, function (i, row) {
                    ids[i] = row['stuId'];
                });
                $.ajax({
                    type: 'POST',
                    url: '',
                    data: {
                        stuId: ids,
                    },
                    success: function (data) {
                        if (data.code == 1) {
                            alert("关闭"+rows.length+"个工作室成功！")
                            reLoad();
                        } else {
                            alert(data.msg);
                        }
                    }
                });
            }
        }*/

        /*刷新table*/
        function reLoad() {
            $('#StudioTable').bootstrapTable('refresh');
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
           
//点击查看详情方法
function CheckDetails(stuId){
	   $('#CheckDetailsModel').modal({backdrop: "static"})
	    $.ajax({
        type: "post",
        url: "/Maker/studio/selectStu",   //查看某个我的工作室详情URL
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
