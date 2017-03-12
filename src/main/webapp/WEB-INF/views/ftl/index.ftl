<html>
<head>
    <title>Star</title>
<body>
<script>
    function setEventId() {
        var eventId = document.getElementById('event-id').value;
        var eventForm = document.getElementById('eventForm');
        eventForm.setAttribute('action', '/user/event/' + eventId);
    }
</script>
<div id="header">
    <H2>
        Welcome to Spring advanced application
    </H2>
    <h4>You entered as <b>${user}</b></h4>
    <table>
        <tr>
            <td>
                <button><a href="/upload/files/events?${_csrf.parameterName}=${_csrf.token}">Upload events</a></button>
            </td>
            <td>Only for user has role BOOKING_MANAGER</td>
        </tr>
        <tr>
            <form action="/user/ticket">
                <td><input type="submit" size="10" value="Event tickets"/></td>
                <td><input type="text" name="eventId" placeholder="Fill event id" size="9" required/></td>
            </form>
        </tr>
        <tr>
            <form id="eventForm" action="#">
                <td><input type="submit" size="10" onclick="setEventId();" value="Event"/></td>
                <td><input type="text" id="event-id" placeholder="Fill event name" size="9" required/></td>
            </form>
        </tr>
        <tr>
            <td>
                <button><a href="/user/event">Events</a></button>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>
                <button><a href="/user/auditorium">Auditorium</a></button>
            </td>
            <td></td>
        </tr>
        <tr>
            <td>
                <button><a href="/user/user">Users</a></button>
            </td>
            <td></td>
        </tr>
        <tr>
            <form action="/userAccount">
                <td><input type="submit" size="10" value="Set account"/></td>
                <td><input type="text" name="account" placeholder="Fill account"
                           size="9" pattern="[0-9]{1,}\.[0-9]{1,}" required/></td>
            </form>
        </tr>
    </table>

    <a href="/logout">Logout</a>

</body>
</html>