/**
 * @author AbuKhleif
 */



var $template = $(".template");

var hash = 1;
$(".btn-add-panel").on("click", function () {
    var senario_name = document.getElementById('sname').value;
    // var $newPanel = $template.clone();
    // $newPanel.find(".collapse").removeClass("in");
    // $newPanel.find(".accordion-toggle").attr("href",  "#" + )
    //     .text(document.getElementById('sname').value);
    // $newPanel.find(".panel-collapse").attr("id", hash).addClass("collapse").removeClass("in");
    // $("#accordion").append($newPanel.fadeIn());

    var div = document.createElement('div');
    div.className = 'panel panel-default template';
    div.innerHTML = '<div class="panel-heading">\
    <h4 class="panel-title">\
    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#scenario_' + ++hash + '">' + senario_name +
        '</a>\
    </h4>\
    </div>\
    <div id="scenario_' + hash + '" class="panel-collapse collapse">\
    <div class="panel-body">\ hahah</div>';

    document.getElementById('accordion').appendChild(div);
});
