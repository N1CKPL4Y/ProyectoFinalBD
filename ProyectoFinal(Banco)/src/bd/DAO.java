/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Motivo;
import model.Movimiento;
import model.Tipo_cuenta;
import model.Trabajador;
import model.Usuario;

/**
 *
 * @author N1CK PL4Y
 */
public class DAO {
    private Conexion oConexion;
    private String sql;
    private List<Movimiento> movimientos;
    private List<Usuario> usuario;
    private List<Motivo> motivo;
    private List<Tipo_cuenta> t_cuenta;
    
    public DAO() throws SQLException {
        oConexion = new Conexion(
                "localhost",
                "banco",
                "root",
                "");
    }
    
    public Usuario isUsuario(String rut, String clave) throws SQLException {
        sql = "SELECT * FROM usuario WHERE Rut='" + rut + "' and Clave='" + clave + "'";
        //System.out.println(sql);
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        Usuario oUsuario;
        if (oConexion.oResultSet.next()) {
            oUsuario = new Usuario();
            oUsuario.setN_Cuenta(oConexion.oResultSet.getInt(1));
            oUsuario.setRut(oConexion.oResultSet.getString(2));
            oUsuario.setNombre(oConexion.oResultSet.getString(3));
            oUsuario.setApellido_P(oConexion.oResultSet.getString(4));
            oUsuario.setApellido_M(oConexion.oResultSet.getString(5));
            oUsuario.setClave(oConexion.oResultSet.getString(6));
            oUsuario.setEstado(oConexion.oResultSet.getBoolean(7));
            return oUsuario;
        } else {
            return null;
        }
    }
    
    public void estadoCuenta(int n_cuenta, int estado) throws SQLException{
        sql="UPDATE usuario SET Estado="+estado+" WHERE N_Cuenta="+n_cuenta+";";
        oConexion.ejecutar(sql);
    }
    
    public List <Tipo_cuenta> getT_cuenta() throws SQLException{
        sql="SELECT * FROM tipo_cuenta;";
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        Tipo_cuenta oTipo_cuenta;
        t_cuenta = new ArrayList<>();
        while(oConexion.oResultSet.next()){
            oTipo_cuenta = new Tipo_cuenta();
            oTipo_cuenta.setId(oConexion.oResultSet.getInt(1));
            oTipo_cuenta.setDetalle(oConexion.oResultSet.getString(2));
            t_cuenta.add(oTipo_cuenta);
        }
        return t_cuenta;
    }
    public Trabajador isTrabajador(String rut, String clave) throws SQLException {
        sql = "SELECT * FROM trabajador WHERE Rut='" + rut + "' AND Clave='" + clave + "'";
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        Trabajador oTrabajador;
        if (oConexion.oResultSet.next()) {
            oTrabajador = new Trabajador();
            oTrabajador.setRut(oConexion.oResultSet.getString(1));
            oTrabajador.setNombre(oConexion.oResultSet.getString(2));
            oTrabajador.setApellido(oConexion.oResultSet.getString(3));
            oTrabajador.setCargo(oConexion.oResultSet.getString(4));
            oTrabajador.setClave(oConexion.oResultSet.getString(5));
            return oTrabajador;
        } else {
            return null;
        }
    }
    
    public void solicitud(int ncuenta, String rutT, String descripcion, int motivo ) throws SQLException {
        sql = "INSERT INTO solicitud VALUES(null,"+motivo+",'" + descripcion + "'," + ncuenta + ",'" + rutT + "')";
        oConexion.ejecutar(sql);
    }
    
    public Usuario getUserRegisted(int ruser) throws SQLException {
        sql = "SELECT * FROM usuario WHERE N_Cuenta=" + ruser + "";
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        Usuario oUsuario;
        if (oConexion.oResultSet.next()) {
            oUsuario = new Usuario();
            oUsuario.setN_Cuenta(oConexion.oResultSet.getInt(1));
            oUsuario.setRut(oConexion.oResultSet.getString(2));
            oUsuario.setNombre(oConexion.oResultSet.getString(3));
            oUsuario.setApellido_P(oConexion.oResultSet.getString(4));
            oUsuario.setApellido_M(oConexion.oResultSet.getString(5));
            oUsuario.setClave(oConexion.oResultSet.getString(6));
            oUsuario.setEstado(oConexion.oResultSet.getBoolean(7));
            return oUsuario;
        }
        return null;

    }
    
    public List<Motivo> getMotivo() throws SQLException{
        sql="SELECT * FROM Motivo";
        oConexion.oResultSet=oConexion.ejecutarSelect(sql);
        Motivo oMotivo;
        motivo=new ArrayList<>();
        while(oConexion.oResultSet.next()) {
            oMotivo=new Motivo();
            oMotivo.setId(oConexion.oResultSet.getInt(1));
            oMotivo.setDetalle(oConexion.oResultSet.getString(2));
            motivo.add(oMotivo);
            
        }
        return  motivo;
        
    }
    
    public Usuario getUserRegisted(String ruser) throws SQLException {
        sql = "SELECT * FROM usuario WHERE Rut='" + ruser + "'";
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        Usuario oUsuario;
        if (oConexion.oResultSet.next()) {
            oUsuario = new Usuario();
            oUsuario.setN_Cuenta(oConexion.oResultSet.getInt(1));
            oUsuario.setRut(oConexion.oResultSet.getString(2));
            oUsuario.setNombre(oConexion.oResultSet.getString(3));
            oUsuario.setApellido_P(oConexion.oResultSet.getString(4));
            oUsuario.setApellido_M(oConexion.oResultSet.getString(5));
            oUsuario.setClave(oConexion.oResultSet.getString(6));
            oUsuario.setEstado(oConexion.oResultSet.getBoolean(7));
            return oUsuario;
        }
        return null;

    }
    
    public void eliminarTrabajador(String rutString) throws SQLException{
        sql="DELETE trabajador WHERE Rut='"+rutString+"'";
        oConexion.ejecutar(sql);
    }
    
    public String getRutUsuario(int n_cuenta) throws SQLException {
        sql = "SELECT Rut FROM usuario WHERE N_Cuenta=" + n_cuenta;
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        String rut;
        Usuario oUsuario;
        if (oConexion.oResultSet.next()) {
            rut = oConexion.oResultSet.getString("Rut");
            return rut;
        }
        return null;
    }
    public String getClaveUsuario(int n_cuenta) throws SQLException {
        sql = "SELECT Clave FROM usuario WHERE N_Cuenta=" + n_cuenta;
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        String clave;
        Usuario oUsuario;
        if (oConexion.oResultSet.next()) {
            clave = oConexion.oResultSet.getString("Clave");
            return clave;
        }
        return null;
    }
    
    

    public void transferencia(int _n_cuenta_ori, int _n_cuenta_des, int _monto, int t_c_ori, String msg, int t_c_des) throws SQLException {
        sql = "CALL transferencia_Bancaria(" + _n_cuenta_ori + "," + _n_cuenta_des + "," + _monto + ","+t_c_ori+",'"+msg+"',"+t_c_des+")";
        oConexion.ejecutar(sql);
    }

    public void cambiarClave(String claveString, int ncuenta) throws SQLException {
        sql = "UPDATE usuario SET Clave='" + claveString + "' WHERE N_Cuenta=" + ncuenta;
        oConexion.ejecutar(sql);
    }

    public List<Movimiento> mostrarMovimiento() throws SQLException {
        movimientos = new ArrayList<>();
        Movimiento oMovimiento;
        sql = "SELECT * FROM movimiento  ORDER BY Id DESC";
        oConexion.oResultSet = oConexion.ejecutarSelect(sql);
        while (oConexion.oResultSet.next()) {
            oMovimiento = new Movimiento();
            oMovimiento.setId(oConexion.oResultSet.getInt(1));
            oMovimiento.setDescripcion(oConexion.oResultSet.getString(2));
            oMovimiento.setN_Cuenta_Ori(oConexion.oResultSet.getInt(3));
            oMovimiento.setN_Cuenta_Des(oConexion.oResultSet.getInt(4));
            oMovimiento.setFecha(oConexion.oResultSet.getDate(5));
            oMovimiento.setMonto(oConexion.oResultSet.getInt(6));
            movimientos.add(oMovimiento);
        }
        return movimientos;

    }

    public void crearUsuario(int b, String rut, String nombre, String apellido_P, String apellido_M, String clave) throws SQLException {
        sql="CALL crear_Cuentas("+b+", '"+rut+"', '"+nombre+"', '"+apellido_P+"', '"+apellido_M+"', '"+clave+"')";
        oConexion.ejecutar(sql);
    }
}
