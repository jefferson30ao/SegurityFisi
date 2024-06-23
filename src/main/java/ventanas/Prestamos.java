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

    private void initComponents() {

        jPanel1 = new JPanel();
        options = new JComboBox<>();
        txtprestador = new JTextField(20);
        lb2 = new JLabel();
        lb1 = new JLabel();
        lb3 = new JLabel();
        lb4 = new JLabel();
        lb5 = new JLabel();
        lb6 = new JLabel();
        txtcodusuario = new JTextField(20);
        txtcodigo = new JTextField(20);
        txtfecha = new JTextField(20);
        BBuscar = new JButton();
        lb7 = new JLabel();
        txt6 = new JTextField(20);
        back = new JButton();
        jScrollPane2 = new JScrollPane();
        table = new JTable();
        registrarP = new JButton();
        jLabel1 = new JLabel();
        txtnombre = new JTextField(20);
        Tlibro = new JRadioButton();
        TTesis = new JRadioButton();
        TRevista = new JRadioButton();
        ButtonGroup group = new ButtonGroup();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        options.setModel(new DefaultComboBoxModel<>(new String[] { "Libro", "Tesis", "Revista" }));
        options.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });

        lb2.setText("Prestador");

        lb1.setText("Seleccionar");

        lb3.setText("Código de usuario");

        lb4.setText("Tipo");

        lb5.setText("Código");

        lb6.setText("Fecha");

        BBuscar.setText("Buscar");
        BBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BBuscarActionPerformed(evt);
            }
        });

        lb7.setText("Ingrese título");

        back.setText("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Cantidad", "Tipo"
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
        registrarP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registrarPActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        group.add(Tlibro);
        Tlibro.setText("Libro");
        Tlibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TlibroActionPerformed(evt);
            }
        });

        group.add(TTesis);
        TTesis.setText("Tesis");
        TTesis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TTesisActionPerformed(evt);
            }
        });

        group.add(TRevista);
        TRevista.setText("Revista");
        TRevista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                TRevistaActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(lb1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(options, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(lb7, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt6, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BBuscar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(back))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(141, 141, 141)
                                    .addComponent(registrarP))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtprestador, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lb3)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtcodusuario))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lb4)
                                                .addGap(18, 18, 18)
                                                .addComponent(Tlibro, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TTesis, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TRevista, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lb5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtcodigo))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lb6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtfecha))))))))
                    .addGap(0, 37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(options, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb1))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtprestador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcodusuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb3))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lb4)
                        .addComponent(Tlibro)
                        .addComponent(TTesis)
                        .addComponent(TRevista))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb5))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb6))
                    .addGap(33, 33, 33)
                    .addComponent(registrarP)
                    .addContainerGap(63, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lb7)
                        .addComponent(txt6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(BBuscar))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back)
                    .addGap(13, 13, 13))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setTitle("Préstamos");
        setLocationRelativeTo(null);
    }

    private void BBuscarActionPerformed(ActionEvent evt) {
        String titulo = this.txt6.getText();
        String tipo;
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado

        for (Volumen d : Registro.getListaDocumentos()) {
            if (d.getTitulo().equalsIgnoreCase(titulo)) { // Comparar ignorando mayúsculas y minúsculas
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

    private void optionsActionPerformed(ActionEvent evt) {
        String opVol = this.options.getSelectedItem().toString();
        T.setRowCount(0); // Limpiar todas las filas antes de agregar el resultado
        if (opVol.equals("Libro")) {
            T.setColumnIdentifiers(new Object[]{"ID", "Título", "Editorial", "Cantidad"});
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Libro) {
                    Libro libro = (Libro) d;
                    T.addRow(new Object[]{libro.getCodigo(), libro.getTitulo(), libro.getEditorial(), libro.getCantidad()});
                }
            }

        }
        if (opVol.equals("Revista")) {
            T.setColumnIdentifiers(new Object[]{"ID", "Área", "Título", "Cantidad"});
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Revista) {
                    Revista revista = (Revista) d;
                    T.addRow(new Object[]{revista.getCodigo(), revista.getArea(), revista.getTitulo(), revista.getCantidad()});
                }
            }
        }
        if (opVol.equals("Tesis")) {
            T.setColumnIdentifiers(new Object[]{"ID", "Grado", "Título", "Cantidad"});
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Tesis) {
                    Tesis tesis = (Tesis) d;
                    T.addRow(new Object[]{tesis.getCodigo(), tesis.getGrado(), tesis.getTitulo(), tesis.getCantidad()});
                }
            }
        }
    }

    private void backActionPerformed(ActionEvent evt) {
        this.dispose(); // Cierra el JFrame actual (PANEL)
    }

    private void registrarPActionPerformed(ActionEvent evt) {
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
            JOptionPane.showMessageDialog(this, "El formato de la fecha no es válido. Debe estar en formato dd/MM/yyyy.");
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

    private void TlibroActionPerformed(ActionEvent evt) {
        if (Tlibro.isSelected()) {
            TRevista.setEnabled(false);
            TTesis.setEnabled(false);
        } else {
            TRevista.setEnabled(true);
            TTesis.setEnabled(true);
        }
    }

    private void TTesisActionPerformed(ActionEvent evt) {
        if (TTesis.isSelected()) {
            TRevista.setEnabled(false);
            Tlibro.setEnabled(false);
        } else {
            TRevista.setEnabled(true);
            Tlibro.setEnabled(true);
        }
    }

    private void TRevistaActionPerformed(ActionEvent evt) {
        if (TRevista.isSelected()) {
            TTesis.setEnabled(false);
            Tlibro.setEnabled(false);
        } else {
            TTesis.setEnabled(true);
            Tlibro.setEnabled(true);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }
}
