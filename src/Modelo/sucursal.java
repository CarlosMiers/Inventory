/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class sucursal {

    int codigo;
    String nombre;
    String nombrefacturasuc;
    String nombreremisionsuc;
    String impresorafacturasuc;
    String impresoraremisionsuc;

    public sucursal() {

    }

    public sucursal(int codigo, String nombre, String nombrefacturasuc, String nombreremisionsuc, String impresorafacturasuc, String impresoraremisionsuc) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombrefacturasuc = nombrefacturasuc;
        this.nombreremisionsuc = nombreremisionsuc;
        this.impresorafacturasuc = impresorafacturasuc;
        this.impresoraremisionsuc = impresoraremisionsuc;
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

    public String getNombrefacturasuc() {
        return nombrefacturasuc;
    }

    public void setNombrefacturasuc(String nombrefacturasuc) {
        this.nombrefacturasuc = nombrefacturasuc;
    }

    public String getNombreremisionsuc() {
        return nombreremisionsuc;
    }

    public void setNombreremisionsuc(String nombreremisionsuc) {
        this.nombreremisionsuc = nombreremisionsuc;
    }

    public String getImpresorafacturasuc() {
        return impresorafacturasuc;
    }

    public void setImpresorafacturasuc(String impresorafacturasuc) {
        this.impresorafacturasuc = impresorafacturasuc;
    }

    public String getImpresoraremisionsuc() {
        return impresoraremisionsuc;
    }

    public void setImpresoraremisionsuc(String impresoraremisionsuc) {
        this.impresoraremisionsuc = impresoraremisionsuc;
    }



}
