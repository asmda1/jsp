/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.nhom3.qlcf.helper.JDBCHelper;
import model.NguoiDung;
import model.NhaCungCap;
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
public class NhaCungCapDAO implements DAO<NhaCungCap> {

    @Override
    public boolean insert(NhaCungCap t) {
        String sql = "Insert dbo.NhaCungCap values (?,?,?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getMaNhaCungCap(), t.getTenNhaCC(), t.getDienThoai(), t.getDiaChi(), t.isTrangThai());
    }

    @Override
    public boolean delete(NhaCungCap t) {
        String sql = "Delete from dbo.NhaCungCap where maNhaCungCap=?";
        return JDBCHelper.executeUpdate(sql, t.getMaNhaCungCap());
    }

    @Override
    public boolean update(NhaCungCap t) {
        String sql = "Update dbo.NhaCungCap set tenNhaCungCap=?, dienThoai=?, diaChi=?, trangThai=? where maNhaCungCap=?";
        return JDBCHelper.executeUpdate(sql, t.getTenNhaCC(), t.getDienThoai(), t.getDiaChi(), t.isTrangThai(), t.getMaNhaCungCap());
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String sql = "Select * from dbo.NhaCungCap";
        return select(sql);
    }

    @Override
    public List<NhaCungCap> select(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhaCungCap model = readFromResultSet(rs);
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
    public NhaCungCap readFromResultSet(ResultSet rs) {
        NhaCungCap model = new NhaCungCap();
        try {
            model.setMaNhaCungCap(rs.getString(1));
            model.setTenNhaCC(rs.getString(2));
            model.setDienThoai(rs.getString(3));
            model.setDiaChi(rs.getString(4));
            model.setTrangThai(rs.getBoolean(5));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return model;
    }

    @Override
    public NhaCungCap selectID(String ID) {
        String sql = "Select * from dbo.NhaCungCap where dienThoai=?";
        List<NhaCungCap> list = select(sql, ID);
        return list.size() > 0 ? list.get(0) : null;
    }
     public boolean checkMa(String ma) {
        String sql = "Select * from dbo.NhaCungCap WHERE maNhaCungCap ='" + ma + "' or dienThoai='" + ma + "'";
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
