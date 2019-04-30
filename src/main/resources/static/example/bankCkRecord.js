var basicPath = '/adaptor'
var pageSize = 10;
var page = 1;
var pageNum = 5

getPageOfMemo(page);

// 分页函数
function getPageOfMemo(page) {
    var check = $('#search_check').val();
    var startDate = $('#startDate').val();
    var endDate = $('#endDate').val();
    var oppAcctNo = $('#search_acctNo').val();
    var oppBkName = $('#search_acctBank').val();
    var oppName = $('#search_oppName').val();
    var amount = $('#search_amount').val();
    if (check == "" || check == null) check = "AbcErp";
    var startDateStr = ""
    var endDateStr = ""
    var oppAcctNoStr = ""
    var oppBkNameStr = ""
    var oppNameStr = ""
    var amountStr = ""
    if (startDate != null && startDate != "") startDateStr = handleDateStr(startDate);
    if (endDate != null && endDate != "") endDateStr = handleDateStr(endDate);
    if (oppAcctNo != null && oppAcctNo != "") oppAcctNoStr = String(oppAcctNo);
    if (oppBkName != null && oppBkName != "") oppBkNameStr = String(oppBkName);
    if (oppName != null && oppName != "") oppNameStr = String(oppName);
    if (amount != null && amount != "") amountStr = String(amount);
    var abcOrHxStr = ""
    if (check == "HxErp"){
        var hxZhdNo = $('#search_zhdNo').val();
        if (hxZhdNo != null && hxZhdNo != "") abcOrHxStr = String(hxZhdNo);
    } else {
        var abcAcctName = $('#search_acctName').val();
        if (abcAcctName != null && abcAcctName != "--") abcOrHxStr = String(abcAcctName);
    }
    console.log(page+','+check+','+startDateStr+','+endDateStr+','+oppAcctNoStr+','+oppBkNameStr+','+abcOrHxStr+','+oppNameStr+','+amountStr);
    $.ajax({
        url : basicPath + "/bankData/queryBank",
        type : "POST",
        data:{
            "currentPage":page,
            "pageSize":pageSize,
            "check":check,
            "startDate":startDateStr,
            "endDate":endDateStr,
            "oppAcctNo":oppAcctNoStr,
            "oppBkName":oppBkNameStr,
            "abcOrHx":abcOrHxStr,
            "oppName":oppNameStr,
            "amount":amountStr
            },
        dataType : "json",
        success : function(data) {
            var total;
            if (data != null) {
                total = data.total;
                var htm = "";
                $.each(data.list, function(i, item) {
                    createTableThead(check)
                    htm += "<tr style='text-align: center'>"
                    htm += "<td style='width: 120px'>"+item.id+"</td>"
                    if (check == "HxErp"){
                        htm += "<td style='width: 100px'>"+handleNull(item.transDate)+"</td>"
                        htm += "<td style='width: 100px'>"+handleNull(item.transTime)+"</td>"
                        htm += "<td style='width: 200px'>"+handleNull(item.amount)+"</td>"
                        htm += "<td>"+handleNull(item.acctNo)+"</td>"
                        htm += "<td>"+handleNull(item.acctName)+"</td>"
                        htm += "<td>"+handleNull(item.acctBank)+"</td>"
                        htm += "<td>"+handleNull(item.zhdAcctNo)+"</td>"
                        htm += "<td>"+handleNull(item.serial)+"</td>"
                        htm += "<td>"+handleNull(item.cropSerial)+"</td>"
                    } else {
                        htm += "<td style='width: 100px'>"+handleNull(item.trDate)+"</td>"
                        htm += "<td style='width: 100px'>"+handleDate(item.timeStab)+"</td>"
                        htm += "<td style='width: 200px'>"+handleNull(item.amt)+"</td>"
                        htm += "<td>"+handleNull(item.oppAccNo)+"</td>"
                        htm += "<td>"+handleNull(item.oppName)+"</td>"
                        htm += "<td>"+handleNull(item.oppBkName)+"</td>"
                        htm += "<td>"+handleNull(item.accName)+"</td>"
                        htm += "<td>"+handleNull(item.postScript)+"</td>"
                    }
                    htm += "</tr>"
                });
                $('.panel-body table tbody').html(htm); //覆盖tbody部分
                var pages = Math.ceil(total/pageSize); //计算总页数
                if (pages <= 5) pageNum = pages;
                else pageNum = 5;
                console.log("总数:"+total+",总页数:"+pages+",显示按钮:"+pageNum+",page:"+page)
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

$(function(){// 初始化内容
    //默认农行数据展示
    $("#label_acctName").show();
    $("#div_acctName").show();
    $("#label_zhdNo").hide();
    $("#div_zhdNo").hide();

    $("#btn_query").click(function(){
        getPageOfMemo(page);
    });
    $('#startDate').datetimepicker({
        language:"zh-CN", //汉化
        todayBtn : "true",  //显示今天按钮
        autoclose : true,   //选择日期后自动关闭日期选择框
        todayHighlight : true,   //当天高亮显示
        minView: 2,   //不显示时分秒
        format: 'yyyy-mm-dd',
        pickerPosition: "bottom-left"
    }).on('click',function(e){
        $("#startDate").datetimepicker("setEndDate", $("#endDate").val());
    });
    $('#endDate').datetimepicker({
        language:"zh-CN",
        todayBtn : "true",
        autoclose : true,
        todayHighlight : true,
        minView: 2,
        format: 'yyyy-mm-dd',
        pickerPosition: "bottom-left"
    }).on('click',function(e){
        $("#endDate").datetimepicker("setStartDate", $("#startDate").val());
    });
});

function btnChange(value){
    console.log("change:"+value)
    //清空条件数据
    $("#startDate").val("");
    $("#endDate").val("");
    $("#search_acctNo").val("");
    $("#search_oppName").val("");
    $("#search_amount").val("");
    $("#search_zhdNo").val("");
    $("#search_acctName").val("--");
    if (value == "HxErp") {//华夏数据展示收款账号条件框
        $("#label_zhdNo").show();
        $("#div_zhdNo").show();
        $("#label_acctName").hide();
        $("#div_acctName").hide();
    } else {//农行数据展示公司名称条件框
        $("#label_acctName").show();
        $("#div_acctName").show();
        $("#label_zhdNo").hide();
        $("#div_zhdNo").hide();
    }
    page = 1;
};

function createTableThead(check){
    var theadHtm = "";
    theadHtm += "<tr class='thead'>"
    theadHtm += "<th>编号</th>"
    theadHtm += "<th>交易日期</th>"
    theadHtm += "<th>交易时间</th>"
    theadHtm += "<th>交易金额</th>"
    theadHtm += "<th>对方账号</th>"
    theadHtm += "<th>对方公司名</th>"
    theadHtm += "<th>对方开户行</th>"
    if (check == "HxErp") {//华夏
    	theadHtm += "<th>收款方账号</th>"
        theadHtm += "<th>会计流水</th>"
        theadHtm += "<th>企业端流水号</th>"
    } else {//农行
    	theadHtm += "<th>收款公司名</th>"
        theadHtm += "<th>备注内容</th>"
    }
    theadHtm += "</tr>"
    $('.panel-body table thead').html(theadHtm); //覆盖thead部分
};

function handleNull(value){
    var result = ""
    if (value != null) result = String(value);
    return result
};

function handleDate(value){
    var result = value
    if (value != null && value.length > 12) {//20181218120923626162
        result = value.substring(8,10)+":"+value.substring(10,12)+":"+value.substring(12,14);
    }
    return result
};

String.prototype.replaceAll  = function(s1,s2){
        return this.replace(new RegExp(s1,"gm"),s2);
}

function handleDateStr(date){
    var str = String(date)
    str = str.replaceAll("-","");
    return str
};