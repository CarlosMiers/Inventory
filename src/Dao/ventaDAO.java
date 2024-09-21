/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import clases.Config;
import Modelo.venta;
import Conexion.Conexion;
import Modelo.cliente;
import Modelo.producto;
import Modelo.rubro;
import Modelo.sucursal;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 *
 * @author SERVIDOR
 */
public class ventaDAO {

    DecimalFormat formatosinpunto = new DecimalFormat("############");
    DecimalFormat formatea = new DecimalFormat("###,###.##");

    Conexion con = null;
    Statement st = null;

    public ArrayList<venta> MostrarxFecha(Date fechaini, Date fechafin, int tipo) throws SQLException {
        ArrayList<venta> lista = new ArrayList<venta>();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        try {

            String cSql = "SELECT creferencia,cabecera_ventas.factura,cabecera_ventas.fecha,cabecera_ventas.factura,cabecera_ventas.vencimiento,";
            cSql = cSql + "cabecera_ventas.cliente,cabecera_ventas.sucursal,condicion,idusuario,";
            cSql = cSql + "supago,sucambio,totalbruto,totaldescuento,gravadas10,totalneto,";
            cSql = cSql + "anuladopor,preventa,observacion,";
            cSql = cSql + "clientes.nombre AS nombrecliente,";
            cSql = cSql + "sucursales.nombre AS nombresucursal ";
            cSql = cSql + " FROM cabecera_ventas ";
            cSql = cSql + " LEFT JOIN clientes ";
            cSql = cSql + " ON clientes.codigo=cabecera_ventas.cliente ";
            cSql = cSql + " LEFT JOIN sucursales ";
            cSql = cSql + " ON sucursales.codigo=cabecera_ventas.sucursal ";
            cSql = cSql + "WHERE cabecera_ventas.fecha between ? AND ? ";
            cSql = cSql + " AND IF(?>0,cabecera_ventas.totalneto>0,cabecera_ventas.totalneto<0) ";
            cSql = cSql + " ORDER BY cabecera_ventas.factura ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(cSql)) {
                ps.setDate(1, fechaini);
                ps.setDate(2, fechafin);
                ps.setInt(3, tipo);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    sucursal sucursal = new sucursal();
                    cliente cliente = new cliente();

                    venta vta = new venta();

                    vta.setSucursal(sucursal);
                    vta.setCliente(cliente);

                    vta.setCreferencia(rs.getString("creferencia"));
                    vta.setFactura(rs.getDouble("factura"));
                    vta.setFecha(rs.getDate("fecha"));
                    vta.getCliente().setCodigo(rs.getInt("cliente"));
                    vta.getCliente().setNombre(rs.getString("nombrecliente"));
                    vta.getSucursal().setCodigo(rs.getInt("sucursal"));
                    vta.getSucursal().setNombre(rs.getString("nombresucursal"));
                    vta.setVencimiento(rs.getDate("vencimiento"));
                    vta.setGravadas10(rs.getBigDecimal("gravadas10"));
                    vta.setTotalneto(rs.getBigDecimal("totalneto"));
                    vta.setObservacion(rs.getString("observacion"));
                    vta.setCondicion(rs.getString("condicion"));
                    vta.setIdusuario(rs.getInt("idusuario"));
                    lista.add(vta);
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        conn.close();
        return lista;
    }

    public ArrayList<venta> MostrarxFechaTodas(Date fechaini, Date fechafin) throws SQLException {
        ArrayList<venta> lista = new ArrayList<venta>();
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        try {

            String cSql = "SELECT creferencia,cabecera_ventas.factura,cabecera_ventas.fecha,cabecera_ventas.factura,cabecera_ventas.vencimiento,";
            cSql = cSql + "cabecera_ventas.cliente,cabecera_ventas.sucursal,";
            cSql = cSql + "supago,sucambio,totalbruto,totaldescuento,gravadas10,totalneto,idusuario,";
            cSql = cSql + "anuladopor,preventa,observacion,";
            cSql = cSql + "clientes.nombre AS nombrecliente,";
            cSql = cSql + "sucursales.nombre AS nombresucursal,cabecera_ventas.condicion ";
            cSql = cSql + " FROM cabecera_ventas ";
            cSql = cSql + " LEFT JOIN clientes ";
            cSql = cSql + " ON clientes.codigo=cabecera_ventas.cliente ";
            cSql = cSql + " LEFT JOIN sucursales ";
            cSql = cSql + " ON sucursales.codigo=cabecera_ventas.sucursal ";
            cSql = cSql + "WHERE cabecera_ventas.fecha between ? AND ? ";
            cSql = cSql + " AND IF(?>0,cabecera_ventas.totalneto>0,cabecera_ventas.totalneto<0) ";
            cSql = cSql + " ORDER BY cabecera_ventas.factura ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(cSql)) {
                ps.setDate(1, fechaini);
                ps.setDate(2, fechafin);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    sucursal sucursal = new sucursal();
                    cliente cliente = new cliente();

                    venta vta = new venta();

                    vta.setSucursal(sucursal);
                    vta.setCliente(cliente);

                    vta.setCreferencia(rs.getString("creferencia"));
                    vta.setFactura(rs.getDouble("factura"));
                    vta.setFecha(rs.getDate("fecha"));
                    vta.getCliente().setCodigo(rs.getInt("cliente"));
                    vta.getCliente().setNombre(rs.getString("nombrecliente"));
                    vta.getSucursal().setCodigo(rs.getInt("sucursal"));
                    vta.getSucursal().setNombre(rs.getString("nombresucursal"));
                    vta.setVencimiento(rs.getDate("vencimiento"));
                    vta.setGravadas10(rs.getBigDecimal("gravadas10"));
                    vta.setTotalneto(rs.getBigDecimal("totalneto"));
                    vta.setObservacion(rs.getString("observacion"));
                    vta.setCondicion(rs.getString("condicion"));
                    vta.setIdusuario(rs.getInt("idusuario"));
                    lista.add(vta);
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        st.close();
        conn.close();
        return lista;
    }

    public venta buscarId(String id) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        venta vta = new venta();

        try {

            String cSql = "SELECT creferencia,cabecera_ventas.factura,cabecera_ventas.fecha,cabecera_ventas.factura,cabecera_ventas.vencimiento,";
            cSql = cSql + "cabecera_ventas.cliente,cabecera_ventas.sucursal,";
            cSql = cSql + "supago,sucambio,totalbruto,totaldescuento,gravadas10,totalneto,";
            cSql = cSql + "anuladopor,preventa,observacion,cabecera_ventas.condicion,idusuario,";
            cSql = cSql + "clientes.nombre AS nombrecliente,";
            cSql = cSql + "sucursales.nombre AS nombresucursal ";
            cSql = cSql + " FROM cabecera_ventas ";
            cSql = cSql + " LEFT JOIN clientes ";
            cSql = cSql + " ON clientes.codigo=cabecera_ventas.cliente ";
            cSql = cSql + " LEFT JOIN sucursales ";
            cSql = cSql + " ON sucursales.codigo=cabecera_ventas.sucursal ";
            cSql = cSql + "WHERE cabecera_ventas.creferencia=?";
            cSql = cSql + " ORDER BY cabecera_ventas.factura ";

            try (PreparedStatement ps = st.getConnection().prepareStatement(cSql)) {
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    sucursal sucursal = new sucursal();
                    cliente cliente = new cliente();

                    vta.setSucursal(sucursal);
                    vta.setCliente(cliente);

                    vta.setCreferencia(rs.getString("creferencia"));
                    vta.setFactura(rs.getDouble("factura"));
                    vta.setFecha(rs.getDate("fecha"));
                    vta.getCliente().setCodigo(rs.getInt("cliente"));
                    vta.getCliente().setNombre(rs.getString("nombrecliente"));
                    vta.getSucursal().setCodigo(rs.getInt("sucursal"));
                    vta.getSucursal().setNombre(rs.getString("nombresucursal"));
                    vta.setVencimiento(rs.getDate("vencimiento"));
                    vta.setGravadas10(rs.getBigDecimal("gravadas10"));
                    vta.setTotalneto(rs.getBigDecimal("totalneto"));
                    vta.setObservacion(rs.getString("observacion"));
                    vta.setCondicion(rs.getString("condicion"));
                    vta.setIdusuario(rs.getInt("idusuario"));
                }
                ps.close();
                rs.close();
                st.close();
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("--> " + ex.getLocalizedMessage());
        }
        return vta;
    }

    public venta AgregarFacturaVenta(venta v, String detalle) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        boolean guardado = false;
        boolean guardacuota = false;
        int id = 0;
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("INSERT INTO cabecera_ventas (creferencia,fecha,"
                + "vencimiento,cliente,sucursal,"
                + "gravadas10,"
                + "totalneto,observacion,"
                + "idusuario,preventa,sucambio,condicion) "
                + "VALUES (?,?,?,?,?,?,"
                + "?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, v.getCreferencia());
        ps.setDate(2, v.getFecha());
        ps.setDate(3, v.getVencimiento());
        ps.setInt(4, v.getCliente().getCodigo());
        ps.setInt(5, v.getSucursal().getCodigo());
        ps.setBigDecimal(6, v.getGravadas10());
        ps.setBigDecimal(7, v.getTotalneto());
        ps.setString(8, v.getObservacion());
        ps.setInt(9, v.getIdusuario());
        ps.setInt(10, v.getPreventa());
        ps.setBigDecimal(11, v.getSucambio());
        ps.setString(12, v.getCondicion());
        ps.executeUpdate();
        guardarItemFactura(v.getCreferencia(), detalle, con);

        st.close();
        ps.close();
        conn.close();
        return v;
    }

    public boolean ActualizarFactura(int sucursal, Double factura) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;
        ps = st.getConnection().prepareStatement("UPDATE sucursales SET factura=? WHERE codigo=?");
        ps.setDouble(1, factura);
        ps.setInt(2, sucursal);
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

    public boolean ActualizarNroNotaCredito(int sucursal, Double factura) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        PreparedStatement ps = null;
        ps = st.getConnection().prepareStatement("UPDATE sucursales SET notacredito=? WHERE codigo=?");
        ps.setDouble(1, factura);
        ps.setInt(2, sucursal);
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

    public venta ActualizarVenta(venta v, String detalle) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection cnn = st.getConnection();
        boolean guardado = false;
        boolean guardacuota = false;
        int id = 0;
        PreparedStatement ps = null;

        ps = st.getConnection().prepareStatement("UPDATE  cabecera_ventas SET fecha=?,"
                + "vencimiento=?,cliente=?,sucursal=?,"
                + "gravadas10=?,"
                + "totalneto=?,observacion=?,"
                + "idusuario=?,condicion=? WHERE creferencia= '" + v.getCreferencia() + "'");
        ps.setDate(1, v.getFecha());
        ps.setDate(2, v.getVencimiento());
        ps.setInt(3, v.getCliente().getCodigo());
        ps.setInt(4, v.getSucursal().getCodigo());
        ps.setBigDecimal(5, v.getGravadas10());
        ps.setBigDecimal(6, v.getTotalneto());
        ps.setString(7, v.getObservacion());
        ps.setInt(8, v.getIdusuario());
        ps.setString(9, v.getCondicion());
        ps.executeUpdate();
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            guardado = guardarItemFactura(v.getCreferencia(), detalle, con);
        }
        st.close();
        ps.close();
        cnn.close();
        return v;
    }

    public boolean guardarItemFactura(String id, String detalle, Conexion conexion) throws SQLException {
        boolean guardado = true;
        Connection conn = st.getConnection();
        conn.setAutoCommit(false);

        PreparedStatement psdetalle = null;

        psdetalle = st.getConnection().prepareStatement("DELETE FROM detalle_ventas WHERE dreferencia=?");
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
                    String sql = "INSERT INTO detalle_ventas("
                            + "dreferencia,"
                            + "codprod,"
                            + "prcosto,"
                            + "cantidad,"
                            + "precio,"
                            + "monto,"
                            + "impiva,"
                            + "porcentaje,"
                            + "comentario,"
                            + "suc"
                            + ") "
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    try (PreparedStatement ps = st.getConnection().prepareStatement(sql)) {
                        ps.setString(1, id);
                        ps.setString(2, obj.get("codprod").getAsString());
                        ps.setBigDecimal(3, obj.get("prcosto").getAsBigDecimal());
                        ps.setBigDecimal(4, obj.get("cantidad").getAsBigDecimal());
                        ps.setBigDecimal(5, obj.get("precio").getAsBigDecimal());
                        ps.setBigDecimal(6, obj.get("monto").getAsBigDecimal());
                        ps.setBigDecimal(7, obj.get("impiva").getAsBigDecimal());
                        ps.setBigDecimal(8, obj.get("porcentaje").getAsBigDecimal());
                        ps.setString(9, obj.get("comentario").getAsString());
                        ps.setString(10, obj.get("suc").getAsString());
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
        conn.close();
        return guardado;
    }


    public boolean borrarVenta(String id) throws SQLException {
        con = new Conexion();
        st = con.conectar();
        Connection conn = st.getConnection();
        int rowsUpdated = 0;
        PreparedStatement ps = null;
        ps = st.getConnection().prepareStatement("DELETE FROM cabecera_ventas WHERE creferencia=?");
        ps.setString(1, id);
        rowsUpdated = ps.executeUpdate();
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
