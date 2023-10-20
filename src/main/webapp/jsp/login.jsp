<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="nav.jsp"></jsp:include>
<link rel="stylesheet" href="/common/login.css"></link>
<form id="login-form" action="/doLogin" method="post">
        <div class="form-group">
            <label for="username">Username or Email</label>
            <input type="text" class="form-control" id="username"name="userEmail" aria-describedby="emailHelp">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password"name="userPassword">
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
        <p>Don't have an account?
        </p>
        <a id="sign-up-button" href="/music/create">Sign up for 100pro</a>
</form>
<script src="/login.js"></script>
<jsp:include page="footer.jsp"></jsp:include>

