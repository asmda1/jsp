/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author Kanbi
 */
public class CTPhieuNhap {
    private int maCTPhieuNhap;
    private PhieuNhap maPhieuNhap;
    private HangHoa maHangHoa;
    private float soLuong;

    public CTPhieuNhap() {
    }

    public CTPhieuNhap(int maCTPhieuNhap, PhieuNhap maPhieuNhap, HangHoa maHangHoa, float soLuong) {
        this.maCTPhieuNhap = maCTPhieuNhap;
        this.maPhieuNhap = maPhieuNhap;
        this.maHangHoa = maHangHoa;
        this.soLuong = soLuong;
    }

    

    public int getMaCTPhieuNhap() {
        return maCTPhieuNhap;
    }

    public void setMaCTPhieuNhap(int maCTPhieuNhap) {
        this.maCTPhieuNhap = maCTPhieuNhap;
    }

    public PhieuNhap getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(PhieuNhap maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public HangHoa getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(HangHoa maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    
    
    
}
