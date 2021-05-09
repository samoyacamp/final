/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio.DAO;

import com.mycompany.biblio.App;
// import com.mycompany.biblio.modelos.Libros;
// import com.mycompany.biblio.modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author sergi
 */
public class UsuarioDAO {
     private Connection conexion;
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("localhost");
        String port = configuration.getProperty("3306");
        String name = configuration.getProperty("biblioteca");
        String username = configuration.getProperty("root");
        String password = configuration.getProperty("paco123");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    public boolean checkBDUsuario(String nombre, String email, String pwd) throws SQLException{
        String sql="SELECT nombre, email, pwd FROM USUARIOS";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, email);
        sentencia.setString(3, pwd);
        ResultSet resultado = sentencia.executeQuery();
      
        return resultado.next();

    }
    
}
