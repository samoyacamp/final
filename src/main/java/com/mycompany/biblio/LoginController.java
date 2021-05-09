/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblio;

import com.mycompany.biblio.DAO.LibroDAO;
import com.mycompany.biblio.modelos.Libros;
import com.mycompany.biblio.DAO.UsuarioDAO;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.mycompany.biblio.modelos.Usuario;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergi
 */
public class LoginController {

    @FXML
    private TextField nombre;
    @FXML
    private TextField email;
    @FXML
    private TextField pwd;

    @FXML
    private void login() {
        //String usuario = nombre.getText();

        Usuario u = new Usuario(-1, nombre.getText(), email.getText(), pwd.getText());
        //u.checkNombre(usuario);
        //UsuarioDAO x = new UsuarioDAO();
        //System.out.println(u.getNombre());
        //boolean correcto = u.checkBDUsuario();
        // x.checkBDUsuario(u.getNombre());
        //boolean correcto = x.checkBDUsuario(u.toString());
        // DriverManager.println(String.valueOf(correcto));
        String Usuario=nombre.getText();
        String pass =pwd.getText();
        String correo = email.getText();
        boolean ok=true;
        if (ok) {
            AlertsUtil.mostrarInformacion("correcto");
            App.setUsuario(u );
            try {
                App.loadLibrosWindow();
            } catch (IOException e) {
                AlertsUtil.mostrarError(e.getMessage());
            }
        } else {
            AlertsUtil.mostrarError("incorrecto");
        }

        if (nombre.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha pueto ningun nombre");
        }
        if (email.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha puesto ningun email");
        }
        if (pwd.getText().isEmpty()) {
            AlertsUtil.mostrarError("no se ha puesto ninguna contraseña");
        }

    }

    @FXML
    private void register() {
        AlertsUtil.mostrarError("Aun no esta");

    }

}
