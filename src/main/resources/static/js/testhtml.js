$(function(){
    console.log('start ...')
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
});