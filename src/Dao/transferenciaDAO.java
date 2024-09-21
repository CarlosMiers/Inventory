/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.cliente;
import Modelo.sucursal;
import Modelo.transferencia;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class transferenciaDAO {

    Conexion con = null;
    Statement st = null;

    public ArrayList<transferencia> MostrarxFechaTransferencia(Date fechaini, Date fechafin) throws SQLException {
        ArrayList<transferencia> lista = new ArrayList<transferencia>();
        con = new Conexion();
        st = con.conectar();
        try {

            String sql = "SELECT transferencias.idtransferencia,transferencias.numero,transferencias.fecha,"
                    + "transferencias.origen,transferencias.destino, "
                    + "transferencias.cierre,transferencias.horagrabado, "
                    + "(SELECT nombre FROM sucursales WHERE origen=sucursales.codigo) nombreorigen, "
                    + "(SELECT nombre FROM sucursales WHERE destino=sucursales.codigo) nombredestino "
                    + "FROM transferencias "
                    + " WHERE transferencias.fecha between ? AND ? "
                    + " AND transferencias.cliente=0 "
                    + " ORDER BY transferencias.numero ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setDate(1, fechaini);
                ps.setDate(2, fechafin);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    transferencia tr = new transferencia();
                    sucursal sucursal = new sucursal();
                    tr.setNumero(rs.getInt("numero"));
                    tr.setFecha(rs.getDate("fecha"));
                    tr.setOrigen(rs.getInt("origen"));
                    tr.setCierre(rs.getInt("cierre"));
                    tr.setHoragrabado(rs.getTime("horagrabado"));
                    tr.setIdtransferencia(rs.getString("idtransferencia"));
                    tr.setNumero(rs.getInt("numero"));
                    tr.setDestino(rs.getInt("destino"));
                    tr.setNombredestino(rs.getString("nombredestino"));
                    tr.setNombreorigen(rs.getString("nombreorigen"));
                    lista.add(tr);
                }
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        return lista;
    }


    public ArrayList<transferencia> MostrarxFechaReserva(Date fechaini, Date fechafin) throws SQLException {
        ArrayList<transferencia> lista = new ArrayList<transferencia>();
        con = new Conexion();
        st = con.conectar();
        try {

            String sql = "SELECT transferencias.idtransferencia,transferencias.numero,transferencias.fecha,"
                    + "transferencias.origen,transferencias.destino, "
                    + "transferencias.cierre,transferencias.horagrabado, "
                    + "(SELECT nombre FROM sucursales WHERE origen=sucursales.codigo) nombreorigen, "
                    + "(SELECT nombre FROM sucursales WHERE destino=sucursales.codigo) nombredestino "
                    + "FROM transferencias "
                    + " WHERE transferencias.fecha between ? AND ? "
                    + " AND transferencias.cliente<>0 "
                    + " ORDER BY transferencias.numero ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setDate(1, fechaini);
                ps.setDate(2, fechafin);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    transferencia tr = new transferencia();
                    sucursal sucursal = new sucursal();
                    tr.setNumero(rs.getInt("numero"));
                    tr.setFecha(rs.getDate("fecha"));
                    tr.setOrigen(rs.getInt("origen"));
                    tr.setCierre(rs.getInt("cierre"));
                    tr.setHoragrabado(rs.getTime("horagrabado"));
                    tr.setIdtransferencia(rs.getString("idtransferencia"));
                    tr.setNumero(rs.getInt("numero"));
                    tr.setDestino(rs.getInt("destino"));
                    tr.setNombredestino(rs.getString("nombredestino"));
                    tr.setNombreorigen(rs.getString("nombreorigen"));
                    lista.add(tr);
                }
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        return lista;
    }


    public transferencia buscarString(String id) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        transferencia tr = new transferencia();
        try {
            String sql = "SELECT transferencias.idtransferencia,transferencias.numero,transferencias.fecha,"
                    + "transferencias.origen,transferencias.destino,transferencias.horagrabado,"
                    + "transferencias.cierre,"
                    + "(SELECT nombre FROM sucursales WHERE origen=sucursales.codigo) nombreorigen, "
                    + "(SELECT nombre FROM sucursales WHERE destino=sucursales.codigo) nombredestino "
                    + " FROM transferencias "
                    +" WHERE transferencias.idtransferencia=?";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    sucursal sucursal = new sucursal();
                    tr.setNumero(rs.getInt("numero"));
                    tr.setFecha(rs.getDate("fecha"));
                    tr.setCierre(rs.getInt("cierre"));
                    tr.setHoragrabado(rs.getTime("horagrabado"));
                    tr.setIdtransferencia(rs.getString("idtransferencia"));
                    tr.setNumero(rs.getInt("numero"));
                    tr.setDestino(rs.getInt("destino"));
                    tr.setNombredestino(rs.getString("nombredestino"));
                    tr.setOrigen(rs.getInt("origen"));
                    tr.setNombreorigen(rs.getString("nombreorigen"));
                }
                ps.close();
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        return tr;
    }

    public transferencia buscarStringReserva(String id) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        transferencia tr = new transferencia();
        try {
            String sql = "SELECT transferencias.idtransferencia,transferencias.numero,transferencias.fecha,"
                    + "transferencias.origen,transferencias.destino,transferencias.horagrabado,"
                    + "transferencias.cierre,transferencias.fechaentrega,"
                    + "(SELECT nombre FROM sucursales WHERE origen=sucursales.codigo) nombreorigen, "
                    + "(SELECT nombre FROM sucursales WHERE destino=sucursales.codigo) nombredestino, "
                    + "transferencias.cliente,clientes.nombre AS nombrecliente,transferencias.observacion "
                    + " FROM transferencias "
                    + " LEFT JOIN clientes "
                    + " ON clientes.codigo=transferencias.cliente "
                    +" WHERE transferencias.idtransferencia=?";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    sucursal sucursal = new sucursal();
                    tr.setNumero(rs.getInt("numero"));
                    tr.setFecha(rs.getDate("fecha"));
                    tr.setFechaentrega(rs.getDate("fechaentrega"));
                    tr.setCierre(rs.getInt("cierre"));
                    tr.setHoragrabado(rs.getTime("horagrabado"));
                    tr.setIdtransferencia(rs.getString("idtransferencia"));
                    tr.setNumero(rs.getInt("numero"));
                    tr.setDestino(rs.getInt("destino"));
                    tr.setNombredestino(rs.getString("nombredestino"));
                    tr.setOrigen(rs.getInt("origen"));
                    tr.setNombreorigen(rs.getString("nombreorigen"));
                    tr.setCliente(rs.getInt("cliente"));
                    tr.setNombrecliente(rs.getString("nombrecliente"));
                    tr.setObservacion(rs.getString("observacion"));
                }
                ps.close();
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        return tr;
    }



    public transferencia insertarmercaderia(transferencia ocr, String detalle) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        boolean guardado = false;
        int id = 0;
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO transferencias (idtransferencia,fecha,origen,destino) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, ocr.getIdtransferencia());
        ps.setDate(2, ocr.getFecha());
        ps.setInt(3, ocr.getOrigen());
        ps.setInt(4, ocr.getDestino());
        ps.executeUpdate();
        ResultSet keyset = ps.getGeneratedKeys();
        if (keyset.next()) {
            id = keyset.getInt(1);
            guardado = guardarDetalle(ocr.getIdtransferencia(), detalle, con);
        }
        st.close();
        ps.close();
        return ocr;
    }

    public boolean actualizarSalida(transferencia aj, String detalle) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;
        boolean guardado = false;
        int id = 0;

        ps = st.getConnection().prepareStatement("UPDATE transferencias SET fecha=?,origen=?,destino=? WHERE idtransferencia='" + aj.getIdtransferencia() + "'");
        ps.setDate(1, aj.getFecha());
        ps.setInt(2, aj.getOrigen());
        ps.setInt(3, aj.getDestino());
        int rowsUpdated = ps.executeUpdate();
        guardado = guardarDetalle(aj.getIdtransferencia(), detalle, con);
        st.close();
        ps.close();
        if (guardado) {
            return true;
        } else {
            return false;
        }
    }

    public boolean guardarDetalle(String id, String detalle, Conexion conexion) throws SQLException {
     
        boolean guardado = true;
        Connection conn = st.getConnection();
        conn.setAutoCommit(false);

        PreparedStatement psdetalle = null;
        psdetalle = st.getConnection().prepareStatement("DELETE FROM detalle_transferencias WHERE dreferencia=?");
        psdetalle.setString(1, id);
        int rowsUpdated = psdetalle.executeUpdate();
        
        try {
            JsonParser parser = new JsonParser();
            JsonElement datos = parser.parse(detalle);
            JsonArray array = datos.getAsJsonArray();
            java.util.Iterator<JsonElement> iter = array.iterator();
            while (iter.hasNext()) {
                JsonElement entrada = iter.next();
                JsonObject obj = entrada.getAsJsonObject();
                try {
                    String sql = "insert into detalle_transferencias("
                            + "dreferencia,"
                            + "producto,"
                            + "cantidad,"
                            + "costo,"
                            + "suc_salida,"
                            + "suc_entrada"
                            + ") "
                            + "values(?,?,?,?,?,?)";
                    try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                        ps.setString(1, obj.get("dreferencia").getAsString());
                        ps.setString(2, obj.get("producto").getAsString());
                        ps.setString(3, obj.get("cantidad").getAsString());
                        ps.setString(4, obj.get("costo").getAsString());
                        ps.setString(5, obj.get("suc_salida").getAsString());
                        ps.setString(6, obj.get("suc_entrada").getAsString());
                        int cr = ps.executeUpdate();
                        if (cr <= 0) {
                            guardado = false;
                            break;
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("--->" + ex.getLocalizedMessage());
                    conn.rollback();
                    guardado = false;
                    return guardado;
                }
            }

            if (guardado) {
                try {
                    conn.commit();
                } catch (SQLException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }
            } else {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex.getLocalizedMessage());
                }
            }
        } catch (Exception ex2) {
            ex2.printStackTrace();
            guardado = false;
        }
        st.close();
        conn.close();
        return guardado;
    }

    public boolean borrarAjustes(String referencia) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("DELETE FROM transferencias WHERE idtransferencia=?");
        ps.setString(1, referencia);
        int rowsUpdated = ps.executeUpdate();
        st.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    
    
    public transferencia insertarReserva(transferencia ocr, String detalle) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        boolean guardado = false;
        int id = 0;
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO transferencias (idtransferencia,"
                + "fecha,origen,destino,cliente,fechaentrega,observacion) VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, ocr.getIdtransferencia());
        ps.setDate(2, ocr.getFecha());
        ps.setInt(3, ocr.getOrigen());
        ps.setInt(4, ocr.getDestino());
        ps.setInt(5, ocr.getCliente());
        ps.setDate(6, ocr.getFechaentrega());
        ps.setString(7,ocr.getObservacion());
        
        ps.executeUpdate();
        ResultSet keyset = ps.getGeneratedKeys();
        if (keyset.next()) {
            id = keyset.getInt(1);
            guardado = guardarDetalle(ocr.getIdtransferencia(), detalle, con);
        }
        st.close();
        ps.close();
        return ocr;
    }

    public boolean actualizarReserva(transferencia aj, String detalle) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        PreparedStatement ps = null;
        boolean guardado = false;
        int id = 0;

        ps = st.getConnection().prepareStatement("UPDATE transferencias SET fecha=?,"
                + "origen=?,destino=?,cliente=?,fechaentrega=?,observacion=? WHERE idtransferencia='" + aj.getIdtransferencia() + "'");
        ps.setDate(1, aj.getFecha());
        ps.setInt(2, aj.getOrigen());
        ps.setInt(3, aj.getDestino());
        ps.setInt(4, aj.getCliente());
        ps.setDate(5, aj.getFechaentrega());
        ps.setString(6, aj.getObservacion());

        int rowsUpdated = ps.executeUpdate();
        guardado = guardarDetalle(aj.getIdtransferencia(), detalle, con);
        st.close();
        ps.close();
        if (guardado) {
            return true;
        } else {
            return false;
        }
    }

    
    public ArrayList<transferencia> MostrarReservaPendiente() throws SQLException {
        ArrayList<transferencia> lista = new ArrayList<transferencia>();
        con = new Conexion();
        st = con.conectar();
        try {

            String sql = "SELECT transferencias.idtransferencia,transferencias.numero,transferencias.fecha,"
                    + "transferencias.origen,transferencias.destino, "
                    + "transferencias.cierre,transferencias.horagrabado, "
                    + "(SELECT nombre FROM sucursales WHERE origen=sucursales.codigo) nombreorigen, "
                    + "(SELECT nombre FROM sucursales WHERE destino=sucursales.codigo) nombredestino, "
                    + "clientes.nombre AS nombrecliente,transferencias.cliente "
                    + "FROM transferencias "
                    + " LEFT JOIN clientes "
                    + " ON clientes.codigo=transferencias.cliente "
                    + " WHERE transferencias.cliente<>0 "
                    + " AND transferencias.venta = 0 "
                    + " ORDER BY transferencias.numero ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    transferencia tr = new transferencia();
                    sucursal sucursal = new sucursal();
                    tr.setNumero(rs.getInt("numero"));
                    tr.setFecha(rs.getDate("fecha"));
                    tr.setOrigen(rs.getInt("origen"));
                    tr.setCierre(rs.getInt("cierre"));
                    tr.setHoragrabado(rs.getTime("horagrabado"));
                    tr.setIdtransferencia(rs.getString("idtransferencia"));
                    tr.setNumero(rs.getInt("numero"));
                    tr.setDestino(rs.getInt("destino"));
                    tr.setNombredestino(rs.getString("nombredestino"));
                    tr.setNombreorigen(rs.getString("nombreorigen"));
                    tr.setNombrecliente(rs.getString("nombrecliente"));
                    tr.setCliente(rs.getInt("cliente"));
                    lista.add(tr);
                }
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        return lista;
    }


    public transferencia buscarInt(int id) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        transferencia tr = new transferencia();
        try {
            String sql = "SELECT transferencias.idtransferencia,transferencias.numero,transferencias.fecha,"
                    + "transferencias.origen,transferencias.destino,transferencias.horagrabado,"
                    + "transferencias.cierre,"
                    + "(SELECT nombre FROM sucursales WHERE origen=sucursales.codigo) nombreorigen, "
                    + "(SELECT nombre FROM sucursales WHERE destino=sucursales.codigo) nombredestino "
                    + " FROM transferencias "
                    +" WHERE transferencias.numero=?";

            try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    sucursal sucursal = new sucursal();
                    tr.setNumero(rs.getInt("numero"));
                    tr.setFecha(rs.getDate("fecha"));
                    tr.setCierre(rs.getInt("cierre"));
                    tr.setHoragrabado(rs.getTime("horagrabado"));
                    tr.setIdtransferencia(rs.getString("idtransferencia"));
                    tr.setNumero(rs.getInt("numero"));
                    tr.setDestino(rs.getInt("destino"));
                    tr.setNombredestino(rs.getString("nombredestino"));
                    tr.setOrigen(rs.getInt("origen"));
                    tr.setNombreorigen(rs.getString("nombreorigen"));
                }
                ps.close();
                st.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        return tr;
    }
    

    public boolean CerrarPreventa(int numeropreventa) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("UPDATE transferencias SET venta=1 WHERE numero= ?");
        ps.setInt(1, numeropreventa);
        int rowsUpdated = ps.executeUpdate();
        ps.close();
        st.close();
        conn.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    
}
