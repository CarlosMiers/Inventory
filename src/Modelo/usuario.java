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
public class usuario {

    int idusuario;
    String descripcion;
    String loginacceso;
    String password;
    int id_tipo_usuario;
    int id_permisos;
    int id_interfaz;

    public usuario() {

    }

    public usuario(int idusuario, String descripcion, String loginacceso, String password, int id_tipo_usuario, int id_permisos, int id_interfaz) {
        this.idusuario = idusuario;
        this.descripcion = descripcion;
        this.loginacceso = loginacceso;
        this.password = password;
        this.id_tipo_usuario = id_tipo_usuario;
        this.id_permisos = id_permisos;
        this.id_interfaz = id_interfaz;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLoginacceso() {
        return loginacceso;
    }

    public void setLoginacceso(String loginacceso) {
        this.loginacceso = loginacceso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public int getId_permisos() {
        return id_permisos;
    }

    public void setId_permisos(int id_permisos) {
        this.id_permisos = id_permisos;
    }

    public int getId_interfaz() {
        return id_interfaz;
    }

    public void setId_interfaz(int id_interfaz) {
        this.id_interfaz = id_interfaz;
    }

}
