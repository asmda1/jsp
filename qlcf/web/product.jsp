<%@page import="model.CartBean"%>
<%@page import="model.SanPham"%>
<%@page import="java.util.List"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Sản Phẩm | TNP-Coffee</title>
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

        <script src="js/main.js"></script>
    </head>
    <body>

        <%
            SanPhamDAO dao = new SanPhamDAO();
            List<SanPham> list = dao.selectAll();
              NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
             CartBean cart = (CartBean) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartBean();
                session.setAttribute("cart", cart);
            }
        %>

        <div class="">
            <div>
               
                <h2>Sản Phẩm</h2>
                <%
                    for (SanPham sp : list) {
                %>
                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div style="padding: 15px"class="productinfo text-center">
                                <img style="width: 250px" src="img/<%=sp.getHinhAnh()%>" alt="" />
                                <h2 ><%=sp.getTenSp()%>
                            </h2>
                            <p><%=nf.format(sp.getGiaBan())%>
                                VNĐ</p>
                                <a
                                    href="CartBeanServlet?enter=insert&maSP=<%=sp.getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>"
                                    class="btn btn-default add-to-cart"><i
                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
                            </div>
                            <img src="images/home/new.png" class="new" alt="" />
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="detail.jsp?maSP=<%=sp.getMaSanPham()%>"><i
                                            class="fa fa-plus-square"></i>Xem Thêm</a></li>

                            </ul>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>



          



    </div>
</body>
</html>