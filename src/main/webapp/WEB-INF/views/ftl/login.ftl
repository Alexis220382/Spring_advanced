<html>
<head>
    <title>Login Page</title>
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Spring Security Custom Login Form (Annotation)</h1>


<div id="login-box">

    <h2>Login with Username and Password</h2>
<#if error??>
    <div class="error">
    ${error}
    </div>
</#if>
    <form name="loginForm" action='/login' method='post'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password'/></td>
            </tr>
        <#if !loginUpdate??>
            <tr>
                <td></td>
                <td>Remember Me: <input type="checkbox" name="remember-me"/></td>
            </tr>
        </#if>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="submit"/>
                </td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <a href="/upload/files/users?${_csrf.parameterName}=${_csrf.token}">Sign up</a>
</div>

</body>
</html>