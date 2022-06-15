window.onload = function init() {

    get_field_name();
    get_raw_data();
    get_data();
    init_bar_scatter_option();
    init_chart();
    init_pie_chart();
}
var raw_data, data, piedata = [], scatter = [], bar= [], name;
var barOption, scatterOption;
var like_comment, like_mean;
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
function get_mean_like(fieldname) {
    var url = get_nap() + "Field/get_video_like_comment__mean_num_by_fieldname";
    $.ajax({
        type: "get",
        url: url,
        data : 'fieldname='+fieldname,
        async: false,
        success: function(data){
            like_mean = data;
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function get_data() {
    var all_field = [];
    piedata = [];
    scatter = [], bar= [];
    for (var key in raw_data) {
        var all_video = [];
        get_like_comment(key);
        get_mean_like(key);
        bar.push({value:like_mean, groupId : key})
        scatter.push({
            type:'scatter',
            id : key,
            dataGroupId : key,
            name : key,
            universalTransition: {
                enabled: true,
                delay: function (idx, count) {
                    return Math.random() * 400;
                }
            },
            data: like_comment
        });
        var pie = {value : raw_data[key].length, name:key};
        piedata.push(pie);
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
    var chartDom = document.getElementById('chart');
    var myChart = echarts.init(chartDom);
    var option = {
        title: {
            text: '分区内容',
            x:'center',
            y:'top',
            textAlign:'center'
        },
        tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove'
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: { readOnly: false },
                saveAsImage: {

                }
            }
        },
        series: [
            {
                type: 'tree',
                data: [data],
                top: '1%',
                left: '7%',
                bottom: '1%',
                right: '20%',
                symbolSize: 20,
                label: {
                    position: 'left',
                    verticalAlign: 'middle',
                    align: 'right',
                    fontSize: 20
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
function get_field_name() {
    var url = get_nap() + "Field/get_field_name";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            name = data;
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });

}
function init_pie_chart() {
    var chartDom = document.getElementById('piechart');
    var myChart = echarts.init(chartDom);
    var option =  {
        title: {
            text: '分区包含视频数',
            x:'center',
            y:'top',
            textAlign:'center'
        },
        legend: {
            top: 'bottom'
        },
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: { readOnly: false },
                saveAsImage: {

                }
            }
        },
        series: [
            {
                name: 'Nightingale Chart',
                type: 'pie',
                radius: [50, 200],
                center: ['50%', '50%'],
                roseType: 'area',
                itemStyle: {
                    borderRadius: 8
                },
                data: piedata
            }
        ]
    };
    myChart.setOption(option);
}
function get_like_comment(fieldname){
    var url = get_nap() + "Field/get_video_like_comment_num_by_fieldname";
    $.ajax({
        type: "get",
        url: url,
        data : 'fieldname='+fieldname,
        async: false,
        success: function(data){
            // console.log(data);
            like_comment = data;
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function init_bar_scatter_option() {
    scatterOption = (option = {
        title: {
            text: '分区视频质量',
            x:'center',
            y:'top',
            textAlign:'center'
        },
        xAxis: {
            scale: true,
            name:'评论数'
        },
        yAxis: {
            scale: true,
            name : '点赞数'
        },legend: {
            top: 'bottom'
        },
        series:scatter
    });
    var mean = 0;

    barOption = {
        title: {
            text: '分区视频质量',
            x:'center',
            y:'top',
            textAlign:'center'
        },
        xAxis: {
            type: 'category',
            data: String(name).split(','),
            name : '分区'
        },
        yAxis: {name : '点赞数'},
        series: [
            {
                type: 'bar',
                id: 'total',
                data: bar,
                universalTransition: {
                    enabled: true,
                    seriesKey: String(name).split(','),
                    delay: function (idx, count) {
                        return Math.random() * 400;
                    }
                }
            }
        ]
    };
    var chartDom = document.getElementById('bar_scatter_chart');
    var myChart = echarts.init(chartDom);
    myChart.setOption(scatterOption, true);
}

let currentOption = scatterOption;
setInterval(function () {
    currentOption = currentOption === scatterOption ? barOption : scatterOption;
    var chartDom = document.getElementById('bar_scatter_chart');
    var myChart = echarts.init(chartDom);
    myChart.setOption(currentOption, true);
}, 900);