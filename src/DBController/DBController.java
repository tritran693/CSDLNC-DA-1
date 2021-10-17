/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;

import Class.DoanhThuThang;
import Class.HoaDon;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author trisu
 */
public class DBController {
    
    public static boolean insert(String maHD, String maKH, String date){
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO HoaDon VALUES(?,?,?,0)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, maHD);
            preparedStatement.setString(2, maKH);
            preparedStatement.setString(3, date);
            
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public static ArrayList<HoaDon> getAllHoaDon() throws SQLException{
        ArrayList<HoaDon> list = new ArrayList<>();
        
        Connection conn = DBConnection.getConnection();
        try{
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("SELECT * FROM HoaDon");
            while(rs.next()){
                String id = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String ngayLap = rs.getString("NgayLap");
                float tongTien = rs.getFloat("TongTien");
                
                HoaDon hoadon = new HoaDon(id,maKH,ngayLap,tongTien);
                list.add(hoadon);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    public static ArrayList<DoanhThuThang> Revenu_month_list(String year) {
        ArrayList<DoanhThuThang> list = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            Statement hd = conn.createStatement();
            String query = "select MONTH(hd.NgayLap) as thang, sum(hd.TongTien) as tong from HoaDon hd where YEAR(hd.NgayLap) = ? group by MONTH(hd.NgayLap) order by MONTH(hd.NgayLap)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, year);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String month = rs.getString("thang");
                Double money = rs.getDouble("tong");
                DecimalFormat dc = new DecimalFormat("0.00");
                String money_String = dc.format(money);
                DoanhThuThang dt = new DoanhThuThang(month, money_String);
                list.add(dt);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 

    
    
}
