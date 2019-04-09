/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.nhom3.qlcf.helper.JDBCHelper;
import model.Extra;
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
public class ExtraDAO implements DAO<Extra> {

    @Override
    public boolean insert(Extra t) {
        String sql = "Insert dbo.Extra values (?,?,?)";
        return JDBCHelper.executeUpdate(sql, t.getId(), t.getTen(), t.getGia());
    }

    @Override
    public boolean delete(Extra t) {
        String sql = "Delete from dbo.Extra where id=?";
        return JDBCHelper.executeUpdate(sql, t.getId());
    }

    @Override
    public boolean update(Extra t) {
        String sql = "Update dbo.Extra set ten=?, gia=? where id=?";
        return JDBCHelper.executeUpdate(sql, t.getTen(), t.getGia(), t.getId());
    }

    @Override
    public List<Extra> selectAll() {
        String sql = "Select * from dbo.Extra where id != 'EX000' ";
        return select(sql);
    }

    @Override
    public List<Extra> select(String sql, Object... args) {
        List<Extra> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Extra model = readFromResultSet(rs);
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
    public Extra readFromResultSet(ResultSet rs) {
        Extra model = new Extra();
        try {
            model.setId(rs.getString(1));
            model.setTen(rs.getString(2));
            model.setGia(rs.getDouble(3));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return model;

    }

  

    @Override
    public Extra selectID(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
