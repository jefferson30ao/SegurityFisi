package ventanas;

import Actores.Alumno;
import Actores.Docente;
import Actores.Administrativo;
import Datos.RegistroActor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarActores extends JFrame {
    private JTextArea textArea;
    private JButton btnListarAlumnos;
    private JButton btnListarDocentes;
    private JButton btnListarAdministrativos;
    private RegistroActor registroActor;

    public ListarActores(RegistroActor registroActor) {
        this.registroActor = registroActor;

        setTitle("Listar Actores");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        btnListarAlumnos = new JButton("Listar Alumnos");
        btnListarDocentes = new JButton("Listar Docentes");
        btnListarAdministrativos = new JButton("Listar Administrativos");

        buttonPanel.add(btnListarAlumnos);
        buttonPanel.add(btnListarDocentes);
        buttonPanel.add(btnListarAdministrativos);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        btnListarAlumnos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAlumnos();
            }
        });

        btnListarDocentes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarDocentes();
            }
        });

        btnListarAdministrativos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAdministrativos();
            }
        });
    }

    private void listarAlumnos() {
        textArea.setText("");
        for (Alumno alumno : registroActor.getAlumnos()) {
            textArea.append(alumno.toString() + "\n");
        }
    }

    private void listarDocentes() {
        textArea.setText("");
        for (Docente docente : registroActor.getDocentes()) {
            textArea.append(docente.toString() + "\n");
        }
    }

    private void listarAdministrativos() {
        textArea.setText("");
        for (Administrativo administrativo : registroActor.getAdministrativos()) {
            textArea.append(administrativo.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        RegistroActor registroActor = new RegistroActor();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListarActores(registroActor).setVisible(true);
            }
        });
    }
}

