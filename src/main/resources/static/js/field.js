window.onload = function init() {
    var url = get_nap() + "Field/get_all_fields";
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

                data_title = ['fieldid', 'fieldname'];
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
    var url = get_nap() + "Field/delete_field?fieldid=" + (event.currentTarget).getAttribute('data-target');
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


function add_field() {
    var fieldname = $("#field_name").val();
    var url = get_nap() + "Field/add_field?fieldname=" + fieldname;
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            alert("成功添加分区");
            location.reload();
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}