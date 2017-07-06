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
<div id="page">
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
                <div class="form-group">
                    <label for="scenario_name">Scenario Name:</label>
                    <input type="text" class="form-control" id="scenario_name" name="scenario_name">
                </div>
                <div>
                    <h5 align="center">Multiple Scenarios feature is supported by the framework but not yet on the
                        WebApp
                        :( </h5>
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

            </div>
        </form>
        <hr/>
    </div>

    <%--Units Container--%>
    <div class="container">
        <h3 align="center">Units</h3>
        <div class="panel-group" id="accordion">
        </div>
        <br/>
    </div>

</div>

<div class="myfooter">
    <h2>Actions</h2>
    <ul class="nav navbar-nav">
        <hr>
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
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Alert
                        </a></li>
                    </ul>
                </div>
            </li>
            <hr>
        </div>
    </ul>
</div>
<script src="javascript.js"></script>
</body>
</html>