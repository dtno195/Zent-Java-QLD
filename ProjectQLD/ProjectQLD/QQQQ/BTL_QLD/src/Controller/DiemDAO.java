/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Diem;
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
 * @author Admin
 */
public class DiemDAO {

    public List<Diem> selectAll() {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM tbl_DIEM");
            List<Diem> diemList = new ArrayList<>();
            while (rs.next()) {
                Diem diem = new Diem();
                diem.setMaSinhVien(rs.getString("MA_SINH_VIEN"));
                diem.setMaMonHoc(rs.getString("MA_MON_HOC"));
                diem.setDiemGiuaKy(rs.getFloat("DIEM_GIUA_KY"));
                diem.setDiemCuoiKy(rs.getFloat("DIEM_CUOI_KY"));
                diem.setDiemTongKet(rs.getFloat("DIEM_TONG_KET"));
                diemList.add(diem);
            }
            return diemList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean insert(Diem diem) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("INSERT INTO [tbl_DIEM]\n"
                    + "           ([MA_SINH_VIEN]\n"
                    + "           ,[MA_MON_HOC]\n"
                    + "           ,[DIEM_GIUA_KY]\n"
                    + "           ,[DIEM_CUOI_KY]\n"
                    + "           ,[DIEM_TONG_KET])\n"
                    + "     VALUES (?,?,?,?,?)");
            prs.setString(1, diem.getMaSinhVien());
            prs.setString(2, diem.getMaMonHoc());
            prs.setFloat(3, diem.getDiemGiuaKy());
            prs.setFloat(4, diem.getDiemCuoiKy());
            prs.setFloat(5, diem.getDiemTongKet());

            return prs.execute();

            //boolean checkMaMH = SQLConnection.Kiem_Tra_Trung("tbl_DIEM", "MA_MON_HOC", ip)
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean update(Diem diem) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("UPDATE [tbl_DIEM]\n"
                    + "   SET \n"
                    + "      [DIEM_GIUA_KY] = ?\n"
                    + "      ,[DIEM_CUOI_KY] = ?\n"
                    + "      ,[DIEM_TONG_KET] = ?\n"
                    + " WHERE [MA_MON_HOC] = ? AND [MA_SINH_VIEN] = ?");
            prs.setString(1, diem.getMaSinhVien());

            prs.setFloat(2, diem.getDiemGiuaKy());
            prs.setFloat(3, diem.getDiemCuoiKy());
            prs.setFloat(4, diem.getDiemTongKet());
            prs.setString(5, diem.getMaMonHoc());

            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean delete(Diem diem) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("DELETE FROM [tbl_DIEM]\n"
                    + "      WHERE [MA_MON_HOC] = ?  ");
            prs.setString(1, diem.getMaMonHoc());
            return prs.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Diem getMaMonHocID(String maMonHoc) {
        Connection conn = null;
        try {

            conn = SQLConnection.getConnection();
            PreparedStatement prs = conn.prepareStatement("SELECT * FROM tbl_DIEM WHERE MA_MON_HOC =?");
            prs.setString(1, maMonHoc);
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                Diem diem = new Diem();
                diem.setMaSinhVien(rs.getString("MA_SINH_VIEN"));
                diem.setMaMonHoc(rs.getString("MA_MON_HOC"));
                diem.setDiemGiuaKy(rs.getFloat("DIEM_GIUA_KY"));
                diem.setDiemCuoiKy(rs.getFloat("DIEM_CUOI_KY"));
                diem.setDiemTongKet(rs.getFloat("DIEM_TONG_KET"));
                return diem;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Diem> search(String input) {
        Connection conn = null;
        try {
            conn = SQLConnection.getConnection();
            String sql = "";
           if (input.equalsIgnoreCase("")) {
                sql = "select * from tbl_DIEM";
            } else {
                sql = "select * from tbl_DIEM where MA_SINH_VIEN like '%" + input + "%'\n"
                        + "OR MA_MON_HOC LIKE '%" + input + "%'\n"
                        + "OR DIEM_GIUA_KY LIKE '%" + input + "%'\n"
                        + "OR DIEM_CUOI_KY LIKE '%" + input + "%'\n"
                        + "OR DIEM_TONG_KET LIKE '%" + input + "%'\n";
            }

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //ResultSet rs = st.executeQuery(sql);
            List<Diem> diemList = new ArrayList<>();
            while (rs.next()) {
                Diem diem = new Diem();
                diem.setMaSinhVien(rs.getString("MA_SINH_VIEN"));
                diem.setMaMonHoc(rs.getString("MA_MON_HOC"));
                diem.setDiemGiuaKy(rs.getFloat("DIEM_GIUA_KY"));
                diem.setDiemCuoiKy(rs.getFloat("DIEM_CUOI_KY"));
                diem.setDiemTongKet(rs.getFloat("DIEM_TONG_KET"));
                diemList.add(diem);
            }
            return diemList;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
