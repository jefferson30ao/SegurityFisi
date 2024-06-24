package ED.Grafo;

import javax.swing.*;
import java.awt.*;
import java.util.*;

class GrafoPanel extends JPanel {
    private Grafo grafo;
    private Map<String, Point> posiciones;

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        this.posiciones = new HashMap<>();
        establecerPosiciones();
    }

    private void establecerPosiciones() {
        // Establecer posiciones aleatorias para los nodos
        Random rand = new Random();
        int width = 800;
        int height = 600;
        for (Nodo nodo : grafo.getAdyacencias().keySet()) {
            int x = rand.nextInt(width - 100) + 50;
            int y = rand.nextInt(height - 100) + 50;
            posiciones.put(nodo.nombre, new Point(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar aristas
        for (Map.Entry<Nodo, java.util.List<Nodo>> entrada : grafo.getAdyacencias().entrySet()) {
            Nodo desde = entrada.getKey();
            for (Nodo hasta : entrada.getValue()) {
                Point p1 = posiciones.get(desde.nombre);
                Point p2 = posiciones.get(hasta.nombre);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
        // Dibujar nodos
        for (Map.Entry<String, Point> entrada : posiciones.entrySet()) {
            String nombre = entrada.getKey();
            Point posicion = entrada.getValue();
            g.setColor(Color.WHITE);
            g.fillOval(posicion.x - 15, posicion.y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(posicion.x - 15, posicion.y - 15, 30, 30);
            g.drawString(nombre, posicion.x - 15, posicion.y - 20);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
