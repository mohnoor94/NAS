<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <%--<link href="css/bootstrap-combined.min.css" rel="stylesheet">--%>
    <link href="css/custom.css" rel="stylesheet">
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
        <div id="site">
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
    </form>
    <hr/>
</div>
<div align="center">
    <h3 align="center">Scenario Details</h3>
    <form action="generator" method="GET" class="form-inline">
        <div id="scenario">
            <%--<input type="hidden" name="command" value="SITE"/>--%>
            <div class="form-group">
                <label for="scenario_name">Scenario Name:</label>
                <input type="text" class="form-control" id="scenario_name" name="scenario_name">
            </div>
            <div>
                <p align="center">Multiple Scenarios feature is supported by the framework but not on the WebApp yet</p>
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
<%--<footer>--%>
<%--<div class="navbar navbar-inverse navbar-fixed-bottom">--%>
<%--<div class="container">--%>
<%--<div class="navbar-collapse collapse" id="footer-body">--%>
<%--<ul class="nav navbar-nav">--%>

<%--<div style="display: table-cell; vertical-align: middle;">--%>
<%--<li>--%>
<%--<div class="form-inline">--%>
<%--<label for="sname">Scenario Name:</label>--%>
<%--<input type="text" class="form-control" id="sname" name="sname">--%>
<%--</div>--%>
<%--<button class="btn btn-primary btn-add-panel add_senario">--%>
<%--<i class="glyphicon glyphicon-plus"></i> Add Scenario--%>
<%--</button>--%>
<%--</li>--%>
<%--</div>--%>
<%--&lt;%&ndash;<div style="display: table-cell; vertical-align: middle;">&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="form-inline">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label for="pname">Page Name:</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input type="text" class="form-control" id="pname" name="pname">&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="form-inline">&ndash;%&gt;--%>
<%--&lt;%&ndash;<label for="purl">Page Url:</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input type="text" class="form-control" id="purl" name="purl">&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<button class="btn btn-primary btn-add-panel add_page">&ndash;%&gt;--%>
<%--&lt;%&ndash;<i class="glyphicon glyphicon-plus"></i> Add Page&ndash;%&gt;--%>
<%--&lt;%&ndash;</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--</div>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</footer>--%>
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