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
public class Cuenta {
    private int id, n_Cuenta, tipo, saldo, saldo_C;
    private Boolean estado;

    public Cuenta() {
    }

    public Cuenta(int id, int n_Cuenta, int tipo, int saldo, int saldo_C, Boolean estado) {
        this.id = id;
        this.n_Cuenta = n_Cuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.saldo_C = saldo_C;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN_Cuenta() {
        return n_Cuenta;
    }

    public void setN_Cuenta(int n_Cuenta) {
        this.n_Cuenta = n_Cuenta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo_C() {
        return saldo_C;
    }

    public void setSaldo_C(int saldo_C) {
        this.saldo_C = saldo_C;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
