layui.use(['element', 'form', 'laydate'], function () {
    var element = layui.element;
    var form = layui.form;
    var laydate = layui.laydate;

    laydate.render({
        elem: '#exp_se_range',
        type: 'datetime',
        range: '~'
    });
});

