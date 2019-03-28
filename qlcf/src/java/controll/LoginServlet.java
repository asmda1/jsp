/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

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
import model.NguoiDung;

/**
 *
 * @author baotri1998
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private NguoiDungDAO taiKhoanDAO = new NguoiDungDAO();
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String usernamex = request.getParameter("ten_dang_nhap");
        String passwordx = request.getParameter("mat_khau");
        String error = "";

        if (usernamex.equals("") || passwordx.equals("")) {
            error = "Vui lòng nhập đầy đủ thông tin !";

        } else if (taiKhoanDAO.checkLogin(usernamex, passwordx) == false) {
            error = "Tài Khoản hoặc Mật Khẩu không chính xác !";
        } else if (taiKhoanDAO.checkLogin(usernamex, passwordx) == false) {
            error = "Tài Khoản hoặc Mật Khẩu không chính xác !";
        }
        if (error.length() > 0) {
            request.setAttribute("error", error);
        }

        request.setAttribute("usernamex", usernamex);
        request.setAttribute("passwordx", passwordx);

        String url = "/index.jsp";

        try {
            if (taiKhoanDAO.checkLogin(usernamex, passwordx) == true) {
                url = "/index.jsp";
                HttpSession session = request.getSession();
                session.setAttribute("usernamex", usernamex);
            }else{
                 url = "/Error.jsp";
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
