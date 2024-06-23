
package Entidades;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Instalacion {
        private String nombre;
        private int codigo;
        private boolean estado;
        private String prestador;

        public Instalacion(String nombre, int codigo, boolean estado, String prestador) {
            this.nombre = nombre;
            this.codigo = codigo;
            this.estado = estado;
            this.prestador = prestador;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCodigo() {
            return codigo;
        }

        public boolean isEstado() {
            return estado;
        }

        public String getPrestador() {
            return prestador;
        }
    

    public static void main(String[] args) {
        //Instalaciones instalaciones = new Instalaciones();

        // Ejemplo de cómo agregar instalaciones
        for (int i = 1; i <= 10; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la instalación " + i);
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la instalación " + i));
            boolean estado = JOptionPane.showConfirmDialog(null, "¿Está ocupada la instalación " + i + "?", "Estado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
            String prestador = JOptionPane.showInputDialog("Ingrese el nombre del prestador de la instalación " + i);

            //instalaciones.agregarInstalacion(nombre, codigo, estado, prestador);
        }

        // Mostrar la tabla
       // instalaciones.mostrarTabla();
    }
}
