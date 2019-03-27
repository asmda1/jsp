<%-- 
    Document   : t
    Created on : Mar 25, 2019, 10:03:14 PM
    Author     : baotri1998
--%>

<%@page import="model.SizeSP"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        SizeSP SV = new SizeSP();
        SV.setHeSo(Float.parseFloat(session.getAttribute("heso").toString()));
   

    %>
    <body>
        <%if (session.getAttribute("heso") == null) {%>

        <%} else {%>
    <li><a>Hệ số: <%=session.getAttribute("heso")%></a></li>
    <li><a>Tên SP Đặt: <%=session.getAttribute("sp")%></a></li>
    <li><a>Tên giá: <%=session.getAttribute("gia")%></a></li>
    <img src="img/<%=session.getAttribute("img")%>" />
    Đăng Xuất</a></li>
<%}%>-->


</body>
</html>
