/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author baotri1998
 */
public class SanPham implements Comparable<SanPham> {

    private String maSanPham;
    private LoaiSanPham maLoaiSanPham;
    private String tenSp;
    private double giaBan;
    private boolean trangThai;
    private String hinhAnh;
    private SizeSP sizeSP;

    public SanPham(String maSanPham, LoaiSanPham maLoaiSanPham, String tenSp, double giaBan, boolean trangThai, String hinhAnh) {
        this.maSanPham = maSanPham;
        this.maLoaiSanPham = maLoaiSanPham;

        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    public SizeSP getSizeSP() {
        return sizeSP;
    }

    public void setSizeSP(SizeSP sizeSP) {
        this.sizeSP = sizeSP;
    }

    public SanPham() {
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public LoaiSanPham getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(LoaiSanPham maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public int compareTo(SanPham t) {
        return this.getMaSanPham().compareTo(t.getMaSanPham());
    }

}
