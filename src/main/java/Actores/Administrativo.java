package Actores;

public class Administrativo {
    private String nombre;
    private String apellidos;
    private String cargo;
    private String contacto;

    public Administrativo(String nombre, String apellidos, String cargo, String contacto) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.contacto = contacto;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

        @Override
        public String toString() {
            return "Administrativo [Nombre=" + nombre + ", Apellidos=" + apellidos + ", Cargo=" + cargo + ", Contacto=" + contacto + "]";
        }
    }
