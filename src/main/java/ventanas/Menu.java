package ventanas;

import javax.swing.*;


import Datos.RegistroActor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Menu extends JFrame {
    private JButton btnRegistrarIngreso, btnRegistrarSalida, btnListarActores, btnAccesoInstalaciones, btnReportesIncidencias, btnGestionBiblioteca;
    private RegistroActor registroActor;
    private JLabel lblMensajeEmergencia;
    Instalaciones I1 = new Instalaciones();

    public Menu() {
        registroActor = new RegistroActor();
        initUI();
    }

    private void initUI() {

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

        // Crear el panel central con imagen de fondo
        JPanel panelCentral = new BackgroundPanel();
        panelCentral.setLayout(new GridBagLayout());
        panelCentral.setBackground(new Color(224, 255, 255)); 
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

        // Crear y agregar el botón biblio
        btnGestionBiblioteca = new JButton("Gestión de Biblioteca");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelCentral.add(btnGestionBiblioteca, gbc);

        btnGestionBiblioteca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setVisible(true);
            }
        });
        
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
                //JOptionPane.showMessageDialog(null, "Acceso a Instalaciones no implementado aún.");
                //I1.setMenu(this);
                I1.setVisible(true);
                //this.setVisible(false);
            }

           
        });

        btnReportesIncidencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorIncidencias reporteIncidencia = new GestorIncidencias();
                reporteIncidencia.setVisible(true);    
            }
        });

        // Configurar el frame
        setTitle("Menu Principal");
        setSize(900, 700); // Aumentar el tamaño de la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // FONDO DE IMAGEN //
    class BackgroundPanel extends JPanel {
    private BufferedImage backgroundImage;
    private Image logoFISI;
    private Image logoSM;

    public BackgroundPanel() {
        try {
            backgroundImage = ImageIO.read(new File("src/main/java/resources/FISI.jpg"));
            logoFISI = ImageIO.read(new File("src/main/java/resources/LogoFISI.png"));
            logoFISI = logoFISI.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            
            logoSM = ImageIO.read(new File("src/main/java/resources/LogoSM.png"));  
            logoSM = logoSM.getScaledInstance(100, 100, Image.SCALE_SMOOTH);   

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
           
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f)); //Degradado
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            // LogoFISI 
            int logoFISIX = getWidth() - logoFISI.getWidth(this) - 10; 
            int logoFISIY = 10; 
            g2d.drawImage(logoFISI, logoFISIX, logoFISIY, this);
                
            // LogoSM 
            int logoSMX = 10; 
            int logoSMY = 10; 
            g2d.drawImage(logoSM, logoSMX, logoSMY, this);            
      
            g2d.dispose();

        }
        }
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
