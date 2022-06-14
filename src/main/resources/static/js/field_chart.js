window.onload = function init() {
    init_chart();
}
var raw_data, data;
function get_raw_data() {
    var url = get_nap() + "Field/get_field_child";
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
function get_data() {
    get_raw_data();
    var all_field = [];
    for (var key in raw_data) {
        var all_video = [];
        // console.log(key);
        for (var video_title in raw_data[key]) {
            var video = {children : [], name: video_title};
            all_video.push(video);
        }
        var field = {children: all_video, name:key};
        all_field.push(field);
    }
    data = {children: all_field, name:'video'};
}
function init_chart() {
    get_data();
    var chartDom = document.getElementById('chart');
    var myChart = echarts.init(chartDom);
    var option = {
        tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove'
        },
        series: [
            {
                type: 'tree',
                data: [data],
                top: '1%',
                left: '7%',
                bottom: '1%',
                right: '20%',
                symbolSize: 7,
                label: {
                    position: 'left',
                    verticalAlign: 'middle',
                    align: 'right',
                    fontSize: 9
                },
                leaves: {
                    label: {
                        position: 'right',
                        verticalAlign: 'middle',
                        align: 'left'
                    }
                },
                emphasis: {
                    focus: 'descendant'
                },
                expandAndCollapse: true,
                animationDuration: 550,
                animationDurationUpdate: 750
            }
        ]
    };
    myChart.setOption(option);
}