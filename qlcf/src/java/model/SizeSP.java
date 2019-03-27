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
public class SizeSP {
    private String maSize;
    private String tenSize;
    private float heSo;

    public SizeSP(String maSize, String tenSize, float heSo) {
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.heSo = heSo;
    }

    public SizeSP() {
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public float getHeSo() {
        return heSo;
    }

    public void setHeSo(float heSo) {
        this.heSo = heSo;
    }
    
}
