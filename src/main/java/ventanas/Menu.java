package ventanas;

import javax.swing.*;

import Datos.RegistroActor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuArchivo, menuEditar, menuPrestar, menuDevolucion;
    private JMenuItem menuItemSalir, menuItemIngresar, menuItemEliminar, menuItemListar, menuItemRegistrar, menuItemVerPrestamo, menuItemRegistrarDevolucion, menuItemVerRegistro;
    private JButton btnRegistrarIngreso, btnRegistrarSalida, btnListarActores, btnAccesoInstalaciones, btnReportesIncidencias;
    private RegistroActor registroActor;
    private JLabel lblMensajeEmergencia;

    public Menu() {
        registroActor = new RegistroActor();
        initUI();
    }

    private void initUI() {
        // Crear la barra de menú
        menuBar = new JMenuBar();

        // Crear los menús
        menuArchivo = new JMenu("Archivo");
        menuEditar = new JMenu("Editar");
        menuPrestar = new JMenu("Prestar");
        menuDevolucion = new JMenu("Devolución");

        // Crear los elementos de menú
        menuItemSalir = new JMenuItem("Salir");
        menuItemIngresar = new JMenuItem("Ingresar");
        menuItemEliminar = new JMenuItem("Eliminar");
        menuItemListar = new JMenuItem("Listar");
        menuItemRegistrar = new JMenuItem("Registrar Préstamo");
        menuItemVerPrestamo = new JMenuItem("Ver Préstamo");
        menuItemRegistrarDevolucion = new JMenuItem("Registrar Devolución");
        menuItemVerRegistro = new JMenuItem("Ver Registro");

        // Agregar ActionListeners a los elementos de menú
        menuItemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        menuItemIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Ingresar in = new Ingresar();
                in.setVisible(true);
            }
        });

        menuItemEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Eliminar el = new Eliminar();
                el.setVisible(true);
            }
        });

        menuItemListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Listar li = new Listar();
                li.setVisible(true);
            }
        });

        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Prestamos P = new Prestamos();
                P.setVisible(true);
            }
        });

        menuItemVerPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                VerRegistro V = new VerRegistro();
                V.setVisible(true);
            }
        });

        menuItemRegistrarDevolucion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Devolucion D = new Devolucion();
                D.setVisible(true);
            }
        });

        menuItemVerRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                VerRegistro V = new VerRegistro();
                V.setVisible(true);
            }
        });

        // Agregar los elementos de menú a los menús
        menuArchivo.add(menuItemSalir);
        menuEditar.add(menuItemIngresar);
        menuEditar.add(menuItemEliminar);
        menuEditar.add(menuItemListar);
        menuPrestar.add(menuItemRegistrar);
        menuPrestar.add(menuItemVerPrestamo);
        menuDevolucion.add(menuItemRegistrarDevolucion);
        menuDevolucion.add(menuItemVerRegistro);

        // Agregar los menús a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuEditar);
        menuBar.add(menuPrestar);
        menuBar.add(menuDevolucion);

        // Agregar la barra de menú al frame
        setJMenuBar(menuBar);

        // Configurar el layout del frame
        setLayout(new BorderLayout());

        // Crear el panel de título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTitulo.setBackground(new Color(173, 216, 230)); // Color de fondo amigable
        JLabel lblTitulo = new JLabel("SEGURITY FISI");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(25, 25, 112)); // Color de texto que combine
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Crear el panel de la imagen y botones
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridBagLayout());
        panelCentral.setBackground(new Color(224, 255, 255)); // Color de fondo amigable
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Crear y agregar la imagen
        ImageIcon imageIcon = new ImageIcon("path_to_image.jpg");
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel lblImagen = new JLabel(scaledImageIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        panelCentral.add(lblImagen, gbc);

        // Crear y agregar el botón Registrar Ingreso
        btnRegistrarIngreso = new JButton("Registrar Ingreso");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCentral.add(btnRegistrarIngreso, gbc);

        // Crear y agregar el botón Registrar Salida
        btnRegistrarSalida = new JButton("Registrar Salida");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCentral.add(btnRegistrarSalida, gbc);

        // Crear y agregar el botón Personas en la facultad
        btnListarActores = new JButton("Personas en la facultad");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCentral.add(btnListarActores, gbc);

        // Crear y agregar el botón Acceso a Instalaciones
        btnAccesoInstalaciones = new JButton("Acceso a Instalaciones");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCentral.add(btnAccesoInstalaciones, gbc);

        // Crear y agregar el botón Reportes de Incidencias
        btnReportesIncidencias = new JButton("Reportes de Incidencias");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCentral.add(btnReportesIncidencias, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Crear y agregar el panel de mensaje de emergencia
        JPanel panelMensajeEmergencia = new JPanel();
        panelMensajeEmergencia.setBackground(new Color(255, 69, 0)); // Color de fondo de emergencia
        lblMensajeEmergencia = new JLabel("Mensaje de emergencia: Este es un mensaje de ejemplo.");
        lblMensajeEmergencia.setFont(new Font("Arial", Font.BOLD, 16));
        lblMensajeEmergencia.setForeground(Color.WHITE);
        panelMensajeEmergencia.add(lblMensajeEmergencia);
        add(panelMensajeEmergencia, BorderLayout.SOUTH);

        // Agregar ActionListeners a los botones
        btnRegistrarIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresarActor ingresarActor = new IngresarActor(registroActor);
                ingresarActor.setVisible(true);
            }
        });

        btnRegistrarSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalidaActor salidaActor = new SalidaActor(registroActor);
                salidaActor.setVisible(true);
            }
        });

        btnListarActores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarActores listarActores = new ListarActores(registroActor);
                listarActores.setVisible(true);
            }
        });

        btnAccesoInstalaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para manejar el acceso a instalaciones
                JOptionPane.showMessageDialog(null, "Acceso a Instalaciones no implementado aún.");
            }
        });

        btnReportesIncidencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí iría el código para manejar los reportes de incidencias
                JOptionPane.showMessageDialog(null, "Reportes de Incidencias no implementado aún.");
            }
        });

        // Configurar el frame
        setTitle("Menu Principal");
        setSize(900, 700); // Aumentar el tamaño de la ventana
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Mostrar el splash screen
        // SplashScreen splash = new SplashScreen(5000);
        // splash.showSplashAndExit();

        // Iniciar la aplicación principal después del splash screen
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
