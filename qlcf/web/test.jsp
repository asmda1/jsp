<%-- 
    Document   : test
    Created on : Mar 27, 2019, 7:56:25 PM
    Author     : baotri1998
--%>

<%@page import="dao.SanPhamDAO"%>
<%@page import="model.SanPham"%>
<%@page import="model.SizeSP"%>
<%@page import="dao.SelectSIze"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            SelectSIze dao = new SelectSIze();
            SizeSP sisizeze = dao.selectID(request.getParameter("masize"));
            SanPhamDAO dao2 = new SanPhamDAO();
            SanPham sp = dao2.selectID(request.getParameter("maSP"));


        %>
        <h1>
            <%=sp.getTenSp()%>
        </h1>
        <p>
            <%=sisizeze.getTenSize()%>
        </p>
        <h2>Giá </h2>
        <%=sp.getGiaBan() * sisizeze.getHeSo()%>

        <h1>Chọn Size</h1>
        <%
            for (SizeSP show : dao.select()) {

        %>
        <a href="test.jsp?masize=<%=show.getMaSize()%>&maSP=<%=sp.getMaSanPham()%>"><%=show.getMaSize()%></a>

        <%}%>
    </body>
</html>
