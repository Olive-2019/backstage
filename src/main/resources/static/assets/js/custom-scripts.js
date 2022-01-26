/*------------------------------------------------------
    Author : www.webthemez.com
    License: Commons Attribution 3.0
    http://creativecommons.org/licenses/by/3.0/
---------------------------------------------------------  */

(function ($) {
    "use strict";
    var mainApp = {

        initFunction: function () {
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
			
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });

            /* MORRIS BAR CHART
			-----------------------------------------*/
            var videos=[];
            var watches=[];
            var likes=[];
            var barrages=[];



            $.ajax({
                type: "get",
                url: get_nap()+"video_Display_Page/get_hot_videos",
                async:false,
                success: function(data){
                    videos=data;
                    for(var i=0;i<videos.length;i++){
                        $.ajax({
                            type: "get",
                            url: get_nap()+"history/get_data_by_ID?videoID="+videos[i]['videoid'],
                            async:false,
                            success:function (data) {
                                watches.push(data[0]);
                                likes.push(data[1]);
                                barrages.push(data[2]);
                            },
                            error: function (error) {
                             //  alert(JSON.stringify(error));
                            }
                        });
                    }
                },
                error: function (error) {
                 //   alert(JSON.stringify(error));
                }
            });

            var Morris_data=[];
            for(var i=0;i<videos.length;i++){
                var temp={
                    y:videos[i]['title'],
                    a:watches[i],
                    b:likes[i],
                    c:barrages[i]
                };
                Morris_data.push(temp);
            }


            Morris.Bar({
                element: 'morris-bar-chart',
                data: Morris_data,
                xkey: 'y',
                ykeys: ['a', 'b','c'],
                labels: ['播放量', '点赞数','弹幕数'],
				 barColors: [
    '#A6A6A6','#1cc09f',
    '#A8E9DC' 
  ],
                hideHover: 'auto',
                resize: true
            });
	 


            /* MORRIS DONUT CHART
			----------------------------------------*/


            /* MORRIS AREA CHART
			----------------------------------------*/

            /* MORRIS LINE CHART
			----------------------------------------*/

            var watches=[];
            var dates=[];

            $.ajax({
                type: "get",
                url: get_nap()+"history/get_watches",
                async:false,
                success: function(data){
                    watches=data;
                },
                error: function (error) {
                    alert(JSON.stringify(error));
                }
            });
            var d = new Date();
            for(var i=1;i<=10;i++){
                var year=d.getFullYear();
                year=2022;
                var month=d.getMonth();
                month=1;
                var day=d.getDate()-i;
                dates.push(year+"-"+month+"-"+day);
            }
            var morris_data=[];
            for(var i=0;i<10;i++){
                var temp={
                    y:dates[i],
                    a:watches[i],
                }
                morris_data.push(temp);
            }

            Morris.Line({
                element: 'morris-line-chart',
                data: morris_data,
                xkey: 'y',
                ykeys: ['a'],
                labels: ['Total Income'],
                fillOpacity: 0.6,
                hideHover: 'auto',
                behaveLikeLine: true,
                resize: true,
                pointFillColors:['#ffffff'],
                pointStrokeColors: ['black'],
                lineColors:['gray','#1cc09f']
	  
            });
           
     
        },

        initialization: function () {
            mainApp.initFunction();

        }

    }
    // Initializing ///

    $(document).ready(function () {
        mainApp.initFunction(); 
		$("#sideNav").click(function(){
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
				
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'}); 
			}
		});
    });

}(jQuery));


var usernames=[];
var videos=[];
var watches=[];
var likes=[];
$.ajax({
    type:"get",
    url:"http://localhost:8881/Userinfo/get_hot_author",
    async:false,
    success:function(data){
        usernames=data;
        for(var i=0;i<usernames.length;i++){
            $.ajax({
                type:"get",
                url:"http://localhost:8881/Userinfo/get_author_info?username="+usernames[i],
                async:false,
                success:function (data) {
                    videos.push(data[0]);
                    watches.push(data[1]);
                    likes.push(data[2]);
                },
                error:function (error) {
                    alert(error)
                }
            });
        }
    },
    error:function (error) {
        alert("SAdasd");
        alert(error);
    }
});
var example=document.getElementById("tr_example");
for(var i=0;i<usernames.length;i++){
    var clone=example.cloneNode(true);
    var tds=clone.getElementsByTagName("td");
    tds[0].innerText=i;
    tds[1].innerText=usernames[i];
    tds[2].innerText=videos[i];
    tds[3].innerText=watches[i];
    tds[4].innerText=likes[i];
    clone.setAttribute("style","");
    var table_body=document.getElementById("table_body");
    table_body.append(clone);
}




