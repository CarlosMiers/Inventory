package Conexion;

import clases.Config;
import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    public static Statement conectar() {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //   Class.forName("com.mysql.cj.jdbc.Driver"); 8.0
            //conn = DriverManager.getConnection("jdbc:mysql://" + Config.cIpServer.toString() + "/inventory", "root", "1541947");
            //conn = DriverManager.getConnection("jdbc:mysql://192.168.0.5/inventory", "root", "1541947");            
            conn = DriverManager.getConnection("jdbc:mysql://Localhost/inventory", "root", "1541947");
            if (conn != null) {
                //JOptionPane.showMessageDialog(null, "Hemos conectado " + url + " ... Ok");
                st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Hubo un problema al conectar con la base ");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return st;
    }

}
