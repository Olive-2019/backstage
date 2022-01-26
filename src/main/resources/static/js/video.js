window.onload = function init() {
    var url = get_nap() + "Video/get_all_videos";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            var table = document.getElementById('table');
            for (var i = 0; i < data.length; ++i) {
                var tr = document.createElement('tr');
                tr.setAttribute('class', "odd gradeX");
                table.appendChild(tr);

                data_title = ['videoid', 'title', 'description', 'uploader', 'uploadtime'];
                for (var j = 0; j < data_title.length; ++j) {
                    var td = document.createElement('td');
                    td.innerHTML = data[i][data_title[j]];
                    tr.appendChild(td);
                }


                var td  = document.createElement('td');
                var button = document.createElement('input');

                button.setAttribute('type','button');
                button.setAttribute('value','删除');
                button.setAttribute('onclick', 'delete_record()');
                button.setAttribute('data-target', data[i]['videoid']);

                tr.appendChild(td);
                td.appendChild(button);
            }
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}
function delete_record() {
    var url = get_nap() + "Video/delete_video?videoid=" + (event.currentTarget).getAttribute('data-target');
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            alert("删除视频");
            location.reload();
        },
        error: function (error) {
            alert("违反完整性约束")
            // alert(JSON.stringify(error));
        }
    });
}
