<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">



    <!-- main.js -->
    <script src="main.js"></script>
    <style>

        .nocopy {
            -webkit-touch-callout: none;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        .scenarios {
            background-color: #f1f1c1;
            width: 100%;
        }

        /*table, th, td {*/
        /*border: 1px solid black;*/
        /*border-collapse: collapse;*/
        /*}*/

        th, td {
            padding: 5px;
            text-align: left;
        }

        table#t01 {
            width: 100%;
            background-color: #7ed1f1;
        }

        table#t02 {
            width: 100%;
            background-color: #f16e9a;
        }

        /*table, tr, td, th*/
        /*{*/
        /*border: 1px solid black;*/
        /*border-collapse:collapse;*/
        /*}*/
        tr.header {
            cursor: pointer;
        }

        .header .sign:after {
            content: "+";
            display: inline-block;
        }

        .header.expand .sign:after {
            content: "-";
        }
    </style>
</head>
<body>


<br>
<br>
<br>
<table class="scenarios">
    <tr class="header expand nocopy">
        <th><span class="sign"></span> <a href="#" id="username" data-type="text" data-placement="right" data-title="Enter username">Scenario Name</a></th>
    </tr>
    <tr>
        <td>
            <table id="t01">
                <tr class="nocopy header expand">
                    <th><span class="sign"></span> Page 01</th>
                </tr>
                <tr>
                    <td>
                        <table id="t02">
                            <tr class="nocopy header expand">
                                <th><span class="sign"></span> Actions</th>
                            </tr>
                            <tr>
                                <th><span class="sign"></span> Firstname</th>
                                <th>Lastname</th>
                                <th>Age</th>
                            </tr>
                            <tr>
                                <td id="status">Jill</td>
                                <td>Smith</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Eve</td>
                                <td>Jackson</td>
                                <td>94</td>
                            </tr>
                            <tr>
                                <td>John</td>
                                <td>Doe</td>
                                <td>80</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>Eve</td>
                </tr>
                <tr>
                    <td>John</td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>Eve</td>
    </tr>
    <tr>
        <td>John</td>
    </tr>
</table>

<script src="js.js"></script>

</body>
</html>