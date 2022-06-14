window.onload = function init() {
    init_chart();
}
var node, link = [], username_list;
function get_node() {
    var url = get_nap() + "User_Comment/get_all_username";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            node = [];
            username_list = data;
            var i = 0;
            for (i = 0; i < data.length; ++i) {
                var tmp = {category:0,name:data[i]};
                node.push(tmp);
            }
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function init_chart() {
    get_node();
    alert(node);
    var chartDom = document.getElementById('chart');
    var myChart = echarts.init(chartDom);
    var option = {
        title: {
            text: '用户关系图',
            subtext: 'Default layout',
            top: 'bottom',
            left: 'right'
        },
        tooltip: {},
        legend: [
            {
                // selectedMode: 'single',
                data: username_list
            }
        ],
        animationDuration: 1500,
        animationEasingUpdate: 'quinticInOut',
        series: [
            {
                name: '用户关系图',
                type: 'graph',
                layout: 'none',
                data: node,
                links: link,
                // categories: graph.categories,
                roam: true,
                label: {
                    position: 'right',
                    formatter: '{b}'
                },
                lineStyle: {
                    color: 'source',
                    curveness: 0.3
                },
                emphasis: {
                    focus: 'adjacency',
                    lineStyle: {
                        width: 10
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}