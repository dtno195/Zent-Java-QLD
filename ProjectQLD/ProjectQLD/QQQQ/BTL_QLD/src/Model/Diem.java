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
public class Diem {

    private String maSinhVien;
    private String maMonHoc;
    private Float diemGiuaKy;
    private Float diemCuoiKy;
    private Float diemTongKet;

    public Diem() {
    }

    public Diem(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public Diem(Float diemGiuaKy, Float diemCuoiKy) {
        this.diemGiuaKy = diemGiuaKy;
        this.diemCuoiKy = diemCuoiKy;
    }

    public Diem(String maSinhVien, String maMonHoc, Float diemGiuaKy, Float diemCuoiKy, Float diemTongKet) {
        this.maSinhVien = maSinhVien;
        this.maMonHoc = maMonHoc;
        this.diemGiuaKy = diemGiuaKy;
        this.diemCuoiKy = diemCuoiKy;
        this.diemTongKet = diemTongKet;
    }
    

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public Float getDiemGiuaKy() {
        return diemGiuaKy;
    }

    public void setDiemGiuaKy(Float diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }

    public Float getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(Float diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public Float getDiemTongKet() {
        return diemTongKet;
    }

    public void setDiemTongKet(Float diemTongKet) {
        this.diemTongKet = diemTongKet;
    }

    @Override
    public boolean equals(Object obj) {
//        NguoiDung nguoiDung = (NguoiDung) obj;
//        if (nguoiDung != null && this.getTrangThai() != null && nguoiDung.getTrangThai() != null && this.getTrangThai().equalsIgnoreCase(nguoiDung.getTrangThai())) {
//            return true;
//        }
//        return false;
        Diem diem = (Diem) obj;
        if (diem != null && this.getMaMonHoc() != null && diem.getMaMonHoc() != null && this.getMaMonHoc().equalsIgnoreCase(diem.getMaMonHoc())){
            return true;
        }
        return false;
    }

}
