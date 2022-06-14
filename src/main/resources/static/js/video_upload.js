window.onload = function init() {
    init_date_chart();
}
function init_date_chart() {
    var url = get_nap() + "Video/get_video_uploadtime_month";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            init_chart4(data);

        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}


function init_chart4(data1) {
    let date = data1[0];
    let data = data1[1];

    var chartDom = document.getElementById('chart4');
    var myChart = echarts.init(chartDom);
    var option = {

        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '视频上传时间'
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: date
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%']
        },
        dataZoom: [
            {
                type: 'inside',
                start: 0,
                end: 10
            },
            {
                start: 0,
                end: 10
            }
        ],
        series: [
            {
                name: '视频数',
                type: 'line',
                symbol: 'none',
                sampling: 'lttb',
                itemStyle: {
                    color: 'rgb(255, 70, 131)'
                },
                areaStyle: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                        {
                            offset: 0,
                            color: 'rgb(255, 158, 68)'
                        },
                        {
                            offset: 1,
                            color: 'rgb(255, 70, 131)'
                        }
                    ])
                },
                data: data
            }
        ]
    };
    myChart.setOption(option);
}