    $(function () {
    	$('#TheVideoTable').bootstrapTable('destroy'); 
            //初始化Table
            var oTable = new TableInit();
            oTable.Init();
        });
        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#TheVideoTable').bootstrapTable({
                    url: '/Maker/forum/selectForumMe',//请求后台的URL（*）
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
                    uniqueId: "forumId",//每一行的唯一标识，一般为主键列
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
                            field: 'forumName',
                            title: '视频名称'
                        },{
                            field: 'forummemIdName',
                            title: '作者名称',
                        },{
                            field: 'forumForid',
                            title: '是否为转发',
                            formatter: function (value, row, index) {
                                var a="";
                                if(row.forumForid != "" && row.forumForid != null && row.forumForid != undefined){
                                    a="转发";
                                }else{
                                    a="原创";
                                }
                                return a;
                            }
                        },{
                            field: 'forumStart',
                            title: '视频状态',
                            formatter: function (value, row, index) {
                                var a="";
                                if(row.forumStart == "0"){
                                    a="未发布";
                                }else if(row.forumStart == "1"){
                                    a="已发布"
                                }else{
                                    a='错误'
                                }
                                return a;
                            }
                        },{
                            field: 'forumHeat',
                            title: '热度',
                        },{
                            field: 'CheckDetails',
                            title: '查看详情',
                            formatter: function (value, row, index) {
                                var a='<a href="VideoDetails?id='+row.forumId+'" title="查看详情" >查看详情</a>';
                                return a;
                            }
                        },{
                            field: 'operate',
                            title: '操作',
                            formatter: function (value, row, index) {
                                var e = '<a href="UpdateVideo?id='+row.forumId+'" title="修改视频信息" style="cursor: pointer"><i class="fa fa-pencil-square-o"></i></a> ';
                                var d = '<a class="remove" title="删除" style="cursor: pointer"> <i class="glyphicon glyphicon-remove"></i></a> ';
                                return e + d;
                            }
                        },
                    ],
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {//这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                	forumWhat: 1,
                    pageSize: params.limit,//页面大小
                    fenye: (params.offset / params.limit) + 1,//页码

//                  offset: params.offset,
                    forumName:params.search
                };
                return temp;
            };
            return oTableInit;
        };

        window.operateEvents = {
		
            'click .remove': function (e, value, row, index) {
            	var r = confirm('确定要删除选中的记录？');
            	if(r==true){
            	$.ajax({
                    type: "post",
                    url: "/Maker/forum/updateForumStart",
                    data: {
                        forumId: row.forumId,
                        forumStart : 2
                         },
                    success: function (data) {
                      if (data.code == 1) {
                            alert("删除成功");
                       $('#TheVideoTable').bootstrapTable('remove', {
		                    field: 'forumId',
		                    values: [row.forumId]
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
            var rows = $('#TheVideoTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
            if (rows.length == 0) {
                confirm("请选择要删除的数据");
                return;
            }
            var r = confirm("确认要删除选中的'" + rows.length + "'个视频吗?");
            if (r == true) {
                var ids = new Array();
                // 遍历所有选择的行数据，取每条数据对应的ID
                $.each(rows, function (i, row) {
                    ids[i] = row['forumId'];
                });
                $.ajax({
                    type: 'POST',
                    url: '/Maker/forum/updateForumListStart',
                    data: {
                        forumId: ids,
                        forumStart : 2
                    },
                    success: function (data) {
                        if (data.code == 1) {
                            alert("删除"+rows.length+"个视频成功！")
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
            $('#TheVideoTable').bootstrapTable('refresh');
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
           

//点击查看文章方法
function CheckDetails(forumId){
	   $('#CheckDetailsModel').modal({backdrop: "static"})
	    $.ajax({
        type: "post",
        url: "/Maker/forum/selectForumMe",   //查看某个文章详情URL
        data: {
            'forumId': forumId
        },
        error: function (request) {
            alert("连接超时");
        },
        success: function (data) {
            if (data.code == 1) {
                com = data.data[0];
                $('#IdforumInfo').val(com.forumInfo);
                $('#IdforumRoute').attr({'src' : "/Maker/user/video/forumVideo/"+com.forumRoute});
                $('#IdforumReltime').val(com.forumReltime);
            } else {
                alert(data.msg);
            }
        }
    }); 
}
