<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests Generator</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <link href="jasny-bootstrap/css/jasny-bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/custom.css" rel="stylesheet">

    <%-- js --%>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>

    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
<div id="page">
    <div hidden id="test" class="template"></div>
    <h1>Tests Generator</h1>
    <hr/>

    <div align="center">
        <h3>Site Details</h3>
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

    <%--Container--%>
    <div class="container">
        <h3>Scenarios</h3>
        <table class="table" id="selectable">
            <tbody id="scenarios">
            </tbody>
        </table>
        <br/><br/><br/>
    </div>

</div>
<div class="myfooter">
    <h2>Actions</h2>
    <ul class="nav navbar-nav">
        <hr>

        <%--Scenario Button--%>
        <div>
            <h3>Add Scenario</h3>
            <li>
                <div class="form-inline">
                    <label for="sname">Scenario Name:</label>
                    <input type="text" class="form-control" id="sname" name="sname">
                </div>
                <button class="btn btn-primary btn-add-panel add_scenario">
                    <i class="glyphicon glyphicon-plus"></i> Add Scenario
                </button>
            </li>
            <hr>
        </div>


        <%--Page Button--%>
        <div>
            <h3>Add Page</h3>
            <li>
                <div class="form-inline">
                    <label for="pname">Page Name:</label>
                    <input type="text" class="form-control" id="pname" name="pname">
                </div>
                <div class="form-inline">
                    <label for="purl">Page Url:</label>
                    <input type="text" class="form-control" id="purl" name="purl">
                </div>
                <button class="btn btn-primary btn-add-panel add_page">
                    <i class="glyphicon glyphicon-plus"></i> Add Page
                </button>
            </li>
            <hr>
        </div>


        <%--Form Button--%>
        <div>
            <h3>Add Form</h3>
            <li>
                <div class="form-inline">
                    <label for="fname">Form Name:</label>
                    <input type="text" class="form-control" id="fname" name="fname">
                </div>
                <div class="form-inline">
                    <label for="purl">Form Url:</label>
                    <input type="text" class="form-control" id="furl" name="furl">
                </div>
                <button class="btn btn-primary btn-add-panel add_form">
                    <i class="glyphicon glyphicon-plus"></i> Add Form
                </button>
            </li>
            <hr>
        </div>

        <%--Add Action--%>
        <div>
            <h3>Add Action</h3>
            <li>
                <div class="dropup">
                    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">
                        Actions
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                        <%--add class="disabled" to disable an option --%>
                        <li role="presentation" class="dropdown-header">Actions</li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Click</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Click Checkbox</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Fill Element</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Store Value</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Add Value</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Select</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Submit</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Respond Alert</a></li>
                        <li role="presentation" class="divider"></li>
                        <li role="presentation" class="dropdown-header">Verifications</li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Text</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Not Text</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Alert</a></li>
                    </ul>
                </div>

                <br>
                <div id="Action Details">
                    <div class="form-inline">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" id="id" name="id">
                    </div>
                </div>

            </li>
            <hr>
        </div>
    </ul>
</div>
<%--<footer>--%>
<%--<div class="navbar navbar-inverse navbar-fixed-bottom">--%>
<%--<div class="container">--%>
<%--<div class="navbar-collapse collapse" id="footer-body">--%>
<%--<ul class="nav navbar-nav">--%>
<%--<li>--%>
<%--<button class="btn btn-primary add_scenario">--%>
<%--<i class="glyphicon glyphicon-plus"></i> Add Scenario--%>
<%--</button>--%>
<%--</li>--%>
<%--<li>--%>
<%--<button disabled class="btn btn-primary add_page">--%>
<%--<i class="glyphicon glyphicon-plus"></i> Add Page--%>
<%--</button>--%>
<%--</li>--%>
<%--<li>--%>
<%--<button disabled class="btn btn-primary add_form">--%>
<%--<i class="glyphicon glyphicon-plus"></i> Add Form--%>
<%--</button>--%>
<%--</li>--%>
<%--<li>--%>
<%--<button disabled class="btn btn-primary add_action">--%>
<%--<i class="glyphicon glyphicon-plus"></i> Add Action--%>
<%--</button>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</footer>--%>


 <%-- JS --%>
<script src="js/bootstrap.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/npm.js"></script>
<script src="javascript.js"></script>
</body>
</html>
