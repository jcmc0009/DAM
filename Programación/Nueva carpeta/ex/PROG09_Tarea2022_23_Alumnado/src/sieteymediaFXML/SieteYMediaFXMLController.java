package sieteymediaFXML;

import java.awt.TextArea;
import sieteymedia.Carta;
import sieteymedia.SieteYMedia;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.skin.RadioButtonSkin;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sieteymedia.Mazo;


/**
 * FXML Controller class
 *
 * @author Profesorado
 */
public class SieteYMediaFXMLController implements Initializable {

    private SieteYMedia juego; // instancia para almacenar la lógica del juego

    private int numTotalJugadores; // número de jugadores que participan
    private int jugadorTurno; // a quién le toca el turno

    /* Cola donde se van a almacenar los IDs de los jugadores activos en cada momentos. Cuando el jugador finaliza la partida, 
    bien porque se plante o porque se pase, será eliminado de esta cola. El jugador en primera posición (poll) será el que 
    tenga el turno, cuando termine de jugar se colocará en última posición (offer).*/
    private Queue<Integer> jugadoresActivos = new LinkedList<Integer>();

    // controles FXML relacionados con la interfaz
    @FXML
    private AnchorPane main;  // contenedor principal

    /* define a continuación otros contenedores y elementos FXML */
    // Método para inicializar la interfaz de usuario y prepara la partida reiniciando los controles.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reiniciaJuego(); //Comenzamos la partida reiniciando controles
    }

    /**
     * Cuando pulsamos el botón comenzar, comprobamos si se ha elegido el número
     * de jugadores. Si no es así, se muestra un mensaje de error. Si se han
     * elegido los jugadores, hacemos visibles los paneles de los jugadores que
     * están jugando y añadimos a la cola el identificador de los jugadores (1,
     * 2, 3...) que están jugando.
     *
     * @param event Evento que desencadena el inicio del juego (clic en botón
     * Comenzar)
     * @throws Excepción si no se ha podido comenzar la partida (no se
     * seleccionaron jugadores)
     */
    @FXML
    private void comenzarJuego(ActionEvent event) throws RuntimeException {

        juego = new SieteYMedia();  // creación del juego (en la variable juego se lleva el control de la baraja, jugadores, cartas, etc)
        reiniciaJuego();            // al comenzar cada juego se reinician todos los controles, botones, etc.

        try {
            // comprobar si se han elegido los jugadores totales que participarán 
//numTotalJugadores=Integer.parseInt(((RadioButton)numTotalJugadores.getSelectedToggle());
            // meter IDs de jugadores en la cola (1, 2, 3 ...)
            // hacer visibles los paneles principales de los jugadores que están participando
        } catch (RuntimeException e) {
            // si no se han elegido los jugadores, mostrar un mensaje de error
        }

        siguienteTurno(); // pasamos el turno al siguiente jugador
    }

    /**
     * Obtiene el ID del jugador al que le toca (el primero de la cola) y
     * habilita sus controles de juego.
     */
    private void siguienteTurno() {

        // deshabilitar los controles de todos los jugadores
        deshabilitarTodosControles();
        // si hay jugadores aún jugando (su ID está en la cola)
        if (jugadoresActivos.size() > 0) {

            // obtener de la cola el ID de jugador en posesión del turno 
            jugadorTurno = jugadoresActivos.poll();
            // activar solo los controles de este jugador
            ((Button) main.lookup("#carta" + jugadorTurno)).setDisable(false);
            // si no quedan jugadores aún jugando (cola vacía) se puede anunciar el ganador
        }
    }

    /**
     * Calcula quién gana y muestra un mensaje con las puntuaciones finales. El
     * ganador (o ganadores) serán aquellos que hacen 'siete y media' o que,
     * quedando por abajo, se acercan más a 7,5 puntos.
     */
    private void anunciaGanador() {

        // deshabilitar los controles de todos los jugadores
        // determinar el jugador o jugadores con mayor puntuación
        // mostrar mensajes si hay jugadores que se pasaron (puntuación > 7.5). En su caja de texto: Te pasate!
        // mostrar mensajes para los jugadores que obtuvieron la mejor puntuación. En su caja de texto: Enhorabuena, has ganado!
        // mostrar mensajes para los jugadores que NO obtuvieron la mejor puntuación. En su caja de texto: Has obtenido X puntos
    }

    /**
     * Método para deshabilitar todos los botones
     */
    private void deshabilitarTodosControles() {

        // para los 4 jugadores desactivar sus controles de juego
        /* Ejemplo para deshabilitar elementos llamados carta1, carta2, plantar1, plantar2, panel1, panel2...
         */
        for (int i = 1; i <= 4; i++) {
            ((Button) main.lookup("#carta" + i)).setDisable(true);    // busca los botones carta1, carta2, carta3, ... y los desactiva
            ((Button) main.lookup("#plantar" + i)).setDisable(true);  // busca los botones plantar1, plantar2, plantar3, ... y los desactiva
            BackgroundFill backgroundFill = new BackgroundFill(Color.web("#Ea8313"), null, null); // se coloca el color de fondo original a cada panel
            Background bg = new Background(backgroundFill);
            ((Pane) main.lookup("#panel" + i)).setBackground(bg); // busca cada panel panel1, panel2, panel3, ... y les cambia el fondo
        }

    }

    /**
     * Método para reiniciar los controles cuando comienza una partida
     */
    public void reiniciaJuego() {
        for (int i = 1; i < 4; i++) {
            // para los 4 jugadores reiniciar todos sus elementos:
           
          // ((TextArea)main.lookup("#texArea"+i)).clear();
            // vaciar el contenido de su caja de texto

       //     ((ImageView) main.lookup("win" + i)).clear();

            // ocultar las imagenes ganador/perdedor
            // desactivar los botones Carta/Plantarse
            // ocultar el panel completo
            // resetear el número de jugadores total
            numTotalJugadores = 0;

            // vaciar la cola de jugadores
        }
    }

    /**
     * Se obtiene una carta de la baraja, el jugador que tiene el turno la
     * guarda en su mazo, y se calculan los puntos acumulados y se escribe la
     * información en su caja de texto. Si se ha pasado de 7.5 se indica un
     * mensaje de finalización de su partida. Si no se ha pasado, el ID del
     * jugador se vuelve a introducir en la cola en última posición (offer).
     *
     * @param event Evento que desencadena la acción (clic en el botón Carta)
     */
    @FXML
    private void accionCarta(ActionEvent event) {

        Mazo jugadorActual; // para almacenar referencia a un jugador del juego (sus cartas, sus puntuaciones, etc)

        // identificar el jugador actual (el que tiene el turno). Según el turno, será juego.jugador1, juego.jugador2, etc.
        // extraer una carta de la baraja del juego
        Carta carta = juego.baraja.extraerCarta();

        // insertar la carta extraida en el mazo del jugador actual
        // calcular los puntos totales del jugador
        // localizar la caja de texto del jugador (según el turno que sea) y se añade el texto con información de la carta obtenida, puntos, etc.
        // determinar si el jugador puede seguir jugando o no 
        // si su puntuación pasa de 7.5 --> finaliza su participación (mostrar un mensaje)
        // si su puntuación es 7.5 --> finaliza su participación (mostrar un mensaje)
        // en cualquier otra situación --> continua en el juego (meter el ID del jugador en la última posición de la cola)
        siguienteTurno(); // pasamos el turno al siguiente jugador
    }

    /**
     * Si el jugador se planta, mostramos los puntos acumulados y pasamos al
     * siguiente jugador
     *
     * @param event Evento que desencadena la acción (clic en el botón Plantar)
     */
    @FXML
    private void accionPlantar(ActionEvent event) {

        Mazo jugadorActual; // para almacenar referencia a un jugador del juego (sus cartas, sus puntuaciones, etc)

        // identificar el jugador actual (el que tiene el turno). Según el turno, será juego.jugador1, juego.jugador2, etc.
        // calcular los puntos totales del jugador
        // localizar la caja de texto del jugador (según el turno que sea) y se añade el texto con la puntuación final obtenida
        siguienteTurno(); // pasamos el turno al siguiente jugador
    }

    /**
     * Cerramos la aplicación cuando cerramos el botón Salir
     *
     * @param event Evento que desencadena la acción (clic en el botón Salir)
     */
    @FXML
    private void salirJuego(ActionEvent event) {
        System.exit(0); // cierra el programa
    }
}
