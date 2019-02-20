/*文件上传*/
$(function () {
    uploadVideo("IpUpdevVideo");
     // 给视频类型下拉框动态加载数据
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
                var select1 = $("#IpdevSpeciality");
                var html1 = '';
                var rows = data.data;
                var selected = '';
                //选择已勾选
                for (var i = 0; i < rows.length; i++) {
                    html1 += '<option value="' + rows[i].tpId + '">' + rows[i].tpName + '</option>';
                }
                select1.append(html1);

                select1.selectpicker('refresh');
            } else {
                // alert(msg);//出错执行
            }
        }
    });

});

/*视频文件上传*/
function uploadVideo(video) {
    var control = $('#' + video);
    control.fileinput({
        language: 'zh',
        theme: 'explorer',
        uploadUrl: '/Maker/forum/addForVideo',
        allowedFileExtensions: ['mp4'],
        showUpload: true, //是否显示上传按钮
        showCaption: true,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        maxFileSize: 10000,//单位为kb，如果为0表示不限制文件大小
        minFileCount: 1,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        dropZoneTitle:"可拖拽文件...<br/>只支持MP4格式...<br/>请不要上传大于10M的文件",
        uploadExtraData: function(previewId, index) {   //额外参数的关键点
            var data = {
                forumName : $('#IpforumName').val(),
                forumInfo : $('#IpforumInfo').val(),
                forumType : $("#IpdevSpeciality  option:selected").text(),
                forumStart : $("#IpforumStart  option:selected").val()
            };
            data=JSON.stringify(data);
            data= $.parseJSON(data);
            return data;
        },
    }).on("fileuploaded", function (event, data) {
        if (data.code == 1) {
            window.location.reload();
        }else if (data.code == 0){
            alert("上传失败!")
        }
    });
}
