/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Config;
import clases.UUID;
import Conexion.Conexion;
import Conexion.Control;
import Conexion.ObtenerFecha;
import Dao.transferenciaDAO;
import Dao.configuracionDAO;
import Dao.detalle_transferenciaDAO;
import Dao.sucursalDAO;
import Dao.productoDAO;
import Modelo.Tablas;
import Modelo.transferencia;
import Modelo.configuracion;
import Modelo.detalle_transferencia;
import Modelo.producto;
import Modelo.sucursal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.openide.util.Exceptions;

/**
 *
 */
public class transferencia_mercaderias extends javax.swing.JFrame {

    int nBuscar = 0;
    Conexion con = null;
    Statement stm = null;
    String idunico = null;
    Tablas modelo = new Tablas();
    Tablas modelodetalle = new Tablas();
    Tablas modelosucursal = new Tablas();
    Tablas modelogiraduria = new Tablas();
    Tablas modelocasa = new Tablas();
    Tablas modelocliente = new Tablas();
    JScrollPane scroll = new JScrollPane();
    private TableRowSorter trsfiltro, trsfiltrosuc, trsfiltrocli, trsfiltrogira, trsfiltrocasa;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat formatea = new DecimalFormat("###,###.##");
    DecimalFormat formatosinpunto = new DecimalFormat("############");
    DecimalFormat formatcantidad = new DecimalFormat("######.####");
    int nFila = 0;
    String cSql = null;
    ObtenerFecha ODate = new ObtenerFecha();
    Calendar c2 = new GregorianCalendar();
    String cTasa, referencia = null;

    /**
     * Creates new form Template
     */
    ImageIcon icononuevo = new ImageIcon("src/Iconos/nuevo.png");
    ImageIcon iconoeditar = new ImageIcon("src/Iconos/editar.png");
    ImageIcon iconoborrar = new ImageIcon("src/Iconos/eliminar.png");
    ImageIcon iconoprint = new ImageIcon("src/Iconos/impresora.png");
    ImageIcon iconosalir = new ImageIcon("src/Iconos/salir.png");
    ImageIcon iconobuscar = new ImageIcon("src/Iconos/buscar.png");
    ImageIcon icorefresh = new ImageIcon("src/Iconos/refrescar.png");
    ImageIcon imagenfondo = new ImageIcon("src/Iconos/producto.png");

    public transferencia_mercaderias() {
        initComponents();
        this.Agregar.setIcon(icononuevo);
        this.Modificar.setIcon(iconoeditar);
        this.Eliminar.setIcon(iconoborrar);
        this.Listar.setIcon(iconoprint);
        this.salir.setIcon(iconosalir);
        this.Salir.setIcon(iconosalir);
        this.buscarOrigen.setIcon(iconobuscar);
        this.BuscarProducto.setIcon(iconobuscar);
        this.refrescar.setIcon(icorefresh);
        this.creferencia.setVisible(false);
        //this.jTable1.setShowHorizontalLines(false);
        //  this.setAlwaysOnTop(true); Convierte en Modal un jFrame
        this.jTable1.setShowGrid(false);
        this.jTable1.setOpaque(true);
        this.jTable1.setBackground(new Color(204, 204, 255));
        this.jTable1.setForeground(Color.BLACK);
        this.setLocationRelativeTo(null); //Centramos el formulario
        this.idControl.setVisible(false);
        this.cModo.setVisible(false);
        this.nombreproducto.setEnabled(false);
        this.totalitem.setEnabled(false);
        this.idControl.setText("0");
        this.Inicializar();
        this.cargarTitulo();
        this.TituloDetalle();
        this.TitSuc();
        this.TituloProductos();
        GrillaMercaderia GrillaOC = new GrillaMercaderia();
        Thread HiloGrilla = new Thread(GrillaOC);
        HiloGrilla.start();
        GrillaSucursal grillasu = new GrillaSucursal();
        Thread hilosuc = new Thread(grillasu);
        hilosuc.start();

    }
    configuracionDAO configDAO = new configuracionDAO();
    configuracion configinicial = configDAO.consultar();
    Control hand = new Control();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detalle_ajuste = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        origen = new javax.swing.JTextField();
        buscarOrigen = new javax.swing.JButton();
        nombreorigen = new javax.swing.JTextField();
        numero = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        creferencia = new javax.swing.JTextField();
        destino = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        buscarDestino = new javax.swing.JButton();
        nombredestino = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabladetalle = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        grabar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        total = new javax.swing.JFormattedTextField();
        BSucursal = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        combosucursal = new javax.swing.JComboBox();
        jTBuscarSucursal = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablasucursal = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        AceptarSuc = new javax.swing.JButton();
        SalirSuc = new javax.swing.JButton();
        BCliente = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        combocliente = new javax.swing.JComboBox();
        jTBuscarCliente = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablacliente = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        AceptarCli = new javax.swing.JButton();
        SalirCli = new javax.swing.JButton();
        BProducto = new javax.swing.JDialog();
        jPanel17 = new javax.swing.JPanel();
        combogiraduria = new javax.swing.JComboBox();
        jTBuscarGiraduria = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaproducto = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        AceptarGir = new javax.swing.JButton();
        SalirGir = new javax.swing.JButton();
        item_entrada = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        codprod = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        BuscarProducto = new javax.swing.JButton();
        nombreproducto = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cantidad = new javax.swing.JFormattedTextField();
        costo = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        totalitem = new javax.swing.JFormattedTextField();
        cModo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        SalirItem = new javax.swing.JButton();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jComboBox1 = new javax.swing.JComboBox();
        buscarcadena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idControl = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Modificar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        Listar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        dInicial = new com.toedter.calendar.JDateChooser();
        dFinal = new com.toedter.calendar.JDateChooser();
        refrescar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        detalle_ajuste.setTitle(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.detalle_ajuste.title")); // NOI18N
        detalle_ajuste.setName("detalle_ajuste"); // NOI18N
        detalle_ajuste.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                detalle_ajusteFocusGained(evt);
            }
        });
        detalle_ajuste.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                detalle_ajusteWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        detalle_ajuste.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                detalle_ajusteWindowActivated(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setName("jPanel5"); // NOI18N

        jLabel12.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        origen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        origen.setName("origen"); // NOI18N
        origen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                origenFocusGained(evt);
            }
        });
        origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origenActionPerformed(evt);
            }
        });
        origen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                origenKeyPressed(evt);
            }
        });

        buscarOrigen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarOrigen.setName("buscarOrigen"); // NOI18N
        buscarOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarOrigenActionPerformed(evt);
            }
        });

        nombreorigen.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nombreorigen.setEnabled(false);
        nombreorigen.setName("nombreorigen"); // NOI18N

        numero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        numero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        numero.setEnabled(false);
        numero.setName("numero"); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        fecha.setName("fecha"); // NOI18N
        fecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fechaFocusGained(evt);
            }
        });
        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaKeyPressed(evt);
            }
        });

        creferencia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        creferencia.setEnabled(false);
        creferencia.setName("creferencia"); // NOI18N

        destino.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        destino.setName("destino"); // NOI18N
        destino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                destinoFocusGained(evt);
            }
        });
        destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinoActionPerformed(evt);
            }
        });
        destino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                destinoKeyPressed(evt);
            }
        });

        jLabel13.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        buscarDestino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarDestino.setName("buscarDestino"); // NOI18N
        buscarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDestinoActionPerformed(evt);
            }
        });

        nombredestino.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nombredestino.setEnabled(false);
        nombredestino.setName("nombredestino"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(buscarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombreorigen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(buscarDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombredestino, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(257, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(creferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(creferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(nombredestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreorigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setName("jPanel7"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tabladetalle.setModel(modelodetalle);
        tabladetalle.setName("tabladetalle"); // NOI18N
        tabladetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladetalleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabladetalleMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabladetalleMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabladetalle);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setName("jPanel8"); // NOI18N

        agregar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.agregar.text")); // NOI18N
        agregar.setName("agregar"); // NOI18N
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        editar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.editar.text")); // NOI18N
        editar.setName("editar"); // NOI18N
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        eliminar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.eliminar.text")); // NOI18N
        eliminar.setName("eliminar"); // NOI18N
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminar)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setName("jPanel10"); // NOI18N

        grabar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        grabar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.grabar.text")); // NOI18N
        grabar.setToolTipText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.grabar.toolTipText")); // NOI18N
        grabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grabar.setName("grabar"); // NOI18N
        grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Salir.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Salir.text")); // NOI18N
        Salir.setToolTipText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Salir.toolTipText")); // NOI18N
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.setName("Salir"); // NOI18N
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grabar)
                    .addComponent(Salir))
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jPanel11.border.title"))); // NOI18N
        jPanel11.setName("jPanel11"); // NOI18N

        total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        total.setEnabled(false);
        total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total.setName("total"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout detalle_ajusteLayout = new javax.swing.GroupLayout(detalle_ajuste.getContentPane());
        detalle_ajuste.getContentPane().setLayout(detalle_ajusteLayout);
        detalle_ajusteLayout.setHorizontalGroup(
            detalle_ajusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalle_ajusteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detalle_ajusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(detalle_ajusteLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(detalle_ajusteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(detalle_ajusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, Short.MAX_VALUE))
                        .addGap(161, 161, 161)))
                .addContainerGap())
        );
        detalle_ajusteLayout.setVerticalGroup(
            detalle_ajusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detalle_ajusteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(detalle_ajusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detalle_ajusteLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        BSucursal.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        BSucursal.setTitle("null");
        BSucursal.setName("BSucursal"); // NOI18N

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setName("jPanel13"); // NOI18N

        combosucursal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combosucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por Nombre", "Buscar por Código" }));
        combosucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combosucursal.setName("combosucursal"); // NOI18N
        combosucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosucursalActionPerformed(evt);
            }
        });

        jTBuscarSucursal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTBuscarSucursal.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.jTBuscarClientes.text")); // NOI18N
        jTBuscarSucursal.setName("jTBuscarSucursal"); // NOI18N
        jTBuscarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscarSucursalActionPerformed(evt);
            }
        });
        jTBuscarSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTBuscarSucursalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(combosucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTBuscarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combosucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBuscarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        tablasucursal.setModel(modelosucursal);
        tablasucursal.setName("tablasucursal"); // NOI18N
        tablasucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasucursalMouseClicked(evt);
            }
        });
        tablasucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablasucursalKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(tablasucursal);

        jPanel15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setName("jPanel15"); // NOI18N

        AceptarSuc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AceptarSuc.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.Aceptarcliente.text")); // NOI18N
        AceptarSuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AceptarSuc.setName("AceptarSuc"); // NOI18N
        AceptarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarSucActionPerformed(evt);
            }
        });

        SalirSuc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirSuc.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.SalirCliente.text")); // NOI18N
        SalirSuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SalirSuc.setName("SalirSuc"); // NOI18N
        SalirSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirSucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(AceptarSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(SalirSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarSuc)
                    .addComponent(SalirSuc))
                .addContainerGap())
        );

        javax.swing.GroupLayout BSucursalLayout = new javax.swing.GroupLayout(BSucursal.getContentPane());
        BSucursal.getContentPane().setLayout(BSucursalLayout);
        BSucursalLayout.setHorizontalGroup(
            BSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BSucursalLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BSucursalLayout.setVerticalGroup(
            BSucursalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BSucursalLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BCliente.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        BCliente.setTitle("null");
        BCliente.setName("BCliente"); // NOI18N

        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel14.setName("jPanel14"); // NOI18N

        combocliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combocliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por Nombre", "Buscar por Código", "Buscar por RUC" }));
        combocliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combocliente.setName("combocliente"); // NOI18N
        combocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboclienteActionPerformed(evt);
            }
        });

        jTBuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTBuscarCliente.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.jTBuscarClientes.text_2")); // NOI18N
        jTBuscarCliente.setName("jTBuscarCliente"); // NOI18N
        jTBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscarClienteActionPerformed(evt);
            }
        });
        jTBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTBuscarClienteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(combocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        tablacliente.setModel(modelocliente        );
        tablacliente.setName("tablacliente"); // NOI18N
        tablacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclienteMouseClicked(evt);
            }
        });
        tablacliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaclienteKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(tablacliente);

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setName("jPanel16"); // NOI18N

        AceptarCli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AceptarCli.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.Aceptarcliente.text_2")); // NOI18N
        AceptarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AceptarCli.setName("AceptarCli"); // NOI18N
        AceptarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarCliActionPerformed(evt);
            }
        });

        SalirCli.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirCli.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.SalirCliente.text_2")); // NOI18N
        SalirCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SalirCli.setName("SalirCli"); // NOI18N
        SalirCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(AceptarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(SalirCli, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarCli)
                    .addComponent(SalirCli))
                .addContainerGap())
        );

        javax.swing.GroupLayout BClienteLayout = new javax.swing.GroupLayout(BCliente.getContentPane());
        BCliente.getContentPane().setLayout(BClienteLayout);
        BClienteLayout.setHorizontalGroup(
            BClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BClienteLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BClienteLayout.setVerticalGroup(
            BClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BClienteLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BProducto.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        BProducto.setTitle("null");
        BProducto.setName("BProducto"); // NOI18N

        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setName("jPanel17"); // NOI18N

        combogiraduria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        combogiraduria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Buscar por Nombre", "Buscar por Código" }));
        combogiraduria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        combogiraduria.setName("combogiraduria"); // NOI18N
        combogiraduria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogiraduriaActionPerformed(evt);
            }
        });

        jTBuscarGiraduria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTBuscarGiraduria.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.jTBuscarClientes.text_1")); // NOI18N
        jTBuscarGiraduria.setName("jTBuscarGiraduria"); // NOI18N
        jTBuscarGiraduria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscarGiraduriaActionPerformed(evt);
            }
        });
        jTBuscarGiraduria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTBuscarGiraduriaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(combogiraduria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTBuscarGiraduria, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combogiraduria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBuscarGiraduria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        tablaproducto.setModel(modelogiraduria);
        tablaproducto.setName("tablaproducto"); // NOI18N
        tablaproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproductoMouseClicked(evt);
            }
        });
        tablaproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaproductoKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(tablaproducto);

        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setName("jPanel18"); // NOI18N

        AceptarGir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AceptarGir.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.Aceptarcliente.text_1")); // NOI18N
        AceptarGir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AceptarGir.setName("AceptarGir"); // NOI18N
        AceptarGir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarGirActionPerformed(evt);
            }
        });

        SalirGir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SalirGir.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "ventas.SalirCliente.text_1")); // NOI18N
        SalirGir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SalirGir.setName("SalirGir"); // NOI18N
        SalirGir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirGirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(AceptarGir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(SalirGir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarGir)
                    .addComponent(SalirGir))
                .addContainerGap())
        );

        javax.swing.GroupLayout BProductoLayout = new javax.swing.GroupLayout(BProducto.getContentPane());
        BProducto.getContentPane().setLayout(BProductoLayout);
        BProductoLayout.setHorizontalGroup(
            BProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BProductoLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BProductoLayout.setVerticalGroup(
            BProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BProductoLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        item_entrada.setTitle(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.item_entrada.title")); // NOI18N
        item_entrada.setName("item_entrada"); // NOI18N

        jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setName("jPanel21"); // NOI18N

        codprod.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codprod.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.codprod.text")); // NOI18N
        codprod.setName("codprod"); // NOI18N
        codprod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codprodFocusGained(evt);
            }
        });
        codprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codprodActionPerformed(evt);
            }
        });
        codprod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codprodKeyPressed(evt);
            }
        });

        jLabel25.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.jLabel14.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        BuscarProducto.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.BuscarProducto.text")); // NOI18N
        BuscarProducto.setName("BuscarProducto"); // NOI18N
        BuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProductoActionPerformed(evt);
            }
        });

        nombreproducto.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.nombreproducto.text")); // NOI18N
        nombreproducto.setEnabled(false);
        nombreproducto.setName("nombreproducto"); // NOI18N

        jLabel26.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.jLabel15.text")); // NOI18N
        jLabel26.setName("jLabel26"); // NOI18N

        cantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        cantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidad.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.codprod.text")); // NOI18N
        cantidad.setName("cantidad"); // NOI18N
        cantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidadFocusLost(evt);
            }
        });
        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadKeyPressed(evt);
            }
        });

        costo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        costo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        costo.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.codprod.text")); // NOI18N
        costo.setName("costo"); // NOI18N
        costo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                costoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                costoFocusLost(evt);
            }
        });
        costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costoActionPerformed(evt);
            }
        });
        costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                costoKeyPressed(evt);
            }
        });

        jLabel28.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.jLabel17.text")); // NOI18N
        jLabel28.setName("jLabel28"); // NOI18N

        totalitem.setEditable(false);
        totalitem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        totalitem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalitem.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.codprod.text")); // NOI18N
        totalitem.setEnabled(false);
        totalitem.setName("totalitem"); // NOI18N

        cModo.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.codprod.text")); // NOI18N
        cModo.setName("cModo"); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalitem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(176, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(codprod, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cModo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codprod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(cModo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(11, 11, 11)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setName("jPanel22"); // NOI18N

        Guardar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.NuevoItem.text")); // NOI18N
        Guardar.setBorder(null);
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.setName("Guardar"); // NOI18N
        Guardar.setPreferredSize(new java.awt.Dimension(39, 20));
        Guardar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GuardarFocusGained(evt);
            }
        });
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        SalirItem.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "detalle_facturas.SalirItem.text")); // NOI18N
        SalirItem.setBorder(null);
        SalirItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SalirItem.setName("SalirItem"); // NOI18N
        SalirItem.setPreferredSize(new java.awt.Dimension(21, 20));
        SalirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(SalirItem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalirItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout item_entradaLayout = new javax.swing.GroupLayout(item_entrada.getContentPane());
        item_entrada.getContentPane().setLayout(item_entradaLayout);
        item_entradaLayout.setHorizontalGroup(
            item_entradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        item_entradaLayout.setVerticalGroup(
            item_entradaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(item_entradaLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.title")); // NOI18N
        setName("frame_clientes"); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        panel1.setColorPrimario(new java.awt.Color(2, 88, 43));
        panel1.setColorSecundario(new java.awt.Color(2, 88, 43));
        panel1.setName("panel1"); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Número", "Sucursal" }));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buscarcadena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buscarcadena.setName("buscarcadena"); // NOI18N
        buscarcadena.setSelectionColor(new java.awt.Color(0, 63, 62));
        buscarcadena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarcadenaKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        idControl.setEditable(false);
        idControl.setName("idControl"); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(buscarcadena, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(idControl, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarcadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(idControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel2.setBackground(new java.awt.Color(2, 88, 43));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(2, 88, 43));
        jPanel2.setName("jPanel2"); // NOI18N

        Modificar.setBackground(new java.awt.Color(255, 255, 255));
        Modificar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Modificar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Modificar.text")); // NOI18N
        Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Modificar.setName("Modificar"); // NOI18N
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Agregar.setBackground(new java.awt.Color(255, 255, 255));
        Agregar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Agregar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Agregar.text")); // NOI18N
        Agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Agregar.setName("Agregar"); // NOI18N
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Eliminar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Eliminar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Eliminar.text")); // NOI18N
        Eliminar.setToolTipText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Eliminar.toolTipText")); // NOI18N
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.setName("Eliminar"); // NOI18N
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        Listar.setBackground(new java.awt.Color(255, 255, 255));
        Listar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Listar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Listar.text")); // NOI18N
        Listar.setToolTipText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.Listar.toolTipText")); // NOI18N
        Listar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Listar.setName("Listar"); // NOI18N
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        salir.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.salir.text")); // NOI18N
        salir.setToolTipText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.salir.toolTipText")); // NOI18N
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.setName("salir"); // NOI18N
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(2, 88, 43));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "libroventaconsolidado.jPanel2.border.title_1"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        dInicial.setName("dInicial"); // NOI18N

        dFinal.setName("dFinal"); // NOI18N

        refrescar.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.refrescar.text")); // NOI18N
        refrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refrescar.setName("refrescar"); // NOI18N
        refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(org.openide.util.NbBundle.getMessage(transferencia_mercaderias.class, "transferencia_mercaderias.jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(dInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refrescar)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Listar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Modificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Eliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Listar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setName("jScrollPane1"); // NOI18N
        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusGained(evt);
            }
        });

        jTable1.setModel(modelo);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setSelectionBackground(new java.awt.Color(51, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 255));
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Inicializar() {
        this.dInicial.setCalendar(c2);
        this.dFinal.setCalendar(c2);
    }

    public void limpiarCombos() {

    }

    private void jComboBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void buscarcadenaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_buscarcadenaKeyPressed
        this.buscarcadena.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (buscarcadena.getText()).toUpperCase();
                buscarcadena.setText(cadena);
                int indiceColumnaTabla = 0;
                switch (jComboBox1.getSelectedIndex()) {
                    case 0:
                        indiceColumnaTabla = 1;
                        break;//por numero
                    case 1:
                        indiceColumnaTabla = 3;
                        break;//por sucursal
                }
                repaint();
                filtro(indiceColumnaTabla);
            }
        });
        trsfiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(trsfiltro);
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarcadenaKeyPressed

    private void salirActionPerformed(ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

    public void sumatoria() {
        ///ESTE PROCEDIMIENTO USAMOS PARA REALIZAR LAS SUMATORIAS DE
        ///CADA CELDA
        double sumtotal = 0.00;
        double sumatoria = 0.00;
        String cValorImporte = "";
        int totalRow = this.tabladetalle.getRowCount();
        totalRow -= 1;
        for (int i = 0; i <= (totalRow); i++) {
            //Primero capturamos el porcentaje del IVA
            //Luego capturamos el importe de la celda total del item
            cValorImporte = String.valueOf(this.tabladetalle.getValueAt(i, 4));
            cValorImporte = cValorImporte.replace(".", "").replace(",", ".");
            sumatoria = Double.valueOf(cValorImporte);
            sumtotal += sumatoria;
            //Calculamos el total de exentos
        }
        tabladetalle.setRowSorter(new TableRowSorter(modelodetalle));
        int cantFilas = tabladetalle.getRowCount();
        if (cantFilas > 0) {
            eliminar.setEnabled(true);
            editar.setEnabled(true);
        } else {
            eliminar.setEnabled(false);
            editar.setEnabled(false);
        }
        total.setText(formatea.format(sumtotal));
    }


    private void AgregarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        UUID id = new UUID();
        idunico = UUID.crearUUID();
        idunico = idunico.substring(1, 25);
        creferencia.setText(idunico);
        numero.setText("0");
        creferencia.setText("");
        this.limpiar();
        detalle_ajuste.setModal(true);
        detalle_ajuste.setSize(1058, 680);
        //Establecemos un título para el jDialog
        detalle_ajuste.setTitle("Detalle de Mercaderia");
        detalle_ajuste.setLocationRelativeTo(null);
        detalle_ajuste.setVisible(true);
        origen.requestFocus();
          }//GEN-LAST:event_AgregarActionPerformed

    public void limpiar() {
        this.origen.setText(String.valueOf(configinicial.getSucursaldefecto().getCodigo()));
        this.nombreorigen.setText(configinicial.getSucursaldefecto().getNombre());
        this.creferencia.setText("");
        this.fecha.setCalendar(c2);
        this.editar.setEnabled(false);
        this.eliminar.setEnabled(false);
        this.codprod.setEnabled(true);
        this.total.setText("");
        int cantidadRegistro = modelodetalle.getRowCount();
        for (int i = 1; i <= cantidadRegistro; i++) {
            modelodetalle.removeRow(0);
        }

    }
    private void jTable1KeyPressed(KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int nFila = this.jTable1.getSelectedRow();
        this.idControl.setText(this.jTable1.getValueAt(nFila, 0).toString());
        // TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void ModificarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

        if (Config.nNivelUsuario < 3) {
            nFila = this.jTable1.getSelectedRow();
            if (nFila < 0) {
                JOptionPane.showMessageDialog(null,
                        "Debe seleccionar una fila de la tabla");
                return;
            }

            int nFila = this.jTable1.getSelectedRow();
            this.idControl.setText(this.jTable1.getValueAt(nFila, 0).toString());

            transferenciaDAO veDAO = new transferenciaDAO();
            transferencia ve = null;
            try {
                ve = veDAO.buscarString(this.idControl.getText());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
            }
            BigDecimal nCantidad, nCosto, nTotal = new BigDecimal(0);

            if (ve != null) {
                //SE CARGAN LOS DATOS DE LA CABECERA
                creferencia.setText(ve.getIdtransferencia());
                origen.setText(String.valueOf(ve.getOrigen()));
                nombreorigen.setText(ve.getNombreorigen());
                destino.setText(String.valueOf(ve.getDestino()));
                nombredestino.setText(ve.getNombredestino());
                numero.setText(formatosinpunto.format(ve.getNumero()));
                fecha.setDate(ve.getFecha());

                // SE CARGAN LOS DETALLES
                int cantidadRegistro = modelodetalle.getRowCount();
                for (int i = 1; i <= cantidadRegistro; i++) {
                    modelodetalle.removeRow(0);
                }

                detalle_transferenciaDAO detDAO = new detalle_transferenciaDAO();
                try {
                    for (detalle_transferencia detvta : detDAO.MostrarDetalle(creferencia.getText())) {
                        nCantidad = detvta.getCantidad();
                        nCosto = detvta.getCosto();
                        nTotal = nCosto.multiply(nCantidad);
                        String Detalle[] = {formatea.format(detvta.getProducto().getCodigo()),
                            detvta.getProducto().getNombre(),
                            formatcantidad.format(detvta.getCantidad()),
                            formatea.format(detvta.getCosto()),
                            formatea.format(nTotal)};
                        modelodetalle.addRow(Detalle);
                    }
                    this.sumatoria();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                }

                int cantFilas = tabladetalle.getRowCount();
                if (cantFilas > 0) {
                    editar.setEnabled(true);
                    eliminar.setEnabled(true);
                } else {
                    editar.setEnabled(false);
                    eliminar.setEnabled(false);
                }

                detalle_ajuste.setModal(true);
                detalle_ajuste.setSize(1058, 680);
                //Establecemos un título para el jDialog
                detalle_ajuste.setTitle("Modificar Transferencias");
                detalle_ajuste.setLocationRelativeTo(null);
                detalle_ajuste.setVisible(true);
                origen.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "La Operación ya no puede Modificarse");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no Autorizado");
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void jTable1FocusGained(FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusGained

    private void jScrollPane1FocusGained(FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1FocusGained

    private void formWindowGainedFocus(WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowActivated(WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formFocusGained(FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void EliminarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int nFila = jTable1.getSelectedRow();
        String num = jTable1.getValueAt(nFila, 0).toString();
        String cAsiento = jTable1.getValueAt(nFila, 5).toString();

        if (Config.nNivelUsuario == 1) {
            Object[] opciones = {"   Si   ", "   No   "};
            int ret = JOptionPane.showOptionDialog(null, "Desea Eliminar el Registro ? ", "Confirmación", 0, 3, null, opciones, opciones[0]);
            if (ret == 0) {
                //BORRAMOS ASIENTO CONTABLE

                detalle_transferenciaDAO detDAO = new detalle_transferenciaDAO();
                transferenciaDAO cabDAO = new transferenciaDAO();
                try {
                    if (num == null) {
                        JOptionPane.showMessageDialog(null, "Registro no Existe");
                    } else {
                        detDAO.borrarDetalleSalida(num);
                        cabDAO.borrarAjustes(num);
                        JOptionPane.showMessageDialog(null, "Registro Eliminado Exitosamente");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "USUARIO NO AUTORIZADO");
        }
        GrillaMercaderia GrillaOC = new GrillaMercaderia();
        Thread HiloGrilla = new Thread(GrillaOC);
        HiloGrilla.start();
    }//GEN-LAST:event_EliminarActionPerformed

    private void jTable1FocusLost(FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1FocusLost

    private void ListarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_ListarActionPerformed
        GenerarReporte GenerarReporte = new GenerarReporte();
        Thread HiloReporte = new Thread(GenerarReporte);
        HiloReporte.start();
    }//GEN-LAST:event_ListarActionPerformed

    private void SalirActionPerformed(ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        detalle_ajuste.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void grabarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_grabarActionPerformed
        //Se inicia Proceso de Grabado de Registro
        //Se instancian las clases necesarias asociadas al modelado de Orden de Credito

        if (origen.getText().equals("0") || origen.getText().isEmpty()) {
            this.origen.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese Datos de la Sucursal");
            return;
        }

        String cTotal = total.getText();
        cTotal = cTotal.replace(".", "").replace(",", ".");

        if (Double.valueOf(cTotal) > 0) {
            Object[] opciones = {"  Si   ", "   No   "};
            int ret = JOptionPane.showOptionDialog(null, "Confirmar la Operación ? ", "Confirmación", 0, 3, null, opciones, opciones[0]);
            if (ret == 0) {
                Date Fecha = ODate.de_java_a_sql(fecha.getDate());

                sucursalDAO sucDAO = new sucursalDAO();
                sucursal suc = null;
                try {
                    suc = sucDAO.buscarId(Integer.valueOf(this.origen.getText()));
                } catch (SQLException ex) {
                    Exceptions.printStackTrace(ex);
                }

                transferenciaDAO ajDAO = new transferenciaDAO();
                transferencia aju = new transferencia();
                if (this.creferencia.getText().isEmpty()) {
                    referencia = UUID.crearUUID();
                    referencia = referencia.substring(1, 25);
                } else {
                    referencia = this.creferencia.getText();
                }
                aju.setIdtransferencia(referencia);
                aju.setFecha(Fecha);
                aju.setOrigen(Integer.valueOf(origen.getText()));
                aju.setDestino(Integer.valueOf(destino.getText()));
                String cCosto = null;
                String cCantidad = null;
                String cPrecio = null;

                int totalRow = modelodetalle.getRowCount();
                totalRow -= 1;

                String detalle = "[";

                for (int i = 0; i <= (totalRow); i++) {
                    String cProducto = String.valueOf(modelodetalle.getValueAt(i, 0));
                    cCantidad = String.valueOf(modelodetalle.getValueAt(i, 2));
                    cCantidad = cCantidad.replace(".", "").replace(",", ".");
                    cCosto = String.valueOf(modelodetalle.getValueAt(i, 3));
                    cCosto = cCosto.replace(".", "").replace(",", ".");

                    String linea = "{dreferencia : " + referencia + ","
                            + "producto : '" + cProducto + "',"
                            + "cantidad : " + cCantidad + ","
                            + "costo : " + cCosto + ","
                            + "suc_salida : " + origen.getText() + ","
                            + "suc_entrada : " + destino.getText()
                            + "},";
                    detalle += linea;
                }
                if (!detalle.equals("[")) {
                    detalle = detalle.substring(0, detalle.length() - 1);
                }
                detalle += "]";
                System.out.println(detalle);
                if (Integer.valueOf(this.numero.getText()) == 0) {
                    try {
                        ajDAO.insertarmercaderia(aju, detalle);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error BD: " + e.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
                } else {
                    //Actualizar Orden de Credito
                    detalle_transferenciaDAO detDAO = new detalle_transferenciaDAO();
                    try {
                        detDAO.borrarDetalleSalida(referencia);
                        ajDAO.actualizarSalida(aju, detalle);
                    } catch (SQLException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                    //   grabarOCR.ActualizarOrdenCredito(cr, detalle);
                    JOptionPane.showMessageDialog(null, "Datos Agregados Correctamente");
                }
                detalle_ajuste.setVisible(false);
                this.detalle_ajuste.setModal(false);
                this.refrescar.doClick();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay Productos en el Detalle");
        }
    }//GEN-LAST:event_grabarActionPerformed

    private void detalle_ajusteFocusGained(FocusEvent evt) {//GEN-FIRST:event_detalle_ajusteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_detalle_ajusteFocusGained

    private void detalle_ajusteWindowGainedFocus(WindowEvent evt) {//GEN-FIRST:event_detalle_ajusteWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_detalle_ajusteWindowGainedFocus

    private void detalle_ajusteWindowActivated(WindowEvent evt) {//GEN-FIRST:event_detalle_ajusteWindowActivated

        // TODO add your handling code here:
    }//GEN-LAST:event_detalle_ajusteWindowActivated

    private void jTable1PropertyChange(PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

    private void refrescarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_refrescarActionPerformed
        GrillaMercaderia GrillaOC = new GrillaMercaderia();
        Thread HiloGrilla = new Thread(GrillaOC);
        HiloGrilla.start();        // TODO add your handling code here:
    }//GEN-LAST:event_refrescarActionPerformed

    private void origenKeyPressed(KeyEvent evt) {//GEN-FIRST:event_origenKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            this.fecha.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_origenKeyPressed

    private void fechaFocusGained(FocusEvent evt) {//GEN-FIRST:event_fechaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFocusGained

    private void fechaKeyPressed(KeyEvent evt) {//GEN-FIRST:event_fechaKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            this.agregar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            this.origen.requestFocus();
        }   // TODO add your handling code 
        // TODO add your handling code here:*/
    }//GEN-LAST:event_fechaKeyPressed

    private void buscarOrigenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buscarOrigenActionPerformed
        nBuscar = 1;
        sucursalDAO sucDAO = new sucursalDAO();
        sucursal sucu = null;
        try {
            sucu = sucDAO.buscarId(Integer.valueOf(this.origen.getText()));
            if (sucu.getCodigo() == 0) {
                BSucursal.setModal(true);
                BSucursal.setSize(500, 575);
                BSucursal.setLocationRelativeTo(null);
                BSucursal.setTitle("Buscar Sucursal");
                BSucursal.setVisible(true);
                BSucursal.setModal(false);
            } else {
                nombreorigen.setText(sucu.getNombre());
                //Establecemos un título para el jDialog
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        this.destino.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarOrigenActionPerformed

    private void origenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_origenActionPerformed
        this.buscarOrigen.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_origenActionPerformed

    private void comboclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboclienteActionPerformed

    private void jTBuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBuscarClienteKeyPressed
        this.jTBuscarCliente.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jTBuscarCliente.getText()).toUpperCase();
                jTBuscarCliente.setText(cadena);
                int indiceColumnaTabla = 0;
                switch (combocliente.getSelectedIndex()) {
                    case 0:
                        indiceColumnaTabla = 1;
                        break;//por nombre
                    case 1:
                        indiceColumnaTabla = 0;
                        break;//por codigo
                    case 2:
                        indiceColumnaTabla = 3;
                        break;//por RUC
                }
                repaint();
                filtrocli(indiceColumnaTabla);
            }
        });
        trsfiltrocli = new TableRowSorter(tablacliente.getModel());
        tablacliente.setRowSorter(trsfiltrocli);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarClienteKeyPressed

    private void tablaclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaclienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.AceptarCli.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaclienteKeyPressed

    private void AceptarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarCliActionPerformed
        int nFila = this.tablacliente.getSelectedRow();
        /*        this.cliente.setText(this.tablacliente.getValueAt(nFila, 0).toString());
        this.nombrecliente.setText(this.tablacliente.getValueAt(nFila, 1).toString());
        this.direccioncliente.setText(this.tablacliente.getValueAt(nFila, 2).toString());
        this.BCliente.setVisible(false);
        this.jTBuscarCliente.setText("");*/
//        this.giraduria.requestFocus();

        // TODO add your handling code here:
    }//GEN-LAST:event_AceptarCliActionPerformed

    private void SalirCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirCliActionPerformed
        this.BCliente.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirCliActionPerformed

    private void combogiraduriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogiraduriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combogiraduriaActionPerformed

    private void jTBuscarGiraduriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscarGiraduriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarGiraduriaActionPerformed

    private void jTBuscarGiraduriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBuscarGiraduriaKeyPressed
        this.jTBuscarGiraduria.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jTBuscarGiraduria.getText()).toUpperCase();
                jTBuscarGiraduria.setText(cadena);
                int indiceColumnaTabla = 0;
                switch (combogiraduria.getSelectedIndex()) {
                    case 0:
                        indiceColumnaTabla = 1;
                        break;//por nombre
                    case 1:
                        indiceColumnaTabla = 0;
                        break;//por codigo
                }
                repaint();
                filtrogira(indiceColumnaTabla);
            }
        });
        trsfiltrogira = new TableRowSorter(tablaproducto.getModel());
        tablaproducto.setRowSorter(trsfiltrogira);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarGiraduriaKeyPressed

    private void tablaproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaproductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.AceptarGir.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaproductoKeyPressed

    private void AceptarGirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarGirActionPerformed
        int nFila = this.tablaproducto.getSelectedRow();
        this.codprod.setText(this.tablaproducto.getValueAt(nFila, 0).toString());
        this.nombreproducto.setText(this.tablaproducto.getValueAt(nFila, 1).toString());
        this.costo.setText(this.tablaproducto.getValueAt(nFila, 2).toString());

        this.BProducto.setVisible(false);
        this.jTBuscarGiraduria.setText("");
        this.cantidad.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_AceptarGirActionPerformed

    private void SalirGirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirGirActionPerformed
        this.BProducto.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirGirActionPerformed

    private void jTBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarClienteActionPerformed

    private void tablaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclienteMouseClicked
        this.AceptarCli.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaclienteMouseClicked

    private void tablaproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaproductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaproductoMouseClicked

    private void SalirSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirSucActionPerformed
        this.BSucursal.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirSucActionPerformed

    private void AceptarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarSucActionPerformed
        if (nBuscar == 1) {
            int nFila = this.tablasucursal.getSelectedRow();
            this.origen.setText(this.tablasucursal.getValueAt(nFila, 0).toString());
            this.nombreorigen.setText(this.tablasucursal.getValueAt(nFila, 1).toString());
            this.destino.requestFocus();
        } else {
            int nFila = this.tablasucursal.getSelectedRow();
            this.destino.setText(this.tablasucursal.getValueAt(nFila, 0).toString());
            this.nombredestino.setText(this.tablasucursal.getValueAt(nFila, 1).toString());
            this.fecha.requestFocus();
        }
        this.BSucursal.setVisible(false);
        this.jTBuscarSucursal.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_AceptarSucActionPerformed

    private void tablasucursalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablasucursalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.AceptarSuc.doClick();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tablasucursalKeyPressed

    private void tablasucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasucursalMouseClicked
        this.AceptarSuc.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_tablasucursalMouseClicked

    private void jTBuscarSucursalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBuscarSucursalKeyPressed
        this.jTBuscarSucursal.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (jTBuscarSucursal.getText()).toUpperCase();
                jTBuscarSucursal.setText(cadena);
                int indiceColumnaTabla = 0;
                switch (combosucursal.getSelectedIndex()) {
                    case 0:
                        indiceColumnaTabla = 1;
                        break;//por nombre
                    case 1:
                        indiceColumnaTabla = 0;
                        break;//por codigo
                    case 2:
                        indiceColumnaTabla = 2;
                        break;//por RUC
                }
                repaint();
                filtrosuc(indiceColumnaTabla);
            }
        });
        trsfiltrosuc = new TableRowSorter(tablasucursal.getModel());
        tablasucursal.setRowSorter(trsfiltrosuc);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarSucursalKeyPressed

    private void jTBuscarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscarSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBuscarSucursalActionPerformed

    private void combosucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combosucursalActionPerformed

    private void origenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_origenFocusGained
        origen.selectAll();

        // TODO add your handling code here:
    }//GEN-LAST:event_origenFocusGained

    private void codprodFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codprodFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_codprodFocusGained

    private void codprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codprodActionPerformed
        BuscarProducto.doClick();
    }//GEN-LAST:event_codprodActionPerformed

    private void codprodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codprodKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            //Si pulso enter o cursor abajo obtiene el foco el sgte objeto
            this.cantidad.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
//            this.vendedor.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_codprodKeyPressed

    private void BuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProductoActionPerformed

        productoDAO proDAO = new productoDAO();
        producto pro = null;
        try {
            pro = proDAO.buscarId(Integer.valueOf(this.codprod.getText()));
            if (pro.getCodigo() == 0) {
                GrillaProductos grillapr = new GrillaProductos();
                Thread hilopr = new Thread(grillapr);
                hilopr.start();
                BProducto.setModal(true);
                BProducto.setSize(500, 575);
                BProducto.setLocationRelativeTo(null);
                BProducto.setTitle("Buscar Producto");
                BProducto.setVisible(true);
                BProducto.setModal(false);
            } else {
                nombreproducto.setText(pro.getNombre());
                costo.setText(formatea.format(pro.getCosto()));
                //Establecemos un título para el jDialog
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        // TODO add your handling code here:       

//this.cantidad.requestFocus();       

    }//GEN-LAST:event_BuscarProductoActionPerformed

    private void cantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadFocusGained
        cantidad.selectAll();
    }//GEN-LAST:event_cantidadFocusGained

    private void cantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            //Si pulso enter o cursor abajo obtiene el foco el sgte objeto
            this.costo.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            this.codprod.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadKeyPressed

    private void costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costoActionPerformed
        String cCantidad = this.cantidad.getText();
        cCantidad = cCantidad.replace(".", "").replace(",", ".");
        String cPrecio = this.costo.getText();
        cPrecio = cPrecio.replace(".", "").replace(",", ".");
        double ntotal = Double.valueOf(cCantidad) * Double.valueOf(cPrecio);
        this.totalitem.setText(formatea.format(ntotal));
        // TODO add your handling code here:
    }//GEN-LAST:event_costoActionPerformed

    private void costoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoKeyPressed
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            //Si pulso enter o cursor abajo obtiene el foco el sgte objeto
            this.Guardar.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            this.cantidad.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_costoKeyPressed

    private void GuardarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuardarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarFocusGained

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed

        if (this.cModo.getText().isEmpty()) {
            Object[] fila = new Object[7];
            fila[0] = this.codprod.getText().toString();
            fila[1] = this.nombreproducto.getText().toString();
            fila[2] = this.cantidad.getText();
            fila[3] = this.costo.getText();
            fila[4] = this.totalitem.getText();
            modelodetalle.addRow(fila);
            this.codprod.requestFocus();
        } else {
            this.tabladetalle.setValueAt(this.codprod.getText(), nFila, 0);
            this.tabladetalle.setValueAt(this.nombreproducto.getText(), nFila, 1);
            this.tabladetalle.setValueAt(this.cantidad.getText(), nFila, 2);
            this.tabladetalle.setValueAt(this.costo.getText(), nFila, 3);
            this.tabladetalle.setValueAt(this.totalitem.getText(), nFila, 4);
            nFila = 0;
            this.SalirItem.doClick();
        }
        this.limpiaritems();
        this.sumatoria();
        // TODO add your handling code here:*/
    }//GEN-LAST:event_GuardarActionPerformed

    private void SalirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirItemActionPerformed
        item_entrada.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirItemActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        item_entrada.setSize(440, 265);
        item_entrada.setLocationRelativeTo(null);
        this.limpiaritems();
        this.Guardar.setText("Agregar");
        this.cModo.setText("");
        item_entrada.setModal(true);
        item_entrada.setVisible(true);
        codprod.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarActionPerformed

    private void costoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_costoFocusGained
        costo.selectAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_costoFocusGained

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        nFila = this.tabladetalle.getSelectedRow();
        if (nFila < 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla");
            return;
        }
        item_entrada.setSize(440, 265);
        item_entrada.setLocationRelativeTo(null);
        this.cModo.setText(String.valueOf(nFila));
        this.codprod.setText(this.tabladetalle.getValueAt(this.tabladetalle.getSelectedRow(), 0).toString());
        this.nombreproducto.setText(this.tabladetalle.getValueAt(this.tabladetalle.getSelectedRow(), 1).toString());
        this.cantidad.setText(this.tabladetalle.getValueAt(this.tabladetalle.getSelectedRow(), 2).toString());
        this.costo.setText(this.tabladetalle.getValueAt(this.tabladetalle.getSelectedRow(), 3).toString());
        this.totalitem.setText(this.tabladetalle.getValueAt(this.tabladetalle.getSelectedRow(), 4).toString());
        item_entrada.setModal(true);
        item_entrada.setVisible(true);
        codprod.requestFocus();
        codprod.requestFocus();

        // TODO add your handling code here:*/
    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int a = this.tabladetalle.getSelectedRow();
        if (a < 0) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla");
        } else {
            int confirmar = JOptionPane.showConfirmDialog(null,
                    "Esta seguro que desea Eliminar el registro? ");
            if (JOptionPane.OK_OPTION == confirmar) {
                modelodetalle.removeRow(a);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                this.sumatoria();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void tabladetalleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladetalleMouseEntered

        // TODO add your handling code here:*/
    }//GEN-LAST:event_tabladetalleMouseEntered

    private void costoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_costoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_costoFocusLost

    private void tabladetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladetalleMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_tabladetalleMouseClicked

    private void tabladetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladetalleMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabladetalleMousePressed

    private void cantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadFocusLost
        String cCantidad = cantidad.getText();
        cCantidad = cCantidad.replace(".", ",");
        cantidad.setText(cCantidad);
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadFocusLost

    private void destinoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_destinoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoFocusGained

    private void destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinoActionPerformed
        this.buscarDestino.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoActionPerformed

    private void destinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_destinoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinoKeyPressed

    private void buscarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDestinoActionPerformed
        nBuscar = 2;
        sucursalDAO sucDAO = new sucursalDAO();
        sucursal sucu = null;
        try {
            sucu = sucDAO.buscarId(Integer.valueOf(this.destino.getText()));
            if (sucu.getCodigo() == 0) {
                BSucursal.setModal(true);
                BSucursal.setSize(500, 575);
                BSucursal.setLocationRelativeTo(null);
                BSucursal.setTitle("Buscar Sucursal");
                BSucursal.setVisible(true);
                BSucursal.setModal(false);
            } else {
                nombredestino.setText(sucu.getNombre());
                //Establecemos un título para el jDialog
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage());
        }
        this.fecha.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarDestinoActionPerformed
    private void limpiaritems() {
        this.codprod.setText("0");
        this.cantidad.setText("0");
        this.nombreproducto.setText("");
        this.costo.setText("0");
        this.totalitem.setText("0");
    }

    public void filtro(int nNumeroColumna) {
        trsfiltro.setRowFilter(RowFilter.regexFilter(buscarcadena.getText(), nNumeroColumna));
    }

    public void filtrosuc(int nNumeroColumna) {
        trsfiltrosuc.setRowFilter(RowFilter.regexFilter(this.jTBuscarSucursal.getText(), nNumeroColumna));
    }

    public void filtrocli(int nNumeroColumna) {
        trsfiltrocli.setRowFilter(RowFilter.regexFilter(this.jTBuscarCliente.getText(), nNumeroColumna));
    }

    public void filtrogira(int nNumeroColumna) {
        trsfiltrogira.setRowFilter(RowFilter.regexFilter(this.jTBuscarGiraduria.getText(), nNumeroColumna));
    }

    private void cargarTitulo() {
        modelo.addColumn("IdRef");
        modelo.addColumn("Número");
        modelo.addColumn("Fecha");
        modelo.addColumn("Destino");
        modelo.addColumn("Origen");
        int[] anchos = {3, 100, 120,150,150};
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            this.jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
        TablaRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // aqui defines donde alinear 

        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// Este código es para centrar las cabeceras de la tabla.
        jTable1.getTableHeader().setFont(new Font("Arial Black", 1, 9));

        this.jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        this.jTable1.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTable1.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        this.jTable1.getColumnModel().getColumn(1).setCellRenderer(TablaRenderer);
        this.jTable1.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
    }

    private void TituloDetalle() {
        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
        TablaRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // aqui defines donde alinear 
        modelodetalle.addColumn("Codigo");
        modelodetalle.addColumn("Descripción");
        modelodetalle.addColumn("Cantidad");
        modelodetalle.addColumn("Costo");
        modelodetalle.addColumn("Total");
        int[] anchos = {90, 200, 100, 100, 100};
        for (int i = 0; i < modelodetalle.getColumnCount(); i++) {
            tabladetalle.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        ((DefaultTableCellRenderer) tabladetalle.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// Este código es para centrar las cabeceras de la tabla.
        tabladetalle.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        tabladetalle.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tabladetalle.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
        //Se usa para poner invisible una determinada celda

        tabladetalle.getTableHeader().setFont(new Font("Arial Black", 1, 10));

        Font font = new Font("Arial", Font.BOLD, 10);
        tabladetalle.setFont(font);
    }

    private void TitSuc() {
        modelosucursal.addColumn("Código");
        modelosucursal.addColumn("Nombre");

        int[] anchos = {90, 200};
        for (int i = 0; i < modelosucursal.getColumnCount(); i++) {
            tablasucursal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        ((DefaultTableCellRenderer) tablasucursal.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// Este código es para centrar las cabeceras de la tabla.
        tablasucursal.getTableHeader().setFont(new Font("Arial Black", 1, 10));

        // Hacemos Invisible la Celda de Costos de los Productos
        Font font = new Font("Arial", Font.BOLD, 9);
        this.tablasucursal.setFont(font);

        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
        TablaRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // aqui defines donde alinear 
        this.tablasucursal.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
    }

    private void TitClie() {
        modelocliente.addColumn("Código");
        modelocliente.addColumn("Nombre");
        modelocliente.addColumn("Dirección");
        modelocliente.addColumn("RUC");

        int[] anchos = {90, 150, 100, 100};
        for (int i = 0; i < modelocliente.getColumnCount(); i++) {
            tablacliente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        ((DefaultTableCellRenderer) tablacliente.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// Este código es para centrar las cabeceras de la tabla.
        tablacliente.getTableHeader().setFont(new Font("Arial Black", 1, 10));

        // Hacemos Invisible la Celda de Costos de los Productos
        Font font = new Font("Arial", Font.BOLD, 9);
        this.tablacliente.setFont(font);

        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
        TablaRenderer.setHorizontalAlignment(SwingConstants.RIGHT); // aqui defines donde alinear 
        this.tablacliente.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
    }

    private void TituloProductos() {
        modelogiraduria.addColumn("Código");
        modelogiraduria.addColumn("Descripción");
        modelogiraduria.addColumn("Costo");

        int[] anchos = {90, 200, 100};
        for (int i = 0; i < modelogiraduria.getColumnCount(); i++) {
            tablaproducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        ((DefaultTableCellRenderer) tablaproducto.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);// Este código es para centrar las cabeceras de la tabla.
        tablaproducto.getTableHeader().setFont(new Font("Arial Black", 1, 11));

        // Hacemos Invisible la Celda de Costos de los Productos
        Font font = new Font("Arial", Font.BOLD, 9);
        this.tablaproducto.setFont(font);
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
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {    //</editor-fold>
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transferencia_mercaderias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarCli;
    private javax.swing.JButton AceptarGir;
    private javax.swing.JButton AceptarSuc;
    private javax.swing.JButton Agregar;
    private javax.swing.JDialog BCliente;
    private javax.swing.JDialog BProducto;
    private javax.swing.JDialog BSucursal;
    private javax.swing.JButton BuscarProducto;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Listar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Salir;
    private javax.swing.JButton SalirCli;
    private javax.swing.JButton SalirGir;
    private javax.swing.JButton SalirItem;
    private javax.swing.JButton SalirSuc;
    private javax.swing.JButton agregar;
    private javax.swing.JButton buscarDestino;
    private javax.swing.JButton buscarOrigen;
    private javax.swing.JTextField buscarcadena;
    private javax.swing.JTextField cModo;
    private javax.swing.JFormattedTextField cantidad;
    private javax.swing.JTextField codprod;
    private javax.swing.JComboBox combocliente;
    private javax.swing.JComboBox combogiraduria;
    private javax.swing.JComboBox combosucursal;
    private javax.swing.JFormattedTextField costo;
    private javax.swing.JTextField creferencia;
    private com.toedter.calendar.JDateChooser dFinal;
    private com.toedter.calendar.JDateChooser dInicial;
    private javax.swing.JTextField destino;
    private javax.swing.JDialog detalle_ajuste;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton grabar;
    private javax.swing.JTextField idControl;
    private javax.swing.JDialog item_entrada;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTBuscarCliente;
    private javax.swing.JTextField jTBuscarGiraduria;
    private javax.swing.JTextField jTBuscarSucursal;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombredestino;
    private javax.swing.JTextField nombreorigen;
    private javax.swing.JTextField nombreproducto;
    private javax.swing.JFormattedTextField numero;
    private javax.swing.JTextField origen;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JButton refrescar;
    private javax.swing.JButton salir;
    private javax.swing.JTable tablacliente;
    private javax.swing.JTable tabladetalle;
    private javax.swing.JTable tablaproducto;
    private javax.swing.JTable tablasucursal;
    private javax.swing.JFormattedTextField total;
    private javax.swing.JFormattedTextField totalitem;
    // End of variables declaration//GEN-END:variables

    private class GenerarReporte extends Thread {

        public void run() {
            con = new Conexion();
            stm = con.conectar();
            try {
                Map parameters = new HashMap();
                //Ahora que hay parametros le enviamos uno con el mismo nombre del que creamos
                //en el reporte
                int nFila = jTable1.getSelectedRow();
                String cReferencia = jTable1.getValueAt(nFila, 0).toString();

                parameters.put("cNombreEmpresa", Config.cNombreEmpresa);
                parameters.put("cReferencia", cReferencia);
                JasperReport jr = null;
                URL url = getClass().getClassLoader().getResource("Reports/ticket_transferencias.jasper");
                //URL url = getClass().getClassLoader().getResource("Reports/" + Config.cNombreFactura.toString());
                jr = (JasperReport) JRLoader.loadObject(url);
                JasperPrint masterPrint = null;
                //Se le incluye el parametro con el nombre parameters porque asi lo definimos
                masterPrint = JasperFillManager.fillReport(jr, parameters, stm.getConnection());
                JasperViewer ventana = new JasperViewer(masterPrint, false);
                ventana.setTitle("Vista Previa");
                ventana.setVisible(true);
            } catch (Exception e) {
                JDialog.setDefaultLookAndFeelDecorated(true);
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
            }
        }

    }

    private class GrillaMercaderia extends Thread {

        public void run() {

            Date dFechaInicio = ODate.de_java_a_sql(dInicial.getDate());
            Date dFechaFinal = ODate.de_java_a_sql(dFinal.getDate());

            //Antes de Cargar el Jtable Ajustamos el ancho de las columnas con el Ancho que se nos antoje
            int cantidadRegistro = modelo.getRowCount();
            for (int i = 1; i <= cantidadRegistro; i++) {
                modelo.removeRow(0);
            }

            transferenciaDAO DAO = new transferenciaDAO();
            try {
                for (transferencia ajuste : DAO.MostrarxFechaTransferencia(dFechaInicio, dFechaFinal)) {
                    String Datos[] = {ajuste.getIdtransferencia(), String.valueOf(ajuste.getNumero()), formatoFecha.format(ajuste.getFecha()), ajuste.getNombredestino(), ajuste.getNombreorigen()};
                    modelo.addRow(Datos);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }

            jTable1.setRowSorter(new TableRowSorter(modelo));
            int cantFilas = jTable1.getRowCount();
            if (cantFilas > 0) {
                Modificar.setEnabled(true);
                Eliminar.setEnabled(true);
                Listar.setEnabled(true);
            } else {
                Modificar.setEnabled(false);
                Eliminar.setEnabled(false);
                Listar.setEnabled(false);
            }
        }
    }

    private class GrillaSucursal extends Thread {

        public void run() {

            //Antes de Cargar el Jtable Ajustamos el ancho de las columnas con el Ancho que se nos antoje
            int cantidadRegistro = modelosucursal.getRowCount();
            for (int i = 1; i <= cantidadRegistro; i++) {
                modelosucursal.removeRow(0);
            }

            sucursalDAO DAOSUC = new sucursalDAO();
            try {
                for (sucursal suc : DAOSUC.todos()) {
                    String Datos[] = {String.valueOf(suc.getCodigo()), suc.getNombre()};
                    modelosucursal.addRow(Datos);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }

            tablasucursal.setRowSorter(new TableRowSorter(modelosucursal));
            int cantFilas = tablasucursal.getRowCount();
        }
    }

    private class GrillaProductos extends Thread {

        public void run() {

            //Antes de Cargar el Jtable Ajustamos el ancho de las columnas con el Ancho que se nos antoje
            int cantidadRegistro = modelogiraduria.getRowCount();
            for (int i = 1; i <= cantidadRegistro; i++) {
                modelogiraduria.removeRow(0);
            }
            productoDAO DAOpro = new productoDAO();
            try {
                for (producto pr : DAOpro.todos()) {
                    String Datos[] = {String.valueOf(pr.getCodigo()), pr.getNombre(), formatea.format(pr.getCosto())};
                    modelogiraduria.addRow(Datos);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            }

            tablaproducto.setRowSorter(new TableRowSorter(modelogiraduria));
            int cantFilas = tablaproducto.getRowCount();
        }
    }

}
