/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.TreeMap;

/**
 *
 * @author baotri1998
 */
public class CartBean {

    private TreeMap<SanPham, Integer> list;
    private long cartID;
    
    public CartBean() {
        list = new TreeMap<>();
        cartID = System.currentTimeMillis();
    }

    public CartBean(TreeMap<SanPham, Integer> list, long cartID) {
        this.list = list;
        this.cartID = cartID;
    }

    public TreeMap<SanPham, Integer> getList() {
        return list;
    }

    public void setList(TreeMap<SanPham, Integer> list) {
        this.list = list;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public void insertToCart(SanPham pr, int quantity) {
        boolean bln = list.containsKey(pr);
        if (bln) {
            int sl = list.get(pr);
            quantity += sl;
            list.put(pr, quantity);
        } else {
            list.put(pr, quantity);
        }
    }

    public void subToCart(SanPham pr, int quantity) {
        boolean bln = list.containsKey(pr);
        if (bln) {
            int sl = list.get(pr);
            quantity = sl - quantity;
            if (quantity <= 0) {
                list.remove(pr);
            } else {
                list.remove(pr);
                list.put(pr, quantity);
            }
        }
    }

    public void removeToCart(SanPham pr) {
        boolean bln = list.containsKey(pr);
        if (bln) {
            list.remove(pr);
        }
    }

}
