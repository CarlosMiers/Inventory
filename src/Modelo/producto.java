/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pc_Server
 */
public class producto {

    int codigo;
    String nombre;
    String codigointerno;
    Double costo;
    Double mayorista;
    Double minorista;
    rubro rubro;
    Double stock;
    int estado;

    public producto() {

    }

    public producto(int codigo, String nombre, String codigointerno, Double costo, Double mayorista, Double minorista, rubro rubro, Double stock, int estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigointerno = codigointerno;
        this.costo = costo;
        this.mayorista = mayorista;
        this.minorista = minorista;
        this.rubro = rubro;
        this.stock = stock;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigointerno() {
        return codigointerno;
    }

    public void setCodigointerno(String codigointerno) {
        this.codigointerno = codigointerno;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getMayorista() {
        return mayorista;
    }

    public void setMayorista(Double mayorista) {
        this.mayorista = mayorista;
    }

    public Double getMinorista() {
        return minorista;
    }

    public void setMinorista(Double minorista) {
        this.minorista = minorista;
    }

    public rubro getRubro() {
        return rubro;
    }

    public void setRubro(rubro rubro) {
        this.rubro = rubro;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    

}
