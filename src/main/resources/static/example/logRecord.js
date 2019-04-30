var basicPath = '/adaptor'
var pageSize = 10;
var page = 1;
var pageNum = 5

getPageOfMemo(page);

// 分页函数
function getPageOfMemo(page) {
    var name = $('#search_name').val();
    var content = $('#search_content').val();
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    var nameStr = ""
    var contentStr = ""
    var startDateStr = ""
    var endDateStr = ""
    if (name != null && name != "") nameStr = String(name);
    if (content != null && content != "") contentStr = String(content);
    if (startDate != null && startDate != "") startDateStr = String(startDate);
    if (endDate != null && endDate != "") endDateStr = String(endDate);
    console.log('{'+nameStr+','+contentStr+','+startDateStr+','+endDateStr+'}');
    $.ajax({
        url : basicPath + "/bankData/queryLog",
        type : "POST",
        data:{
            "currentPage":page,
            "pageSize":pageSize,
            "name":nameStr,
            "content":contentStr,
            "startDate":startDateStr,
            "endDate":endDateStr
        },
        dataType : "json",
        success : function(data) {
            var total;
            if (data != null) {
                total = data.total;
                var htm = "";
                $.each(data.list, function(i, item) {
                    htm += "<tr>"
                    htm += "<td width='8%'>"+item.id+"</td>"
                    htm += "<td width='10%'>"+item.name+"</td>"
                    htm += "<td width='10%'>"+timeToStr(item.createAt)+"</td>"
                    htm += "<td>"+item.content+"</td>"
                    htm += "</tr>"
                });
                $('.panel-body table tbody').html(htm); //覆盖tbody部分
                var pages = Math.ceil(total/pageSize); //计算总页数
                console.log("总数:"+total+",总页数:"+pages)
                var element = $('#pageButton');
                var options = {
                    bootstrapMajorVersion : 3,
                    currentPage : page, // 当前页数
                    numberOfPages : pageNum, // 显示按钮的数量
                    totalPages : pages, // 总页数
                    itemTexts : function(type, page, current) {
                        switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "上一页";
                        case "next":
                            return "下一页";
                        case "last":
                            return "末页";
                        case "page":
                            return page;
                        }
                    },
                    // 点击事件，用于通过Ajax来刷新整个list列表
                    onPageClicked : function(event, originalEvent, type, page) {
                        getPageOfMemo(page);
                    }
                };
                element.bootstrapPaginator(options);
            }
        }
    });
};

$(function(){
    $("#btn_query").click(function(){
        getPageOfMemo(page);
    });
    $('#startDate').datetimepicker({
        language:"zh-CN", //汉化
        todayBtn : "true",  //显示今天按钮
        autoclose : true,   //选择日期后自动关闭日期选择框
        todayHighlight : true,   //当天高亮显示
        minView: 0,
        format: 'yyyy-mm-dd hh:ii',
        pickerPosition: "bottom-left"
    }).on('click',function(e){
        $("#startDate").datetimepicker("setEndDate", $("#endDate").val());
    });
    $('#endDate').datetimepicker({
        language:"zh-CN",
        todayBtn : "true",
        autoclose : true,
        todayHighlight : true,
        minView: 0,
        format: 'yyyy-mm-dd hh:ii',
        pickerPosition: "bottom-left"
    }).on('click',function(e){
        $("#endDate").datetimepicker("setStartDate", $("#startDate").val());
    });
});

function timeToStr(time){
    var date = new Date(time);
    var ymd = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
    var hms = date.getHours() + ":" + date.getMinutes();
    var str = ymd +" "+ hms;
    return str
};

function onKeyDown(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
    if(e && e.keyCode==13){ // enter 键
        getPageOfMemo(page);
    }
};
