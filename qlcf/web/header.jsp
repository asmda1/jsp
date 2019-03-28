
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home |TNP-Coffee</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/nav.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">

    </head>
    <body>
      
            .                
            <jsp:include page="nav.jsp"></jsp:include>

    <header id="header"><!--header-->
        <!--/header_top-->

        <div  class="header-middle">
            <!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div  style="top: 40px" class="logo pull-left">
                            <a href="index.jsp"><img src="images/home/logo_htt.gif" alt="" /></a>
                        </div>

                    </div>

                </div>
            </div>
        </div>


        <!--/header-middle-->
        <div class="header-bottom">
            <!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                    data-target=".navbar-collapse">
                                <span class="sr-only"> Chuyển đổi điều hướng</span> <span
                                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                                    class="icon-bar"></span>
                            </button>
                        </div>

                        <div class="mainmenu pull-left">

                        </div>

                    </div>
                    <div class="col-sm-3">
                        <div class="search_box pull-right">
                            <input type="text" placeholder="Tìm Kiếm" name="txtSearch" />
                        </div>
                    </div>
                    <div style="float: right" class="col-sm-8">
                        <div class="shop-menu pull-right">
                            <ul class="nav navbar-nav">

                       
                            <%if (session.getAttribute("usernamex") == null ) {%>
                                <li><a href="login.jsp"><i class=""></i>
                                        Đăng Nhập</a></li>
                                <!--<li><a href="#"><i class="fa fa-star"></i> Danh Sách</a></li>-->    
                                <li><a href="checkout.jsp"><i class=""></i>
                                        Thanh Toán</a></li>
                                <li><a href="cart.jsp"><i class=""></i>
                                        Giỏ Hàng</a></li><% } else {%>
                                <li><a >
                                        Email:  <%=session.getAttribute("usernamex")%>
                                    
                                    </a></li>
                                <li><a href="checkout.jsp"><i class=""></i>
                                        Thanh Toán</a></li>
                                <li><a href="cart.jsp"><i class=""></i>
                                        Giỏ Hàng</a></li>
                                           <li><a href="LoginServlet?enter=logout"><i class=""></i>
                                        Đăng Xuất</a></li>
                                        <%}%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--/header-bottom--> </header>
    <!--/header-->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>