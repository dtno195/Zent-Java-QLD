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
public class Lop {

    private String maLop;
    private String tenLop;
    private String tenKhoa;
    private String nienKhoa;

    public Lop() {
    }

    public Lop(String maLop) {
        this.maLop = maLop;
    }

    public Lop(String tenLop, String tenKhoa, String nienKhoa) {
        this.tenLop = tenLop;
        this.tenKhoa = tenKhoa;
        this.nienKhoa = nienKhoa;
    }

    public Lop(String maLop, String tenLop, String tenKhoa, String nienKhoa) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.tenKhoa = tenKhoa;
        this.nienKhoa = nienKhoa;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    @Override
    public boolean equals(Object obj) {
        Lop lop = (Lop) obj;
        if (lop != null && this.getMaLop() != null && lop.getMaLop() != null && this.getMaLop().equalsIgnoreCase(lop.getMaLop())) {
            return true;
        }
        return false;
    }

}
