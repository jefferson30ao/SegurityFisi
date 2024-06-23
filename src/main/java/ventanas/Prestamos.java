package ventanas;

import Datos.Registro;
import Datos.RegistrarP;
import Entidades.Libro;
import Entidades.Prestar;
import Entidades.Revista;
import Entidades.Tesis;
import Entidades.Volumen;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Prestamos extends JFrame {

    private DefaultTableModel T;
    private JButton BBuscar;
    private JRadioButton TRevista;
    private JRadioButton TTesis;
    private JRadioButton Tlibro;
    private JButton back;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JLabel lb5;
    private JLabel lb6;
    private JLabel lb7;
    private JComboBox<String> options;
    private JButton registrarP;
    private JTable table;
    private JTextField txt6;
    private JTextField txtcodigo;
    private JTextField txtcodusuario;
    private JTextField txtfecha;
    private JTextField txtnombre;
    private JTextField txtprestador;
    

    public Prestamos() {
        initComponents();
        T = (DefaultTableModel) table.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        options = new javax.swing.JComboBox<>();
        txtprestador = new javax.swing.JTextField();
        lb2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        txtcodusuario = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();
        BBuscar = new javax.swing.JButton();
        lb7 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        registrarP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        Tlibro = new javax.swing.JRadioButton();
        TTesis = new javax.swing.JRadioButton();
        TRevista = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libro", "Tesis", "Revista" }));
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });

        txtprestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprestadorActionPerformed(evt);
            }
        });

        lb2.setText("Prestador");

        lb1.setText("Seleccionar");

        lb3.setText("Codigo de usuario");

        lb4.setText("Tipo");

        lb5.setText("Código");

        lb6.setText("Fecha");

        txtcodusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodusuarioActionPerformed(evt);
            }
        });

        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        BBuscar.setText("Buscar");
        BBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarActionPerformed(evt);
            }
        });

        lb7.setText("Ingrese titulo");

        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        registrarP.setText("Registrar Préstamo");
        registrarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        Tlibro.setText("Libro");
        Tlibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TlibroActionPerformed(evt);
            }
        });

        TTesis.setText("Tesis");
        TTesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTesisActionPerformed(evt);
            }
        });

        TRevista.setText("Revista");
        TRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRevistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BBuscar)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lb6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lb5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(lb4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtprestador, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addComponent(registrarP)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lb3)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtcodusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(Tlibro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TTesis, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprestador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb4)
                            .addComponent(Tlibro)
                            .addComponent(TTesis)
                            .addComponent(TRevista))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb6))
                        .addGap(33, 33, 33)
                        .addComponent(registrarP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lb7)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BBuscar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(back)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void txtprestadorActionPerformed(java.awt.event.ActionEvent evt) {                                             

    }                                            

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String titulo = this.txt6.getText();
        String tipo;
        boolean encontrado = false;
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado

        for (Volumen d : Registro.getListaDocumentos()) {
            if (d.getTitulo().equalsIgnoreCase(titulo)) { // Comparar ignorando mayúsculas y minúsculas
                encontrado = true;
                if (d instanceof Libro) {
                    tipo ="Libro";
                    Libro libro = (Libro) d;
                    T.setColumnIdentifiers(new Object[]{"ID", "Título", "Cantidad", "Tipo"});
                    T.addRow(new Object[]{libro.getCodigo(), libro.getTitulo(), libro.getCantidad(),tipo});
                } else if (d instanceof Revista) {
                    tipo ="Revista";
                    Revista revista = (Revista) d;
                    T.addRow(new Object[]{revista.getCodigo(),revista.getTitulo(), revista.getCantidad(),tipo});
                } else if (d instanceof Tesis) {
                    tipo ="Tesis";
                    Tesis tesis = (Tesis) d;
                    T.addRow(new Object[]{tesis.getCodigo(), tesis.getTitulo(), tesis.getCantidad(),tipo});
                }
                break; // Salir del bucle después de encontrar el primer documento
            }
        }
    }                                       


    private void optionsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String opVol = this.options.getSelectedItem().toString();
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado
        if (opVol.equals("Libro")) {
            T.setColumnIdentifiers(new Object[]{"ID", "Título", "Editorial", "Cantidad"});
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Libro) {
                    System.out.println(d.toString());
                    Libro libro = (Libro) d;
                    T.addRow(new Object[]{libro.getCodigo(), libro.getTitulo(), libro.getEditorial(), libro.getCantidad()});
                }
            }

        }
        if (opVol.equals("Revista")) {
            T.setColumnIdentifiers(new Object[]{"ID", "Area", "Título", "Cantidad"});
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Revista) {
                    System.out.println(d.toString());
                    Revista revista = (Revista) d;
                    T.addRow(new Object[]{revista.getCodigo(), revista.getArea(), revista.getTitulo(), revista.getCantidad()});
                }
            }
        }
        if (opVol.equals("Tesis")) {
            T.setColumnIdentifiers(new Object[]{"ID", "Grado", "Título", "Cantidad"});
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Tesis) {
                    System.out.println(d.toString());
                    Tesis tesis = (Tesis) d;
                    T.addRow(new Object[]{tesis.getCodigo(), tesis.getGrado(), tesis.getTitulo(), tesis.getCantidad()});
                }
            }
        }
    }                                       

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
        this.dispose(); // Cierra el JFrame actual (PANEL)
    }                                    

    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {                                     

    }                                    

    private void txtcodusuarioActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void registrarPActionPerformed(java.awt.event.ActionEvent evt) {                                           
    String tipo = "";
    String prestador = this.txtprestador.getText();
    String nombre = this.txtnombre.getText();
    int codUsu = Integer.parseInt(this.txtcodusuario.getText());
    if (Tlibro.isSelected()) {
        tipo = "Libro";
    } else if (TTesis.isSelected()) {
        tipo = "Tesis";
    } else if (TRevista.isSelected()) {
        tipo = "Revista";
    }
    int codigo = Integer.parseInt(this.txtcodigo.getText());
    String fecha = this.txtfecha.getText();
    Date fechaD;
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fechaD = dateFormat.parse(fecha);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "El formato de la periocidad no es válido. Debe estar en formato dd/MM/yyyy.");
        return; // Detener la ejecución del método si ocurre un error en la conversión
    }
    
    if (!Registro.verificarDisponibilidad(codigo, tipo)) {
        JOptionPane.showMessageDialog(this, "No hay suficientes ejemplares disponibles.");
        return; // Detener la ejecución si no hay disponibilidad
    } 
    
    Prestar P = new Prestar(prestador, tipo, codigo, fechaD, codUsu, nombre);
    if (RegistrarP.agregarPrestamo(P)) {
        Registro.actualizarCantidad(codigo, tipo);
    }
    }                                          

    private void TlibroActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (Tlibro.isSelected()) {
            TRevista.setEnabled(false);
            TTesis.setEnabled(false);
        } else {
            TRevista.setEnabled(true);
            TTesis.setEnabled(true);
        }
    }                                      

    private void TTesisActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (TTesis.isSelected()) {
            TRevista.setEnabled(false);
            Tlibro.setEnabled(false);
        } else {
            TRevista.setEnabled(true);
            Tlibro.setEnabled(true);
        }
    }                                      

    private void TRevistaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (TRevista.isSelected()) {
            TTesis.setEnabled(false);
            Tlibro.setEnabled(false);
        } else {
            TTesis.setEnabled(true);
            Tlibro.setEnabled(true);
        }
    }                                        

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

}
