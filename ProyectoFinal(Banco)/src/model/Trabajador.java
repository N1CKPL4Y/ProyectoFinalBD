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
public class Trabajador {
    private String rut;
    private String nombre;
    private String apellido;
    private String cargo;
    private String seccion;
    private String clave;

    public Trabajador() {
    }

    public Trabajador(String rut, String nombre, String apellido, String cargo, String seccion, String clave) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.seccion = seccion;
        this.clave = clave;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
