package ventanas;

import Datos.RegistrarP;
import Entidades.Prestar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerRegistro extends JFrame {
    private DefaultTableModel T;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable table2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;

    public VerRegistro() {
        initComponents();
        T = (DefaultTableModel) table2.getModel();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        table2 = new JTable();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        table2.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Prestador", "Estudiante", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(table2);

        jButton1.setText("LIBROS");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("REVISTAS");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("TESIS");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(jButton1)
                    .addGap(113, 113, 113)
                    .addComponent(jButton2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3)
                    .addGap(107, 107, 107))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jButton4)))
                    .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton4)
                    .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
        setTitle("Ver Registro");
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado
        T.setColumnIdentifiers(new Object[]{"ID", "Tipo", "Prestador", "Estudiante", "Fecha"});
        for (Prestar d : RegistrarP.getRegistros()) {
            if (d.getTipo().equals("Libro")) {
                Prestar P = d;
                T.addRow(new Object[]{P.getCodigo(), P.getTipo(), P.getPrestador(), P.getCodigoU(), P.getFecha()});
            }
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado
        T.setColumnIdentifiers(new Object[]{"ID", "Tipo", "Prestador", "Estudiante", "Fecha"});
        for (Prestar d : RegistrarP.getRegistros()) {
            if (d.getTipo().equals("Revista")) {
                Prestar P = d;
                T.addRow(new Object[]{P.getCodigo(), P.getTipo(), P.getPrestador(), P.getCodigoU(), P.getFecha()});
            }
        }
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado
        T.setColumnIdentifiers(new Object[]{"ID", "Tipo", "Prestador", "Estudiante", "Fecha"});
        for (Prestar d : RegistrarP.getRegistros()) {
            if (d.getTipo().equals("Tesis")) {
                Prestar P = d;
                T.addRow(new Object[]{P.getCodigo(), P.getTipo(), P.getPrestador(), P.getCodigoU(), P.getFecha()});
            }
        }
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerRegistro().setVisible(true);
            }
        });
    }
}

