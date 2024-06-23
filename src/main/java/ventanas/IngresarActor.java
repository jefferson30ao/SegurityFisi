package ventanas;

import Actores.Alumno;
import Actores.Docente;
import Actores.Administrativo;
import Datos.RegistroActor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresarActor extends JFrame {
    private JComboBox<String> tipoActorComboBox;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField codigoField;
    private JTextField escuelaField;
    private JTextField baseField;
    private JTextField asignaturaField;
    private JTextField cargoField;
    private JTextField contactoField;
    private JButton registrarButton;
    private JButton cancelarButton;
    private RegistroActor registroActor;

    public IngresarActor(RegistroActor registroActor) {
        this.registroActor = registroActor;

        setTitle("Registro de Ingreso de Actores");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        panel.add(new JLabel("Tipo de Actor:"));
        tipoActorComboBox = new JComboBox<>(new String[]{"Alumno", "Docente", "Administrativo"});
        panel.add(tipoActorComboBox);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Apellidos:"));
        apellidosField = new JTextField();
        panel.add(apellidosField);

        panel.add(new JLabel("Código:"));
        codigoField = new JTextField();
        panel.add(codigoField);

        panel.add(new JLabel("Escuela:"));
        escuelaField = new JTextField();
        panel.add(escuelaField);

        panel.add(new JLabel("Base:"));
        baseField = new JTextField();
        panel.add(baseField);

        panel.add(new JLabel("Asignatura:"));
        asignaturaField = new JTextField();
        panel.add(asignaturaField);

        panel.add(new JLabel("Cargo:"));
        cargoField = new JTextField();
        panel.add(cargoField);

        panel.add(new JLabel("Contacto:"));
        contactoField = new JTextField();
        panel.add(contactoField);

        registrarButton = new JButton("Registrar");
        cancelarButton = new JButton("Cancelar");

        panel.add(registrarButton);
        panel.add(cancelarButton);

        add(panel);

        tipoActorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampos();
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarActor();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        actualizarCampos();
    }

    private void actualizarCampos() {
        String tipoActor = (String) tipoActorComboBox.getSelectedItem();
        if ("Alumno".equals(tipoActor)) {
            escuelaField.setEnabled(true);
            baseField.setEnabled(true);
            asignaturaField.setEnabled(false);
            cargoField.setEnabled(false);
            contactoField.setEnabled(false);
        } else if ("Docente".equals(tipoActor)) {
            escuelaField.setEnabled(false);
            baseField.setEnabled(false);
            asignaturaField.setEnabled(true);
            cargoField.setEnabled(false);
            contactoField.setEnabled(false);
        } else if ("Administrativo".equals(tipoActor)) {
            escuelaField.setEnabled(false);
            baseField.setEnabled(false);
            asignaturaField.setEnabled(false);
            cargoField.setEnabled(true);
            contactoField.setEnabled(true);
        }
    }

    private void registrarActor() {
        String tipoActor = (String) tipoActorComboBox.getSelectedItem();
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        String codigo = codigoField.getText();
        String escuela = escuelaField.getText();
        String base = baseField.getText();
        String asignatura = asignaturaField.getText();
        String cargo = cargoField.getText();
        String contacto = contactoField.getText();

        if ("Alumno".equals(tipoActor)) {
            Alumno alumno = new Alumno(nombre, apellidos, codigo, escuela, base);
            registroActor.registrarAlumno(alumno);
        } else if ("Docente".equals(tipoActor)) {
            Docente docente = new Docente(nombre, apellidos, codigo, asignatura);
            registroActor.registrarDocente(docente);
        } else if ("Administrativo".equals(tipoActor)) {
            Administrativo administrativo = new Administrativo(nombre, apellidos, cargo, contacto);
            registroActor.registrarAdministrativo(administrativo);
        }

        JOptionPane.showMessageDialog(this, "Registro exitoso.");
        dispose();
    }

    public static void main(String[] args) {
        RegistroActor registroActor = new RegistroActor();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IngresarActor(registroActor).setVisible(true);
            }
        });
    }
}
