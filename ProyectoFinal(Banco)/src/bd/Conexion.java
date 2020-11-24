/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author N1CK PL4Y
 */
public class Conexion {
    private Connection oConnection;
    public Statement oStatement;
    public ResultSet oResultSet;

    public Conexion(String server, String bd, String user, String pass) throws SQLException {
        MysqlDataSource mysql = new MysqlDataSource();
        mysql.setServerName(server);
        mysql.setDatabaseName(bd);
        mysql.setUser(user);
        mysql.setPassword(pass);
        oConnection = mysql.getConnection();
    }

    public void ejecutar(String sql) throws SQLException {
        oStatement = oConnection.createStatement();
        oStatement.executeUpdate(sql);
        oStatement.close();
    }

    public ResultSet ejecutarSelect(String select) throws SQLException {
        oStatement = oConnection.createStatement();
        oResultSet = oStatement.executeQuery(select);
        return oResultSet;
    }
}
