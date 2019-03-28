<%-- 
    Document   : login
    Created on : Feb 27, 2019, 11:42:39 AM
    Author     : baotri1998
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Đăng Nhập | TNP-Coffee</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head>
    <body>
        <%
            String error = "";
            if (request.getAttribute("error") != null) {
                error = (String) request.getAttribute("error");
            }
            //Phần Đăng Nhập (LogiServelet)
            String usernamex = "", passwordx = "";
            if (request.getAttribute("usernamex") != null) {
                usernamex = (String) request.getAttribute("usernamex");
            }
            if (request.getAttribute("passwordx") != null) {
                passwordx = (String) request.getAttribute("passwordx");
            }
        %>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">

                    <!--login form-->
                    <h2>Đăng Nhập</h2>
                    <form align="center" action="LoginServlet" method="post">
                        <p style="color: red"><%=error%>
                    <div style="padding: 10px">  <input style="width: 50%;height:40px" type="text" placeholder="Tài Khoản" name="ten_dang_nhap"
                                                        value="<%=usernamex%>" /> </div>
                    <div style="padding: 10px">  <input style="width: 50%;height:40px" type="password"
                                  placeholder="Mật Khẩu" name="mat_khau" value="<%=passwordx%>" /></div>
                    <input type="hidden" name="access" value="2" />
                <input type="hidden" name="status" value="1" /></div><br>
                <div align="center"> <span
                style="color: gray;"> <input type="checkbox"
                                         class=""> Duy trì đăng nhập
            </span>
            <button type="submit" class="btn btn-default">Đăng Nhập</button>
            <br></div>

            </form>
            <div style="padding: 15px;float: right"> <a href="account.jsp">Chưa có Tài khoản? Đăng ký</a> </div>
        </div>
        <!--/login form-->
    </div>




<jsp:include page="footer.jsp"></jsp:include>

    <!--/form-->

  
    </body>
</html>

<!--/form-->

</body>
</html>
