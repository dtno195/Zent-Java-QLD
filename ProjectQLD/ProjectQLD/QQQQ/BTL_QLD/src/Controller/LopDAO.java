/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Diem;
import Model.Lop;
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
 * @author Admin
 */
public class LopDAO {

    public List<Lop> selectAll() {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM tbl_LOP");
            List<Lop> lopList = new ArrayList<>();
            while (rs.next()) {
                Lop mh = new Lop();
                mh.setMaLop(rs.getString("MA_LOP"));
                mh.setTenLop(rs.getString("TEN_LOP"));
                mh.setTenKhoa(rs.getString("TEN_KHOA"));
                mh.setNienKhoa(rs.getString("NIEN_KHOA"));
                lopList.add(mh);
            }
            return lopList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(Lop lop) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("INSERT INTO [tbl_LOP]\n"
                    + "           ([MA_LOP]\n"
                    + "           ,[TEN_LOP]\n"
                    + "           ,[TEN_KHOA]\n"
                    + "           ,[NIEN_KHOA])\n"
                    + "     VALUES (?,?,?,?) ");
            prs.setString(1, lop.getMaLop());
            prs.setString(2, lop.getTenLop());
            prs.setString(3, lop.getTenKhoa());
            prs.setString(4, lop.getNienKhoa());

            return prs.execute();

            //boolean checkMaMH = SQLConnection.Kiem_Tra_Trung("tbl_LOP", "MA_LOP", ip)
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(Lop lop) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("UPDATE [tbl_LOP]\n"
                    + "   SET [TEN_LOP] =? \n"
                    + "      ,[TEN_KHOA] =? \n"
                    + "      ,[NIEN_KHOA] =? \n"
                    + " WHERE [MA_LOP] =? ");

            prs.setString(1, lop.getTenLop());
            prs.setString(2, lop.getTenKhoa());
            prs.setString(3, lop.getNienKhoa());
            prs.setString(4, lop.getMaLop());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(Lop lop) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("DELETE FROM [tbl_LOP]\n"
                    + "      WHERE [MA_LOP] =? ");
            prs.setString(1, lop.getMaLop());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Lop getMaLopID(String maLop) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("SELECT * FROM tbl_LOP WHERE MA_LOP = ?");
            prs.setString(1, maLop);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                Lop mh = new Lop();
                mh.setMaLop(rs.getString("MA_LOP"));
                mh.setTenLop(rs.getString("TEN_LOP"));
                mh.setTenKhoa(rs.getString("TEN_KHOA"));
                mh.setNienKhoa(rs.getString("NIEN_KHOA"));
                return mh;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Lop> search(String input) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            String sql = "";
            if (input.equalsIgnoreCase("")) {
                sql = "select * from tbl_LOP";
            } else {
                sql = "select * from tbl_LOP where MA_LOP like '%" + input + "%'\n"
                        + "OR TEN_LOP LIKE '%" + input + "%'\n"
                        + "OR TEN_KHOA LIKE '%" + input + "%'\n"
                        + "OR NIEN_KHOA LIKE '%" + input + "%'\n";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ResultSet rs = st.executeQuery(sql);
            List<Lop> lopList = new ArrayList<>();
            while (rs.next()) {
                Lop mh = new Lop();
                mh.setMaLop(rs.getString("MA_LOP"));
                mh.setTenLop(rs.getString("TEN_LOP"));
                mh.setTenKhoa(rs.getString("TEN_KHOA"));
                mh.setNienKhoa(rs.getString("NIEN_KHOA"));
                lopList.add(mh);
            }
            return lopList;

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
