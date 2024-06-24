package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestorIncidencias extends JFrame {
    private ArrayList<String> incidencias;
    private DefaultListModel<String> listModel;
    private JList<String> incidenciasList;

    public GestorIncidencias() {
        incidencias = new ArrayList<>();
        listModel = new DefaultListModel<>();

        setTitle("Gestor de Incidencias");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));

        JButton registrarButton = new JButton("Registrar Incidencia");
        JButton visualizarButton = new JButton("Visualizar Incidencias");

        panel.add(registrarButton);
        panel.add(visualizarButton);

        add(panel);

        registrarButton.addActionListener(e -> mostrarVentanaRegistro());
        visualizarButton.addActionListener(e -> mostrarVentanaVisualizacion());
    }

    private void mostrarVentanaRegistro() {
        JFrame ventanaRegistro = new JFrame("Registrar Incidencia");
        ventanaRegistro.setSize(300, 200);
        ventanaRegistro.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JTextArea textArea = new JTextArea();
        JButton guardarButton = new JButton("Guardar");

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(guardarButton, BorderLayout.SOUTH);

        ventanaRegistro.add(panel);

        guardarButton.addActionListener(e -> {
            String incidencia = textArea.getText();
            if (!incidencia.isEmpty()) {
                incidencias.add(incidencia);
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
        ventanaVisualizacion.setSize(400, 300);
        ventanaVisualizacion.setLocationRelativeTo(this);

        incidenciasList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(incidenciasList);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton editarButton = new JButton("Editar");
        JButton eliminarButton = new JButton("Eliminar");

        buttonPanel.add(editarButton);
        buttonPanel.add(eliminarButton);

        ventanaVisualizacion.add(scrollPane, BorderLayout.CENTER);
        ventanaVisualizacion.add(buttonPanel, BorderLayout.SOUTH);

        editarButton.addActionListener(e -> editarIncidencia());
        eliminarButton.addActionListener(e -> eliminarIncidencia());

        ventanaVisualizacion.setVisible(true);
    }

    private void editarIncidencia() {
        int selectedIndex = incidenciasList.getSelectedIndex();
        if (selectedIndex != -1) {
            String incidenciaActual = incidencias.get(selectedIndex);
            String incidenciaEditada = JOptionPane.showInputDialog(this, "Editar incidencia:", incidenciaActual);
            if (incidenciaEditada != null && !incidenciaEditada.isEmpty()) {
                incidencias.set(selectedIndex, incidenciaEditada);
                listModel.setElementAt(incidenciaEditada, selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una incidencia para editar.");
        }
    }

    private void eliminarIncidencia() {
        int selectedIndex = incidenciasList.getSelectedIndex();
        if (selectedIndex != -1) {
            incidencias.remove(selectedIndex);
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una incidencia para eliminar.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorIncidencias().setVisible(true));
    }
}
