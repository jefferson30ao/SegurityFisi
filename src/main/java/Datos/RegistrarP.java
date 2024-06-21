
package Datos;

import Entidades.Prestar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nalle
 */
public class RegistrarP {

    static ArrayList<Prestar> registros;

    public RegistrarP() {
        registros = new ArrayList<Prestar>();
    }

    public static ArrayList<Prestar> getRegistros() {
        return registros;
    }

    public static void setListaPrestamos(ArrayList<Prestar> registros) {
        RegistrarP.registros = registros;
    }

    public static boolean agregarPrestamo(Prestar pres) {
        if (registros == null) {
            registros = new ArrayList<Prestar>();
        }

        boolean repetido = false;
        for (Prestar d : registros) {
            if (d.getCodigoU() == pres.getCodigoU()) {
                repetido = true;
                JOptionPane.showMessageDialog(null, "Usted ya solicitó un préstamo");
                break;
            }
        }

        if (!repetido) {
            registros.add(pres);
            JOptionPane.showMessageDialog(null, "Préstamo registrado");
            return true;  // Se agregó el préstamo correctamente
        }

        return false;  // No se pudo agregar el préstamo
    }

    public static void eliminarPrestamo(int code) {
        boolean existe = false;
        for (Prestar d : registros) {
            if (d.getCodigo() == code) {
                existe = true;
                registros.remove(d);
                JOptionPane.showMessageDialog(null, "Devolucion exitosa");
                break;
            }
        }
        if (existe == false) {
            JOptionPane.showMessageDialog(null, "Codigo incorrecto");
        }

    }

    public static void listar() {
        for (Prestar d : registros) {
            System.out.println(d.toString());
        }
    }

}
