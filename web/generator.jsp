<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <title>Tests Generator</title>
</head>
<body>
<h1 style="text-align: center">Tests Generator</h1>
<hr/>


<form action="generator" method="GET" class="form-inline">
    <div site>
        <input type="hidden" name="command" value="SITE"/>
        <h2 class="form-inline">Site Details:</h2>
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

<footer>
    <div class="navbar navbar-inverse navbar-fixed-bottom">
        <div class="container">
            <div class="navbar-collapse collapse" id="footer-body">
                <ul class="nav navbar-nav">
                    <li><h5>&nbsp;Scopes:&nbsp;</h5></li>
                    <li>&nbsp;<button type="button" class="btn btn-default" onclick="show('snr')">Add Scenario</button>
                    </li>
                    <li>&nbsp;<button disabled type="button" class="btn btn-default" onclick="show('snr')">Add
                        Scenario
                    </button>
                    </li>
                    <li>&nbsp;<button type="button" class="btn btn-default" onclick="show('snr')">Add Scenario</button>
                    </li>
                    <li>&nbsp;<button type="button" class="btn btn-default" onclick="show('snr')">Add Scenario</button>
                    </li>
                    <br>
                    <br>
                    <li><h5>&nbsp;Actions:&nbsp;</h5></li>
                    <li> &nbsp;<button type="button" class="btn btn-default" onclick="show('snr')">Add Scenario</button>
                    </li>
                    <li> &nbsp;<button disabled type="button" class="btn btn-default" onclick="show('snr')">Add
                        Scenario
                    </button>
                    </li>
                    <li> &nbsp;<button type="button" class="btn btn-default" onclick="show('snr')">Add Scenario</button>
                    </li>
                    <li> &nbsp;<button type="button" class="btn btn-default" onclick="show('snr')">Add Scenario</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

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