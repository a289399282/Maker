    $(function () {
    	$('#TheProjectTable').bootstrapTable('destroy'); 
            //初始化Table
            var oTable = new TableInit();
            oTable.Init();
        });
        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#TheProjectTable').bootstrapTable({
                    url: '/Maker/project/selectProMe',//请求后台的URL（*）
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
                    uniqueId: "proId",//每一行的唯一标识，一般为主键列
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
                            field: 'proId',
                            title: '编号',
                        },{
                            field: 'proName',
                            title: '项目名称'
                        },{
                            field: 'proPubname',
                            title: '发布人姓名',
                        },{
                            field: 'proState',
                            title: '项目状态',
                              formatter: function (value, row, index) {
                              var a="";
                              if(row.proState == "1"){
                              	a="已发布";
                              }else if(row.proState == "2"){
                              	a="已接单"
                              }else if(row.proState == "3"){
                              	a="已驳回"
                              }else if(row.proState == "4"){
                              	a="等待检验"
                              }else if(row.proState == "5"){
                              	a="已通过检验"
                              }else if(row.proState == "6"){
                              	a="已删除"
                              }else{
                              	a="错误"
                              }
                                return a;
                            }
                        },{
                            field: 'proHeat',
                            title: '热度',
                        },{
                            field: 'CheckDetails',
                            title: '查看详情',
                              formatter: function (value, row, index) {
                              var a='<a href="javascript:void(0)" title="查看详情" onclick="CheckDetails(\''+row.proId+'\')">查看详情</a>';

                                return a;
                            }
                        },{
                            field: 'CheckProdetaMem',
                            title: '查看竞标人员',
                              formatter: function (value, row, index) {
                              var a='<a href="ProjectProdetaMem?id='+row.proId+'" style="cursor: pointer">查看竞标人员</a> ';
                            	
                                return a;
                            }
                        },{
                            field: 'operate',
                            title: '修改项目状态',
                            formatter: function (value, row, index) {
                                var e = '<a href="javascript:void(0)" onclick="UpDateStudioTeam(\''+row.proId+'\',\''+row.proName+'\')" style="cursor: pointer">修改项目状态</a> ';
                                return e;
                            }
                        },{
                            field: 'operate',
                            title: '操作',
                            formatter: function (value, row, index) {
                                var e = '<a href="UpdateTheProject?id='+row.proId+'" title="修改项目信息" style="cursor: pointer"><i class="fa fa-pencil-square-o"></i></a> ';
                                var d = '<a onclick="removeID(\''+row.proId+'\')" title="删除" style="cursor: pointer"> <i class="glyphicon glyphicon-remove"></i></a> ';
                                return e + d;
                            }
                        },
                    ],
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    pageSzie: params.limit,//页面大小
                    fenye: (params.offset / params.limit) + 1,//页码
//                  offset: params.offset,
                    proName:params.search
                };
                return temp;
            };
            return oTableInit;
        };

function removeID(id) {
            	var r = confirm('确定要删除选中的记录？');
            	if(r==true){
            	$.ajax({
                    type: "post",
                    url: "/Maker/project/updatePro",
                    data: {
                        proId: id,
                        proState: 6,
                    },
                    success: function (data) {
                      if (data.code == 1) {
                            alert("删除成功");
                            reLoad();
                       $('#TheProjectTable').bootstrapTable('remove', {
		                    field: 'proId',
		                    values: [row.proId]
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
        function removeMuch() {
            var rows = $('#TheProjectTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
            if (rows.length == 0) {
                confirm("请选择要删除的数据");
                return;
            }
            var r = confirm("确认要删除选中的'" + rows.length + "'个项目吗?");
            if (r == true) {
                var ids = new Array();
                // 遍历所有选择的行数据，取每条数据对应的ID
                $.each(rows, function (i, row) {
                    ids[i] = row['proId'];
                });
                $.ajax({
                    url: '',//删除多个项目URL
                    type: 'POST',
                    data: {
                        "proId": ids
                    },

                    success: function (data) {
                        if (data.code == 1) {
                            alert("删除"+rows.length+"个项目成功！")
                            reLoad();
                        } else {
                            alert(data.msg);
                        }
                    }
                });
            }
        }

        /*刷新table*/
        function reLoad() {
            $('#TheProjectTable').bootstrapTable('refresh');
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
function UpDateStudioTeam(Id,name){
	   $('#UpdateModel').modal({backdrop: "static"})
	    $('#IdproId').val(Id);
        $('#Idproname').val(name);
       $('#Subtn').click(function(){
       $.ajax({
        type: "post",
        url: "/Maker/project/updatePro",   //修改状态URL
	    data: $('#updateTeam').serialize(),
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
            	alert('修改成功');
                reLoad()
            } else {
                alert(data.msg);
            }
        }
    }); 	
    });
	 
}
//点击查看方法
function CheckDetails(Id){
	   $('#CheckDetailsModel').modal({backdrop: "static"})
	    $.ajax({
        type: "post",
        url: "/Maker/project/selectProById",   //查看某个详情URL
        data: {
            'proId': Id
        },
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                com = data.data;
                $('#IdproCity').val(com.proCity);
                $('#IdproMoney').val(com.proMoney);
                $('#IdproType').val(com.proType);
                $('#IdproFoutime').val(com.proFoutime);
                $('#IdproReltime').val(com.proReltime);
                $('#IdproEndtime').val(com.proEndtime);
                $('#IdproInfo').val(com.proInfo);
            } else {
                alert(data.msg);
            }
        }
    }); 
}