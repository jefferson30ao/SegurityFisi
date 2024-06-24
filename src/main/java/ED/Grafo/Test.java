package ED.Grafo;
import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregar roles
        grafo.agregarNodo("Estudiante");
        grafo.agregarNodo("Profesor");
        grafo.agregarNodo("Administrativo");

        // Agregar recursos
        grafo.agregarNodo("Laboratorio");
        grafo.agregarNodo("Sala de Estudio");
        grafo.agregarNodo("Oficina");

        // Definir permisos de acceso
        grafo.agregarArista("Estudiante", "Sala de Estudio");
        grafo.agregarArista("Profesor", "Sala de Estudio");
        grafo.agregarArista("Profesor", "Laboratorio");
        grafo.agregarArista("Administrativo", "Oficina");

        // Crear el marco y agregar el panel del grafo
        JFrame frame = new JFrame("Gestión de Acceso a Instalaciones");
        GrafoPanel panel = new GrafoPanel(grafo);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
