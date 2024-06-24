package ED.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grafo {
    private Map<Nodo, List<Nodo>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarNodo(String nombre, boolean esRol) {
        adyacencias.putIfAbsent(new Nodo(nombre, esRol), new ArrayList<>());
    }

    public void agregarArista(String desde, String hasta) {
        Nodo nodoDesde = new Nodo(desde, true);  // Asumiendo que 'desde' es siempre un rol
        Nodo nodoHasta = new Nodo(hasta, false); // Asumiendo que 'hasta' es siempre un recurso
        adyacencias.putIfAbsent(nodoDesde, new ArrayList<>());
        adyacencias.putIfAbsent(nodoHasta, new ArrayList<>());
        adyacencias.get(nodoDesde).add(nodoHasta);
    }

    public boolean tieneArista(String desde, String hasta) {
        Nodo nodoDesde = new Nodo(desde, true);
        Nodo nodoHasta = new Nodo(hasta, false);
        return adyacencias.containsKey(nodoDesde) && adyacencias.get(nodoDesde).contains(nodoHasta);
    }

    public Map<Nodo, List<Nodo>> getAdyacencias() {
        return adyacencias;
    }

    public List<Nodo> obtenerRecursosParaRol(String rol) {
        Nodo nodoRol = new Nodo(rol, true);
        return adyacencias.getOrDefault(nodoRol, new ArrayList<>());
    }

    public void imprimirGrafo2() {
        for (Map.Entry<Nodo, List<Nodo>> entrada : adyacencias.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }


    public void crearYMostrarVentana() {
        JFrame frame = new JFrame("Gestión de Acceso a Instalaciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel buttonPanel = new JPanel();

        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();

        // Añadir un panel para cada rol
        for (Nodo rol : adyacencias.keySet()) {
            if (rol.esRol) {
                GrafoPanel panel = new GrafoPanel(this, rol.nombre);
                cardPanel.add(panel, rol.nombre);

                JButton button = new JButton(rol.nombre);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cardLayout.show(cardPanel, rol.nombre);
                    }
                });
                buttonPanel.add(button);
            }
        }

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }   
}

class Arista {
    Nodo desde;
    Nodo hasta;

    public Arista(Nodo desde, Nodo hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    public String toString() {
        return desde + " -> " + hasta;
    }
}