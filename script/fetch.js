$(document).ready(function(){
    $.ajax({
    url: 'http://localhost:9090/file/getFiles',
    headers: {
        'Access-Control-Allow-Origin': '*'
    },
    type: "GET", /* or type:"GET" or type:"PUT" */
    dataType: "json",

    
    success: function (result) {
        console.log(result);
        var cList = $('div.view')
        $.each(result, function(i)
        {
            var h1 = $('<h2/>')
                .addClass('ui-menu-item')
                .appendTo(cList);
            var aaa = $('<a/>')
                .addClass('ui-all')
                .attr('href', 'http://localhost:9090/file/download/'+result[i])
                .text(result[i])
                .appendTo(h1);
        });
    },
    error: function () {
        console.log("error");
    }
});
// $(".view a").click(function(){
//     console.log("clixk works...!")
//   });

$('a').click(function(){
    //do something on click
    alert('jhhdksfh')
});
//function for download file
function downloadFile(){
    console.log($(this).attr('path'));
//     $.ajax({
//     url: 'http://localhost:9090/file/getFiles',
//     headers: {
//         'Access-Control-Allow-Origin': '*'
//     },
//     type: "GET", /* or type:"GET" or type:"PUT" */
//     dataType: "json",

    
//     success: function (result) {
//         console.log(result);
//     },
//     error: function () {
//         console.log("error");
//     }
// });
}
    
 
});

// http://localhost:9090/file/download/