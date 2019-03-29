/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import dao.CTHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NguoiDungDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CTHoaDon;
import model.CartBean;
import model.Extra;
import model.HoaDon;
import model.KhachHang;
import model.NguoiDung;
import model.SanPham;
import model.SizeSP;

/**
 *
 * @author baotri1998
 */
@WebServlet(name = "PayServlet", urlPatterns = {"/PayServlet"})
public class PayServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private HoaDonDAO hdDAO = new HoaDonDAO();
    private CTHoaDonDAO hdct = new CTHoaDonDAO();
    private NguoiDungDAO accDAO = new NguoiDungDAO();

    public PayServlet() {
        super();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String txmaKH = request.getParameter("txmaKH");
        String txtemail = request.getParameter("txtemail");
        String tenkh = request.getParameter("tenkh");
        String dienthoai = request.getParameter("dienthoai");
        String diachi = request.getParameter("diachi");
        String mahoadon = request.getParameter("txthd");
        String maextra = request.getParameter("txtextra");
        String masize = request.getParameter("txtSize");
        HttpSession session = request.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        String error_address = "", error_methods = "";
        if (diachi.trim().equals("")) {

            error_address = " Hiện Tại địa chỉ chưa có! Vui lòng nhập địa chỉ ship!";

        }
        if (error_address.length() > 0) {
            request.setAttribute("error_address", error_address);
        }

        /* // Validate dia chi
        if (Shipping_Address.equals("")) {
            error_address = "Vui lòng nhập địa chỉ của bạn !";
        }
        if (error_address.length() > 0) {
            request.setAttribute("error_address", error_address);
        }
        // Validate phuong thuc thanh toan
        if (Payment_Methods.equals("")) {
            error_methods = "Vui lòng ch�?n phương thức thanh toán";
        }
        if (error_methods.length() > 0) {
            request.setAttribute("error_methods", error_methods);
        }
        // Validate Email
        if (Email.equals("")) {
            error_email = "Vui lòng nhập địa chỉ Email của bạn !";
        }
        if (error_email.length() > 0) {
            request.setAttribute("error_email", error_email);
        }*/

 /*request.setAttribute("Shipping_Address", Shipping_Address);
        request.setAttribute("Payment_Methods", Payment_Methods);
        request.setAttribute("Email", Email);*/
        try {
            if (error_address.length() == 0 && error_methods.length() == 0) {
                Date date = new Date();

                TreeMap<SanPham, Integer> list = cart.getList();
                for (Map.Entry<SanPham, Integer> ds : list.entrySet()) {
                    SanPham pr = new SanPham();
                    NguoiDung nd = new NguoiDung();
                    KhachHang kh = new KhachHang();
                    KhachHangDAO kdao = new KhachHangDAO();
                    SizeSP size = new SizeSP();
                    Extra ex = new Extra();
                    kh.setMakh(txmaKH);
                    kh.setEmail(txtemail);
                    kh.setDiaChi(diachi);
                    kh.setTenKh(tenkh);
                    kh.setDienThoai(dienthoai);
                    kdao.updateKHonl(kh, kh.getMakh());//update KH
                    nd.setMaNguoidung("ND001");
                    pr.setMaSanPham(ds.getKey().getMaSanPham());
                    HoaDon hd = new HoaDon();
                    hd.setMaHoaDon(mahoadon);
                    hd.setMaNguoiDung(nd);
                    hd.setTrangThai(false);
                    hd.setMaKhachHang(kh);
                    hd.setTongTien(ds.getKey().getGiaBan() * ds.getValue());
                    hd.setNgayHD(date);
                    hd.setChietKhau(0);
                    hdDAO.insert(hd);//insert HD chưa thanh toán 
                    CTHoaDon cthd = new CTHoaDon();
                    cthd.setMaHoaDon(hd);
                    cthd.setMaSanPham(pr);
                    ex.setId(maextra);
                    cthd.setExtra(ex);
                    size.setMaSize(masize);
                    cthd.setSizeSP(size);
                    cthd.setSoLuong(ds.getValue());
                    hdct.insert(cthd);

                }

                request.setAttribute("message", "Thanh toán thành công !"); 
                request.getRequestDispatcher("/checkout.jsp").forward(request, response);
                // response.sendRedirect("/SOF301_Assignment/checkout.jsp");
            } else {
                request.setAttribute("message", "Mua hàng thất bại !");
                request.getRequestDispatcher("/checkout.jsp").forward(request, response);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
