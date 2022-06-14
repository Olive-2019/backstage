
window.onload = function init() {
    init_chart();
}

function init_chart() {
    var url = get_nap() + "Video/get_video_bar_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            init_chart1(data);
            init_chart2(data);
            init_chart3(data);
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function init_chart1(data) {
    var chartDom = document.getElementById('chart1');
    var myChart = echarts.init(chartDom);
    var option = {
        title: {
            text: '视频统计数据'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['弹幕数', '评论数', '点赞数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: { readOnly: false },
                magicType: { type: ['line', 'bar'] },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: data[0]
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: '弹幕数',
                type: 'line',
                stack: 'Total',
                data: data[1]
            },
            {
                name: '评论数',
                type: 'line',
                stack: 'Total',
                data: data[2]
            },
            {
                name: '点赞数',
                type: 'line',
                stack: 'Total',
                data: data[3]
            }
        ]
    };
    myChart.setOption(option);
}
function init_chart2(data) {
    var chartDom = document.getElementById('chart2');
    var myChart = echarts.init(chartDom);
    var option = {
        color: ['#80FFA5', '#00DDFF', '#37A2FF', '#FF0087', '#FFBF00'],
        title: {
            text: '视频统计数据（叠加）'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data: ['弹幕数', '评论数', '点赞数']
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: { readOnly: false },
                magicType: { type: ['line', 'bar'] },
                restore: {},
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: data[0]
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '弹幕数',
                type: 'line',
                stack: 'Total',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                            offset: 0,
                            color: 'rgb(128, 255, 165)'
                        },
                        {
                            offset: 1,
                            color: 'rgb(1, 191, 236)'
                        }
                    ])
                },
                emphasis: {
                    focus: 'series'
                },
                data: data[1]
            },
            {
                name: '评论数',
                type: 'line',
                stack: 'Total',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                            offset: 0,
                            color: 'rgb(0, 221, 255)'
                        },
                        {
                            offset: 1,
                            color: 'rgb(77, 119, 255)'
                        }
                    ])
                },
                emphasis: {
                    focus: 'series'
                },
                data: data[2]
            },
            {
                name: '点赞数',
                type: 'line',
                stack: 'Total',
                smooth: true,
                lineStyle: {
                    width: 0
                },
                showSymbol: false,
                areaStyle: {
                    opacity: 0.8,
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                            offset: 0,
                            color: 'rgb(55, 162, 255)'
                        },
                        {
                            offset: 1,
                            color: 'rgb(116, 21, 219)'
                        }
                    ])
                },
                emphasis: {
                    focus: 'series'
                },
                data: data[3]
            }
        ]
    };
    myChart.setOption(option);
}
function init_chart3(data) {
    // alert("in chart3");
    var chartDom = document.getElementById('chart3');
    var myChart = echarts.init(chartDom);
    var option = {
        title: {
            text: '视频统计数据（叠加）'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data: ['弹幕数', '评论数', '点赞数']
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: { readOnly: false },
                magicType: { type: ['line', 'bar'] },
                restore: {},
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: data[0]
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '弹幕数',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: data[1]
            },
            {
                name: '评论数',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: data[2]
            },
            {
                name: '点赞数',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: data[3]
            }
        ]
    };
    myChart.setOption(option);
}