/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class NguoiDung {

    private String tenDangNhap;
    private String matKhau;
    private String trangThai;

    public NguoiDung() {
    }

    public NguoiDung(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public NguoiDung(String matKhau, String trangThai) {
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public NguoiDung(String tenDangNhap, String matKhau, String trangThai) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object obj) {
        NguoiDung nguoiDung = (NguoiDung) obj;
        if (nguoiDung != null && this.getTrangThai() != null && nguoiDung.getTrangThai() != null && this.getTrangThai().equalsIgnoreCase(nguoiDung.getTrangThai())) {
            return true;
        }
        return false;

    }

}
