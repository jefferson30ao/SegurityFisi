package ED.Grafo;
import java.util.Objects;
public class Nodo {
    String nombre;
    boolean esRol;

    public Nodo(String nombre, boolean esRol) {
        this.nombre = nombre;
        this.esRol = esRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodo nodo = (Nodo) o;
        return nombre.equals(nodo.nombre);
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
