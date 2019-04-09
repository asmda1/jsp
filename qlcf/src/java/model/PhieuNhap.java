/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author baotri1998
 */
public class PhieuNhap {

    private String maPhieu;
    private NhaCungCap maNhaCungCap;
    private NguoiDung maNguoiDung;
    private Date ngayNhap;
    private double tongTien;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPhieu, NhaCungCap maNhaCungCap, NguoiDung maNguoiDung, Date ngayNhap, double tongTien) {
        this.maPhieu = maPhieu;
        this.maNhaCungCap = maNhaCungCap;
        this.maNguoiDung = maNguoiDung;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public NhaCungCap getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(NhaCungCap maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public NguoiDung getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(NguoiDung maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;

    }

}
