/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author baotri1998
 */
/*Ham tao Class CTHoaDon*/
public class CTHoaDon {

    private int id;
    private HoaDon maHoaDon;
    private SanPham maSanPham;
    private Extra extra;
    private int soLuong;
    private SizeSP sizeSP;
    double Tongtien;
    public CTHoaDon() {
 }

    public CTHoaDon(int id, HoaDon maHoaDon, SanPham maSanPham,SizeSP sizeSP, Extra extra, int soLuong) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.extra = extra;
        this.soLuong = soLuong;
        this.sizeSP = sizeSP;
    }
/*Phuong thuc getId*/
    public int getId() {
        return id;
    }
/*Phuong thuc setId*/
    public void setId(int id) {
        this.id = id;
    }
/*Phuong thuc getMaHoaDon*/
    public HoaDon getMaHoaDon() {
        return maHoaDon;
    }
/*Phuong thuc setMaHoaDon*/
    public void setMaHoaDon(HoaDon maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
/*Phuong thuc getMaSanPham*/
    public SanPham getMaSanPham() {
        return maSanPham;
    }
/*Phuong thuc setMaSanPham*/
    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }
/*Phuong thuc getExtra*/
    public Extra getExtra() {
        return extra;
    }
/*Phuong thuc setExtra*/
    public void setExtra(Extra extra) {
        this.extra = extra;
    }
/*Phuong thuc getSoLong*/
    public int getSoLuong() {
        return soLuong;
    }
/*Phuong thuc setSoLuong*/
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
/*Phuong thuc getSizeSP*/
    public SizeSP getSizeSP() {
        return sizeSP;
    }
/*Phuong thuc setSizeSP*/
    public void setSizeSP(SizeSP sizeSP) {
        this.sizeSP = sizeSP;
    }
 

}
