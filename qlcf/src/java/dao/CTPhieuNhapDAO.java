/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.nhom3.qlcf.helper.JDBCHelper;
import model.CTPhieuNhap;
import model.HangHoa;
import model.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kanbi
 */
public class CTPhieuNhapDAO implements DAO<CTPhieuNhap> {

    @Override
    public boolean insert(CTPhieuNhap t) {
        String sql = "Insert dbo.CTPhieuNhap values (?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getMaPhieuNhap().getMaPhieu(), t.getMaHangHoa().getMaHangHoa(), t.getSoLuong());
    }

    @Override
    public boolean delete(CTPhieuNhap t) {
        String sql = "Delete from dbo.CTPhieuNhap where maCTPhieuNhap=?";
        return JDBCHelper.executeUpdate(sql, t.getMaCTPhieuNhap());
    }

    @Override
    public boolean update(CTPhieuNhap t) {
        String sql = "Update dbo.CTPhieuNhap set maPhieuNhap=?, maHangHoa=?, soLuong=? where maCTPhieuNhap=?";
        return JDBCHelper.executeUpdate(sql, t.getMaPhieuNhap().getMaPhieu(), t.getMaHangHoa().getMaHangHoa(), t.getSoLuong(), t.getMaCTPhieuNhap());
    }

    @Override
    public List<CTPhieuNhap> selectAll() {
        String sql = "Select * from dbo.CTPhieuNhap";
        return select(sql);
    }

    @Override
    public CTPhieuNhap selectID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CTPhieuNhap> select(String sql, Object... args) {
        List<CTPhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    CTPhieuNhap model = readFromResultSet(rs);
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
    public CTPhieuNhap readFromResultSet(ResultSet rs) {
        CTPhieuNhap model = new CTPhieuNhap();
        try {
            model.setMaCTPhieuNhap(rs.getInt(1));

            PhieuNhap pn = new PhieuNhap();
            pn.setMaPhieu(rs.getString(2));
            model.setMaPhieuNhap(pn);

            HangHoa hh = new HangHoa();
            hh.setMaHangHoa(rs.getString(3));
            model.setMaHangHoa(hh);

            model.setSoLuong(rs.getFloat(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

}
