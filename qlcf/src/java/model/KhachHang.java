/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author h.Phong
 */
public class KhachHang implements Serializable{
  private  String makh,tenKh,email,dienThoai,diaChi, matKhau;
  private  boolean trangThai;
  private  int diemThuong;

    public KhachHang(String makh, String tenKh, String email, String dienThoai, String diaChi, String matKhau, boolean trangThai, int diemThuong) {
        this.makh = makh;
        this.tenKh = tenKh;
        this.email = email;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.diemThuong = diemThuong;
    }


    public KhachHang() {
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(int diemThuong) {
        this.diemThuong = diemThuong;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
    
    
    
}
