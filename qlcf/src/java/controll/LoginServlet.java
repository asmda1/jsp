/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.KhachHangDAO;
import dao.NguoiDungDAO;
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
import model.NguoiDung;

/**
 *
 * @author baotri1998
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private KhachHangDAO taiKhoanDAO = new KhachHangDAO();
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String pass = request.getParameter("mat_khau");
        String error = "";

        if (email.equals("") || pass.equals("")) {
            error = "Vui lòng nhập đầy đủ thông tin !";

        } else if (taiKhoanDAO.checkLogin(email, pass) == false) {
            error = "Tài Khoản hoặc Mật Khẩu không chính xác !";
        } else if (taiKhoanDAO.checkLogin(email, pass) == false) {
            error = "Tài Khoản hoặc Mật Khẩu không chính xác !";
        }
        if (error.length() > 0) {
            request.setAttribute("error", error);
        }

        request.setAttribute("usernamex", email);
        request.setAttribute("passwordx", pass);

        String url = "/index.jsp";

        try {
            if (taiKhoanDAO.checkLogin(email, pass) == true) {
                url = "/index.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("usernamex", email);
            }else{
                 url = "/account.jsp";
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("enter").equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("/qlcf/login.jsp");

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
