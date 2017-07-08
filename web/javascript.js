/**
 * @author AbuKhleif
 */


// get panel id;
// console.log($('#accordion .in').parent().attr("id"));

// show selected option as dropup text
// $(function () {
//     $(".dropdown-menu li a").click(function () {
//         var item = $(this);
//         var id = item.parent().parent().attr("aria-labelledby");
//         $("#" + id + ':first-child').text($(this).text() + ' ?');
//         console.log();
//
//         switch (this.innerHTML) {
//             case 'Click':
//                 console.log('click');
//                 break;
//             case 'Apples':
//                 console.log('Apples are $0.32 a pound.');
//                 break;
//             case 'Bananas':
//                 console.log('Bananas are $0.48 a pound.');
//                 break;
//             case 'Cherries':
//                 console.log('Cherries are $3.00 a pound.');
//                 break;
//             case 'Mangoes':
//             case 'Papayas':
//                 console.log('Mangoes and papayas are $2.79 a pound.');
//                 break;
//             default:
//                 console.log('hmmmm?');
//         }
//
//     });
// });

$("#selectable").selectable({
    filter: 'tbody tr',
    selected: function (event, ui) {
        $("#sname").val($(ui.selected).find("th").html());
    }
});
snrCtr = 0;
$(".add_scenario").on("click", function () {
    var snrName = document.getElementById('sname').value;
    var scenario = document.createElement('tr');
    scenario.className = 'snr';
    scenario.id = 'scenario_' + ++snrCtr;
    scenario.innerHTML = '<th>' + snrName + '</th>';
    document.getElementById('scenarios').appendChild(scenario);
});
var unitCtr = 0;
$(".add_page").on("click", function () {
    var page_name = document.getElementById('pname').value;
    var page_url = document.getElementById('purl').value;
    var page = document.createElement('tr');
    page.className = 'page';
    page.id = 'unit_' + ++unitCtr;
    page.innerHTML = '<th>' + page_name + ' (' + page_url + ')</th>';
    document.getElementById('scenarios').appendChild(page);
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
