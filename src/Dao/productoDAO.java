/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.rubro;
import Modelo.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SERVIDOR
 */
public class productoDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<producto> todos() throws SQLException {
        ArrayList<producto> lista = new ArrayList<producto>();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        String sql = "SELECT productos.codigo,"
                + "productos.codigointerno,"
                + "productos.nombre,"
                + "productos.costo,"
                + "productos.minorista,"
                + "productos.mayorista,"
                + "productos.stock,"
                + "productos.estado,"
                + "productos.rubro,"
                + "rubros.nombre as nombrerubro "
                + " FROM productos "
                + " LEFT JOIN rubros "
                + " ON rubros.codigo=productos.rubro "
                + " ORDER BY productos.codigo ";

        try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto u = new producto();
                rubro loc = new rubro();
                u.setRubro(loc);
                u.getRubro().setCodigo(rs.getInt("rubro"));
                u.getRubro().setNombre(rs.getString("nombrerubro"));
                u.setCodigo(rs.getInt("codigo"));
                u.setCodigointerno(rs.getString("codigointerno"));
                u.setNombre(rs.getString("nombre"));
                u.setCosto(rs.getDouble("costo"));
                u.setMayorista(rs.getDouble("mayorista"));
                u.setMinorista(rs.getDouble("minorista"));
                u.setStock(rs.getDouble("stock"));
                u.setEstado(rs.getInt("estado"));
                lista.add(u);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        conn.close();
        return lista;
    }

    public producto buscarId(int id) throws SQLException {
        producto u = new producto();
        rubro loc = new rubro();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        try {
            String sql = "SELECT productos.codigo,"
                    + "productos.codigointerno,"
                    + "productos.nombre,"
                    + "productos.costo,"
                    + "productos.minorista,"
                    + "productos.mayorista,"
                    + "productos.stock,"
                    + "productos.estado,"
                    + "productos.rubro,"
                    + "rubros.nombre as nombrerubro "
                    + " FROM productos "
                    + " LEFT JOIN rubros "
                    + " ON rubros.codigo=productos.rubro "
                    + " WHERE productos.codigo=? "
                    + " ORDER BY productos.codigo ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setRubro(loc);
                    u.getRubro().setCodigo(rs.getInt("rubro"));
                    u.getRubro().setNombre(rs.getString("nombrerubro"));
                    u.setCodigo(rs.getInt("codigo"));
                    u.setCodigointerno(rs.getString("codigointerno"));
                    u.setNombre(rs.getString("nombre"));
                    u.setCosto(rs.getDouble("costo"));
                    u.setMayorista(rs.getDouble("mayorista"));
                    u.setMinorista(rs.getDouble("minorista"));
                    u.setStock(rs.getDouble("stock"));
                    u.setEstado(rs.getInt("estado"));
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        conn.close();
        return u;
    }

    public producto insertarProducto(producto u) throws SQLException {

        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO productos "
                + "(nombre,"
                + "codigointerno,"
                + "costo,"
                + "mayorista,"
                + "minorista,"
                + "rubro,"
                + "estado)"
                + " VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getCodigointerno());
        ps.setDouble(3, u.getCosto());
        ps.setDouble(4, u.getMayorista());
        ps.setDouble(5, u.getMinorista());
        ps.setInt(6, u.getRubro().getCodigo());
        ps.setInt(7, u.getEstado());
        ps.executeUpdate();
        st.close();
        ps.close();
        conn.close();
        return u;
    }

    public boolean actualizarProducto(producto u) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;
        Connection conn = st.getConnection();

        ps = st.getConnection().prepareStatement("UPDATE productos "
                + " SET nombre=?,"
                + "codigointerno=?,"
                + "costo=?,"
                + "mayorista=?,"
                + "minorista=?,"
                + "rubro=?,"
                + "estado=? WHERE codigo=" + u.getCodigo());
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getCodigointerno());
        ps.setDouble(3, u.getCosto());
        ps.setDouble(4, u.getMayorista());
        ps.setDouble(5, u.getMinorista());
        ps.setInt(6, u.getRubro().getCodigo());
        ps.setInt(7, u.getEstado());
        int rowsUpdated = ps.executeUpdate();
        st.close();
        ps.close();
        conn.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarProducto(int cod) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("DELETE FROM productos WHERE codigo=?");
        ps.setInt(1, cod);
        int rowsUpdated = ps.executeUpdate();
        st.close();
        ps.close();
        conn.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

}
