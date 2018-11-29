<%--
  Created by IntelliJ IDEA.
  User: antonio
  Date: 28/11/18
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compastible" content="IE=edge">
    <title>Atividade SVG e JTS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/style.css" />
    <script src="main.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>

<body>
<center><label class="title">Atividade SVG e JTS</label></center>
<div class="row"><br>
    <div class="col-sm-4">
        <ul class="list-group">
            <li class="list-group-item">
                <center><label class="cidade">Cidade 1</label></center><br>
                <label class="estado">Estado</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>Paraíba</option>
                    <option>Pernambuco</option>
                </select>
                <label class="estado">Cidade</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>Conceição</option>
                    <option>Triunfo</option>
                </select><br>
            </li>
            <li class="list-group-item">
                <b><label class="dados">População:</label></b><br>
                <b><label class="dados">Densidade Demográfica:</label></b><br>
                <b><label class="dados">Área:</label></b><br>
                <b><label class="dados">Perímetro:</label></b><br>
            </li>

        </ul>
    </div>
    <div class="col-sm-4">
        <ul class="list-group">
            <li class="list-group-item">
                <center><label class="cidade">Cidade 2</label></center><br>
                <label class="estado">Estado</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>Paraíba</option>
                    <option>Pernambuco</option>
                </select>
                <label class="estado">Cidade</label>
                <select class="form-control" id="exampleFormControlSelect1">
                    <option>Conceição</option>
                    <option>Triunfo</option>
                </select><br>
            </li>
            <li class="list-group-item">
                <b><label class="dados">População:</label></b><br>
                <b><label class="dados">Densidade Demográfica:</label></b><br>
                <b><label class="dados">Área:</label></b><br>
                <b><label class="dados">Perímetro:</label></b><br>
            </li>

        </ul>
    </div>


</div>
</body>

</html>
