package Actores;

public class Docente {
    private String nombre;
    private String apellidos;
    private String codigo;
    private String asignatura;

    public Docente(String nombre, String apellidos, String codigo, String asignatura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.asignatura = asignatura;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return "Docente [Nombre=" + nombre + ", Apellidos=" + apellidos + ", Código=" + codigo + ", Asignatura=" + asignatura + "]";
    }
}
