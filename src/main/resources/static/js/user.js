window.onload = function init() {
    var url = get_nap() + "Userinfo/get_all_user";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            var table = document.getElementById('user_table');
            for (var i = 0; i < data.length; ++i) {
                var tr = document.createElement('tr');
                tr.setAttribute('class', "odd gradeX");
                table.appendChild(tr);

                var username = document.createElement('td');
                username.innerHTML = data[i]['username'];
                tr.appendChild(username);

                var nickname = document.createElement('td');
                nickname.innerHTML = data[i]['nickname'];
                tr.appendChild(nickname);

                var point = document.createElement('td');
                point.innerHTML = data[i]['point'];
                tr.appendChild(point);

                var td  = document.createElement('td');
                var button = document.createElement('input');

                button.setAttribute('type','button');
                button.setAttribute('value','删除');
                button.setAttribute('onclick', 'delete_user()');
                button.setAttribute('data-username', data[i]['username']);

                tr.appendChild(td);
                td.appendChild(button);
            }
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}

function delete_user() {
    var url = get_nap() + "Userinfo/delete_user?username=" + (event.currentTarget).getAttribute('data-username');
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            alert("删除用户");
            location.reload();
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}