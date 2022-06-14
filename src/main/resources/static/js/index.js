
window.onload = function init() {
    init_num();
}

function init_num() {
    var url = get_nap() + "Barrage/get_video_bar_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            // $("#barrage_num").html(data);
            var chartDom = document.getElementById('main');
            var myChart = echarts.init(chartDom);
            var option = {
                legend: {
                    // Try 'horizontal'
                    orient: 'vertical',
                    right: 10,
                    top: 'center'
                },
                xAxis: {
                    type: 'category',
                    data: data[0],
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        data: data[1],
                        type: 'line'
                    }
                ]
            };
            myChart.setOption(option);
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });

}