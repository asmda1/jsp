/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.KhachHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.KhachHang;

/**
 *
 * @author baotri1998
 */
@WebServlet(name = "DangKy", urlPatterns = {"/DangKy"})
public class DangKy extends HttpServlet {

    KhachHangDAO kdao = new KhachHangDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String txtmakh = request.getParameter("txtmakh");
        String tenkh = request.getParameter("tenkh");
        String dienthoai = request.getParameter("dienthoai");
        String diachi = request.getParameter("diachi");
        String email = request.getParameter("email");
        String pass = request.getParameter("matkhau");
        String error_kh = "";
        String error_pass = "";
        String error_sdt = "";
        String error_email = "";
        if (tenkh.trim().equals("")) {
            error_kh = "Vui Lòng Nhập Tên";
        }
        if (error_kh.length() > 0) {
            request.setAttribute("error_kh", error_kh);
        }
        if (dienthoai.trim().equals("")) {
            error_sdt = "Vui lòng nhập số điện thoại";
        } else {
            if (kdao.checkSDT(dienthoai) == true) {
                error_sdt = "Số điện thoại này đã được đăng ký";
            }else{
                 String so = "[0-9]+";
                 if(!dienthoai.matches(so)){
                    error_sdt = "Số điện thoại phải nhập bằng số"; 
                 }
            }
        }
        if (error_sdt.length() > 0) {
            request.setAttribute("error_sdt", error_sdt);
        }
        if (email.trim().equals("")) {
            error_email = " Vui lòng nhập email";
        } else {
            if (kdao.checkEmail(email) == true) {
                error_email = "  Email này đã được đăng ký, vui lòng chọn tài khoản khác!";
            }
        }
        if (error_email.length() > 0) {
            request.setAttribute("error_email", error_email);
        }
        // Validate Mat Khau
        if (pass.trim().equals("")) {
            error_pass = "Vui lòng nhập Mật Khẩu của bạn !";
        }
        if (error_pass.length() > 0) {
            request.setAttribute("error_pass", error_pass);
        }
        request.setAttribute("dienthoai", dienthoai);
        request.setAttribute("tenkh", tenkh);
            request.setAttribute("email", email);
        String url = "/account.jsp";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (error_pass.length() == 0 && error_email.length() == 0 && error_kh.length() == 0
                    && error_sdt.length() == 0) {
                KhachHang kh = new KhachHang();

                kh.setMakh(txtmakh);
                kh.setDiaChi(diachi);
                kh.setTenKh(tenkh);
                kh.setDienThoai(dienthoai);
                kh.setEmail(email);
                kh.setMatKhau(pass);
                kdao.insert(kh);//insert KH
                if (kdao.checkLogin(email, pass) == true) {
                    url = "/index.jsp";
                    HttpSession session = request.getSession();
                    session.setAttribute("usernamex", email);
                }

            } else {
                url = "/account.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
