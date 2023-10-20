<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.min.js"></script>



<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link
                rel="stylesheet"
                href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous"
        />    <link rel="stylesheet"  href="/common/nav.css" />
        <title>Music Player Web</title>
    </head>
    <body class="logged-in">
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="#">
            <img src="/image/Cristiano_Ronaldo_2018.jpg" width="30" height="30" alt="Logo" />
        </a>
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#" id="home-button" onclick="window.location.href='/music/home'">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Library</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Create Playlist</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/music/backend/track/list" method="get">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" id="search" value="${title}" />
                <button class="btn btn-outline-light my-2 my-sm-0" type="button" onclick="searchClick()">Search</button>
            </form>
            <script>
                function searchClick() {
                    var name = document.getElementById("search").value;
                    if (name.trim() !== '') {
                        window.location.href = "/music/backend/track/list?name=" + name;
                    } else {
                        alert('Yêu cầu nhập thông tin hợp lệ');
                    }
                }
            </script>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#"onclick="window.location.href='/music/backend/track/upload'">Upload</a>
                </li>
                <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="window.location.href='/music/create'">Register</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#" onclick="window.location.href='/music/login'">Login</a>
                </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown1111" data-bs-toggle="dropdown"
                       aria-expanded="false">${fn:substring(pageContext.request.userPrincipal.name, 0, 3)}</a>

                    <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdown1111">
                        <li><a class="dropdown-item" href="/backend/user/change-pass">Đổi mật khẩu</a></li>
                        <li><a class="dropdown-item" href="/backend/brand/category">Thông tin tài khoản</a></li>
                        <li><a class="dropdown-item" href="/logout">Đăng xuất</a></li>
                    </ul>
                </li>
                </sec:authorize>
            </ul>
        </div>
    </nav>
    <script>
        $(function() {
            // initialize all dropdowns
            $('.dropdown-toggle').dropdown();
        });
    </script>



