/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.usuario;
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
public class usuarioDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<usuario> todos() throws SQLException {
        ArrayList<usuario> lista = new ArrayList<usuario>();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        String sql = "SELECT idusuario,"
                + "descripcion,"
                + "loginacceso,"
                + "password,"
                + "id_tipo_usuario,"
                + "id_permisos,"
                + "id_interfaz "
                + " FROM gestor_usuarios "
                + " ORDER BY idusuario ";

        try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario u = new usuario();
                u.setIdusuario(rs.getInt("idusuario"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setLoginacceso(rs.getString("loginacceso"));
                u.setPassword(rs.getString("password"));
                u.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
                u.setId_permisos(rs.getInt("id_permisos"));
                u.setId_interfaz(rs.getInt("id_interfaz"));
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

    public usuario buscarId(int id) throws SQLException {
        usuario u = new usuario();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        try {
            String sql = "SELECT idusuario,"
                    + "descripcion,"
                    + "loginacceso,"
                    + "password,"
                    + "id_tipo_usuario,"
                    + "id_permisos,"
                    + "id_interfaz "
                    + " FROM gestor_usuarios "
                    + " WHERE idusuario=? "
                    + " ORDER BY idusuario ";
            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setIdusuario(rs.getInt("idusuario"));
                    u.setDescripcion(rs.getString("descripcion"));
                    u.setLoginacceso(rs.getString("loginacceso"));
                    u.setPassword(rs.getString("password"));
                    u.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
                    u.setId_permisos(rs.getInt("id_permisos"));
                    u.setId_interfaz(rs.getInt("id_interfaz"));
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

    public usuario buscarUsuario(String login, String pass) throws SQLException {
        usuario u = new usuario();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        try {
            String sql = "SELECT idusuario,"
                    + "descripcion,"
                    + "loginacceso,"
                    + "password,"
                    + "id_tipo_usuario,"
                    + "id_permisos,"
                    + "id_interfaz "
                    + " FROM gestor_usuarios "
                    + " WHERE loginacceso=? "
                    + " AND password=? "
                    + " ORDER BY idusuario ";
            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setString(1, login);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    u.setIdusuario(rs.getInt("idusuario"));
                    u.setDescripcion(rs.getString("descripcion"));
                    u.setLoginacceso(rs.getString("loginacceso"));
                    u.setPassword(rs.getString("password"));
                    u.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
                    u.setId_permisos(rs.getInt("id_permisos"));
                    u.setId_interfaz(rs.getInt("id_interfaz"));
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

    public usuario insertarUsuario(usuario u) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO gestor_usuarios "
                + " (descripcion,"
                + "loginacceso,"
                + "password,"
                + "id_tipo_usuario,"
                + "id_permisos,"
                + "id_interfaz)"
                + " VALUES (?,?,?,?,?,?)");
        ps.setString(1, u.getDescripcion());
        ps.setString(2, u.getLoginacceso());
        ps.setString(3, u.getPassword());
        ps.setInt(4, u.getId_tipo_usuario());
        ps.setInt(5, u.getId_permisos());
        ps.setInt(6, u.getId_interfaz());
        ps.executeUpdate();
        st.close();
        ps.close();
        conn.close();
        return u;
    }

    public boolean actualizarUsuarios(usuario u) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;
        Connection conn = st.getConnection();

        ps = st.getConnection().prepareStatement("UPDATE gestor_usuarios "
                + "SET descripcion=?,"
                + "loginacceso=?,"
                + "password=?,"
                + "id_tipo_usuario=?,"
                + "id_permisos=?,"
                + "id_interfaz=? "
                + " WHERE idusuario=" + u.getIdusuario());
        ps.setString(1, u.getDescripcion());
        ps.setString(2, u.getLoginacceso());
        ps.setString(3, u.getPassword());
        ps.setInt(4, u.getId_tipo_usuario());
        ps.setInt(5, u.getId_permisos());
        ps.setInt(6, u.getId_interfaz());
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

    public boolean eliminarUsuario(int cod) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("DELETE FROM gestor_usuarios WHERE idusuario=?");
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
