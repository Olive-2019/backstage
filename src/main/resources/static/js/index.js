
window.onload = function init() {
    init_num();
}

function init_num() {
    var url = get_nap() + "Barrage/get_barrage_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            $("#barrage_num").html(data);
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });

    url = get_nap() + "User_Comment/get_user_comment_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            $("#comment_num").html(data);
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });

    url = get_nap() + "Userinfo/get_user_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            $("#user_num").html(data);
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });

    url = get_nap() + "Video/get_video_num";
    $.ajax({
        type: "get",
        url: url,
        async: false,
        success: function(data){
            $("#video_num").html(data);
        },
        error: function (error) {
            alert(JSON.stringify(error));
        }
    });
}