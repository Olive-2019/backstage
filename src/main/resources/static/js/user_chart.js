window.onload = function init() {
    init_chart();
}
var nodes, links = [], username_list;
function get_node() {
    var url = get_nap() + "Userinfo/get_all_username";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            nodes = [];
            username_list = data;
            var i = 0;
            for (i = 0; i < data[0].length; ++i) {
                var ca, symbol_size;
                if (data[1][i] == '0') ca = 0, symbol_size = 10;
                else if (data[1][i] == '1') ca = 1, symbol_size = 20;
                var tmp = {category:ca, name:data[0][i], label : data[0][i], symbolSize: symbol_size};
                nodes.push(tmp);
            }
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function get_link() {
    var url = get_nap() + "Userinfo/get_all_link";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            links = [];
            var i = 0;
            for (i = 0; i < data[0].length; ++i) {
                var tmp = {source : data[0][i],  target : data[1][i], weight: 1, name:'关注'};
                links.push(tmp);
            }
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function init_chart() {
    get_node();
    get_link();
    var title = "用户关系图";
    var categories= [{name:"管理员"},{name:"普通用户"}];
    var chartDom = document.getElementById('chart');
    var myChart = echarts.init(chartDom);
    var option = {
        title: {
            text: title,
            subtext: 'Circular layout',
            top: 'bottom',
            left: 'right'
        },
        tooltip: {},
        legend: [
            {
                data: categories.map(function (a) {
                    return a.name;
                })
            }
        ],
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        series: [
            {
                name: title,
                type: 'graph',
                layout: 'circular',
                circular: {
                    rotateLabel: true
                },
                data: nodes,
                links: links,
                categories: categories,
                roam: true,
                label: {
                    position: 'right',
                    formatter: '{b}'
                },
                lineStyle: {
                    color: 'source',
                    curveness: 0.3
                }
            }
        ]
    };

    myChart.setOption(option);
}