/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author SERVIDOR
 */
public class venta {

    String creferencia;
    Date fecha;
    String condicion;
    Double factura;
    Date vencimiento;
    cliente cliente;
    sucursal sucursal;
    BigDecimal supago;
    BigDecimal sucambio;
    BigDecimal totalbruto;
    BigDecimal totaldescuento;
    BigDecimal gravadas10;
    BigDecimal totalneto;
    int anuladopor;
    Date fechaanulado;
    BigDecimal pagos;
    int preventa;
    int cierre;
    String observacion;
    int idusuario;

    public venta() {

    }

    public venta(String creferencia, Date fecha, String condicion, Double factura, Date vencimiento, cliente cliente, sucursal sucursal, BigDecimal supago, BigDecimal sucambio, BigDecimal totalbruto, BigDecimal totaldescuento, BigDecimal gravadas10, BigDecimal totalneto, int anuladopor, Date fechaanulado, BigDecimal pagos, int preventa, int cierre, String observacion, int idusuario) {
        this.creferencia = creferencia;
        this.fecha = fecha;
        this.condicion = condicion;
        this.factura = factura;
        this.vencimiento = vencimiento;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.supago = supago;
        this.sucambio = sucambio;
        this.totalbruto = totalbruto;
        this.totaldescuento = totaldescuento;
        this.gravadas10 = gravadas10;
        this.totalneto = totalneto;
        this.anuladopor = anuladopor;
        this.fechaanulado = fechaanulado;
        this.pagos = pagos;
        this.preventa = preventa;
        this.cierre = cierre;
        this.observacion = observacion;
        this.idusuario = idusuario;
    }

    public String getCreferencia() {
        return creferencia;
    }

    public void setCreferencia(String creferencia) {
        this.creferencia = creferencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Double getFactura() {
        return factura;
    }

    public void setFactura(Double factura) {
        this.factura = factura;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public BigDecimal getSupago() {
        return supago;
    }

    public void setSupago(BigDecimal supago) {
        this.supago = supago;
    }

    public BigDecimal getSucambio() {
        return sucambio;
    }

    public void setSucambio(BigDecimal sucambio) {
        this.sucambio = sucambio;
    }

    public BigDecimal getTotalbruto() {
        return totalbruto;
    }

    public void setTotalbruto(BigDecimal totalbruto) {
        this.totalbruto = totalbruto;
    }

    public BigDecimal getTotaldescuento() {
        return totaldescuento;
    }

    public void setTotaldescuento(BigDecimal totaldescuento) {
        this.totaldescuento = totaldescuento;
    }

    public BigDecimal getGravadas10() {
        return gravadas10;
    }

    public void setGravadas10(BigDecimal gravadas10) {
        this.gravadas10 = gravadas10;
    }

    public BigDecimal getTotalneto() {
        return totalneto;
    }

    public void setTotalneto(BigDecimal totalneto) {
        this.totalneto = totalneto;
    }

    public int getAnuladopor() {
        return anuladopor;
    }

    public void setAnuladopor(int anuladopor) {
        this.anuladopor = anuladopor;
    }

    public Date getFechaanulado() {
        return fechaanulado;
    }

    public void setFechaanulado(Date fechaanulado) {
        this.fechaanulado = fechaanulado;
    }

    public BigDecimal getPagos() {
        return pagos;
    }

    public void setPagos(BigDecimal pagos) {
        this.pagos = pagos;
    }

    public int getPreventa() {
        return preventa;
    }

    public void setPreventa(int preventa) {
        this.preventa = preventa;
    }

    public int getCierre() {
        return cierre;
    }

    public void setCierre(int cierre) {
        this.cierre = cierre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }



}
