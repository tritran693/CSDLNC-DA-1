/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author trisu
 */
public class DBConnection {
     public static Connection getConnection() throws SQLException{
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
