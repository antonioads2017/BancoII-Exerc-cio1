<%--
  Created by IntelliJ IDEA.
  User: antonio
  Date: 28/11/18
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compastible" content="IE=edge">
    <title>Atividade SVG e JTS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/style.css"/>
    <script src="js/jQuery 3.3.1.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>

<body>
<center><label class="title">Atividade SVG e JTS</label></center>
<form id="form2" action="inicio" method="POST" class="row" style="margin-top: 15px;"><br>
    <div class="col-sm-3">

        <ul class="list-group">
            <li class="list-group-item">
                <center><label class="cidade">Cidade 1</label></center>
                <br>
                <label class="box">Estado</label>
                <select name="estado1" class="form-control" onchange="this.form.submit()">
                    <c:forEach var="estado" items="${estados}">
                        <option ${estadoSelecionado1==estado?'selected':''}>${estado}</option>
                    </c:forEach>
                    <option>Selecione um Estado</option>
                </select>
                <label class="box">Cidade</label>
                <select name="cidade1" class="form-control" onchange="this.form.submit()">
                    <c:forEach var="cidade" items="${cidades1}">
                        <option ${cidadeSelecionada1==cidade?'selected':''}>${cidade}</option>
                    </c:forEach>
                    <option>Selecione uma Cidade</option>
                </select><br>
            </li>
            <li class="list-group-item">
                <b><label class="dados">População: ${cidade1.getPopulacao()}</label></b><br>
                <b><label class="dados">Densidade Demográfica: ${cidade1.getDencidade()}</label></b><br>
                <b><label class="dados">Área: ${cidade1.getArea()}</label></b><br>
                <b><label class="dados">Perímetro: ${cidade1.getPerimetro()}</label></b><br>
            </li>

        </ul>
    </div>
    <%--<input type="submit" onclick="gerarParam('GerarSVG')" value="Enviar" class="btn btn-primary" style="height:6%; margin-top: 390px;">--%>
    <div class="col-sm-3">
        <ul class="list-group">
            <li class="list-group-item">
                <center><label class="cidade">Cidade 2</label></center>
                <br>
                <label class="box">Estado</label>
                <select name="estado2" class="form-control" onchange="this.form.submit()">
                    <c:forEach var="estado" items="${estados}">
                        <option ${estadoSelecionado2==estado?'selected':''}>${estado}</option>
                    </c:forEach>
                    <option>Selecione um Estado</option>
                </select>
                <label class="box">Cidade</label>
                <select name="cidade2" class="form-control" onchange="this.form.submit()">
                    <c:forEach var="cidade" items="${cidades2}">
                        <option ${cidadeSelecionada2==cidade?'selected':''}>${cidade}</option>
                    </c:forEach>
                    <option>Selecione uma Cidade</option>
                </select><br>
            </li>
            <li class="list-group-item">
                <b><label class="dados">População: ${cidade2.getPopulacao()}</label></b><br>
                <b><label class="dados">Densidade Demográfica: ${cidade2.getDencidade()}</label></b><br>
                <b><label class="dados">Área: ${cidade2.getArea()}</label></b><br>
                <b><label class="dados">Perímetro: ${cidade2.getPerimetro()}</label></b><br>
            </li>

        </ul>

    </div>
    <%--<input type="text" id="command" name="command" hidden>--%>
    <div class="col-sm-3">
        <label>Distância Aproximada: ${distancia} km</label><br>
        <div id="svg">
            <svg viewBox="${viewBox}" width="581" height="200">
                <path d="${cidade1.getSvg()}" stroke="black" stroke-width="0.005" fill="blue" fill-opacity=""/>
                <%--<c:forEach var="cidade" items="cidades">--%>
                    <%--<path d="${cidade.getSvg()}" stroke="black" stroke-width="0.005" fill="gray" fill-opacity=""/>--%>
                <%--</c:forEach>--%>
                <path d="${cidade2.getSvg()}" stroke="black" stroke-width="0.005" fill="green" fill-opacity=""/>
            </svg>
        </div>
    </div>
</form>

<script src="js/main.js"></script>
</body>

</html>
