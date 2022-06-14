
var chartDom = document.getElementById('chart');
var myChart = echarts.init(chartDom);
var option;
var time, raw_data, fieldname, index;
window.onload = function init() {
    index = 0;
    get_data();
    get_fieldname();
    get_time();
    init_option();
}
function get_fieldname() {
    var url = get_nap() + "Field/get_field_name";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            fieldname = data;
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function get_time() {
    var url = get_nap() + "Video/get_upload_ym";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            time = data;
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function get_data() {
    var url = get_nap() + "Field/get_cur_video_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            raw_data = data;
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function init_option() {
    option = {
        xAxis: {
            max: 'dataMax'
        },
        yAxis: {
            type: 'category',
            data: fieldname,
            inverse: true,
            animationDuration: 300,
            animationDurationUpdate: 300,
            max: 5 // only the largest 3 bars will be displayed
        },
        series: [
            {
                realtimeSort: true,
                name: '当月视频数',
                type: 'bar',
                data: raw_data[0],
                label: {
                    show: true,
                    position: 'right',
                    valueAnimation: true
                }
            }
        ],
        legend: {
            show: true
        },
        animationDuration: 0,
        animationDurationUpdate: 3000,
        animationEasing: 'linear',
        animationEasingUpdate: 'linear',
        graphic: {
            elements: [
                {
                    type: 'text',
                    right: 160,
                    bottom: 60,
                    style: {
                        text: time[0],
                        font: 'bolder 80px monospace',
                        fill: 'rgba(100, 100, 100, 0.25)'
                    },
                    z: 100
                }
            ]
        }
    };
    myChart.setOption(option);
}
function run() {
    if (index < time.length) {
        option.graphic.elements[0].style.text = time[index];
        option.series[0]['data'] = raw_data[index];
        myChart.setOption(option);
        index+=1;
    }
}
setTimeout(function () {
    run();
}, 0);
setInterval(function () {
    run();
}, 1000);