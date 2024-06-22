package ventanas;

import Actores.Alumno;
import Actores.Docente;
import Actores.Administrativo;
import Datos.RegistroActor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class SalidaActor extends JFrame {
    private JTextField buscarField;
    private JButton eliminarButton;
    private JList<String> resultadosList;
    private DefaultListModel<String> listModel;
    private RegistroActor registroActor;

    public SalidaActor(RegistroActor registroActor) {
        this.registroActor = registroActor;

        setTitle("Registro de Salida de Actores");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel buscarPanel = new JPanel();
        buscarPanel.setLayout(new BorderLayout(5, 5));
        buscarPanel.add(new JLabel("Buscar por nombre:"), BorderLayout.WEST);
        buscarField = new JTextField();
        buscarPanel.add(buscarField, BorderLayout.CENTER);

        eliminarButton = new JButton("Eliminar Seleccionados");
        panel.add(buscarPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        resultadosList = new JList<>(listModel);
        resultadosList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(resultadosList);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(eliminarButton, BorderLayout.SOUTH);

        add(panel);

        buscarField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarLista();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarLista();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarLista();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarSeleccionados();
            }
        });

        actualizarLista();
    }

    private void actualizarLista() {
        String filtro = buscarField.getText().toLowerCase();
        listModel.clear();

        List<String> resultados = registroActor.getAlumnos().stream()
                .filter(a -> a.getNombre().toLowerCase().contains(filtro) || a.getApellidos().toLowerCase().contains(filtro))
                .map(Alumno::toString)
                .collect(Collectors.toList());

        resultados.addAll(registroActor.getDocentes().stream()
                .filter(d -> d.getNombre().toLowerCase().contains(filtro) || d.getApellidos().toLowerCase().contains(filtro))
                .map(Docente::toString)
                .collect(Collectors.toList()));

        resultados.addAll(registroActor.getAdministrativos().stream()
                .filter(ad -> ad.getNombre().toLowerCase().contains(filtro) || ad.getApellidos().toLowerCase().contains(filtro))
                .map(Administrativo::toString)
                .collect(Collectors.toList()));

        for (String resultado : resultados) {
            listModel.addElement(resultado);
        }
    }

    private void eliminarSeleccionados() {
        List<String> seleccionados = resultadosList.getSelectedValuesList();
        for (String seleccionado : seleccionados) {
            if (seleccionado.contains("Alumno [")) {
                Alumno alumno = registroActor.getAlumnos().stream()
                        .filter(a -> a.toString().equals(seleccionado))
                        .findFirst()
                        .orElse(null);
                if (alumno != null) {
                    registroActor.getAlumnos().remove(alumno);
                }
            } else if (seleccionado.contains("Docente [")) {
                Docente docente = registroActor.getDocentes().stream()
                        .filter(d -> d.toString().equals(seleccionado))
                        .findFirst()
                        .orElse(null);
                if (docente != null) {
                    registroActor.getDocentes().remove(docente);
                }
            } else if (seleccionado.contains("Administrativo [")) {
                Administrativo administrativo = registroActor.getAdministrativos().stream()
                        .filter(ad -> ad.toString().equals(seleccionado))
                        .findFirst()
                        .orElse(null);
                if (administrativo != null) {
                    registroActor.getAdministrativos().remove(administrativo);
                }
            }
        }
        actualizarLista();
        JOptionPane.showMessageDialog(this, "Actores seleccionados eliminados.");
    }

    public static void main(String[] args) {
        RegistroActor registroActor = new RegistroActor();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SalidaActor(registroActor).setVisible(true);
            }
        });
    }
}

