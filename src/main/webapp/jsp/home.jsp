<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="nav.jsp"></jsp:include>
<link
        rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous"
/>

<div class="container" id="container">
    <div class="category" id="solo-albums" onclick="window.location.href='/music/backend/track/solo'">
        <img src="/image/ab67616d0000b273da4c74e60bdc3acf459c06af.jpg" width="300px" height="200px" alt="Albums Solo">
        <h2>Albums Solo</h2>
    </div>
    <div class="category" id="duet-albums"onclick="window.location.href='/music/backend/track/duet'">
        <img src="/image/ab67616d0000b273cc639ca1d584dc13c111c560.jpg" width="300px" height="200px" alt="Albums Duet">
        <h2>Albums Duet</h2>
    </div>
</div>
<script src="/login.js"></script>
<jsp:include page="footer.jsp"></jsp:include>

