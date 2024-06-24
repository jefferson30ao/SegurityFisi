package ED.Grafo;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class GrafoPanel extends JPanel {
    private Grafo grafo;
    private String rol;
    private Map<String, Point> posiciones;
    private Color rolColor = Color.magenta; // Color para los nodos de roles
    private Color recursoColor = Color.lightGray; // Color para los nodos de recursos
    private String[] roles = new String[] { "Estudiante", "Profesor", "Administrativo" };

    public GrafoPanel(Grafo grafo, String rol) {
        this.grafo = grafo;
        this.rol = rol;
        this.posiciones = new HashMap<>();
        establecerPosiciones();
    }

    private void establecerPosiciones() {
        // Establecer posiciones aleatorias para todos los nodos si no se especifica un
        // rol
        Random rand = new Random();
        int width = 1000;
        int height = 600;

        if (rol == null) {
            // Añadir posiciones para todos los nodos
            for (Nodo nodo : grafo.getAdyacencias().keySet()) {
                int x = rand.nextInt(width - 100) + 50;
                int y = rand.nextInt(height - 100) + 50;
                posiciones.put(nodo.nombre, new Point(x, y));
            }
        } else {
            // Añadir posición para el rol
            int x = rand.nextInt(width - 100) + 50;
            int y = rand.nextInt(height - 100) + 50;
            posiciones.put(rol, new Point(x, y));

            // Añadir posiciones para los recursos relacionados
            List<Nodo> recursos = grafo.obtenerRecursosParaRol(rol);
            for (Nodo recurso : recursos) {
                x = rand.nextInt(width - 100) + 50;
                y = rand.nextInt(height - 100) + 50;
                posiciones.put(recurso.nombre, new Point(x, y));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (rol == null) {
            // Mostrar todos los nodos y aristas
            for (Nodo nodo : grafo.getAdyacencias().keySet()) {
                Point p1 = posiciones.get(nodo.nombre);
                List<Nodo> adyacentes = grafo.getAdyacencias().get(nodo);
                for (Nodo hasta : adyacentes) {
                    Point p2 = posiciones.get(hasta.nombre);
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        } else {
            // Mostrar nodos y aristas para el rol específico
            Nodo nodoRol = new Nodo(rol, true);
            List<Nodo> recursos = grafo.obtenerRecursosParaRol(rol);
            for (Nodo hasta : recursos) {
                Point p1 = posiciones.get(nodoRol.nombre);
                Point p2 = posiciones.get(hasta.nombre);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // Dibujar nodos
        for (String nombre : posiciones.keySet()) {
            Point posicion = posiciones.get(nombre);

            Boolean isRole = false;
            for(String role : roles){
                if(nombre.equals(role)){
                    isRole = true;
                }
            }
            if (isRole) {
                g.setColor(rolColor);
            } else {
                g.setColor(recursoColor);
            }
            g.fillOval(posicion.x - 15, posicion.y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(posicion.x - 15, posicion.y - 15, 30, 30);
            g.drawString(nombre, posicion.x - 15, posicion.y - 20);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }
}