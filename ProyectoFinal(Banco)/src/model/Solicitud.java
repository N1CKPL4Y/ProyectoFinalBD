/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author N1CK PL4Y
 */
public class Solicitud {
    private int id, motivo, n_Cuenta;
    private String rut_Tra;
    private Date fecha;
    private Boolean estado;

    public Solicitud() {
    }

    public Solicitud(int id, int motivo, int n_Cuenta, String rut_Tra, Date fecha, Boolean estado) {
        this.id = id;
        this.motivo = motivo;
        this.n_Cuenta = n_Cuenta;
        this.rut_Tra = rut_Tra;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }

    public int getN_Cuenta() {
        return n_Cuenta;
    }

    public void setN_Cuenta(int n_Cuenta) {
        this.n_Cuenta = n_Cuenta;
    }

    public String getRut_Tra() {
        return rut_Tra;
    }

    public void setRut_Tra(String rut_Tra) {
        this.rut_Tra = rut_Tra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
