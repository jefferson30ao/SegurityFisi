package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Biblioteca extends JFrame {

    private JButton btnIngresar, btnEliminar, btnListar, btnRegistrarPrestamo, btnVerPrestamo, btnRegistrarDevolucion, btnVerRegistro;

    public Biblioteca() {
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(7, 1, 10, 10));

        btnIngresar = new JButton("Ingresar");
        btnEliminar = new JButton("Eliminar");
        btnListar = new JButton("Listar");
        btnRegistrarPrestamo = new JButton("Registrar Préstamo");
        btnVerPrestamo = new JButton("Ver Préstamo");
        btnRegistrarDevolucion = new JButton("Registrar Devolución");
        btnVerRegistro = new JButton("Ver Registro");

        btnIngresar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16));
        btnListar.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegistrarPrestamo.setFont(new Font("Arial", Font.BOLD, 16));
        btnVerPrestamo.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegistrarDevolucion.setFont(new Font("Arial", Font.BOLD, 16));
        btnVerRegistro.setFont(new Font("Arial", Font.BOLD, 16));

        add(btnIngresar);
        add(btnEliminar);
        add(btnListar);
        add(btnRegistrarPrestamo);
        add(btnVerPrestamo);
        add(btnRegistrarDevolucion);
        add(btnVerRegistro);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Ingresar in = new Ingresar();
                in.setVisible(true);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Eliminar el = new Eliminar();
                el.setVisible(true);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Listar li = new Listar();
                li.setVisible(true);
            }
        });

        btnRegistrarPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Prestamos P = new Prestamos();
                P.setVisible(true);
            }
        });

        btnVerPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                VerRegistro V = new VerRegistro();
                V.setVisible(true);
            }
        });

        btnRegistrarDevolucion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Devolucion D = new Devolucion();
                D.setVisible(true);
            }
        });

        btnVerRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                VerRegistro V = new VerRegistro();
                V.setVisible(true);
            }
        });

        // Configurar el frame
        setTitle("Gestión de Biblioteca");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }
}
