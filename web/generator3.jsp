<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>X-editable starter template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- bootstrap -->
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <!-- x-editable (bootstrap version) -->

    <link href="http://cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css"
          rel="stylesheet"/>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
    <!-- main.js -->

</head>

<body>

<div class="container">

    <p>X-editable: create editable column in table.<br>
        As pk is unique in each row, you should put it in data-pk attribute.
    </p>
    <div style="margin: 150px">
        <table id="users" class="table">
            <tr>
                <th>#</th>
                <th>name</th>
                <th>age</th>
            </tr>
            <tr>
                <td>1</td>
                <td><a href="#" class="username" data-type="text" data-title="scenario">enter scenario name</a></td>
                <td><a href="#" class="username" data-type="text" data-title="scenario">enter scenario name</a></td>
            </tr>

            <tr>
                <td>2</td>
                <td><a href="#" id="status"></a></td>
                <td>28</td>
            </tr>

            <tr>
                <td>3</td>
                <td><a href="#" data-pk="3">Mary</a></td>
                <td>24</td>
            </tr>

        </table>
    </div>
</div>
<script src="main2.js"></script>
</body>
</html>