/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Usuario
 */
public class transferencia {

    String idtransferencia;
    int numero;
    Date fecha;
    int origen;
    String nombreorigen;
    int destino;
    String nombredestino;
    int cierre;
    int codusuario;
    Time horagrabado;
    int cliente;
    String nombrecliente;
    Date fechaentrega;
    int venta;
    String observacion;
    public transferencia() {

    }

    public transferencia(String idtransferencia, int numero, Date fecha, int origen, String nombreorigen, int destino, String nombredestino, int cierre, int codusuario, Time horagrabado, int cliente, String nombrecliente, Date fechaentrega, int venta, String observacion) {
        this.idtransferencia = idtransferencia;
        this.numero = numero;
        this.fecha = fecha;
        this.origen = origen;
        this.nombreorigen = nombreorigen;
        this.destino = destino;
        this.nombredestino = nombredestino;
        this.cierre = cierre;
        this.codusuario = codusuario;
        this.horagrabado = horagrabado;
        this.cliente = cliente;
        this.nombrecliente = nombrecliente;
        this.fechaentrega = fechaentrega;
        this.venta = venta;
        this.observacion = observacion;
    }

    public String getIdtransferencia() {
        return idtransferencia;
    }

    public void setIdtransferencia(String idtransferencia) {
        this.idtransferencia = idtransferencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public String getNombreorigen() {
        return nombreorigen;
    }

    public void setNombreorigen(String nombreorigen) {
        this.nombreorigen = nombreorigen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public String getNombredestino() {
        return nombredestino;
    }

    public void setNombredestino(String nombredestino) {
        this.nombredestino = nombredestino;
    }

    public int getCierre() {
        return cierre;
    }

    public void setCierre(int cierre) {
        this.cierre = cierre;
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public Time getHoragrabado() {
        return horagrabado;
    }

    public void setHoragrabado(Time horagrabado) {
        this.horagrabado = horagrabado;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


    
}
