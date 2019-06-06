<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
    <link href="../../resources/css/profile.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="../components/header.jsp"/>

<main>

    <input id="tab1" class="inp" type="radio" name="tabs" checked>
    <label class="lab" for="tab1">Profile</label>

    <input id="tab2" class="inp" type="radio" name="tabs">
    <label class="lab" for="tab2">Visa Statistic</label>

    <input id="tab3" class="inp" type="radio" name="tabs">
    <label class="lab" for="tab3">Booking Statistic</label>

    <section id="content1">
        <p>First Name: <span>${person.firstName}</span></p>
        <hr>
        <p>Last Name: <span>${person.lastName}</span></p>
        <hr>
        <p>Username: <span>${person.username}</span></p>
        <hr>
    </section>

    <section id="content2">
        <div class="input-container">
            <i class="fas fa-search icon"></i>
            <input type="text" class="myInput" id="input1" onkeyup="findVisasByCountry()"
                   placeholder="Search by country.."/>
        </div>
        <ul id="myUL1">
            <c:forEach var="visa" items="${visaList}" varStatus="status">
                <li><p>${status.index+1}. ${countryList[status.index].countryName}
                    <span>end date - ${visa.endDate}</span></p></li>
            </c:forEach>
        </ul>
    </section>
    <section id="content3">
        <div class="input-container">
            <i class="fas fa-search icon"></i>
            <input type="text" class="myInput" id="input2" onkeyup="findBookingsByCountry()"
                   placeholder="Search by country.."/>
        </div>
        <ul id="myUL2">
            <c:forEach var="booking" items="${bookingList}" varStatus="status">
                <li>
                    <p>${status.index+1}. ${booking.country.countryName}, ${booking.city.cityName} , ${booking.hotel.hotelName}<span>${booking.startDate} / ${booking.endDate}</span>
                    </p></li>
            </c:forEach>
        </ul>
    </section>

</main>
<script>
    function findVisasByCountry() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById("input1");
        filter = input.value.toUpperCase();
        ul = document.getElementById("myUL1");
        li = ul.getElementsByTagName("li");
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("p")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>
<script>
    function findBookingsByCountry() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById("input2");
        filter = input.value.toUpperCase();
        ul = document.getElementById("myUL2");
        li = ul.getElementsByTagName("li");
        for (i = 0; i < li.length; i++) {
            a = li[i].getElementsByTagName("p")[0];
            txtValue = a.textContent || a.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                li[i].style.display = "";
            } else {
                li[i].style.display = "none";
            }
        }
    }
</script>
</body>
</html>
