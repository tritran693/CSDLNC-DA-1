/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import DBController.DBController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trisu
 */
public class DBConnection {
     public static Connection getConnection() throws SQLException, ClassNotFoundException{
    	 Connection conn = null;
         
         try {
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBH;user=sa;password=123456789"); 
         } catch (SQLException ex) {
             Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return conn;
     }
}
