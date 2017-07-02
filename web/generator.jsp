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

<form action="Controller" method="GET" class="form-inline">
    <input type="hidden" name="command" value="SITE"/>
    <h2 class="form-inline">Site Details:</h2>
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="form-group">
        <label for="url">URL:</label>
        <input type="text" class="form-control" id="url" name="url">
    </div>
    <button type="submit" class="btn btn-default">Add</button>
</form>

</body>
</html>
