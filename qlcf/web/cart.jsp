<%-- 
    Document   : cart
    Created on : Mar 26, 2019, 11:55:07 PM
    Author     : baotri1998
--%>

<%@page import="model.SizeSP"%>
<%@page import="dao.SelectSIze"%>
<%@page import="java.util.Map"%>
<%@page import="model.CartBean"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.TreeMap"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Giỏ Hàng | TNP_Coffe</title>
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
            CartBean cart = (CartBean) session.getAttribute("cart");
            if (cart == null) {
                cart = new CartBean();
                session.setAttribute("cart", cart);
            }
            TreeMap<SanPham, Integer> list = cart.getList();

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
            SelectSIze dao = new SelectSIze();
            SizeSP sisizeze = dao.selectID(request.getParameter("masize"));
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="row">

                        <section id="cart_items">
                            <div class="container">

                                <div class="table-responsive cart_info">
                                    <table class="table table-condensed">
                                        <thead>
                                            <tr class="cart_menu">
                                                <td class="image">Hình Ảnh</td>
                                                <td class="description">Thông Tin Sản Phẩm</td>
                                                <td class="price">Giá Bán</td>
                                                <td class="quantity">Số Lượng</td>
                                                <td class="total">Tổng Tiền</td>
                                                <td></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
                                        %>
                                        <tr>
                                            <td class="cart_product"><a href=""><img style="width: 200px"
                                                                                     src="img/<%=ds.getKey().getHinhAnh()%>" alt=""></a></td>
                                            <td class="cart_description">
                                                <h4>
                                                    <a href=""><%=ds.getKey().getTenSp()%></a>
                                                </h4>
                                                <p>
                                                    Mã Sản Phẩm:
                                                    <%=ds.getKey().getMaSanPham()%><br>
                                                    Mã Size: 
                                                    <%--=//sisizeze.getMaSize()--%>

                                                </p>

                                            </td>
                                            <td class="cart_price">
                                               <%-- //if (request.getParameter("masize") == null) {--%>
                                                <p><%=nf.format(ds.getKey().getGiaBan())%>
                                                    VNĐ
                                                </p>
                                                <%-- //} else {%>
                                                <p><%=//nf.format(ds.getKey().getGiaBan() * sisizeze.getHeSo())%>
                                                 
                                                </p>

                                                <%//}--%>
                                            </td>
                                            <td class="cart_quantity">
                                                <div class="cart_quantity_button">
                                                    <a class="cart_quantity_up"
                                                       href="CartBeanServlet?enter=tang&maSP=<%=ds.getKey().getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>">
                                                        + </a> <input class="cart_quantity_input" type="text"
                                                                  value="<%=ds.getValue()%>" autocomplete="off" size="2"
                                                                  disabled=""> <a class="cart_quantity_down"
                                                                  href="CartBeanServlet?enter=giam&maSP=<%=ds.getKey().getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>">
                                                        - </a>
                                                </div>
                                            </td>
                                            <td class="cart_total">
                                                <p class="cart_total_price"><%=nf.format(ds.getValue() * ds.getKey().getGiaBan())%>
                                                    VNĐ
                                                </p>
                                            </td>
                                            <td class="cart_delete"><a class="cart_quantity_delete"
                                                                       href="CartBeanServlet?enter=remove&maSP=<%=ds.getKey().getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>"><i
                                                        class="fa fa-times"></i></a></td>
                                        </tr>

                                        <%
                                            }
                                        %>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                    <!--/#cart_items-->

                    <section id="do_action">
                        <div class="container">
                            <div class="heading">
                                <h3>Thanh toán sản phẩm?</h3>

                            </div>
                            <div class="row">				
                                <div class="col-sm-6">
                                    <div class="total_area">						
                                        <a class="btn btn-default update" href="index.jsp" onclick="return confirm('Bạn muốn hủy đơn không?')">Hủy</a> <a
                                            class="btn btn-default check_out" href="checkout.jsp">Mua Hàng</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--/#do_action-->
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
