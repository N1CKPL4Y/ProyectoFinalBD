/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author N1CK PL4Y
 */
public class Usuario {
    private int n_Cuenta;
    private String rut;
    private String nombre;
    private String apellido_P;
    private String apellido_M;
    private String clave;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(int n_Cuenta, String rut, String nombre, String apellido_P, String apellido_M, String clave, boolean estado) {
        this.n_Cuenta = n_Cuenta;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_P = apellido_P;
        this.apellido_M = apellido_M;
        this.clave = clave;
        this.estado = estado;
    }

    public int getN_Cuenta() {
        return n_Cuenta;
    }

    public void setN_Cuenta(int n_Cuenta) {
        this.n_Cuenta = n_Cuenta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_P() {
        return apellido_P;
    }

    public void setApellido_P(String apellido_P) {
        this.apellido_P = apellido_P;
    }

    public String getApellido_M() {
        return apellido_M;
    }

    public void setApellido_M(String apellido_M) {
        this.apellido_M = apellido_M;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    
    
    
}
