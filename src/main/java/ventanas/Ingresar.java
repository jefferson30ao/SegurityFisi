package ventanas;

import Datos.Registro;
import Entidades.Libro;
import Entidades.Revista;
import Entidades.Tesis;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ingresar extends JFrame {

    private JButton B1;
    private JButton btnIngresar;
    private JComboBox<String> cbxTipo;
    private JLabel jLabel1;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JTextField txtArea;
    private JTextField txtAsesor;
    private JTextField txtCodigo;
    private JTextField txtEditorial;
    private JTextField txtGrado;
    private JTextField txtMateria;
    private JTextField txtPais;
    private JTextField txtPeriodicidad;
    private JTextField txtSeccion;
    private JTextField txtTitulo;
    private JTextField txtVolumen;
    private JTextField txtpaginas;

    public Ingresar() {
        initComponents();
    }

    private void initComponents() {

        jPanel4 = new JPanel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        cbxTipo = new JComboBox<>();
        jPanel3 = new JPanel();
        btnIngresar = new JButton();
        B1 = new JButton();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        txtCodigo = new JTextField(20);
        txtTitulo = new JTextField(20);
        txtPais = new JTextField(20);
        txtSeccion = new JTextField(20);
        txtpaginas = new JTextField(20);
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        txtEditorial = new JTextField(20);
        txtMateria = new JTextField(20);
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        txtVolumen = new JTextField(20);
        txtPeriodicidad = new JTextField(20);
        txtArea = new JTextField(20);
        txtGrado = new JTextField(20);
        txtAsesor = new JTextField(20);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        jPanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        jLabel1.setText("Tipo de documento");

        cbxTipo.setModel(new DefaultComboBoxModel<>(new String[] { "Seleccione", "Libro", "Revista", "Tesis" }));
        cbxTipo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                cbxTipoMouseClicked(evt);
            }
        });
        cbxTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jLabel1)
                    .addGap(57, 57, 57)
                    .addComponent(cbxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        B1.setText("Back");
        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnIngresar)
                        .addComponent(B1))
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(btnIngresar)
                    .addGap(18, 18, 18)
                    .addComponent(B1)
                    .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        jLabel2.setText("Código");
        jLabel3.setText("Título");
        jLabel4.setText("País");
        jLabel5.setText("Sección");
        jLabel6.setText("Número de páginas");
        jLabel7.setText("Editorial");
        jLabel8.setText("Materia");
        jLabel13.setText("Volumen");
        jLabel14.setText("Periodicidad");
        jLabel15.setText("Área");
        jLabel16.setText("Grado");
        jLabel17.setText("Asesor");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtpaginas)
                        .addComponent(txtSeccion)
                        .addComponent(txtPais)
                        .addComponent(txtTitulo)
                        .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
                    .addGap(81, 81, 81)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
                    .addGap(28, 28, 28)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtAsesor, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVolumen, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEditorial, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(txtMateria))
                        .addComponent(txtPeriodicidad, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtArea, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGrado, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtTitulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtVolumen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtSeccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtPeriodicidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)))
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtGrado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtpaginas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtAsesor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(56, Short.MAX_VALUE))
        );

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(31, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(25, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void formWindowOpened(WindowEvent evt) {
        this.txtCodigo.setEnabled(false);
        this.txtTitulo.setEnabled(false);
        this.txtPais.setEnabled(false);
        this.txtSeccion.setEnabled(false);
        this.txtpaginas.setEnabled(false);
        this.txtEditorial.setEnabled(false);
        this.txtMateria.setEnabled(false);
        this.txtVolumen.setEnabled(false);
        this.txtPeriodicidad.setEnabled(false);
        this.txtArea.setEnabled(false);
        this.txtGrado.setEnabled(false);
        this.txtAsesor.setEnabled(false);
        this.btnIngresar.setEnabled(false);
    }

    private void cbxTipoActionPerformed(ActionEvent evt) {
        String opcion = this.cbxTipo.getSelectedItem().toString();
        if (opcion.equals("Seleccione")) {
            this.txtCodigo.setEnabled(false);
            this.txtTitulo.setEnabled(false);
            this.txtPais.setEnabled(false);
            this.txtSeccion.setEnabled(false);
            this.txtpaginas.setEnabled(false);
            this.txtEditorial.setEnabled(false);
            this.txtMateria.setEnabled(false);
            this.txtVolumen.setEnabled(false);
            this.txtPeriodicidad.setEnabled(false);
            this.txtArea.setEnabled(false);
            this.txtGrado.setEnabled(false);
            this.txtAsesor.setEnabled(false);
            this.btnIngresar.setEnabled(false);
        }
        if (opcion.equals("Libro")) {
            this.txtCodigo.setEnabled(true);
            this.txtTitulo.setEnabled(true);
            this.txtPais.setEnabled(true);
            this.txtSeccion.setEnabled(true);
            this.txtpaginas.setEnabled(true);
            this.txtEditorial.setEnabled(true);
            this.txtMateria.setEnabled(true);
            this.txtVolumen.setEnabled(false);
            this.txtPeriodicidad.setEnabled(false);
            this.txtArea.setEnabled(false);
            this.txtGrado.setEnabled(false);
            this.txtAsesor.setEnabled(false);
            this.btnIngresar.setEnabled(true);
        }
        if (opcion.equals("Revista")) {
            this.txtCodigo.setEnabled(true);
            this.txtTitulo.setEnabled(true);
            this.txtPais.setEnabled(true);
            this.txtSeccion.setEnabled(true);
            this.txtpaginas.setEnabled(true);
            this.txtEditorial.setEnabled(false);
            this.txtMateria.setEnabled(false);
            this.txtVolumen.setEnabled(true);
            this.txtPeriodicidad.setEnabled(true);
            this.txtArea.setEnabled(true);
            this.txtGrado.setEnabled(false);
            this.txtAsesor.setEnabled(false);
            this.btnIngresar.setEnabled(true);
        }
        if (opcion.equals("Tesis")) {
            this.txtCodigo.setEnabled(true);
            this.txtTitulo.setEnabled(true);
            this.txtPais.setEnabled(true);
            this.txtSeccion.setEnabled(true);
            this.txtpaginas.setEnabled(true);
            this.txtEditorial.setEnabled(false);
            this.txtMateria.setEnabled(false);
            this.txtVolumen.setEnabled(false);
            this.txtPeriodicidad.setEnabled(false);
            this.txtArea.setEnabled(false);
            this.txtGrado.setEnabled(true);
            this.txtAsesor.setEnabled(true);
            this.btnIngresar.setEnabled(true);
        }
    }

    private void cbxTipoMouseClicked(MouseEvent evt) {

    }

    private void btnIngresarActionPerformed(ActionEvent evt) {
        try {
            String titulo = this.txtTitulo.getText();
            int codigo = Integer.parseInt(this.txtCodigo.getText());
            String pais = this.txtPais.getText();
            int cantidad = Integer.parseInt(this.txtSeccion.getText());
            int num = Integer.parseInt(this.txtpaginas.getText());
            String opDoc = this.cbxTipo.getSelectedItem().toString();
    
            if (titulo.isEmpty() || pais.isEmpty() || this.txtCodigo.getText().isEmpty() || 
                this.txtSeccion.getText().isEmpty() || this.txtpaginas.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.");
                return;
            }
    
            if (opDoc.equals("Libro")) {
                String editorial = this.txtEditorial.getText();
                String materia = this.txtMateria.getText();
                if (editorial.isEmpty() || materia.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos para Libro.");
                    return;
                }
                Libro li = new Libro(editorial, materia, titulo, codigo, pais, cantidad, num);
                Registro.agregarDoc(li);
            } else if (opDoc.equals("Revista")) {
                int volumen = Integer.parseInt(this.txtVolumen.getText());
                String periocidad = this.txtPeriodicidad.getText();
                String area = this.txtArea.getText();
                if (periocidad.isEmpty() || area.isEmpty() || this.txtVolumen.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos para Revista.");
                    return;
                }
                Date periodicidad;
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    periodicidad = dateFormat.parse(periocidad);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "El formato de la periodicidad no es válido. Debe estar en formato dd/MM/yyyy.");
                    return; // Detener la ejecución del método si ocurre un error en la conversión
                }
                Revista re = new Revista(volumen, periodicidad, area, titulo, codigo, pais, cantidad, num);
                Registro.agregarDoc(re);
            } else if (opDoc.equals("Tesis")) {
                String grado = this.txtGrado.getText();
                String asesor = this.txtAsesor.getText();
                if (grado.isEmpty() || asesor.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos para Tesis.");
                    return;
                }
                Tesis T = new Tesis(grado, asesor, titulo, codigo, pais, cantidad, num);
                Registro.agregarDoc(T);
            }
    
            JOptionPane.showMessageDialog(this, "Documento ingresado correctamente.");
    
            // Limpiar campos
            this.txtTitulo.setText("");
            this.txtCodigo.setText("");
            this.txtPais.setText("");
            this.txtSeccion.setText("");
            this.txtpaginas.setText("");
            this.cbxTipo.setSelectedIndex(0); // Establece la selección del ComboBox al primer elemento
    
            // Limpieza de campos específicos según el tipo de documento
            if (opDoc.equals("Libro")) {
                this.txtEditorial.setText("");
                this.txtMateria.setText("");
            } else if (opDoc.equals("Revista")) {
                this.txtVolumen.setText("");
                this.txtPeriodicidad.setText("");
                this.txtArea.setText("");
            } else if (opDoc.equals("Tesis")) {
                this.txtGrado.setText("");
                this.txtAsesor.setText("");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos en los campos numéricos.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
        }
    }
    

    private void B1ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar().setVisible(true);
            }
        });
    }
}
