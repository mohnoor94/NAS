<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <%--<link href="css/bootstrap-combined.min.css" rel="stylesheet">--%>
    <link href="css/custome.css" rel="stylesheet">
    <title>Tests Generator</title>

    <%-- js --%>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/npm.js"></script>
</head>
<body>
<div hidden id="test" class="template"></div>
<h1 style="text-align: center">Tests Generator</h1>
<hr/>

<div align="center">
    <h3 align="center">Site Details</h3>
    <form action="generator" method="GET" class="form-inline">
        <div site>
            <%--<input type="hidden" name="command" value="SITE"/>--%>
            <div class="form-group">
                <label for="name">Site Name:</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="url">URL:</label>
                <input type="text" class="form-control" id="url" name="url">
            </div>
            <div class="form-group">
                <label for="xml">XML File Title:</label>
                <input type="text" class="form-control" id="xml" name="xml">
            </div>
        </div>
        <div id="snr" hidden>
            <div class="form-group">
                <label for="snr_name">Add Scenario:</label>
                <input type="text" class="form-control" id="snr_name" name="snr_name">
            </div>
        </div>
    </form>
    <hr/>
</div>
<div class="container">
    <h3 align="center">Scenarios</h3>
    <div class="row">
        <%--<div class="col-xs-8">--%>
        <div class="panel-group" id="accordion">
            <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"--%>
            <%--href="#collapseOne">--%>
            <%--Collapsible Group Item #1--%>
            <%--</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="collapseOne" class="panel-collapse collapse in">--%>
            <%--<div class="panel-body">--%>
            <%--Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad--%>
            <%--squid.--%>
            <%--3 wolf moon officia aute, non cupidatat skateboard dolor brunch.--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="panel panel-default template">--%>
            <%--<div class="panel-heading">--%>
            <%--<h4 class="panel-title">--%>
            <%--<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion"--%>
            <%--href="#collapseThree">--%>
            <%--Collapsible Group Item #2 (template panel)--%>
            <%--</a>--%>
            <%--</h4>--%>
            <%--</div>--%>
            <%--<div id="collapseThree" class="panel-collapse collapse">--%>
            <%--<div class="panel-body">--%>
            <%--Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad--%>
            <%--squid.--%>
            <%--3 wolf moon officia aute, non cupidatat skateboard dolor brunch.--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>
        </div>
        <br/>

        <%--</div>--%>
        <%--<div class="col-xs-4">--%>
        <%--</div>--%>
    </div>
</div>

<br/>
<br/>
<br/>
<br/>
<br/>
<footer>
    <div class="navbar navbar-inverse navbar-fixed-bottom">
        <div class="container">
            <div class="navbar-collapse collapse" id="footer-body">
                <ul class="nav navbar-nav">

                    <div style="display: table-cell; vertical-align: middle;">
                        <li>
                            <div class="form-inline">
                                <label for="sname">Scenario Name:</label>
                                <input type="text" class="form-control" id="sname" name="sname">
                            </div>
                        </li>
                        <li>
                            <button class="btn btn-primary btn-add-panel">
                                <i class="glyphicon glyphicon-plus"></i> Add Scenario
                            </button>
                        </li>
                    </div>
            </div>
                </ul>
            </div>
        </div>
    </div>
</footer>
<script src="javascript.js"></script>
</body>


<script>
    function hide(id) {
        document.getElementById(id).hidden = "hidden";
    }

    function show(id) {
        document.getElementById(id).hidden = "";
    }
</script>
</html>