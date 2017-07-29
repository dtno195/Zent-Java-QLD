/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SinhVien;
import Util.SQLConnection;
import Util.Convert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class SinhVienDAO {

    public List<SinhVien> selectAll() {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM tbl_SINHVIEN");
            List<SinhVien> sinhVienList = new ArrayList<>();
            while (rs.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSinhVien(rs.getString("MA_SINH_VIEN"));
                sinhVien.setTenSinhVien(rs.getString("TEN_SINH_VIEN"));
                sinhVien.setGioiTinh(rs.getBoolean("GIOI_TINH"));
                sinhVien.setNgaySinh(rs.getDate("NGAY_SINH"));
                sinhVien.setQueQuan(rs.getString("QUE_QUAN"));
                sinhVien.setSDT(rs.getString("SDT"));
                sinhVien.setEmail(rs.getString("EMAIL"));
                sinhVien.setMaLop(rs.getString("MA_LOP"));

                sinhVienList.add(sinhVien);
            }
            return sinhVienList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(SinhVien sinhVien) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("INSERT INTO [tbl_SINHVIEN]\n"
                    + "           ([MA_SINH_VIEN]\n"
                    + "           ,[TEN_SINH_VIEN]\n"
                    + "           ,[GIOI_TINH]\n"
                    + "           ,[NGAY_SINH]\n"
                    + "           ,[QUE_QUAN]\n"
                    + "           ,[SDT]\n"
                    + "           ,[EMAIL]\n"
                    + "           ,[MA_LOP])\n"
                    + "     VALUES (?,?,?,?,?,?,?,?)");
            prs.setString(1, sinhVien.getMaSinhVien());
            prs.setString(2, sinhVien.getTenSinhVien());
            prs.setBoolean(3, sinhVien.getGioiTinh());
            prs.setDate(4, Convert.convertDate(sinhVien.getNgaySinh()));
            prs.setString(5, sinhVien.getQueQuan());
            prs.setString(6, sinhVien.getSDT());
            prs.setString(7, sinhVien.getEmail());
            prs.setString(8, sinhVien.getMaLop());

            return prs.execute();

            //boolean checkMaMH = SQLConnection.Kiem_Tra_Trung("tbl_SINHVIEN", "MA_MON_HOC", ip)
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(SinhVien sinhVien) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("UPDATE [tbl_SINHVIEN]\n"
                    + "   SET [TEN_SINH_VIEN] =? \n"
                    + "      ,[GIOI_TINH] =? \n"
                    + "      ,[NGAY_SINH] =? \n"
                    + "      ,[QUE_QUAN] =? \n"
                    + "      ,[SDT] =? \n"
                    + "      ,[EMAIL] =? \n"
                    + "      ,[MA_LOP] =? \n"
                    + " WHERE [MA_SINH_VIEN] =? ");

            prs.setString(1, sinhVien.getTenSinhVien());
            prs.setBoolean(2, sinhVien.getGioiTinh());
            prs.setDate(3, Convert.convertDate(sinhVien.getNgaySinh()));
            prs.setString(4, sinhVien.getQueQuan());
            prs.setString(5, sinhVien.getSDT());
            prs.setString(6, sinhVien.getEmail());
            prs.setString(7, sinhVien.getMaLop());
            prs.setString(8, sinhVien.getMaSinhVien());

            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(SinhVien sinhVien) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("DELETE FROM [tbl_SINHVIEN]\n"
                    + "      WHERE [MA_SINH_VIEN] =? ");
            prs.setString(1, sinhVien.getMaSinhVien());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<SinhVien> search(String input) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            String sql = "";
            if (input.equalsIgnoreCase("")) {
                sql = "select * from tbl_SINHVIEN";
            } else {
                sql = "select * from tbl_SINHVIEN where MA_SINH_VIEN like '%" + input + "%'\n"
                        + "OR TEN_SINH_VIEN LIKE '%" + input + "%'\n"
                        + "OR GIOI_TINH LIKE '%" + input + "%'\n"
                        + "OR NGAY_SINH LIKE '%" + input + "%'\n"
                        + "OR QUE_QUAN LIKE '%" + input + "%'\n"
                        + "OR SDT LIKE '%" + input + "%'\n"
                        + "OR EMAIL LIKE '%" + input + "%'\n"
                        + "OR MA_LOP LIKE '%" + input + "%'\n";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ResultSet rs = st.executeQuery(sql);
            List<SinhVien> sinhVienList = new ArrayList<>();
            while (rs.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSinhVien(rs.getString("MA_SINH_VIEN"));
                sinhVien.setTenSinhVien(rs.getString("TEN_SINH_VIEN"));
                sinhVien.setGioiTinh(rs.getBoolean("GIOI_TINH"));
                sinhVien.setNgaySinh(rs.getDate("NGAY_SINH"));
                sinhVien.setQueQuan(rs.getString("QUE_QUAN"));
                sinhVien.setSDT(rs.getString("SDT"));
                sinhVien.setEmail(rs.getString("EMAIL"));
                sinhVien.setMaLop(rs.getString("MA_LOP"));

                sinhVienList.add(sinhVien);
            }
            return sinhVienList;
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
