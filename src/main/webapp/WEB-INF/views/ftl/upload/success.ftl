<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>File Upload Result</title>
</head>
<body>
<center>
<#if user_flag??>
    <#if users_error??>
        <h2>${users_error}</h2>
    <#else>
        <h2>User file was upload successfully</h2>
        <br><br>
        <h5><a href="/">Back to login page</a></h5>
    </#if>
</#if>
    <br><br>
<#if event_flag??>
    <#if events_error??>
        <h2>${events_error}</h2>
    <#else>
        <h2>Event file was upload successfully</h2>
        <br><br>
        <h5><a href="/user/home">Back to home page</a></h5>
    </#if>
</#if>
    <br><br>
</center>
</body>
</html>