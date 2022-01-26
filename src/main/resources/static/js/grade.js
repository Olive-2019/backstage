window.onload = function init() {
    var url = get_nap() + "Grade/get_all_grades";
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

                data_title = ['grade', 'lowpoint', 'highpoint'];
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
                button.setAttribute('data-target', data[i][data_title[0]]);

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
    var url = get_nap() + "Grade/delete_grade?grade=" + (event.currentTarget).getAttribute('data-target');
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function (data) {
            alert("删除成功");
            location.reload();
        },
        error: function (error) {
            alert("可能数据有误");
            alert(JSON.stringify(error));
        }
    });

}











function add_grade() {
    var url = get_nap() + "Grade/insert_grade?grade=" + $("#grade").val()
        + "&lowpoint=" + $("#low").val() + "&highpoint=" + $("#high").val();
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function (data) {
            if (data == true) {
                alert("添加成功");
                location.reload();
            }
            else alert("该等级代号已存在");
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}