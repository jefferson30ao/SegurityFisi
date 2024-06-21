/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author nalle
 */
public class Tesis extends Volumen{
    private String grado;
    private String asesor;

    public Tesis(String grado, String asesor, String titulo, int codigo, String pais, int cantidad, int numeroDePaginas) {
        super(titulo, codigo, pais, cantidad, numeroDePaginas);
        this.grado = grado;
        this.asesor = asesor;
    }

    // Getters y setters
    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    // Sobrescribir el método toString() para proporcionar una representación detallada de la tesis
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(getTitulo()).append("\n");
        sb.append("Código: ").append(getCodigo()).append("\n");
        sb.append("País: ").append(getPais()).append("\n");
        sb.append("Cantidad: ").append(getCantidad()).append("\n");
        sb.append("Número de páginas: ").append(getNumeroDePaginas()).append("\n");
        sb.append("Grado: ").append(grado).append("\n");
        sb.append("Asesor: ").append(asesor);
        return sb.toString();
    }
}
