<html>
<head>
    <title>Application Error, please contact support.</title>
<body>
<div id="header">
    <H2>
        Unknown error occurred, please contact site support
    </H2>
    <div id="content">

        <h3>Message:</h3>
        Exception Message:

    <#if message??>
    ${message}
    <#else>
        Message not found
    </#if>
        <br><br>

        StackTrace Message:
    <#if stackTrace??>
    ${stackTrace}
    <#else>
        StackTrace not found
    </#if>
        <br><br>
    </div>
</body>
</html>