package Actores;

public class Alumno {
    private String nombre;
    private String apellidos;
    private String codigo;
    private String escuela;
    private String base;

    public Alumno(String nombre, String apellidos, String codigo, String escuela, String base) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.escuela = escuela;
        this.base = base;
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

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
    
    @Override
    public String toString() {
        return "Alumno [Nombre=" + nombre + ", Apellidos=" + apellidos + ", Código=" + codigo + ", Escuela=" + escuela + ", Base=" + base + "]";
    }
}
