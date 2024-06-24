package ED.Grafo;

import java.util.Objects;

public class Nodo {
    String nombre;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Nodo nodo = (Nodo) obj;
        return Objects.equals(nombre, nodo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
