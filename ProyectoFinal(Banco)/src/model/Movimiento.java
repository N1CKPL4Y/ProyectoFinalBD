/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author N1CK PL4Y
 */
public class Movimiento {
    private int id;
    private String descripcion;
    private int n_Cuenta_Ori, n_Cuenta_Des;
    private Date fecha;
    private Time hora;
    private int monto;
    private int cuenta;

    public Movimiento() {
    }

    public Movimiento(int id, String descripcion, int n_Cuenta_Ori, int n_Cuenta_Des, Date fecha, Time hora, int monto, int cuenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.n_Cuenta_Ori = n_Cuenta_Ori;
        this.n_Cuenta_Des = n_Cuenta_Des;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.cuenta = cuenta;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getN_Cuenta_Ori() {
        return n_Cuenta_Ori;
    }

    public void setN_Cuenta_Ori(int n_Cuenta_Ori) {
        this.n_Cuenta_Ori = n_Cuenta_Ori;
    }

    public int getN_Cuenta_Des() {
        return n_Cuenta_Des;
    }

    public void setN_Cuenta_Des(int n_Cuenta_Des) {
        this.n_Cuenta_Des = n_Cuenta_Des;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    
    
    
}
