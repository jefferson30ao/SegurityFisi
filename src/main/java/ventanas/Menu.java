package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuArchivo, menuEditar, menuPrestar, menuDevolucion;
    private JMenuItem menuItemSalir, menuItemIngresar, menuItemEliminar, menuItemListar, menuItemRegistrar, menuItemVerPrestamo, menuItemRegistrarDevolucion, menuItemVerRegistro;
    private JButton btnRegistrarIngreso, btnRegistrarSalida;

    public Menu() {
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
        gbc.gridheight = 2;
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
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelCentral.add(btnRegistrarSalida, gbc);

        add(panelCentral, BorderLayout.CENTER);

        // Agregar ActionListeners a los botones
        btnRegistrarIngreso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Ingresar in = new Ingresar();
                in.setVisible(true);
            }
        });

        btnRegistrarSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Acción para registrar salida
                // Ingresar salida = new Ingresar();
                // salida.setVisible(true);
                // Este código debe ser ajustado dependiendo de cómo se maneje la salida en tu aplicación
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
        SplashScreen splash = new SplashScreen(5000);
        splash.showSplashAndExit();

        // Iniciar la aplicación principal después del splash screen
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
