package ventanas;

import Datos.RegistrarP;
import Datos.Registro;
import Entidades.Libro;
import Entidades.Prestar;
import Entidades.Revista;
import Entidades.Tesis;
import Entidades.Volumen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Devolucion extends JFrame {

    private JTextField DcodDoc;
    private JTextField DcodUsu;
    private JRadioButton Dlibro;
    private JRadioButton Drevista;
    private JRadioButton Dtesis;
    private JButton RegistroDev;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private ButtonGroup tipoGrupo;

    public Devolucion() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        DcodUsu = new JTextField(20);
        Dlibro = new JRadioButton("Libro");
        Dtesis = new JRadioButton("Tesis");
        Drevista = new JRadioButton("Revista");
        DcodDoc = new JTextField(20);
        RegistroDev = new JButton("Registrar devolución");
        jButton2 = new JButton("Back");
        tipoGrupo = new ButtonGroup();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingrese el código de usuario");
        jLabel2.setText("Ingrese el tipo");
        jLabel3.setText("Ingrese el código del documento");

        DcodUsu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DcodUsuActionPerformed(evt);
            }

            private void DcodUsuActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

        Dlibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DlibroActionPerformed(evt);
            }
        });

        Dtesis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DtesisActionPerformed(evt);
            }
        });

        Drevista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DrevistaActionPerformed(evt);
            }
        });

        RegistroDev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegistroDevActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tipoGrupo.add(Dlibro);
        tipoGrupo.add(Dtesis);
        tipoGrupo.add(Drevista);

        // Configurar layout del panel
        jPanel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        jPanel1.add(jLabel1, gbc);

        gbc.gridx = 1;
        jPanel1.add(DcodUsu, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        jPanel1.add(jLabel2, gbc);

        gbc.gridx = 1;
        jPanel1.add(Dlibro, gbc);

        gbc.gridx = 2;
        jPanel1.add(Dtesis, gbc);

        gbc.gridx = 3;
        jPanel1.add(Drevista, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        jPanel1.add(jLabel3, gbc);

        gbc.gridx = 1;
        jPanel1.add(DcodDoc, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        jPanel1.add(RegistroDev, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        jPanel1.add(jButton2, gbc);

        // Configurar el frame
        add(jPanel1);
        setTitle("Devolución de Material");
        setSize(500, 400);
        setLocationRelativeTo(null);
    }


    private void RegistroDevActionPerformed(ActionEvent evt) {
        int codUsu = Integer.parseInt(this.DcodUsu.getText());
        int codDoc = Integer.parseInt(this.DcodDoc.getText());
        boolean documentoEncontrado = false;

        if (Dlibro.isSelected()) {
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Libro && d.getCodigo() == codDoc) {
                    Libro libro = (Libro) d;
                    libro.setCantidad(libro.getCantidad() + 1);
                    JOptionPane.showMessageDialog(this, "Cantidad de libros aumentada satisfactoriamente");
                    documentoEncontrado = true;
                    break;
                }
            }
        } else if (Dtesis.isSelected()) {
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Tesis && d.getCodigo() == codDoc) {
                    Tesis tesis = (Tesis) d;
                    tesis.setCantidad(tesis.getCantidad() + 1);
                    JOptionPane.showMessageDialog(this, "Cantidad de tesis aumentada satisfactoriamente");
                    documentoEncontrado = true;
                    break;
                }
            }
        } else if (Drevista.isSelected()) {
            for (Volumen d : Registro.getListaDocumentos()) {
                if (d instanceof Revista && d.getCodigo() == codDoc) {
                    Revista revista = (Revista) d;
                    revista.setCantidad(revista.getCantidad() + 1);
                    JOptionPane.showMessageDialog(this, "Cantidad de revistas aumentada satisfactoriamente");
                    documentoEncontrado = true;
                    break;
                }
            }
        }

        if (documentoEncontrado) {
            // Verificar y eliminar el registro de préstamo del usuario
            boolean prestamoEncontrado = false;
            for (Prestar P : RegistrarP.getRegistros()) {
                if (P.getCodigoU() == codUsu && P.getCodigo() == codDoc) {  // Asegúrate de que Prestar tiene un método getCodigoDoc()
                    RegistrarP.eliminarPrestamo(P.getCodigo());
                    prestamoEncontrado = true;
                    break;
                }
            }
            if (!prestamoEncontrado) {
                JOptionPane.showMessageDialog(this, "No se encontró un préstamo con el código de usuario especificado.");
            }
        } else {
            // Si no se encuentra el documento
            JOptionPane.showMessageDialog(this, "No se encontró un documento con el código especificado.");
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void DlibroActionPerformed(ActionEvent evt) {
        if (Dlibro.isSelected()) {
            Drevista.setEnabled(false);
            Dtesis.setEnabled(false);
        } else {
            Drevista.setEnabled(true);
            Dtesis.setEnabled(true);
        }
    }

    private void DtesisActionPerformed(ActionEvent evt) {
        if (Dtesis.isSelected()) {
            Drevista.setEnabled(false);
            Dlibro.setEnabled(false);
        } else {
            Drevista.setEnabled(true);
            Dlibro.setEnabled(true);
        }
    }

    private void DrevistaActionPerformed(ActionEvent evt) {
        if (Dlibro.isSelected()) {
            Drevista.setEnabled(false);
            Dtesis.setEnabled(false);
        } else {
            Drevista.setEnabled(true);
            Dtesis.setEnabled(true);
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Devolucion().setVisible(true);
            }
        });
    }
}
