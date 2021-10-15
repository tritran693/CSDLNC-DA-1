/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Date;

/**
 *
 * @author trisu
 */
public class HoaDon {
    private String id;
    private String maKH;
    private Date ngayLap;
        
    private int tongTien;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDon(String id, String maKH, Date ngayLap, int tongTien) {
        this.id = id;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }
}
