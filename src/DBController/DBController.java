/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBController;

import Class.HoaDon;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                float tongTien = rs.getInt("TongTien");
                
                HoaDon hoadon = new HoaDon(id,maKH,ngayLap,tongTien);
                list.add(hoadon);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    

    public static ArrayList<HoaDon> getHoaDon(String valueOf, String Year) {
         ArrayList<HoaDon> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement hd = conn.createStatement();
            ResultSet rs = hd.executeQuery("SELECT * FROM HoaDon"
                    + "WHERE MONTH(NgayLap)= month & YEAR(NgayLap)=year");
            while(rs.next()){
                String id = rs.getString("MaHD");
                String maKH = rs.getString("MaKH");
                String ngayLap = rs.getString("NgayLap");
                float tongTien = rs.getInt("TongTien");
                
                HoaDon hoadon = new HoaDon(id,maKH,ngayLap,tongTien);
                list.add(hoadon);
            }
        }catch (SQLException ex) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 

    
    
}
