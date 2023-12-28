<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Login</title>
        <script>
        function validateLoginForm() {
            var username = document.forms["loginForm"]["username"].value;
            var password = document.forms["loginForm"]["password"].value;

            if (username === "" || password === "") {
                alert("Both username and password must be filled out");
                return false;
            }
        }
    </script>
    </head>

    <body>
        <h1>Employee Login Form</h1>
        <form name="loginForm" action="<%= request.getContextPath() %>/login" method="post" onsubmit="return validateLoginForm()">
            <table style="with: 100%">
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>

            </table>
            <input type="submit" value="Submit" />
        </form>
    </body>

    </html>

</body>
</html>