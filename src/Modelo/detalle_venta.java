/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;

/**
 *
 * @author SERVIDOR
 */
public class detalle_venta {

    String dreferencia;
    producto codprod;
    BigDecimal cantidad;
    String comentario;
    BigDecimal prcosto;
    BigDecimal precio;
    BigDecimal monto;
    BigDecimal impiva;
    BigDecimal porcentaje;
    int suc;
    Double item;

    public detalle_venta() {

    }

    public detalle_venta(String dreferencia, producto codprod, BigDecimal cantidad, String comentario, BigDecimal prcosto, BigDecimal precio, BigDecimal monto, BigDecimal impiva, BigDecimal porcentaje, int suc, Double item) {
        this.dreferencia = dreferencia;
        this.codprod = codprod;
        this.cantidad = cantidad;
        this.comentario = comentario;
        this.prcosto = prcosto;
        this.precio = precio;
        this.monto = monto;
        this.impiva = impiva;
        this.porcentaje = porcentaje;
        this.suc = suc;
        this.item = item;
    }

    public String getDreferencia() {
        return dreferencia;
    }

    public void setDreferencia(String dreferencia) {
        this.dreferencia = dreferencia;
    }

    public producto getCodprod() {
        return codprod;
    }

    public void setCodprod(producto codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getPrcosto() {
        return prcosto;
    }

    public void setPrcosto(BigDecimal prcosto) {
        this.prcosto = prcosto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getImpiva() {
        return impiva;
    }

    public void setImpiva(BigDecimal impiva) {
        this.impiva = impiva;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getSuc() {
        return suc;
    }

    public void setSuc(int suc) {
        this.suc = suc;
    }

    public Double getItem() {
        return item;
    }

    public void setItem(Double item) {
        this.item = item;
    }


    
}
