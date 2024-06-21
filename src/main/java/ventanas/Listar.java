package ventanas;

import Datos.Registro;
import Entidades.Libro;
import Entidades.Revista;
import Entidades.Tesis;
import Entidades.Volumen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listar extends JFrame {

    private JRadioButton BRevista;
    private JRadioButton BTesis;
    private JRadioButton Blibro;
    private JButton btnListar;
    private JButton btnSalir;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;

    public Listar() {
        initComponents();
    }

    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        btnListar = new JButton();
        btnSalir = new JButton();
        Blibro = new JRadioButton();
        BRevista = new JRadioButton();
        BTesis = new JRadioButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnListar.setText("Listar");
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        buttonGroup1.add(Blibro);
        Blibro.setText("Libro");
        Blibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BlibroActionPerformed(evt);
            }
        });

        buttonGroup1.add(BRevista);
        BRevista.setText("Revista");
        BRevista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BRevistaActionPerformed(evt);
            }
        });

        buttonGroup1.add(BTesis);
        BTesis.setText("Tesis");
        BTesis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTesisActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Blibro, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListar))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(BRevista, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(BTesis, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                            .addGap(262, 262, 262))
                        .addComponent(jScrollPane1))
                    .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(Blibro, GroupLayout.Alignment.TRAILING)
                        .addComponent(btnListar))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalir)
                        .addComponent(BRevista))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(BTesis)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setTitle("Listar Documentos");
        setLocationRelativeTo(null);
    }

    private void btnSalirActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void btnListarActionPerformed(ActionEvent evt) {
        String cadena = "";

        if (Blibro.isSelected()) {
            // Mostrar solo los libros
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Libro) {
                    cadena += d.toString() + "\n";
                }
            }
        } else if (BRevista.isSelected()) {
            // Mostrar solo las revistas
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Revista) {
                    cadena += d.toString() + "\n";
                }
            }
        } else if (BTesis.isSelected()) {
            // Mostrar solo las tesis
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Tesis) {
                    cadena += d.toString() + "\n";
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una opción.");
            return;
        }

        // Mostrar la cadena actualizada en el JTextArea
        this.jTextArea1.setText(cadena);
    }

    private void BlibroActionPerformed(ActionEvent evt) {
        if (Blibro.isSelected()) {
            BRevista.setEnabled(false);
            BTesis.setEnabled(false);
        } else {
            BRevista.setEnabled(true);
            BTesis.setEnabled(true);
        }
    }

    private void BRevistaActionPerformed(ActionEvent evt) {
        if (BRevista.isSelected()) {
            Blibro.setEnabled(false);
            BTesis.setEnabled(false);
        } else {
            Blibro.setEnabled(true);
            BTesis.setEnabled(true);
        }
    }

    private void BTesisActionPerformed(ActionEvent evt) {
        if (BTesis.isSelected()) {
            BRevista.setEnabled(false);
            Blibro.setEnabled(false);
        } else {
            BRevista.setEnabled(true);
            Blibro.setEnabled(true);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar().setVisible(true);
            }
        });
    }
}

