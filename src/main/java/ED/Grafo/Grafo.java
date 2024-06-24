package ED.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Grafo {
    private Map<Nodo, List<Nodo>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarNodo(String nombre) {
        adyacencias.putIfAbsent(new Nodo(nombre), new ArrayList<>());
    }

    public void agregarArista(String desde, String hasta) {
        Nodo nodoDesde = new Nodo(desde);
        Nodo nodoHasta = new Nodo(hasta);
        adyacencias.putIfAbsent(nodoDesde, new ArrayList<>());
        adyacencias.putIfAbsent(nodoHasta, new ArrayList<>());
        adyacencias.get(nodoDesde).add(nodoHasta);
    }

    public boolean tieneArista(String desde, String hasta) {
        Nodo nodoDesde = new Nodo(desde);
        Nodo nodoHasta = new Nodo(hasta);
        return adyacencias.containsKey(nodoDesde) && adyacencias.get(nodoDesde).contains(nodoHasta);
    }

    public Map<Nodo, List<Nodo>> getAdyacencias() {
        return adyacencias;
    }

    public List<Nodo> obtenerRecursosParaRol(String rol) {
        Nodo nodoRol = new Nodo(rol);
        return adyacencias.getOrDefault(nodoRol, new ArrayList<>());
    }

    public void imprimirGrafo2() {
        for (Map.Entry<Nodo, List<Nodo>> entrada : adyacencias.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }

    public void imprimirGrafo(){
        GrafoPanel panel = new GrafoPanel(this);
        JFrame frame = new JFrame("Gestión de Acceso a Instalaciones");
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);    }
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