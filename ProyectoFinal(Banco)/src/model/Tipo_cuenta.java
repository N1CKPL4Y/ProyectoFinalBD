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
public class Tipo_cuenta {
    private int id;
    private String detalle;

    public Tipo_cuenta() {
    }

    public Tipo_cuenta(int id, String detalle) {
        this.id = id;
        this.detalle = detalle;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
