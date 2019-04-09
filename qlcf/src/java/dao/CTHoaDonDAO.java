/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.nhom3.qlcf.helper.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CTHoaDon;
import model.Extra;
import model.HoaDon;
import model.SanPham;
import model.SizeSP;
///
/** s
 *
 * @author Kanbidđ
 */
public class CTHoaDonDAO implements DAO<CTHoaDon> {

    @Override
    public boolean insert(CTHoaDon t) {
        String sql = "Insert dbo.CTHoaDon values (?,?,?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getMaHoaDon().getMaHoaDon(), t.getMaSanPham().getMaSanPham(),t.getSizeSP().getMaSize(), t.getExtra().getId(), t.getSoLuong());
    }

    @Override
    public boolean delete(CTHoaDon t) {
        String sql = "Delete from CTHoaDon where maCTHD=?";
        return JDBCHelper.executeUpdate(sql, t.getId());
    }

    @Override
    public boolean update(CTHoaDon t) {
        String sql = "Update dbo.CTHoaDon set maHD=?,maSP=?,maSize=?, soLuong=? where maCTHD=?";
        return JDBCHelper.executeUpdate(sql, t.getMaHoaDon().getMaHoaDon(), t.getMaSanPham().getMaSanPham(),t.getSizeSP().getMaSize(), t.getExtra().getId(), t.getSoLuong(), t.getId());
    }

    @Override
    public List<CTHoaDon> selectAll() {
        String sql = "Select * from CTHoaDon";
        return select(sql);
    }

    @Override
    public List<CTHoaDon> select(String sql, Object... args) {
        List<CTHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    CTHoaDon model = readFromResultSet(rs);
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
    public CTHoaDon readFromResultSet(ResultSet rs) {
        CTHoaDon model = new CTHoaDon();
        try {
            model.setId(rs.getInt("maCTHD"));
            HoaDon hd = new HoaDon();
            hd.setMaHoaDon(rs.getString("maHD"));
            model.setMaHoaDon(hd);
            SanPham sp = new SanPham();
            sp.setMaSanPham(rs.getString("maSP"));
            model.setMaSanPham(sp);
            SizeSP size = new SizeSP();
            size.setMaSize(rs.getString("maSize"));
            model.setSizeSP(size);
            Extra ex = new Extra();
            ex.setId(rs.getString("extra"));
            model.setExtra(ex);
            model.setSoLuong(rs.getInt("soLuong"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return model;
    }

    @Override
    public CTHoaDon selectID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
