
<%@page import="java.util.List"%>
<%@page import="model.SizeSP"%>
<%@page import="dao.SelectSIze"%>
<%@page import="model.SanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Chi Tiết Sản Phẩm | TNP_Coffe</title>
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

        <div id="fb-root"></div>

        <%
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            SanPham sp = sanPhamDAO.selectID(request.getParameter("maSP"));
            SelectSIze size = new SelectSIze();
            List<SizeSP> list = size.select();

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
            SelectSIze dao = new SelectSIze();
            SizeSP sisizeze = dao.selectID(request.getParameter("masize"));
        %>
          <jsp:include page="header.jsp"></jsp:include>
    <section>
        <div class="container">
            <div class="row">

                <div class="col-sm-9 padding-right">
                    <div class="product-details">
                        <!--product-details-->
                        <div class="col-sm-5">
                            <div class="view-product">
                                <img src="img/<%=sp.getHinhAnh()%>" alt="" />

                            </div>

                        </div>

                        <div class="col-sm-7">
                            <div class="product-information">
                                <!--/product-information-->



                                <h2><%=sp.getTenSp()%></h2>
                                <p>
                                    Mã Sản Phẩm:
                                    <%=request.getParameter("maSP")%>
                                </p>
                                <h4>Chọn Size</h4>

                                <%

                                    for (SizeSP show : dao.select()) {

                                %>
                                <a href="detail.jsp?masize=<%=show.getMaSize()%>&maSP=<%=sp.getMaSanPham()%>"><%=show.getMaSize()%></a>

                                <%}%>
                                </br> 
                                <span>
                                    <% if (request.getParameter("masize") != null) {%>
                                    <span> <%=nf.format(sp.getGiaBan() * sisizeze.getHeSo())%> VNĐ</span> <!--<label>Số
                                            Lượng:</label> <input type="text" value="Nhập" />-->

                                    <p>
                                        <a
                                            href="CartBeanServlet?enter=insert&maSP=<%=sp.getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>&masize=<%=sisizeze.getMaSize()%>"
                                            type="button" class="btn btn-fefault cart"> <i
                                                class="fa fa-shopping-cart"></i> Thêm vào giỏ
                                        </a>
                                    </p>
                                    <%} else {%>
                                    <span> <%=nf.format(sp.getGiaBan())%> VNĐ</span> 
                                    <p>
                                        <a
                                            href="CartBeanServlet?enter=insert&maSP=<%=sp.getMaSanPham()%>&cartID=<%=System.currentTimeMillis()%>&masize=M"
                                            type="button" class="btn btn-fefault cart"> <i
                                                class="fa fa-shopping-cart"></i> Thêm vào giỏ
                                        </a>
                                    </p>
                                    <%}%>
                                </span>


                                </br>

                                <p></p>
                                <p>
                                    <b>Số lượng</b>:


                                </p>
                                <p>
                                    <b>Giảm giá: 
                                        VNĐ
                                </p>
                                <p>
                                    <b>Bán Tại:</b> TNP-Coffe
                                </p>

                                <!--/product-information-->
                            </div>
                        </div>
                        <!--/product-details-->



                    </div>
                </div>
            </div>
    </section>

</body>
</html>