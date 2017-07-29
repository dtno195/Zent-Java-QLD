/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NguoiDung;
import Model.NguoiDung;
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
public class NguoiDungDAO {

    public List<NguoiDung> selectAll() {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM tbl_NGUOIDUNG");
            List<NguoiDung> nguoiDungList = new ArrayList<>();
            while (rs.next()) {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setTenDangNhap(rs.getString("TEN_DANG_NHAP"));
                nguoiDung.setMatKhau(rs.getString("MAT_KHAU"));
                nguoiDung.setTrangThai(rs.getString("TRANG_THAI"));
                nguoiDungList.add(nguoiDung);
            }
            return nguoiDungList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(NguoiDung nguoiDung) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("INSERT INTO [tbl_NGUOIDUNG]\n"
                    + "           ([TEN_DANG_NHAP]\n"
                    + "           ,[MAT_KHAU]\n"
                    + "           ,[TRANG_THAI])\n"
                    + "     VALUES (?,?,?) ");
            prs.setString(1, nguoiDung.getTenDangNhap());
            prs.setString(2, nguoiDung.getMatKhau());
            prs.setString(3, nguoiDung.getTrangThai());

            return prs.execute();

            //boolean checkMaMH = SQLConnection.Kiem_Tra_Trung("tbl_NGUOIDUNG", "TEN_DANG_NHAP", ip)
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(NguoiDung nguoiDung) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("UPDATE [tbl_NGUOIDUNG]\n"
                    + "   SET [MAT_KHAU] =? \n"
                    + "      ,[TRANG_THAI] =? \n"
                    + " WHERE [TEN_DANG_NHAP] =?");

            prs.setString(1, nguoiDung.getMatKhau());
            prs.setString(2, nguoiDung.getTrangThai());
            prs.setString(3, nguoiDung.getTenDangNhap());

            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(NguoiDung nguoiDung) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("DELETE FROM [tbl_NGUOIDUNG]\n"
                    + "      WHERE [TEN_DANG_NHAP] =? ");
            prs.setString(1, nguoiDung.getTenDangNhap());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public NguoiDung getTrangThaiID(String trangThai) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("SELECT * FROM tbl_NGUOIDUNG WHERE TRANG_THAI = ?");
            prs.setString(1, trangThai);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setTenDangNhap(rs.getString("TEN_DANG_NHAP"));
                nguoiDung.setMatKhau(rs.getString("MAT_KHAU"));
                nguoiDung.setTrangThai(rs.getString("TRANG_THAI"));
                return nguoiDung;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<NguoiDung> search(String input) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            String sql = "";
            if (input.equalsIgnoreCase("")) {
                sql = "select * from tbl_NGUOIDUNG";
            } else {
                sql = "select * from tbl_NGUOIDUNG where TEN_DANG_NHAP like '%" + input + "%'\n"
                        + "OR MAT_KHAU LIKE '%" + input + "%'\n"
                        + "OR TRANG_THAI LIKE '%" + input + "%'\n";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ResultSet rs = st.executeQuery(sql);
            List<NguoiDung> nguoiDungList = new ArrayList<>();
            while (rs.next()) {
                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setTenDangNhap(rs.getString("TEN_DANG_NHAP"));
                nguoiDung.setMatKhau(rs.getString("MAT_KHAU"));
                nguoiDung.setTrangThai(rs.getString("TRANG_THAI"));
                nguoiDungList.add(nguoiDung);
            }
            return nguoiDungList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean login(String taiKhoan, String matKhau) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("select COUNT(*) as NUMBER from tbl_NGUOIDUNG where TEN_DANG_NHAP = ? \n"
                    + "and MAT_KHAU = ?");
            prs.setString(1, taiKhoan);
            prs.setString(2, matKhau);
            ResultSet rs = prs.executeQuery();
            Integer count = 0;
            while (rs.next()) {
                count = rs.getInt("NUMBER");
            }
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
