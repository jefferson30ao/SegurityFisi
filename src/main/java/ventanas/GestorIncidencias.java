package ventanas;

import ED.ListaEnlazada;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class GestorIncidencias extends JFrame {
    private ListaEnlazada<String> incidencias;
    private DefaultListModel<String> listModel;
    private JList<String> incidenciasList;

    private static final Color COLOR_FONDO = new Color(240, 240, 240);
    private static final Color COLOR_BOTON = new Color(70, 130, 180);
    private static final Color COLOR_TEXTO = Color.WHITE;
    private static final Font FUENTE_BOTON = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 18);

    public GestorIncidencias() {
        incidencias = new ListaEnlazada<>();
        listModel = new DefaultListModel<>();

        setTitle("Gestor de Incidencias");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_FONDO);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 20, 0);

        JLabel titulo = new JLabel("Gestor de Incidencias", SwingConstants.CENTER);
        titulo.setFont(FUENTE_TITULO);
        panel.add(titulo, gbc);

        JButton registrarButton = crearBoton("Registrar Incidencia");
        JButton visualizarButton = crearBoton("Visualizar Incidencias");

        panel.add(registrarButton, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        panel.add(visualizarButton, gbc);

        add(panel);

        registrarButton.addActionListener(e -> mostrarVentanaRegistro());
        visualizarButton.addActionListener(e -> mostrarVentanaVisualizacion());
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(COLOR_BOTON);
        boton.setForeground(COLOR_TEXTO);
        boton.setFont(FUENTE_BOTON);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setPreferredSize(new Dimension(200, 40));
        return boton;
    }

    private void mostrarVentanaRegistro() {
        JFrame ventanaRegistro = new JFrame("Registrar Incidencia");
        ventanaRegistro.setSize(400, 300);
        ventanaRegistro.setLocationRelativeTo(this);
        ventanaRegistro.getContentPane().setBackground(COLOR_FONDO);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(COLOR_BOTON));

        JButton guardarButton = crearBoton("Guardar");

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(guardarButton, BorderLayout.SOUTH);

        ventanaRegistro.add(panel);

        guardarButton.addActionListener(e -> {
            String incidencia = textArea.getText();
            if (!incidencia.isEmpty()) {
                incidencias.agregar(incidencia);
                listModel.addElement(incidencia);
                JOptionPane.showMessageDialog(ventanaRegistro, "Incidencia registrada con éxito.");
                ventanaRegistro.dispose();
            } else {
                JOptionPane.showMessageDialog(ventanaRegistro, "Por favor, ingrese una incidencia.");
            }
        });

        ventanaRegistro.setVisible(true);
    }

    private void mostrarVentanaVisualizacion() {
        JFrame ventanaVisualizacion = new JFrame("Visualizar Incidencias");
        ventanaVisualizacion.setSize(500, 400);
        ventanaVisualizacion.setLocationRelativeTo(this);
        ventanaVisualizacion.getContentPane().setBackground(COLOR_FONDO);

        actualizarListModel();
        incidenciasList = new JList<>(listModel);
        incidenciasList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        incidenciasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(incidenciasList);
        scrollPane.setBorder(BorderFactory.createLineBorder(COLOR_BOTON));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(COLOR_FONDO);
        JButton editarButton = crearBoton("Editar");
        JButton eliminarButton = crearBoton("Eliminar");

        buttonPanel.add(editarButton);
        buttonPanel.add(eliminarButton);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(COLOR_FONDO);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        ventanaVisualizacion.add(mainPanel);

        editarButton.addActionListener(e -> editarIncidencia());
        eliminarButton.addActionListener(e -> eliminarIncidencia());

        ventanaVisualizacion.setVisible(true);
    }

    private void actualizarListModel() {
        listModel.clear();
        for (int i = 0; i < incidencias.tamaño(); i++) {
            listModel.addElement(incidencias.obtener(i));
        }
    }

    private void editarIncidencia() {
        int selectedIndex = incidenciasList.getSelectedIndex();
        if (selectedIndex != -1) {
            String incidenciaActual = incidencias.obtener(selectedIndex);
            JTextArea textArea = new JTextArea(incidenciaActual);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(300, 200));

            int result = JOptionPane.showConfirmDialog(this, scrollPane, "Editar incidencia",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String incidenciaEditada = textArea.getText();
                if (!incidenciaEditada.isEmpty()) {
                    incidencias.establecer(selectedIndex, incidenciaEditada);
                    listModel.setElementAt(incidenciaEditada, selectedIndex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una incidencia para editar.");
        }
    }

    private void eliminarIncidencia() {
        int selectedIndex = incidenciasList.getSelectedIndex();
        if (selectedIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea eliminar esta incidencia?", 
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                incidencias.eliminar(selectedIndex);
                actualizarListModel();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una incidencia para eliminar.");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new GestorIncidencias().setVisible(true));
    }
}