/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.localidad;
import Modelo.cliente;
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
public class clienteDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<cliente> todos() throws SQLException {
        ArrayList<cliente> lista = new ArrayList<cliente>();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        String sql = "SELECT codigo,"
                + "clientes.nombre,"
                + "clientes.ruc,"
                + "clientes.direccion,"
                + "clientes.telefono,"
                + "clientes.estado"
                + " FROM clientes "
                + " ORDER BY codigo ";

        try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente u = new cliente();
                u.setCodigo(rs.getInt("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setRuc(rs.getString("ruc"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getString("telefono"));
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

    public cliente buscarId(int id) throws SQLException {
        cliente u = new cliente();
        localidad loc = new localidad();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        try {
            String sql = "SELECT codigo,"
                    + "clientes.nombre,"
                    + "clientes.ruc,"
                    + "clientes.direccion,"
                    + "clientes.telefono,"
                    + "clientes.estado"
                    + " FROM clientes "
                    + " WHERE codigo=? "
                    + " ORDER BY codigo ";
            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setCodigo(rs.getInt("codigo"));
                    u.setNombre(rs.getString("nombre"));
                    u.setRuc(rs.getString("ruc"));
                    u.setDireccion(rs.getString("direccion"));
                    u.setTelefono(rs.getString("telefono"));
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

    public cliente insertarCliente(cliente u) throws SQLException {

        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO clientes "
                + "(nombre,"
                + "ruc,"
                + "telefono,"
                + "direccion,"
                + "estado)"
                + " VALUES (?,?,?,?,?)");
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getRuc());
        ps.setString(3, u.getTelefono());
        ps.setString(4, u.getDireccion());
        ps.setInt(5, u.getEstado());
        ps.executeUpdate();
        st.close();
        ps.close();
        conn.close();
        return u;
    }

    public boolean actualizarCliente(cliente u) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;
        Connection conn = st.getConnection();

        ps = st.getConnection().prepareStatement("UPDATE clientes "
                + " SET nombre=?,"
                + "ruc=?,"
                + "telefono=?,"
                + "direccion=?,"
                + "estado=? "
                + " WHERE codigo=" + u.getCodigo());
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getRuc());
        ps.setString(3, u.getTelefono());
        ps.setString(4, u.getDireccion());
        ps.setInt(5, u.getEstado());
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

    public boolean eliminarCliente(int cod) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("DELETE FROM clientes WHERE codigo=?");
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
