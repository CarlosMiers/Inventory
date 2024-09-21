/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.sucursal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class sucursalDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<sucursal> todos() throws SQLException {
        ArrayList sucursal = new ArrayList();
        con = new Conexion();
        st = con.conectar();
        String sql = "SELECT * "
                + "FROM sucursales "
                + "ORDER BY codigo ";
        try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sucursal sucursales = new sucursal();
                sucursales.setCodigo(rs.getInt("codigo"));
                sucursales.setNombre(rs.getString("nombre"));
                sucursal.add(sucursales);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("FALLA" + ex.getLocalizedMessage());
            st.close();
        }
        return sucursal;
    }

    public sucursal buscarId(int id) throws SQLException {

        sucursal sucursal = new sucursal();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();

        try {
            String sql = "select * "
                    + " from sucursales "
                    + " where sucursales.codigo = ? "
                    + " order by sucursales.codigo ";
            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    sucursal.setCodigo(rs.getInt("codigo"));
                    sucursal.setNombre(rs.getString("nombre"));
                    sucursal.setNombrefacturasuc(rs.getString("nombrefacturasuc"));
                    sucursal.setNombreremisionsuc(rs.getString("nombreremisionsuc"));
                    sucursal.setImpresorafacturasuc(rs.getString("impresorafacturasuc"));
                    sucursal.setImpresoraremisionsuc(rs.getString("impresoraremisionsuc"));
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("SUCURSAL--> " + ex.getLocalizedMessage());
        }
        st.close();
        conn.close();
        return sucursal;
    }

    public boolean GrabarConfiguracionImpresora(sucursal suc) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("UPDATE sucursales "
                + " SET nombrefacturasuc=?,nombreremisionsuc=?,"
                + "impresorafacturasuc=?,"
                + "impresoraremisionsuc=? WHERE codigo= " + suc.getCodigo());
        ps.setString(1, suc.getNombrefacturasuc());
        ps.setString(2, suc.getNombreremisionsuc());
        ps.setString(3, suc.getImpresorafacturasuc());
        ps.setString(4, suc.getImpresoraremisionsuc());
        System.out.println("PASE POR AQUI");
        int rowsUpdated = ps.executeUpdate();

        try {
            st.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Falla--> " + ex.getLocalizedMessage());
        }

        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    
       public sucursal insertarSucursal(sucursal ca) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO sucursales "
                + "(nombre,nombrefacturasuc,nombreremisionsuc,impresoraremisionsuc,"
                + "impresorafacturasuc) VALUES (?,?,?,?,?)");
        ps.setString(1, ca.getNombre());
        ps.setString(2, ca.getNombrefacturasuc());
        ps.setString(3, ca.getNombreremisionsuc());
        ps.setString(4, ca.getImpresoraremisionsuc());
        ps.setString(5, ca.getImpresorafacturasuc());
        ps.executeUpdate();
        st.close();
        ps.close();
        return ca;
    }

    public boolean actualizarSucursal(sucursal ca) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("UPDATE sucursales "
                + "SET nombre=?,nombrefacturasuc=?,"
                + "nombreremisionsuc=?,impresoraremisionsuc=?,"
                + "impresorafacturasuc=? WHERE codigo=" + ca.getCodigo());
        ps.setString(1, ca.getNombre());
        ps.setString(2, ca.getNombrefacturasuc());
        ps.setString(3, ca.getNombreremisionsuc());
        ps.setString(4, ca.getImpresoraremisionsuc());
        ps.setString(5, ca.getImpresorafacturasuc());
        int rowsUpdated = ps.executeUpdate();
        st.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarSucursal(int cod) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("DELETE FROM sucursales WHERE codigo=?");
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
