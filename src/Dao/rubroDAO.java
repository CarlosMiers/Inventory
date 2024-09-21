/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.rubro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class rubroDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<rubro> todos() throws SQLException {
        ArrayList<rubro> lista = new ArrayList<rubro>();
        con = new Conexion();
        st = con.conectar();

        String sql = "SELECT rubros.codigo,rubros.nombre "
                + " FROM rubros "
                + " ORDER BY rubros.codigo ";
        try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rubro r = new rubro();
                r.setCodigo(rs.getInt("codigo"));
                r.setNombre(rs.getString("nombre"));
                lista.add(r);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
            st.close();
        }
        return lista;
    }

    public rubro buscarId(int id) throws SQLException {
        rubro rubro = new rubro();
        rubro.setCodigo(0);
        rubro.setNombre("");
        con = new Conexion();
        st = con.conectar();
        try {
            String sql = "select * "
                    + "from rubros "
                    + "where rubros.codigo = ? "
                    + "order by rubros.codigo ";
            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    rubro.setCodigo(rs.getInt("codigo"));
                    rubro.setNombre(rs.getString("nombre"));
                }
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        return rubro;
    }

}
