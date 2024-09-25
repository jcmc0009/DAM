package tarea09;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.ImageIcon;

/**
 * Clase Controladora
 *
 * @author José Carlos Manjón Carrasco
 */
public class MemoriaController implements Initializable {

    // definición de variables internas para el desarrollo del juego
    private JuegoMemoria juego;         // instancia que controlará el estado del juego (tablero, parejas descubiertas, etc)
    private ArrayList<Button> cartas;   // array para almacenar referencias a las cartas @FXML definidas en la interfaz 
    private int segundos = 0;             // tiempo de juego
    private boolean primerBotonPulsado = false, segundoBotonPulsado = false; // indica si se han pulsado ya los dos botones para mostrar la pareja
    private int idBoton1, idBoton2;     // identificadores de los botones pulsados
    private boolean esPareja;           // almacenará si un par de botones pulsados descubren una pareja o no
    private int numerosIntentos = 0;
    private String cartaPrimera = null, cartaSegunda = null;

    @FXML
    private AnchorPane main;      // panel principal (incluye la notación @FXML porque hace referencia a un elemento de la interfaz)
    @FXML
    private Label tiempo;
    @FXML
    private Label numIntentos;
    @FXML
    private Button carta00, carta01, carta02, carta03, carta10, carta11, carta12, carta13, carta20, carta21, carta22, carta23, carta30, carta31, carta32, carta33, cartaMostrarPrimera = carta00, cartaMostrarSegunda = carta02;
    Media sound = new Media(new File("C:\\Users\\JCMCarra\\OneDrive - Unit4\\Documents\\NetBeansProjects\\2023-2024\\PROG09_Tarea2023_24_Alumnado\\src\\tarea09\\assets\\sonidos\\musica.mp3").toURI().toString());
    // linea de tiempo para gestionar la finalización del intento al pasar 1.5 segundos
    private final Timeline finIntento = new Timeline(new KeyFrame(Duration.seconds(1.5), e -> finalizarIntento()));

    // linea de tiempo para gestionar el contador de tiempo del juego
    private Timeline contadorTiempo;
//asociamos cada carta con una imagen
    Image imagenTrasera = new Image(getClass().getResourceAsStream("assets/interfaz/reversoCarta.png"));

    public Image getImagenTrasera() {
        return imagenTrasera;
    }

    Image imagen00 = new Image(getClass().getResourceAsStream("assets/cartas/1.png"));
    Image imagen01 = new Image(getClass().getResourceAsStream("assets/cartas/2.png"));
    Image imagen02 = new Image(getClass().getResourceAsStream("assets/cartas/3.png"));
    Image imagen03 = new Image(getClass().getResourceAsStream("assets/cartas/4.png"));
    Image imagen04 = new Image(getClass().getResourceAsStream("assets/cartas/5.png"));
    Image imagen05 = new Image(getClass().getResourceAsStream("assets/cartas/6.png"));
    /**
     * Método interno que configura todos los aspectos necesarios para
     * inicializar el juego.
     *
     * @param url No utilizaremos este parámetro (null).
     * @param resourceBundle No utilizaremos este parámetro (null).
     */
    MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        juego = new JuegoMemoria(); // instanciación del juego (esta instancia gestionará el estado de juego)
        juego.iniciarJuego();       // comienzo de una nueva partida
        cartas = new ArrayList<>(); // inicialización del ArrayList de referencias a cartas @FXML
        // música de fondo para que se reproduzca cuando se inicia el juego

        mediaPlayer = new MediaPlayer(sound);
        //      mediaPlayer.play();
        // guarda en el ArrayList "cartas" todas las referencias @FXML a las cartas para gestionarlo cómodamente
        cartas.addAll(Arrays.asList(carta00, carta01, carta02, carta03, carta10, carta11, carta12, carta13,
                carta20, carta21, carta22, carta23, carta30, carta31, carta32, carta33));
        // inicialización de todos los aspectos necesarios
        numIntentos.setText("0");
        segundos = 0;
        // contador de tiempo de la partida (Duration indica cada cuanto tiempo se actualizará)
        contadorTiempo = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            /// acciones a realizar (este código se ejecutará cada segundo)

            tiempo.setText("" + segundos);
            segundos++;
        }));
        contadorTiempo.setCycleCount(Timeline.INDEFINITE);  // reproducción infinita
        contadorTiempo.play();                                // iniciar el contador en este momento

    }

    /**
     * Acción asociada al botón <strong>Comenzar nuevo juego</strong> que
     * permite comenzar una nueva partida.
     *
     * Incluye la notación @FXML porque será accesible desde la interfaz de
     * usuario
     *
     * @param event Evento que ha provocado la llamada a este método
     */
    @FXML
    private void reiniciarJuego(ActionEvent event) {

        // detener el contador de tiempo 
        contadorTiempo.stop();
        // detener la reproducción de la música de fondo
        mediaPlayer.stop();
        /* hacer visibles las 16 cartas de juego ya que es posible que no todas estén visibles 
           si se encontraron parejas en la partida anterior */
        // llamar al método initialize para terminar de configurar la nueva partida
        initialize(null, null);
    }

    /**
     * Este método deberá llamarse cuando el jugador haga clic en cualquiera de
     * las cartas del tablero.
     *
     * Incluye la notación @FXML porque será accesible desde la interfaz de
     * usuario
     *
     * @param event Evento que ha provocado la llamada a este método (carta que
     * se ha pulsado)
     */
    @FXML
    private void mostrarContenidoCasilla(ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();
        String cartaId = botonPresionado.getId(); // obtener el ID de la carta pulsada

        if (!primerBotonPulsado) {
            primerBotonPulsado = true;
            cartaPrimera = cartaId; // Guardar el ID de la primera carta pulsada
            System.out.println("Primera carta pulsada: " + cartaPrimera);
            cartaMostrarPrimera = botonPresionado;
            cartaMostrarPrimera.setGraphic(new ImageView(imagen00));

        } else if (!segundoBotonPulsado) {
            segundoBotonPulsado = true;

            cartaSegunda = cartaId; // Guardar el ID de la segunda carta pulsada
            System.out.println("Segunda carta pulsada: " + cartaSegunda);
            carta00.setGraphic(new ImageView(imagen00));
            // Realizar la lógica para comparar las cartas aquí
            if (cartaPrimera.equals(cartaSegunda)) {
                System.out.println("¡Las cartas son iguales!");
                // Lógica para manejar el caso en que las cartas sean iguales
                cartaMostrarSegunda = botonPresionado;
                cartaMostrarSegunda.setGraphic(new ImageView(imagen00));
                mediaPlayer.stop();
                String rutaParejaSonido = new File("assets/sonidos/pareja.mp3").toURI().toString();
                Media soundPareja = new Media(rutaParejaSonido);
                mediaPlayer = new MediaPlayer(soundPareja);
                mediaPlayer.play();
                mediaPlayer.stop();
                mediaPlayer = new MediaPlayer(sound);

                // mediaPlayer.play();
            } else {
                System.out.println("¡Las cartas son diferentes!");
                // Lógica para manejar el caso en que las cartas sean diferentes
            }

            // Reiniciar las variables para el próximo par de selecciones
            primerBotonPulsado = false;
            segundoBotonPulsado = false;
        }
        // descubrir la imagen asociada a cada una de las cartas (y ajustar su tamaño al tamaño del botón)

        // identificar si se ha encontrado una pareja o no
        // reproducir el efecto de sonido correspondiente
        
        // finalizar intento (usar el timeline para que haga la llamada transcurrido el tiempo definido)
    }

    /**
     * Este método permite finalizar un intento realizado. Se pueden dar dos
     * situaciones:
     * <ul>
     * <li>Si se ha descubierto una pareja: en este caso se ocultarán las cartas
     * desapareciendo del tablero. Además, se debe comprobar si la pareja
     * descubierta es la última pareja del tablero y en ese caso terminar la
     * partida.</li>
     * <li>Si NO se ha descubierto una pareja: las imágenes de las cartas deben
     * volver a ocultarse (colocando su imagen a null).</li>
     * </ul>
     * Este método será interno y NO se podrá acceder desde la interfaz, por lo
     * que NO incorpora notación @FXML.
     */
    private void finalizarIntento() {

        // hacer desaparecer del tablero las cartas seleccionadas si forman una pareja
        // ocultar las imágenes de las cartas seleccionadas si NO forman una pareja
        // comprobar el final de partida 
        // si es final de partida mostra el mensaje de victoria y detener el temporizador y la música
    }

    /**
     * Este método permite salir de la aplicación. Debe mostrar una alerta de
     * confirmación que permita confirmar o rechazar la acción Al confirmar la
     * acción la aplicación se cerrará (opcionalmente, se puede incluir algún
     * efecto de despedida) Incluye la notación @FXML porque será accesible
     * desde la interfaz de usuario
     */
    @FXML
    private void salir() {

        // Alerta de confirmación que permita elegir si se desea salir o no del juego
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Desea salir?");
        alerta.showAndWait().ifPresent((respuesta) -> {
            if (respuesta == ButtonType.OK) {
              //  lo ponemos todo a cero y reiniciamos juego
                tiempo.setText(""+0);
               // reiniciarJuego(salir());
             
                // SOLO si se confirma la acción se cerrará la ventana y el juego finalizará. 
                Platform.exit();
            }
        });

    }
}
