/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto_estructuras;

import Logica.Contacto;
import Logica.DoubleLinkedList;
import Logica.Empresa;
import Logica.LinkedListPropia;
import Logica.Persona;
import Logica.Telefono;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author marle
 */
public class ContactosPageController implements Initializable {

    @FXML
    VBox vboxVerContactos;
 
    @FXML
    TextField txtFiltro;
  
    @FXML
    VBox cajaAsociados;

    public static Contacto contactoSelecionado = null;
    private LinkedListPropia<Contacto> contactos = App.usuario.getContactos();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       

        mostrarContactos(contactos);
    }

    @FXML
    private void agregar(ActionEvent event) {
        try {
            App.setRoot("createContact");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void mostrarContactos(LinkedListPropia<Contacto> contactos) {
        vboxVerContactos.getChildren().clear();
        if (contactos.isEmpty()) {

            Label label = new Label("NO TIENES CONTACTOS");
            vboxVerContactos.getChildren().add(label);
        } else {
            System.out.println(contactos.size());
            for (Contacto contacto : contactos) {
                if (contacto instanceof Persona) {
                    Persona p1 = (Persona) contacto;
                    ImageView imgv = new ImageView();
                    if (!p1.getFotos().isEmpty()) {
                        imgv.setImage(new Image("file:" + p1.getFotos().get(0)));
                        imgv.setFitWidth(80); // Establecer el ancho de la imagen
                        imgv.setFitHeight(80); // Establecer la altura de la imagen
                        imgv.setPreserveRatio(true);
                        imgv.setSmooth(true);
                        imgv.setCache(true);

                    }
                    System.out.println(contacto);
                    HBox principal = new HBox(40);
                    principal.setAlignment(Pos.CENTER);
                    VBox contactoInformacion = new VBox(5);
                    contactoInformacion.setAlignment(Pos.CENTER);

                    Label nombre = null;
                    Label numero = null;

                    for (Telefono telefono : p1.getTelefonos()) {
                        nombre = new Label(p1.getNombre() + " " + p1.getApellido());
                        numero = new Label(telefono.getPrefijo() + " " + telefono.getNumero());
                    }

                    nombre.setStyle("-fx-text-fill: #6735a4; -fx-font-weight: bold;");
                    numero.setStyle("-fx-text-fill: #7F65FF");
                 
                    principal.setStyle("-fx-border-color: #D3D3D3");
                    principal.setPadding(new Insets(5, 5, 5, 5));
                    contactoInformacion.getChildren().addAll(nombre, numero);
//                    ToggleButton botonFavorito= new ToggleButton("✰");
//                    botonFavorito.setUserData(contacto);
//                    botonFavorito.setSelected(contacto.isFavorito());
//                    botonFavorito.setOnAction(this::handleFavoritoAction);
                    principal.getChildren().addAll(imgv, contactoInformacion);
                    vboxVerContactos.setMargin(principal, new Insets(10, 10, 10, 10));

                    vboxVerContactos.getChildren().add(principal);

                } else if (contacto instanceof Empresa) {
                    Empresa p1 = (Empresa) contacto;
                    ImageView imgv = new ImageView();
                    if (!p1.getFotos().isEmpty()) {
                        imgv.setImage(new Image("file:" + p1.getFotos().get(0)));
                        imgv.setFitWidth(80); // Establecer el ancho de la imagen
                        imgv.setFitHeight(80); // Establecer la altura de la imagen
                        imgv.setPreserveRatio(true);
                        imgv.setSmooth(true);
                        imgv.setCache(true);

                    }
                    System.out.println(contacto);
                    HBox principal = new HBox(40);
                    principal.setAlignment(Pos.CENTER);
                    VBox contactoInformacion = new VBox(5);
                    contactoInformacion.setAlignment(Pos.CENTER);

                    Label nombre = null;
                    Label numero = null;

                    for (Telefono telefono : p1.getTelefonos()) {
                        nombre = new Label(p1.getNombre() + " " + p1.getRazonSocial());
                        numero = new Label(telefono.getPrefijo() + " " + telefono.getNumero());
                    }

                    nombre.setStyle("-fx-text-fill: #6735a4; -fx-font-weight: bold;");
                    numero.setStyle("-fx-text-fill: #7F65FF");
                    Button boton = new Button("Ver");
                    boton.setStyle("-fx-background-color: #FFFF;");
                    boton.setStyle("-fx-font-weight: bold; -fx-text-fill: #6735a4;"); // Fuente en negrita y color morado
                    boton.setOnAction(event -> {
                        contactoSelecionado = contacto;
                        try {
                            App.setRoot("MenuEmpresa");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                    principal.setStyle("-fx-border-color: #D3D3D3");
                    principal.setPadding(new Insets(5, 5, 5, 5));
                    contactoInformacion.getChildren().addAll(nombre, numero);
//                    ToggleButton botonFavorito= new ToggleButton("✰");
//                    botonFavorito.setUserData(contacto);
//                    botonFavorito.setSelected(contacto.isFavorito());
//                    botonFavorito.setOnAction(this::handleFavoritoAction);
                    principal.getChildren().addAll(imgv, contactoInformacion, boton);
                    vboxVerContactos.setMargin(principal, new Insets(10, 10, 10, 10));

                    vboxVerContactos.getChildren().add(principal);
                    //para la empresa
                }
            }
        }
    }

//    actualizarListaContactos(contacto);
//    guardarCambios(); //llamda a metodo que tiene guarda las modificaciones
//    private void actualizarListaContactos(Contacto contactoActualizado) {
//    for (Contacto contacto : ) {
//        if (contacto instanceof Persona) {
//            Persona persona = (Persona) contacto;
//            for (Telefono telefono: persona.getTelefonos()){
//                telefono.equals(contacttoActualizado.getNumero());
//                persona.setFavorito(contactoActualizado.getEsFavorito());
//            }
//        } else if (contacto instanceof Empresa) {
//            Empresa empresa = (Empresa) contacto;
//            for (Telefono telefono: empresa.getTelefonos()){
//            if (telefono.equals(contactoActualizado.getTelefono())) {
//                empresa.setEsFavorito(contactoActualizado.getEsFavorito());
//                break;
//            }
//            }
//        }
    
}
