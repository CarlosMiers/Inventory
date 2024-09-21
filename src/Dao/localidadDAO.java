/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Usuario
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Conexion.Conexion;
import Modelo.localidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Webmaster
 */
public class localidadDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<localidad> todos() throws SQLException {
        ArrayList lista = new ArrayList();
        con = new Conexion();
        st = con.conectar();
        String cSql = "select localidades.codigo,localidades.nombre "
                + " from localidades "
                + " order by localidades.codigo ";
        try (PreparedStatement ps = st.getConnection().prepareStatement(cSql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                localidad localidad = new localidad();
                localidad.setCodigo(rs.getInt("codigo"));
                localidad.setNombre(rs.getString("nombre"));
                lista.add(localidad);
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("--> todas las localidades " + ex.getLocalizedMessage());
            st.close();
        }
        return lista;
    }

    public localidad buscarLocalidad(int codlocalidad) throws SQLException {
        localidad localidad = new localidad();
        localidad.setCodigo(0);
        localidad.setNombre("");
        con = new Conexion();
        st = con.conectar();
        try {
            String cSql = "select localidades.codigo,localidades.nombre "
                    + " from localidades "
                    + " where localidades.codigo=? "
                    + " order by localidades.codigo ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(cSql)) {
                ps.setInt(1, codlocalidad);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    localidad.setCodigo(rs.getInt("codigo"));
                    localidad.setNombre(rs.getString("nombre"));
                }
                ps.close();
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println("-->DESCONOCE COLUMNA " + ex.getLocalizedMessage());
        }
        return localidad;
    }

    public localidad insertarlocalidad(localidad loca) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps= st.getConnection().prepareStatement("INSERT INTO localidades (nombre) VALUES (?)");
        ps.setString(1, loca.getNombre());
        ps.executeUpdate();
        st.close();
        ps.close();
        return loca;
    }

    public boolean actualizarlocalidad(localidad loca) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("UPDATE localidades SET nombre=? WHERE codigo=" + loca.getCodigo());
        ps.setString(1, loca.getNombre());
        
        int rowsUpdated = ps.executeUpdate();
        st.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean eliminarLocalidad(int cod) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("DELETE FROM localidades WHERE codigo=?");
        ps.setInt(1, cod);
        int rowsUpdated = ps.executeUpdate();
        st.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
