<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="nav.jsp"></jsp:include>
<link rel="stylesheet" href="/common/music_list.css"></link>

<div class="container">

    <h1>${message}</h1>
    <table class="table table-hover table-bordered" style="margin-top:50px">
        <thead>
        <tr class="table-header">
            <th class="col">Tên</th>
            <th class="col">Loại</th>
            <th class="col">Nhạc</th>
            <c:if test="${not empty deletePath && empty param.name}">
                <th class="col">XÓA</th>
            </c:if>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tracks}" var="brand">
            <tr>
                <td>${brand.instrumentName}</td>
                <td>${brand.musicType}</td>
                <td><audio controls>
                    <source src="/images/${brand.audio}" type="audio/wav">
                </audio>
                </td>
                <c:if test="${not empty deletePath && empty param.name}">
                    <td><a href="${deletePath}/${brand.id}">Delete</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="footer.jsp"></jsp:include>
