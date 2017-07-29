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
public class MonHoc {

    private String maMonHoc;
    private String tenMonHoc;
    private Integer tinChi;
    private Float heSoGiuaKy;
    private Float heSoCuoiKy;

    public MonHoc() {
    }

    public MonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

   

    public MonHoc(String maMonHoc, String tenMonHoc) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
    }

    public MonHoc(String maMonHoc, String tenMonHoc, Integer tinChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.tinChi = tinChi;
    }

    public MonHoc(String tenMonHoc, Integer tinChi, Float heSoGiuaKy, Float heSoCuoiKy) {
        this.tenMonHoc = tenMonHoc;
        this.tinChi = tinChi;
        this.heSoGiuaKy = heSoGiuaKy;
        this.heSoCuoiKy = heSoCuoiKy;
    }

    public MonHoc(String maMonHoc, String tenMonHoc, Integer tinChi, Float heSoGiuaKy, Float heSoCuoiKy) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.tinChi = tinChi;
        this.heSoGiuaKy = heSoGiuaKy;
        this.heSoCuoiKy = heSoCuoiKy;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getTinChi() {
        return tinChi;
    }

    public void setTinChi(Integer tinChi) {
        this.tinChi = tinChi;
    }

    public Float getHeSoGiuaKy() {
        return heSoGiuaKy;
    }

    public void setHeSoGiuaKy(Float heSoGiuaKy) {
        this.heSoGiuaKy = heSoGiuaKy;
    }

    public Float getHeSoCuoiKy() {
        return heSoCuoiKy;
    }

    public void setHeSoCuoiKy(Float heSoCuoiKy) {
        this.heSoCuoiKy = heSoCuoiKy;
    }

    @Override
    public boolean equals(Object obj) {
        MonHoc monHoc = (MonHoc) obj;
        if (monHoc != null && this.getMaMonHoc() != null && monHoc.getMaMonHoc() != null && this.getMaMonHoc().equals(monHoc.getMaMonHoc())) {
            return true;
        }
        return false;

    }

}
