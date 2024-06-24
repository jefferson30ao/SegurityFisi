
package ventanas;

import Entidades.Instalacion;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import ED.Grafo.Grafo;
import ED.Grafo.Nodo;

public class Instalaciones extends JFrame {
    DefaultTableModel modeloInstalacion = new DefaultTableModel();
    private Menu menu;
    private Queue<Instalacion> colaInstalaciones;

    private static final int MAX_INSTALACIONES = 20;
    JComboBox listaDesplegable1;

    private Grafo grafo;
    private String[] roles;
    private String[] recursos;
    private String[][] relaciones;

    public Instalaciones() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        colaInstalaciones = new LinkedList<>();
        initComponents();
        agregarModeloTablaInstalacion();

        grafo = new Grafo();
        roles = new String[] { "Estudiante", "Profesor", "Administrativo" };
        recursos = new String[] { "Aulas de clase", "Aula de estudio", " Laboratorio",
                "Cancha sintetica", "Auditorio", "Oficina" };
        relaciones = new String[][] {
                { "Estudiante", "Aula de estudio" },
                { "Estudiante", "Cancha sintetica" },
                { "Estudiante", "Aulas de clase" },
                { "Profesor", "Aulas de clase" },
                { "Profesor", "Laboratorio" },
                { "Profesor", "Auditorio" },
                { "Administrativo", "Oficina" }
        };
        for (String rol_ : roles) {
            rol.addItem(rol_);
        }

        // Agregar roles
        grafo.agregarNodo("Estudiante", true);
        grafo.agregarNodo("Profesor", true);
        grafo.agregarNodo("Administrativo", true);

        // Agregar recursos
        grafo.agregarNodo("Laboratorio", false);
        grafo.agregarNodo("Sala de Estudio", false);
        grafo.agregarNodo("Oficina", false);
        for (String[] relacion : relaciones) {
            grafo.agregarArista(relacion[0], relacion[1]);
        }

        pack(); // Ajusta el tamaño del frame al de sus componentes
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        setResizable(false);
        colocarListasDesplegables();

    }

    private void colocarListasDesplegables() {
        String rol_ = (String) rol.getSelectedItem();
        listaDesplegable1 = new JComboBox<>();
        listaDesplegable1.setBounds(120, 130, 170, 30);
        jPanel2.add(listaDesplegable1);
        actualizarListaDesplegable(rol_);

    }

    private void actualizarListaDesplegable(String rol) {
        if (rol == null) {
            return;
        }
        if (listaDesplegable1 == null) {
            return;
        }
        List<Nodo> recursos = grafo.obtenerRecursosParaRol(rol);
        listaDesplegable1.removeAllItems();
        for (Nodo recurso : recursos) {
            listaDesplegable1.addItem(recurso.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Reservar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        rol = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        configB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N

        regresar.setText("Atrás");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel1.setText("Instalaciones");

        jLabel2.setText("Nombre");

        jLabel3.setText("Codigo");

        jLabel4.setText("Estado");

        jLabel5.setText("Prestador");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        Reservar.setText("Reservar");
        Reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel6.setText("Elija instalacion");

        jTable1.setModel(modeloInstalacion);
        jScrollPane3.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel7.setText("***   Instalaciones de la FISI  ***");

        rol.setModel(new javax.swing.DefaultComboBoxModel<>());
        rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolActionPerformed(evt);

            }
        });

        jLabel8.setText("Rol");

        configB.setText("Config.");
        configB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(configB)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane3,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 508,
                                                                        Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Reservar,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(regresar,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(137, 137, 137)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addGap(44, 44, 44))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addGap(11, 11, 11)
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(jTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                143,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jTextField3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                143,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel8)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(rol,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        143,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jTextField2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        143,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel5)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jTextField4,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        143,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(29, 29, 29)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rol, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(2, 2, 2)
                                .addComponent(configB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(Reservar)
                                                .addGap(18, 18, 18)
                                                .addComponent(regresar)))
                                .addContainerGap(27, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rolActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rolActionPerformed
        String rol_ = (String) rol.getSelectedItem();
        actualizarListaDesplegable(rol_);
    }// GEN-LAST:event_rolActionPerformed

    private void configBActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_configBActionPerformed
        // Crear el marco y agregar el panel del grafo
        grafo.crearYMostrarVentana();
    }// GEN-LAST:event_configBActionPerformed

    private void ReservarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ReservarActionPerformed
        try {
            String nombre = jTextField3.getText();
            String codigoStr = jTextField1.getText();
            int codigo;
            try {
                codigo = Integer.parseInt(codigoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El código debe ser un número entero.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean estado = Boolean.parseBoolean(jTextField2.getText());
            String prestador = jTextField4.getText();

            // Crear una nueva instalación y agregarla a la cola
            Instalacion instalacion = new Instalacion(nombre, codigo, estado, prestador);
            if (colaInstalaciones == null) {
                colaInstalaciones = new LinkedList<>();
            }
            colaInstalaciones.offer(instalacion);

            // Agregar una nueva fila a la tabla
            if (modeloInstalacion == null) {
                modeloInstalacion = (DefaultTableModel) jTable1.getModel();
            }
            // Agregar una nueva fila a la tabla
            Object[] fila = new Object[4];
            fila[0] = instalacion.getNombre();
            fila[1] = instalacion.getCodigo();
            fila[2] = instalacion.isEstado() ? "Ocupado" : "Libre";
            fila[3] = instalacion.getPrestador();
            modeloInstalacion.addRow(fila);

            // Limpiar los campos de texto
            jTextField1.setText("");
            jTextField3.setText("");
            jTextField2.setText("");
            jTextField4.setText("");

            // Actualizar la vista de la tabla
            jTable1.repaint();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para el código.",
                    "Error de entrada", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar la instalación: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_ReservarActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField4ActionPerformed
        String prestador = jTextField4.getText();
    }// GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
        int codigo = Integer.parseInt(jTextField3.getText());
    }// GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField2ActionPerformed
        boolean valor = true;
        boolean cadena = Boolean.parseBoolean(jTextField2.getText());
        // cadena será "true"
    }// GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        String nombre = jTextField1.getText();
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_regresarActionPerformed
        dispose();
    }// GEN-LAST:event_regresarActionPerformed

    private void agregarModeloTablaInstalacion() {
        modeloInstalacion.addColumn("Nombre_Instal..");
        modeloInstalacion.addColumn("Codigo _Instal..");
        modeloInstalacion.addColumn("Estado");
        modeloInstalacion.addColumn("Prestador");
        jTable1.setModel(modeloInstalacion);
    }

    public void agregarInstalacion(String nombre, int codigo, boolean estado, String prestador) {
        if (colaInstalaciones.size() < MAX_INSTALACIONES) {
            colaInstalaciones.offer(new Instalacion(nombre, codigo, estado, prestador));
        }

    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Instalacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instalacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instalacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instalacion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Instalaciones inst = new Instalaciones();
                // inst.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                inst.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reservar;
    public javax.swing.JButton configB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton regresar;
    public javax.swing.JComboBox<String> rol;
    // End of variables declaration//GEN-END:variables

}
