/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.nhom3.qlcf.helper.JDBCHelper;
import model.KhachHang;
import model.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kanbi
 */
public class KhachHangDAO implements DAO<KhachHang> {

    @Override
    public boolean insert(KhachHang t) {
        String sql = "Insert dbo.KhachHang values (?,?,?,?,?,?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getMakh(), t.getTenKh(), t.getMatKhau(), t.getEmail(), t.getDienThoai(), t.getDiaChi(),t.isTrangThai(), t.getDiemThuong());
    }

    @Override
    public boolean delete(KhachHang t) {
        String sql = "Delete from dbo.KhachHang where maKh=?";
        return JDBCHelper.executeUpdate(sql, t.getMakh());
    }

    @Override
    public boolean update(KhachHang t) {
        String sql = "Update dbo.KhachHang set tenKh=?, matKhau=?, email=?, dienThoai=?, diaChi=?, trangThai=?, diemThuong=? where maKh=?";
        return JDBCHelper.executeUpdate(sql, t.getTenKh(), t.getMatKhau(), t.getEmail(), t.getDienThoai(), t.getDiaChi(), t.isTrangThai(), t.getDiemThuong(), t.getMakh());
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM dbo.KhachHang where maKh != 'KH000' ";
        return select(sql);
    }

    @Override
    public List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public KhachHang readFromResultSet(ResultSet rs) {
        KhachHang model = new KhachHang();
        try {
            model.setMakh(rs.getString(1));
            model.setTenKh(rs.getString(2));
            model.setMatKhau(rs.getString(3));
            model.setEmail(rs.getString(4));
            model.setDienThoai(rs.getString(5));
            model.setDiaChi(rs.getString(6));
            model.setTrangThai(rs.getBoolean(7));
            model.setDiemThuong(rs.getInt(8));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return model;
    }

      @Override
    public KhachHang selectID(String ID) {
        String sql = "Select * from dbo.KhachHang where email = ?";
        List<KhachHang> list = select(sql, ID);
        return list.size() > 0 ? list.get(0) : null;
    }

    //bổ sung
    public boolean checkSDT(String sdt) {
        String sql = "Select * from dbo.KhachHang WHERE dienThoai ='" + sdt + "'";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
  public static boolean checkEmail(String email) {
        String sql = "Select * from dbo.KhachHang WHERE email ='" + email + "'";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
   public boolean updateKHonl(KhachHang t, String makh) {
        String sql = "Update dbo.KhachHang set tenKh=?, dienThoai=?, diaChi=? where maKh=?";
        return JDBCHelper.executeUpdate(sql, t.getTenKh(), t.getDienThoai(), t.getDiaChi(), makh);
    }
     public static boolean checkLogin(String email, String pass) {
        String sql = "Select * from dbo.KhachHang WHERE email ='" + email + "' and matKhau='" + pass 
                + "' and makh!='KH000'";
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
