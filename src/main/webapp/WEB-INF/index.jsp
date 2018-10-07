<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>Ninja Gold</title>
</head>
<body>
    <div class="container">
        <h3>Your Gold: <c:out value="${ goldEarn }"/> </h3>
        <!-- FARM -->
        <form class="bg-success" action="/process_farm" method="POST">
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <input class="btn btn-warning"  type="submit" value="Find Gold!"/>
        </form>

        <!-- Cave -->
        <form class="bg-secondary" action="/process_cave" method="POST">
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <input class="btn btn-warning"  type="submit" value="Find Gold!"/>
        </form>

        <!-- House -->
        <form class="bg-primary" action="/process_house" method="POST">
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <input class="btn btn-warning"  type="submit" value="Find Gold!"/>
        </form>

        <!-- Casino -->
        <form class="bg-danger" action="/process_casino" method="POST">
            <h2>Casino</h2>
            <p>(earns -50-50 golds)</p>
            <input class="btn btn-warning"  type="submit" value="Find Gold!"/>
        </form>

        <p class="text-left">Activities:</p>
        <div class="actives">
        	<c:forEach items="${ activities }" var="log">
        		<c:out value="${ log }" escapeXml="false" />
        	</c:forEach>
        </div>
        <a class="btn btn-primary" href="/reset">Reset</a>
    </div>
</body>
</html>