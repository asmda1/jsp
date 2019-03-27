/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SanPham;
import sun.misc.VM;

/**
 *
 * @author baotri1998
 */
@WebServlet(name = "ShowGiaTheoSize", urlPatterns = {"/ShowGiaTheoSize"})
public class ShowGiaTheoSize extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            String hs = request.getParameter("txtheso");
            String masp = request.getParameter("txtmasp");
            String sp = request.getParameter("txtsp");
            String masize = request.getParameter("txtmasize");
            String img = request.getParameter("txtimg");
            String gia = request.getParameter("txtgia");
            String url = null;
            HttpSession session = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            if (action.equals("L")) {
                url = "/detail_1.jsp";
                session.setAttribute("heso", hs);
                session.setAttribute("sp", sp);
                session.setAttribute("masp", masp);
                session.setAttribute("gia", gia);
                session.setAttribute("masize", masize);
                session.setAttribute("img", img);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("M")) {
                url = "/detail_1.jsp";
                session.setAttribute("heso", hs);
                session.setAttribute("sp", sp);
                session.setAttribute("masp", masp);
                session.setAttribute("gia", gia);
                session.setAttribute("masize", masize);
                session.setAttribute("img", img);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            } else if (action.equals("XL")) {
                url = "/detail_1.jsp";
                session.setAttribute("heso", hs);
                session.setAttribute("sp", sp);
                session.setAttribute("masp", masp);
                session.setAttribute("gia", gia);
                session.setAttribute("masize", masize);
                session.setAttribute("img", img);
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }
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
