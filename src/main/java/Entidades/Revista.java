package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Revista extends Volumen {

    private int volumen;
    private Date periodicidad;
    private String area;

    public Revista(int volumen, Date periodicidad, String area, String titulo, int codigo, String pais, int cantidad, int numeroDePaginas) {
        super(titulo, codigo, pais, cantidad, numeroDePaginas);
        this.volumen = volumen;
        this.periodicidad = periodicidad;
        this.area = area;
    }

    // Getters y setters
    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public Date getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Date periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    // Sobrescribir el método toString() para proporcionar una representación
    // detallada de la revista
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(getTitulo()).append("\n");
        sb.append("Código: ").append(getCodigo()).append("\n");
        sb.append("País: ").append(getPais()).append("\n");
        sb.append("Cantidad: ").append(getCantidad()).append("\n");
        sb.append("Número de páginas: ").append(getNumeroDePaginas()).append("\n");
        sb.append("Volumen: ").append(volumen).append("\n");
        sb.append("Periodicidad: ").append(dateFormat.format(periodicidad)).append("\n");
        sb.append("Área: ").append(area);
        return sb.toString();
    }

}
