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
            int start = 0, end = 9;
            if (list.size() < 9) {
                end = list.size();
            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));
            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);

            List<SanPham> listPage = dao.getListByPage(list, start, end);

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
                    for (SanPham sp : listPage) {
                %>
                <div class="col-sm-4" >
                    <div class="product-image-wrapper" style="padding: 5px; width: 315px">
                        <div class="single-products" >
                            <div style="padding: 5px"class="productinfo text-center">
                                <img style="width: 200px" src="img/<%=sp.getHinhAnh()%>" alt="" />
                                <h2 ><%=sp.getTenSp()%>
                                </h2>
                                <p><%=nf.format(sp.getGiaBan())%>
                                    VNĐ</p>
                                <a
                                    href="CartBeanServlet?enter=insert&maSP=<%=sp.getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>&masize=M"
                                    class="btn btn-default add-to-cart"><i
                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ</a>
                            </div>
                            <img src="images/home/new.png" class="new" alt="" />
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="detail.jsp?maSP=<%=sp.getMaSanPham()%>&masize=M"><i
                                            class="fa fa-plus-square"></i>Xem Chi Tiết</a></li>

                            </ul>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>



            <div style="clear: both;"></div>
            <ul class="pagination">


                <%
                    int a, b;
                    int limit = list.size() / 9;
                    if (limit * 9 < list.size()) {
                        limit += 1;
                    }
                    for (int i = 1; i <= limit; i++) {
                        a = (i - 1) * 9;
                        b = i * 9;
                        if (b > list.size()) {
                            b = list.size();
                        }
                %>
                <li><a href="index.jsp?start=<%=a%>&end=<%=b%>"><%=i%></a></li>
                    <%
                        }
                    %>
            </ul>
        </div>



    </div>
</body>
</html>