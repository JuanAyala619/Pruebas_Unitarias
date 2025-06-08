/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package proyecto_gestión_contactos;

import Clases.Contacto;
import Clases.Empresa;
import Clases.GestorContactos;
import Clases.PersonaNatural;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Gabriel
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private TableView<Contacto> tablaContactos;
    @FXML private TableColumn<Contacto, String> colNombre;
    @FXML private TableColumn<Contacto, String> colTipo;
    @FXML private Button btnCrear;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;
    @FXML private Button btnAnterior;
    @FXML private Button btnSiguiente;

    private ObservableList<Contacto> listaContactos;
    private GestorContactos gestor;
    private int indiceActual=0;
    // Método que se llama al iniciar la ventana
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gestor=new GestorContactos();

    }
    @FXML
    private void mostrarContacto(int index) {
        
    }
        
        
    

    @FXML
    private void mostrarAnterior(ActionEvent event) {

    }

    @FXML
    private void mostrarSiguiente(ActionEvent event) {
    }

    @FXML
    private void crearContacto(ActionEvent event) {
        System.out.println("Crear contacto");

    }

    @FXML
    private void editarContacto(ActionEvent event) {
    }

    @FXML
    private void eliminarContacto(ActionEvent event) {
    }
    
}
