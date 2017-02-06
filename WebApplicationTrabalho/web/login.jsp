<%-- 
    Document   : login
    Created on : 30/01/2017, 15:46:02
    Author     : fabia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("a");
                var b = document.getElementById("b");
                var valid = true;
                if (a.value.length <= 0)
                {
                    alert("Username không được để trống!");
                    valid = false;
                }
                else if(b.value.length < 2){
                    alert("Password it nhat 6 ki tu");
                    valid = false;
                }
                return valid;
            };
        </script>
    </head>
    <body>
        <form method="POST" action="<%=request.getContextPath()%>/Controller?command=LoginServlet" onsubmit="return validate();">
            <label>Login</label><br>
            <input type="text" name="login" id="a"><br>
            <label>Password</label><br>
            <input type="password" name="senha" id="b"><br>
            <input type="submit" class="button" value="Login">
        </form>
    </body>
</html>
