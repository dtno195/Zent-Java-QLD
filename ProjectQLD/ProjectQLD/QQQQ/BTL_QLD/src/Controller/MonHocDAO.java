/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MonHoc;
import Util.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc
 */
public class MonHocDAO {

    public List<MonHoc> selectAll() {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM tbl_MONHOC");
            List<MonHoc> monHocList = new ArrayList<>();
            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMonHoc(rs.getString("MA_MON_HOC"));
                mh.setTenMonHoc(rs.getString("TEN_MON_HOC"));
                mh.setTinChi(rs.getInt("TIN_CHI"));
                mh.setHeSoGiuaKy(rs.getFloat("HESO_GIUAKY"));
                mh.setHeSoCuoiKy(rs.getFloat("HESO_CUOIKY"));
                monHocList.add(mh);
            }
            return monHocList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(MonHoc monHoc) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("INSERT INTO [tbl_MONHOC]\n"
                    + "           ([MA_MON_HOC]\n"
                    + "           ,[TEN_MON_HOC]\n"
                    + "           ,[TIN_CHI]\n"
                    + "           ,[HESO_GIUAKY]\n"
                    + "           ,[HESO_CUOIKY])\n"
                    + "     VALUES  (?,?,?,?,?) ");
            prs.setString(1, monHoc.getMaMonHoc());
            prs.setString(2, monHoc.getTenMonHoc());
            prs.setInt(3, monHoc.getTinChi());
            prs.setFloat(4, monHoc.getHeSoGiuaKy());
            prs.setFloat(5, monHoc.getHeSoCuoiKy());

            return prs.execute();

            //boolean checkMaMH = SQLConnection.Kiem_Tra_Trung("tbl_MONHOC", "MA_MON_HOC", ip)
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(MonHoc monHoc) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("UPDATE [tbl_MONHOC]\n"
                    + "   SET [TEN_MON_HOC] =? \n"
                    + "      ,[TIN_CHI] =? \n"
                    + "      ,[HESO_GIUAKY] =? \n"
                    + "      ,[HESO_CUOIKY] =? \n"
                    + " WHERE [MA_MON_HOC] =? ");

            prs.setString(1, monHoc.getTenMonHoc());
            prs.setInt(2, monHoc.getTinChi());
            prs.setFloat(3, monHoc.getHeSoGiuaKy());
            prs.setFloat(4, monHoc.getHeSoCuoiKy());
            prs.setString(5, monHoc.getMaMonHoc());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(MonHoc monHoc) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("DELETE FROM tbl_MONHOC WHERE MA_MON_HOC = ?");
            prs.setString(1, monHoc.getMaMonHoc());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<MonHoc> search(MonHoc mh) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            String sql = "SELECT * FROM tbl_MONHOC WHERE 1=1";
            if (!mh.getMaMonHoc().isEmpty()) {
                sql = sql + " AND MA_MON_HOC LIKE N'" + mh.getMaMonHoc() + "%'";
            } else if (!mh.getTenMonHoc().isEmpty()) {
                sql = sql + " AND TEN_MON_HOC LIKE N'" + mh.getTenMonHoc() + "'";
            } else if (mh.getTinChi() != 0) {
                sql = sql + " AND TIN_CHI LIKE N'%" + mh.getTinChi() + "%'";
            }
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            List<MonHoc> monHocList = new ArrayList<>();
            while (rs.next()) {
                MonHoc monHoc = new MonHoc();
                monHoc.setMaMonHoc(rs.getString("MA_MON_HOC"));
                monHoc.setTenMonHoc(rs.getString("TEN_MON_HOC"));
                monHoc.setTinChi(rs.getInt("TIN_CHI"));
                monHoc.setHeSoGiuaKy(rs.getFloat("HESO_GIUAKY"));
                monHoc.setHeSoCuoiKy(rs.getFloat("HESO_CUOIKY"));
                monHocList.add(monHoc);
            }
            return monHocList;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<MonHoc> search1(String input) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            String sql = "";
            if (input.equalsIgnoreCase("")) {
                sql = "select * from tbl_MONHOC";
            } else {
                sql = "select * from tbl_MONHOC where MA_MON_HOC like '%" + input + "%'\n"
                        + "OR TEN_MON_HOC LIKE '%" + input + "%'\n"
                        + "OR TIN_CHI LIKE '%" + input + "%'\n"
                        + "OR HESO_GIUAKY LIKE '%" + input + "%'\n"
                        + "OR HESO_CUOIKY LIKE '%" + input + "%'\n";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ResultSet rs = st.executeQuery(sql);
            List<MonHoc> monHocList = new ArrayList<>();
            while (rs.next()) {
                MonHoc monHoc = new MonHoc();
                monHoc.setMaMonHoc(rs.getString("MA_MON_HOC"));
                monHoc.setTenMonHoc(rs.getString("TEN_MON_HOC"));
                monHoc.setTinChi(rs.getInt("TIN_CHI"));
                monHoc.setHeSoGiuaKy(rs.getFloat("HESO_GIUAKY"));
                monHoc.setHeSoCuoiKy(rs.getFloat("HESO_CUOIKY"));
                monHocList.add(monHoc);
            }
            return monHocList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
