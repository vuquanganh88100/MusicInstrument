    <%@page pageEncoding="utf-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <jsp:include page="nav.jsp"></jsp:include>
    <div class="container">
        <div class="row mt-5">
            <h1>Create New Album</h1>
        </div>
        <div class="container mt-4">
            <form action="/music/backend/track/save" method="post" enctype="multipart/form-data">
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-4">
                            <input type="text" class="form-control" id="instrumentName" name="instrumentName" placeholder="Album Name" required>
                            <label for="instrumentName">Album Name</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-4">
                            <select class="form-control" id="musicType" name="musicType" required>
                                <option value="">Select Album Type</option>
                                <option value="solo">Solo</option>
                                <option value="duet">Duet</option>
                            </select>
                            <label for="musicType">Album Type</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-4">
                            <input type="file" class="form-control" id="audioFile" name="audioFile" accept="audio/wav" required>
                            <label for="audioFile">File</label>
                        </div>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
