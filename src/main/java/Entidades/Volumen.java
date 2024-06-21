/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author javier
 */
public class Volumen {
      
    private String titulo;
    private int codigo;
    private String pais;
    private int cantidad;
    private int numeroDePaginas;

    public Volumen(String titulo, int codigo, String pais, int cantidad, int numeroDePaginas) {
        // Validación de entrada
        if (codigo <= 0) {
            throw new IllegalArgumentException("El código debe ser un número positivo");
        }
        if (numeroDePaginas <= 0) {
            throw new IllegalArgumentException("El número de páginas debe ser mayor que cero");
        }

        this.titulo = titulo;
        this.codigo = codigo;
        this.pais = pais;
        this.cantidad = cantidad;
        this.numeroDePaginas = numeroDePaginas;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
