/**
 * @author AbuKhleif
 */

// get panel id;
// console.log($('#accordion .in').parent().attr("id"));

// show selected option as dropup text
$(function () {
    $(".dropdown-menu li a").click(function () {
        var item = $(this);
        var id = item.parent().parent().attr("aria-labelledby");

        $("#" + id + ':first-child').text($(this).text() + '☝');
    });
});

var unitCtr = 0;
$(".add_page").on("click", function () {
    console.log("heeee");
    var page_name = document.getElementById('pname').value;
    var page_url = document.getElementById('purl').value;
    var div = document.createElement('div');
    div.className = 'panel panel-default';
    div.id = unitCtr.toString();
    div.innerHTML = '<div class="panel-heading\">\
    <h3 class="panel-title">\
    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#page_' + ++unitCtr + '">\ ' +
        '<span class="glyphicon glyphicon-arrow-right"></span> 	 ' +
        'Page: ' + page_name + ' (' + page_url + ')' + '</a>\
    </h3>\
    </div>\
    <div id="page_' + unitCtr + '" class="panel-collapse collapse">\
    <div class="panel-body">\
    <div class="row">\
    <div class="panel-group" id="accordion_' + unitCtr + '">\
    </div></div></div></div>';
    document.getElementById('accordion').appendChild(div);
    $('#accordion .in').collapse('hide');
    setTimeout(function () {
        $('#page_' + unitCtr).collapse('show');
    }, 500);
});

$(".add_form").on("click", function () {
    var form_name = document.getElementById('fname').value;
    var form_url = document.getElementById('furl').value;
    var div = document.createElement('div');
    div.className = 'panel panel-default';
    div.innerHTML = '<div class="panel-heading\">\
    <h3 class="panel-title">\
    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#form_' + ++unitCtr + '">\ ' +
        '<span class="glyphicon glyphicon-arrow-right"></span> 	 ' +
        'Form: ' + form_name + ' (' + form_url + ')' + '</a>\
    </h3>\
    </div>\
    <div id="form_' + unitCtr + '" class="panel-collapse collapse">\
    <div class="panel-body">\
    <div class="row">\
    <div class="panel-group" id="accordion_' + unitCtr + '">\
    </div></div></div>\</div>';
    document.getElementById('accordion').appendChild(div);
});

// var pgCtr = 1;
// $(".add_page").on("click", function () {
//     var pname = document.getElementById('pname').value;
//     var purl = document.getElementById('purl').value;
//     var div = document.createElement('div');
//     div.className = 'panel panel-default template';
//     div.innerHTML = '<div class="panel-heading\">\
//     <h5 class="panel-title"> Child  \
//     <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion' + unitCtr + '" href="#scenario_' + ++pgCtr + '">\ ' +
//         '<span class="glyphicon glyphicon-arrow-right"></span> 	' + pname + '(' + purl + ')' + '</a>\
//     </h5>\
//     </div>\
//     <div id="scenario_' + unitCtr + '_page_' + pgCtr + '" class="panel-collapse collapse in">\
//     <div class="panel-body">hello\
//     </div>\</div>';
//     document.getElementById('scenario_1').children[0].children[0].children[0].appendChild(div);
// });
