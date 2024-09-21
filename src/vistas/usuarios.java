/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Dao.usuarioDAO;
import Modelo.Tablas;
import Modelo.usuario;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jorge
 */
public class usuarios extends javax.swing.JFrame {

    Tablas modelo = new Tablas();
    ImageIcon iconograbar = new ImageIcon("src/Iconos/grabar.png");
    ImageIcon icononuevo = new ImageIcon("src/Iconos/nuevo.png");
    ImageIcon iconoeditar = new ImageIcon("src/Iconos/editar.png");
    ImageIcon iconoborrar = new ImageIcon("src/Iconos/eliminar.png");
    ImageIcon iconoprint = new ImageIcon("src/Iconos/impresora.png");
    ImageIcon iconosalir = new ImageIcon("src/Iconos/salir.png");
    ImageIcon iconoean = new ImageIcon("src/Iconos/pencil.png");
    ImageIcon iconobuscar = new ImageIcon("src/Iconos/buscar.png");
    private TableRowSorter trsfiltro;
    int indiceTabla;

    /**
     * Creates new form usuarios
     */
    public usuarios() {
        initComponents();

        this.BotonAgregar.setIcon(icononuevo);
        this.BotonEditar.setIcon(iconoeditar);
        this.BotonSalir.setIcon(iconosalir);
        this.BotonCerrar.setIcon(iconosalir);
        this.BotonGrabar.setIcon(iconograbar);

        this.cargarTitulo();

        GrillaUsuarios GrillaUS = new GrillaUsuarios();
        Thread HiloGrilla = new Thread(GrillaUS);
        HiloGrilla.start();

        //SIRVE PARA CENTRAR EL FORMULARIO
        this.setLocationRelativeTo(null);

    }

    private void cargarTitulo() {
        modelo.addColumn("Código");
        modelo.addColumn("Nombre del Usuario");

        int[] anchos = {100, 250};
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            tablausuarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        ((DefaultTableCellRenderer) tablausuarios.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// Este código es para centrar las cabeceras de la tabla.
        tablausuarios.getTableHeader().setFont(new Font("Arial Black", 1, 11));

        Font font = new Font("Arial", Font.BOLD, 10);
        this.tablausuarios.setFont(font);

        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer AlinearCentro = new DefaultTableCellRenderer();
        TablaRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // aqui defines donde alinear 
        AlinearCentro.setHorizontalAlignment(SwingConstants.CENTER);
        this.tablausuarios.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detalle_usuarios = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        nivel = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clave = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        BotonGrabar = new javax.swing.JButton();
        BotonCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filtrar = new javax.swing.JComboBox<>();
        buscarcadena = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        BotonAgregar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Código");

        jLabel3.setText("Nombre");

        codigo.setEditable(false);
        codigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreKeyReleased(evt);
            }
        });

        jLabel4.setText("Login");

        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginKeyReleased(evt);
            }
        });

        nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Supervisor", "Operador" }));
        nivel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nivelKeyPressed(evt);
            }
        });

        jLabel5.setText("Nivel");

        jLabel6.setText("Password");

        clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                claveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(113, 113, 113))
                        .addComponent(login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(2, 88, 43));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Usuarios del Sistema");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(2, 88, 43));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonGrabar.setText("Grabar");
        BotonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGrabarActionPerformed(evt);
            }
        });

        BotonCerrar.setText("Salir");
        BotonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(BotonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGrabar)
                    .addComponent(BotonCerrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout detalle_usuariosLayout = new javax.swing.GroupLayout(detalle_usuarios.getContentPane());
        detalle_usuarios.getContentPane().setLayout(detalle_usuariosLayout);
        detalle_usuariosLayout.setHorizontalGroup(
            detalle_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        detalle_usuariosLayout.setVerticalGroup(
            detalle_usuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalle_usuariosLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios del Sistema");

        jPanel1.setBackground(new java.awt.Color(2, 88, 43));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuarios");

        filtrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nombre" }));

        buscarcadena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscarcadena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarcadenaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarcadenaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarcadena, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarcadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablausuarios.setModel(modelo);
        jScrollPane1.setViewportView(tablausuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel3.setBackground(new java.awt.Color(2, 88, 43));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonAgregar.setText("Agregar");
        BotonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });

        BotonEditar.setText("Actualizar");
        BotonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarActionPerformed(evt);
            }
        });

        BotonSalir.setText("Salir");
        BotonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BotonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(BotonAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
        //sirve para cerrar el formulario
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void buscarcadenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarcadenaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tablausuarios.requestFocus();
        }

        switch (filtrar.getSelectedIndex()) {
            case 0:
                indiceTabla = 0;
                break;//por nombre
            case 1:
                indiceTabla = 1;
                break;//por codigo
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarcadenaKeyPressed

    private void buscarcadenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarcadenaKeyReleased
        Filtro();
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarcadenaKeyReleased

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        this.limpiar();
        codigo.setEnabled(true);
        nombre.requestFocus();
        this.AbrirVentana();
        //Establecemos un título para el jDialog
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarActionPerformed
        this.limpiar();
        int nFila = this.tablausuarios.getSelectedRow();
        this.codigo.setText(this.tablausuarios.getValueAt(nFila, 0).toString());
        usuarioDAO usu = new usuarioDAO();
        usuario u = null;
        try {
            u = usu.buscarId(Integer.valueOf(codigo.getText()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        if (u != null) {
            nombre.setText(u.getDescripcion());
            login.setText(u.getLoginacceso());
            clave.setText(u.getPassword());
            nivel.setSelectedIndex(u.getId_tipo_usuario() - 1);
        }

        codigo.setEnabled(true);
        nombre.requestFocus();

        this.AbrirVentana();
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEditarActionPerformed

    private void BotonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGrabarActionPerformed
        if (this.nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre o Denominación del Usuario");
            this.nombre.requestFocus();
            return;
        }
        if (this.login.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el Login de Acceso del Usuario");
            this.login.requestFocus();
            return;
        }
        if (this.clave.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el Password de Acceso del Usuario");
            this.clave.requestFocus();
            return;
        }

        usuarioDAO grab = new usuarioDAO();
        usuario us = new usuario();
        us.setDescripcion(nombre.getText());
        us.setLoginacceso(login.getText());
        us.setPassword(clave.getText());
        us.setId_tipo_usuario(nivel.getSelectedIndex() + 1);
        us.setId_permisos(1);
        us.setId_interfaz(1);
        if (Integer.valueOf(codigo.getText()) > 0) {
            // Agregar nuevo Cliente
            try {
                us.setIdusuario(Integer.valueOf(codigo.getText()));
                grab.actualizarUsuarios(us);
                JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        } else {
            System.out.println("Entro para Agregar");
            try {
                grab.insertarUsuario(us);
                JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
            }
        }
        this.BotonCerrar.doClick();
        GrillaUsuarios GrillaUsuario = new GrillaUsuarios();
        Thread HiloGrilla = new Thread(GrillaUsuario);
        HiloGrilla.start();
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGrabarActionPerformed

    private void BotonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarActionPerformed
        this.detalle_usuarios.setModal(false);
        this.detalle_usuarios.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCerrarActionPerformed

    private void nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyReleased

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            this.login.requestFocus();
        }
    }//GEN-LAST:event_nombreKeyPressed

    private void loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_loginKeyReleased

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            this.clave.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            this.nombre.requestFocus();
        }   // TO          // TODO add your handling code here:
    }//GEN-LAST:event_loginKeyPressed

    private void claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            this.nivel.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            this.login.requestFocus();
        }   // TO          // TODO add your handling code here:
    }//GEN-LAST:event_claveKeyPressed

    private void nivelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nivelKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            this.BotonGrabar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            this.clave.requestFocus();
        }   // TO          // TODO add your handling code here:
    }//GEN-LAST:event_nivelKeyPressed

    private void limpiar() {
        this.codigo.setText("0");
        this.nombre.setText("");
        this.login.setText("");
        this.clave.setText("");
        this.nivel.setSelectedIndex(0);
    }

    private void AbrirVentana() {
        detalle_usuarios.setTitle("Usuarios del Sistema");
        detalle_usuarios.setModal(true);
        detalle_usuarios.setSize(400, 399);
        detalle_usuarios.setLocationRelativeTo(null);
        detalle_usuarios.setVisible(true);
    }

    private void Filtro() {
        trsfiltro = new TableRowSorter(tablausuarios.getModel());
        tablausuarios.setRowSorter(trsfiltro);
        trsfiltro.setRowFilter(RowFilter.regexFilter(buscarcadena.getText().toUpperCase(), indiceTabla));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonCerrar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonGrabar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JTextField buscarcadena;
    private javax.swing.JPasswordField clave;
    private javax.swing.JTextField codigo;
    private javax.swing.JDialog detalle_usuarios;
    private javax.swing.JComboBox<String> filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField login;
    private javax.swing.JComboBox<String> nivel;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tablausuarios;
    // End of variables declaration//GEN-END:variables

    private class GrillaUsuarios extends Thread {

        public void run() {

            //Antes de Cargar el Jtable Ajustamos el ancho de las columnas con el Ancho que se nos antoje
            int cantidadRegistro = modelo.getRowCount();
            for (int i = 1; i <= cantidadRegistro; i++) {
                modelo.removeRow(0);
            }

            usuarioDAO DAO = new usuarioDAO();
            try {
                for (usuario usu : DAO.todos()) {
                    String Datos[] = {String.valueOf(usu.getIdusuario()), usu.getDescripcion()};
                    modelo.addRow(Datos);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }
            tablausuarios.setRowSorter(new TableRowSorter(modelo));
            int cantFilas = tablausuarios.getRowCount();
            if (cantFilas > 0) {
                BotonEditar.setEnabled(true);
            } else {
                BotonEditar.setEnabled(false);
            }
            tablausuarios.requestFocus();
        }
    }
}
