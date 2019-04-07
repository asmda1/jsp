<%@page import="dao.KhachHangDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.HoaDonDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Map"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Thanh Toán | TNP-Coffee</title>
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
            if (session.getAttribute("usernamex") == null) {
                response.sendRedirect("/qlcf/account.jsp");
            } else {
                CartBean cart = (CartBean) session.getAttribute("cart");
                if (cart == null) {
                    cart = new CartBean();
                    session.setAttribute("cart", cart);
                }
                TreeMap<SanPham, Integer> list = cart.getList();

                NumberFormat nf = NumberFormat.getInstance();
                nf.setMinimumIntegerDigits(0);

                String error_address = "", error_kh = "", error_sdt = "";
                if (request.getAttribute("error_address") != null) {
                    error_address = (String) request.getAttribute("error_address");
                }
                if (request.getAttribute("error_kh") != null) {
                    error_kh = (String) request.getAttribute("error_sdt");
                }
                if (request.getAttribute("error_sdt") != null) {
                    error_sdt = (String) request.getAttribute("error_sdt");
                }

                String tenkh = "", diachi = "", dienthoai = "";
                if (request.getAttribute("diachi") != null) {
                    diachi = (String) request.getAttribute("diachi");
                }

                if (request.getAttribute("tenkh") != null) {
                    tenkh = (String) request.getAttribute("tenkh");
                }
                if (request.getAttribute("dienthoai") != null) {
                    dienthoai = (String) request.getAttribute("dienthoai");
                }

//maSP tự tăng

        %>


        <%!
            public String AutogetMaHD() {
                HoaDonDAO hdDao = new HoaDonDAO();
                String chuoi = "";
                List<HoaDon> list = hdDao.selectAll();
                if (list.isEmpty()) {
                    chuoi = "HD001";

                    return chuoi;
                } else {
                    int index = list.size() - 1;
                    int so = Integer.parseInt(list.get(index).getMaHoaDon().substring(2)) + 1;
                    switch (String.valueOf(so).length()) {
                        case 1:
                            chuoi = "HD00" + so;
                            break;
                        case 2:
                            chuoi = "HD0" + so;
                            break;
                        case 3:
                            chuoi = "HD" + so;
                            break;
                    }

                    return chuoi;
                }
            }

            public String AutogetKH() {
                KhachHangDAO kh = new KhachHangDAO();
                String chuoi = "";
                List<KhachHang> list = kh.selectAll();
                if (list.isEmpty()) {
                    chuoi = "KH001";
                    return chuoi;
                } else {
                    int index = list.size() - 1;
                    int so = Integer.parseInt(list.get(index).getMakh().substring(2)) + 1;
                    switch (String.valueOf(so).length()) {
                        case 1:
                            chuoi = "KH00" + so;
                            break;
                        case 2:
                            chuoi = "KH0" + so;
                            break;
                        case 3:
                            chuoi = "KH" + so;
                            break;
                    }

                    return chuoi;
                }
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>

        <section id="cart_items">
            <div class="container">
                <div>
                <% KhachHangDAO dao = new KhachHangDAO();
                    KhachHang kh = dao.selectID(session.getAttribute("usernamex").toString());
                %>
                <form align="center" action="PayServlet" method="post">
                    <p>Tên Bạn</p>
                    <span style="color: red;"><%=error_kh%></span>  </br>
                    <input style="width: 50%;height:40px" name="tenkh" value="<%=kh.getTenKh()%>"></input>

                    <p>Thay Đổi Địa Chỉ(Có thể bỏ qua)</p>
                    <span style="color: red;"><%=error_address%></span>  </br>
                    <input style="width: 50%;height:40px" name="diachi" value="<%=kh.getDiaChi()%>"></input>

                    <p>Thay Đổi SDT Ship (Có thể bỏ qua)</p>
                    <span style="color: red;"><%=error_sdt%></span>  </br>
                    <input style="width: 50%;height:40px" name="dienthoai" value="<%=kh.getDienThoai()%>"></input>

                    </br>
                    <input type="hidden" value="<%=session.getAttribute("usernamex")%>" name="txtemail" />
                    <input type="hidden" value="<%=kh.getMakh()%>" name="txmaKH" />
                    <input type="hidden" value="<%=AutogetMaHD()%>" name="txthd" />
                    <input type="hidden" value="EX000" name="txtextra" />
                    <input type="hidden" value="M" name="txtSize" />
                    <input type="submit" value="Xác Nhận Mua Hàng" class="btn btn-primary" name="action" />
                </form>
                <span style="color: #0083C9;">${message}</span>




            </div>

            <div class="review-payment">
                <h2>Đơn Hàng Đặt Mua</h2>
            </div>

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
                        <%                                            for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
                        %>
                        <tr>
                            <td class="cart_product"><a href=""><img style="width: 200px"
                                                                     src="img/<%=ds.getKey().getHinhAnh()%>" alt=""></a></td>
                            <td class="cart_description">
                                <h4>
                                    <a href=""><%=ds.getKey().getMaSanPham()%></a>
                                </h4>
                                <p>
                                    Mã Sản Phẩm:
                                    <%=ds.getKey().getMaSanPham()%></p>
                            </td>
                            <td class="cart_price">
                                <p><%=nf.format(ds.getKey().getGiaBan())%>
                                    VNĐ
                                </p>
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
        </br>
        </hr>
        </br>
    </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>

<%
    }
%>
</body>
</html>