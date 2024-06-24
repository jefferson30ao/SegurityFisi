
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
    

}
