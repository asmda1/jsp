/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.nhom3.qlcf.helper.JDBCHelper;
import model.HangHoa;
import model.NguoiDung;
import model.NhaCungCap;
import model.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kanbi
 */
public class PhieuNhapDAO implements DAO<PhieuNhap> {

    @Override
    public boolean insert(PhieuNhap t) {
        String sql = "Insert dbo.PhieuNhap values (?,?,?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getMaPhieu(), t.getMaNhaCungCap().getMaNhaCungCap(), t.getMaNguoiDung().getMaNguoidung(), t.getNgayNhap(), t.getTongTien());

    }

    @Override
    public boolean delete(PhieuNhap t) {
        String sql = "Delete from dbo.PhieuNhap where maPhieu=?";
        return JDBCHelper.executeUpdate(sql, t.getMaPhieu());
    }

    @Override
    public boolean update(PhieuNhap t) {
        String sql = "Update dbo.PhieuNhap set  maNhacungCap=?, nguoiNhap=?, ngayNhap=?, tongTien=? where maPhieu=?";
        return JDBCHelper.executeUpdate(sql, t.getMaNhaCungCap().getMaNhaCungCap(), t.getMaNguoiDung().getMaNguoidung(), t.getNgayNhap(), t.getTongTien(), t.getMaPhieu());
    }

    @Override
    public List<PhieuNhap> selectAll() {
        String sql = "Select * from dbo.PhieuNhap";
        return select(sql);
    }

    @Override
    public List<PhieuNhap> select(String sql, Object... args) {
        List<PhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuNhap model = readFromResultSet(rs);
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
    public PhieuNhap readFromResultSet(ResultSet rs) {
        PhieuNhap model = new PhieuNhap();
        try {
            model.setMaPhieu(rs.getString(1));

            NhaCungCap ncc = new NhaCungCap();
            ncc.setMaNhaCungCap(rs.getString(2));
            model.setMaNhaCungCap(ncc);

            NguoiDung nd = new NguoiDung();
            nd.setMaNguoidung(rs.getString(3));
            model.setMaNguoiDung(nd);

            model.setNgayNhap(rs.getDate(4));
            model.setTongTien(rs.getDouble(5));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return model;
    }

    @Override
    public PhieuNhap selectID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
