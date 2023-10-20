<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="nav.jsp"></jsp:include>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
    <link rel="stylesheet"  href="/common/register.css" />
    <title>Music Player Web</title>
</head>
<body>
<div class="container1">
    <form id="registration-form" action="/music/backend/user/save" modelAttribute="userDto" method="post" >
        <h1>Create Your Account</h1>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="userName" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="userEmail" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="userPassword" required>
        </div>
        <div class="form-group">
            <label for="confirm-password">Confirm Password:</label>
            <input type="password" id="confirm-password" name="confirmPassword" required>
        </div>
        <div class="form-group">
            <label for="sex">Sex</label>
            <select id="sex" name="userSex">
                <option value="">Please select</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="dob">Date of Birth</label>
            <input type="date" id="dob" name="userDate">
        </div>
        <input type="submit" value="Sign Up">
    </form>
    <p id="error-message"></p>
</div>
<script src="/login.js"></script>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>



