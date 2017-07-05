/**
 * @author AbuKhleif
 */


var snrCtr = 0;
$(".add_senario").on("click", function () {
    var senario_name = document.getElementById('sname').value;
    var div = document.createElement('div');
    div.className = 'panel panel-default template';
    div.innerHTML = '<div class="panel-heading\">\
    <h3 class="panel-title">\
    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#scenario_' + ++snrCtr + '">\ ' +
        '<span class="glyphicon glyphicon-arrow-right"></span> 	 ' +
        senario_name + '</a>\
    </h3>\
    </div>\
    <div id="scenario_' + snrCtr + '" class="panel-collapse collapse">\
    <div class="panel-body">\
    <div class="row">\
    <div class="panel-group" id="accordion_' + snrCtr + '">\
    </div></div></div>\</div>';
    document.getElementById('accordion').appendChild(div);
});

var pgCtr = 1;
$(".add_page").on("click", function () {
    var pname = document.getElementById('pname').value;
    var purl = document.getElementById('purl').value;
    var div = document.createElement('div');
    div.className = 'panel panel-default template';
    div.innerHTML = '<div class="panel-heading\">\
    <h5 class="panel-title"> Child  \
    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion' + snrCtr + '" href="#scenario_' + ++pgCtr + '">\ ' +
        '<span class="glyphicon glyphicon-arrow-right"></span> 	' + pname + '(' + purl + ')' + '</a>\
    </h5>\
    </div>\
    <div id="scenario_' + snrCtr + '_page_' + pgCtr + '" class="panel-collapse collapse in">\
    <div class="panel-body">hello\
    </div>\</div>';
    document.getElementById('scenario_1').children[0].children[0].children[0].appendChild(div);
});
