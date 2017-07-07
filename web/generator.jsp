<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests Generator</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href="bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet">

    <%-- js --%>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/npm.js"></script>


    <%--<style>--%>
        <%--table, th, td {--%>
            <%--border: 1px solid black;--%>
            <%--border-collapse: collapse;--%>
        <%--}--%>

        <%--th, td {--%>
            <%--padding: 5px;--%>
            <%--text-align: left;--%>
        <%--}--%>

        <%--table, tr, td, th {--%>
            <%--border: 1px solid black;--%>
            <%--border-collapse: collapse;--%>
        <%--}--%>
    <%--</style>--%>
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
        <table id="scenarios" class="table">
        </table>
        <br/><br/><br/><br/><br/><br/>
    </div>
</div>
<footer>
    <div class="navbar navbar-inverse navbar-fixed-bottom">
        <div class="container">
            <div class="navbar-collapse collapse" id="footer-body">
                <ul class="nav navbar-nav">
                    <li>
                        <button class="btn btn-primary add_scenario">
                            <i class="glyphicon glyphicon-plus"></i> Add Scenario
                        </button>
                    </li>
                    <li>
                        <button disabled class="btn btn-primary add_page">
                            <i class="glyphicon glyphicon-plus"></i> Add Page
                        </button>
                    </li>
                    <li>
                        <button disabled class="btn btn-primary add_form">
                            <i class="glyphicon glyphicon-plus"></i> Add Form
                        </button>
                    </li>
                    <li>
                        <button disabled class="btn btn-primary add_action">
                            <i class="glyphicon glyphicon-plus"></i> Add Action
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </div>
</footer>
<script src="javascript.js"></script>
</body>
</html>