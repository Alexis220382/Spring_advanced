<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>managing-movie-theater-app</title>
</head>
<body>
<center>
    <h1>Movie Application</h1>
    <form method="post"
          action="/upload/files/events_upload?${_csrf.parameterName}=${_csrf.token}"
          enctype="multipart/form-data">
        <table border="0">
            <tr>
                <td>EVENTS (JSON):</td>
                <td><input type="file" name="fileEvents" size="50"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Upload"/></td>
            </tr>
        </table>
    </form>
    <br><br>
    <h5><a href="/user/home">Back to home page</a></h5>
</center>
</body>
</html>