<%@page import="java.util.TreeMap"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.SanPham"%>
<%@page import="model.CartBean"%>
<%@page import="model.HoaDon"%>
<%@page import="model.KhachHang"%>
<%@page import="java.util.List"%>
<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tài Khoản | Tri-Mobile</title>

    </head>
    <%

        String error_address = "", error_kh = "", error_sdt = "", error_email = "", error_pass = "";
        if (request.getAttribute("error_address") != null) {
            error_address = (String) request.getAttribute("error_address");
        }
        if (request.getAttribute("error_kh") != null) {
            error_kh = (String) request.getAttribute("error_kh");
        }
        if (request.getAttribute("error_sdt") != null) {
            error_sdt = (String) request.getAttribute("error_sdt");
        }
        if (request.getAttribute("error_email") != null) {
            error_email = (String) request.getAttribute("error_email");
        }
        if (request.getAttribute("error_pass") != null) {
            error_pass = (String) request.getAttribute("error_pass");
        }

        String tenkh = "", diachi = "", dienthoai = "", matkhau = "", email = "";
        if (request.getAttribute("diachi") != null) {
            diachi = (String) request.getAttribute("diachi");
        }

        if (request.getAttribute("tenkh") != null) {
            tenkh = (String) request.getAttribute("tenkh");
        }
        if (request.getAttribute("matkhau") != null) {
            matkhau = (String) request.getAttribute("matkhau");
        }
        if (request.getAttribute("email") != null) {
            email = (String) request.getAttribute("email");
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
    <body>


        <jsp:include page="header.jsp"></jsp:include>

            <h2>Đăng Ký Mua Hàng</h2>
            <div   >


                <!--sign up form-->
                <form align="center" action="DangKy" method="post">
                    <p>Họ Tên*</p>
                    <span style="color: red;"><%=error_kh%></span>  </br>
                <input style="width: 50%;height:40px" placeholder="Họ Tên" name="tenkh" value="<%=tenkh%>"></input>
                <p>Email Đăng Ký*</p>
                <span style="color: red;"><%=error_email%></span>  </br>
                <input style="width: 50%;height:40px" type="email" placeholder="Email" name="email" value="<%=email%>"></input>
                <p>Mật Khậu Đăng Ký*</p>
                <span style="color: red;"><%=error_pass%></span>  </br>
                <input style="width: 50%;height:40px" type="password" placeholder="Mật Khẩu" name="matkhau" value="<%=matkhau%>"></input>
                <p>Địa Chỉ</p>
                <span style="color: red;"><%=error_address%></span>  </br>
                <input style="width: 50%;height:40px" placeholder="Địa Chỉ"  name="diachi" value="<%=diachi%>"></input>
                <p>Số Điện Thoại*</p>
                <span style="color: red;"><%=error_sdt%></span>  </br>
                <input style="width: 50%;height:40px" placeholder="Số Điện Thoai"  name="dienthoai" value="<%=dienthoai%>"></input>

                </br>
                <input type="hidden" value="<%=session.getAttribute("usernamex")%>" name="Account" />
                <input type="hidden" value="<%=AutogetKH()%>" name="txtmakh" />
                <input type="submit" value="Đăng Ký" class="btn btn-primary" name="action" />
            </form><br>
            <span style="color: blue">${message}</span>
        </div>
        <!--/sign up form-->




        <!--/form-->

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>