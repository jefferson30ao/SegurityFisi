package Entidades;

public class Libro extends Volumen {
    private String editorial;
    private String materia;

    public Libro(String editorial, String materia, String titulo, int codigo, String pais, int cantidad, int numeroDePaginas) {
        super(titulo, codigo, pais, cantidad, numeroDePaginas);
        this.editorial = editorial;
        this.materia = materia;
    }

    // Getters y setters
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    // Sobrescribir el método toString() para proporcionar una representación
    // detallada del libro
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(getTitulo()).append("\n");
        sb.append("Código: ").append(getCodigo()).append("\n");
        sb.append("País: ").append(getPais()).append("\n");
        sb.append("Cantidad: ").append(getCantidad()).append("\n");
        sb.append("Número de páginas: ").append(getNumeroDePaginas()).append("\n");
        sb.append("Editorial: ").append(editorial).append("\n");
        sb.append("Materia: ").append(materia);
        return sb.toString();
    }
}
