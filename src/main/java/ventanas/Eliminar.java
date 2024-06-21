package ventanas;

import Datos.Registro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eliminar extends JFrame {

    private JButton btnEliminar;
    private JButton btnSalir;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JTextField jTextField1;

    public Eliminar() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField(20);
        btnEliminar = new JButton();
        btnSalir = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        jLabel1.setText("Código");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnEliminar)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir)
                    .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar))
                    .addGap(27, 27, 27)
                    .addComponent(btnSalir)
                    .addContainerGap(65, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
        setTitle("Eliminar Documento");
        setLocationRelativeTo(null);
    }

    private void btnSalirActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void btnEliminarActionPerformed(ActionEvent evt) {
        int codigo = Integer.parseInt(this.jTextField1.getText());
        Registro.eliminarDoc(codigo);
        JOptionPane.showMessageDialog(this, "Documento eliminado satisfactoriamente.");
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eliminar().setVisible(true);
            }
        });
    }

}
