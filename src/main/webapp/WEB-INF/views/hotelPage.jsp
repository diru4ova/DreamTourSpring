<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenel
  Date: 5/23/2019
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <title>${hotel.hotelName}</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/hotelPage.css">
</head>
<body style="background: url('../../resources/images/bg_1.jpg') no-repeat center center fixed;">

<div class="container">
    <div class="row">
        <div class="col-md-7 border border-dark rounded">
            <h1>${hotel.hotelName}</h1>
            <img width="100%" height="350px" src="${hotel.imageUrl}">
        </div>
        <div class="col-md-5 border border-dark rounded">
            <h1>Description</h1>
            <p align="justify">${hotel.hotelDescription}</p>
        </div>
    </div>
    <div class="row">
        <c:set var="room" scope="session" value="${roomStandard}"/>
        <c:if test="${room != null}">
            <div class="col-md-6 border border-dark rounded">
                <h2>STANDARD</h2>
                <img width="100%" height="300px" src="${roomStandard.imageUrl}">
                <c:choose>
                    <c:when test="${startDate.length() != 0}">
                        <h3 class="info">Price: ${roomStandard.price}$ Free now: ${standardCount}</h3>
                    </c:when>
                    <c:otherwise>
                        <h3 class="info">Price: ${roomStandard.price}$ Total amount: ${standardCount}</h3>
                    </c:otherwise>
                </c:choose>
                <form action="/booking" method="POST" onsubmit="return validateData()">
                    <input type="hidden" name="countryId" value="${countryId}">
                    <input type="hidden" name="cityId" value="${cityId}">
                    <input type="hidden" name="hotelId" value="${hotel.idHotel}">
                    <input type="hidden" name="roomId" value="${roomStandard.idRoom}">
                    <input type="hidden" name="startDate" id="startDate" value="${startDate}">
                    <input type="hidden" name="endDate" id="endDate" value="${endDate}">
                    <input type="hidden" id="userId" value="${userId}">
                    <button type="submit" class="btn btn-primary">Book</button>
                </form>
            </div>
        </c:if>

        <c:set var="room" scope="session" value="${roomLuxe}"/>
        <c:if test="${room != null}">
            <div class="col-md-6 border border-dark rounded">
                <h2>LUXE</h2>
                <img width="100%" height="300px" src="${roomLuxe.imageUrl}">
                <c:choose>
                    <c:when test="${startDate.length() != 0}">
                        <h3 class="info">Price: ${roomLuxe.price}$ Free now: ${standardCount}</h3>
                    </c:when>
                    <c:otherwise>
                        <h3 class="info">Price: ${roomLuxe.price}$ Total amount: ${standardCount}</h3>
                    </c:otherwise>
                </c:choose>
                <form action="/booking" method="POST" onsubmit="return validateData()">
                    <input type="hidden" name="countryId" value="${countryId}">
                    <input type="hidden" name="cityId" value="${cityId}">
                    <input type="hidden" name="hotelId" value="${hotel.idHotel}">
                    <input type="hidden" name="roomId" value="${roomLuxe.idRoom}">
                    <input type="hidden" name="startDate" value="${startDate}">
                    <input type="hidden" name="endDate" value="${endDate}">
                    <input type="hidden" value="${userId}">
                    <button type="submit" class="btn btn-primary">Book</button>
                </form>
            </div>
        </c:if>
    </div>
</div>

<script>
    function validateData() {

        var startDate = document.getElementById("startDate").value;
        var endDate = document.getElementById("endDate").value;
        var userId = document.getElementById("userId").value;

        if ((startDate === "" || endDate === "") && userId === "-1") {
            alert("Please,sign in and choose dates!");
            window.location.href = '/login';
            return false;
        } else if ((startDate === "" || endDate === "") && userId !== "-1") {
            alert("Please,choose dates!");
            window.location.href = '/';
            return false;
        } else {
            return true;
        }

    }
</script>

</body>
</html>