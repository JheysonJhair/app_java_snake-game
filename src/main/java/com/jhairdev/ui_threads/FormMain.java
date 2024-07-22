package com.jhairdev.ui_threads;

import com.jhairdev.utils.Panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Jhair
 */
public class FormMain extends javax.swing.JFrame {

    private final Cronometro cronometro;

    private CardLayout cardLayout = new CardLayout();
    protected static Panel[][] tablero;

    protected static int contadorMuertes;
    private Serpiente serpiente;

    private final int width;
    private final int height;
    private int velocidad;

    private Thread musicaFondoThread;
    private final String sonidoComerPath = "C:\\Users\\Jhair\\Documents\\NetBeansProjects\\app_pp_snake\\src\\main\\resources\\recursos\\sound\\fondo.mp3";

    public FormMain() {
        cronometro = new Cronometro();
        initComponents();
        this.setLocationRelativeTo(null);
        this.width = 70;
        this.height = 34;
        this.velocidad = 300;

        cardLayout = (CardLayout) pnlPrincipal.getLayout();
        cardLayout.show(pnlPrincipal, "PanelInicio");
    }

    private void crearTablero() {
        FormMain.tablero = new Panel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                FormMain.tablero[i][j] = new Panel(Color.WHITE, i * 20, j * 20, 20, 20);
                jPanelTablero.add(tablero[i][j]);
            }
        }
    }

    private void reproducirMusicaFondo() {
        musicaFondoThread = new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(sonidoComerPath);
                Player player = new Player(fis);
                player.play();

            } catch (JavaLayerException | IOException e) {
            }
        });
        musicaFondoThread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupDificultad = new javax.swing.ButtonGroup();
        buttonGroupTamaño = new javax.swing.ButtonGroup();
        buttonGroupVelocidad = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        lblAjusVelocidad = new javax.swing.JLabel();
        rbVelBaja = new javax.swing.JRadioButton();
        rbVelMedia = new javax.swing.JRadioButton();
        rbVelAlta = new javax.swing.JRadioButton();
        btnComenzar = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlInfo = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jPanelSerpienteInfo = new javax.swing.JPanel();
        jLabelSerpienteInfo = new javax.swing.JLabel();
        jPanelManzanInfo = new javax.swing.JPanel();
        jLabelManzanaInfo = new javax.swing.JLabel();
        jLabelClockImgInfo = new javax.swing.JLabel();
        btnVolverInfo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pnlJuego = new javax.swing.JPanel();
        jPanelTablero = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblTiempoDato = new javax.swing.JLabel();
        lblManzanas = new javax.swing.JLabel();
        lblManzanasDato = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        lblPuntuacionDato = new javax.swing.JLabel();
        lblMuertes = new javax.swing.JLabel();
        lblMuertesDato = new javax.swing.JLabel();
        btnDetenerJuego = new javax.swing.JButton();
        jPanelEspaciadorUI = new javax.swing.JPanel();
        jPanelEspaciadorUI5 = new javax.swing.JPanel();
        jPanelEspaciadorUI1 = new javax.swing.JPanel();
        jPanelEspaciadorUI2 = new javax.swing.JPanel();
        jPanelEspaciadorUI4 = new javax.swing.JPanel();
        jPanelEspaciadorUI3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/logo_icon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(750, 450));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlPrincipal.setMinimumSize(new java.awt.Dimension(600, 450));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(600, 450));
        pnlPrincipal.setLayout(new java.awt.CardLayout());

        pnlInicio.setBackground(new java.awt.Color(255, 255, 255));
        pnlInicio.setMinimumSize(new java.awt.Dimension(600, 450));
        pnlInicio.setPreferredSize(new java.awt.Dimension(600, 450));
        java.awt.GridBagLayout jPanelInicioLayout = new java.awt.GridBagLayout();
        jPanelInicioLayout.columnWidths = new int[] {0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0};
        jPanelInicioLayout.rowHeights = new int[] {0, 15, 0, 15, 0, 15, 0, 15, 0};
        pnlInicio.setLayout(jPanelInicioLayout);

        jLabelLogo.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/logo_snake.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        pnlInicio.add(jLabelLogo, gridBagConstraints);

        lblAjusVelocidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAjusVelocidad.setText("Seleccione la velocidad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlInicio.add(lblAjusVelocidad, gridBagConstraints);

        rbVelBaja.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupVelocidad.add(rbVelBaja);
        rbVelBaja.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        rbVelBaja.setSelected(true);
        rbVelBaja.setText("Lenta");
        rbVelBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVelBajaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlInicio.add(rbVelBaja, gridBagConstraints);

        rbVelMedia.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupVelocidad.add(rbVelMedia);
        rbVelMedia.setText("Media");
        rbVelMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVelMediaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlInicio.add(rbVelMedia, gridBagConstraints);

        rbVelAlta.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupVelocidad.add(rbVelAlta);
        rbVelAlta.setText("Alta");
        rbVelAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVelAltaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlInicio.add(rbVelAlta, gridBagConstraints);

        btnComenzar.setBackground(new java.awt.Color(0, 0, 0));
        btnComenzar.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        btnComenzar.setForeground(new java.awt.Color(255, 255, 255));
        btnComenzar.setText("Iniciar juego");
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.setNextFocusableComponent(this);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlInicio.add(btnComenzar, gridBagConstraints);

        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/info_snake.png"))); // NOI18N
        btnInfo.setBorder(null);
        btnInfo.setBorderPainted(false);
        btnInfo.setContentAreaFilled(false);
        btnInfo.setFocusPainted(false);
        btnInfo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        pnlInicio.add(btnInfo, gridBagConstraints);

        jPanel1.setPreferredSize(new java.awt.Dimension(420, 65));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jLabel1.setText("ZZZ");

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel2.setText("Juega a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        pnlInicio.add(jPanel1, gridBagConstraints);

        pnlPrincipal.add(pnlInicio, "PanelInicio");

        pnlInfo.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanelInfoLayout = new java.awt.GridBagLayout();
        jPanelInfoLayout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0};
        jPanelInfoLayout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        pnlInfo.setLayout(jPanelInfoLayout);

        lbl1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl1.setText("Al presionar el botón \"DETENER\", podrás verificar tus puntos acumulados.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(lbl1, gridBagConstraints);

        lbl2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl2.setText("Si chocas con la pared, la serpiente volverá al estado inicial, pero mantendrás tus puntos.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(lbl2, gridBagConstraints);

        lbl3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lbl3.setText("Tienes una serpiente que seguirá el cursor del mouse, acumulando puntos infinitamente.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(lbl3, gridBagConstraints);

        jLabelInfo.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabelInfo.setText("Instrucciones!!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(jLabelInfo, gridBagConstraints);

        jPanelSerpienteInfo.setBackground(new java.awt.Color(0, 0, 0));
        jPanelSerpienteInfo.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanelSerpienteInfoLayout = new javax.swing.GroupLayout(jPanelSerpienteInfo);
        jPanelSerpienteInfo.setLayout(jPanelSerpienteInfoLayout);
        jPanelSerpienteInfoLayout.setHorizontalGroup(
            jPanelSerpienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelSerpienteInfoLayout.setVerticalGroup(
            jPanelSerpienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(jPanelSerpienteInfo, gridBagConstraints);

        jLabelSerpienteInfo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabelSerpienteInfo.setText("Esta es tu serpiente. Usa el mouse  para moverte por el tablero.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(jLabelSerpienteInfo, gridBagConstraints);

        jPanelManzanInfo.setBackground(java.awt.Color.red);
        jPanelManzanInfo.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanelManzanInfoLayout = new javax.swing.GroupLayout(jPanelManzanInfo);
        jPanelManzanInfo.setLayout(jPanelManzanInfoLayout);
        jPanelManzanInfoLayout.setHorizontalGroup(
            jPanelManzanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelManzanInfoLayout.setVerticalGroup(
            jPanelManzanInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(jPanelManzanInfo, gridBagConstraints);

        jLabelManzanaInfo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabelManzanaInfo.setText("Las manzanas te dan 10 puntos pero tambien la serpiente crece mas grande.\n");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(jLabelManzanaInfo, gridBagConstraints);

        jLabelClockImgInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/info_snake.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlInfo.add(jLabelClockImgInfo, gridBagConstraints);

        btnVolverInfo.setBackground(new java.awt.Color(0, 0, 0));
        btnVolverInfo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btnVolverInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverInfo.setText("Volver  atrás");
        btnVolverInfo.setPreferredSize(new java.awt.Dimension(222, 35));
        btnVolverInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverInfoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        pnlInfo.add(btnVolverInfo, gridBagConstraints);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/logoInfo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 19;
        pnlInfo.add(jLabel4, gridBagConstraints);

        pnlPrincipal.add(pnlInfo, "PanelInfo");

        pnlJuego.setMinimumSize(new java.awt.Dimension(600, 450));
        pnlJuego.setPreferredSize(new java.awt.Dimension(600, 450));
        pnlJuego.setLayout(new java.awt.GridBagLayout());

        jPanelTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelTablero.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanelTablero.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanelTablero.setName(""); // NOI18N
        jPanelTablero.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanelTableroLayout = new javax.swing.GroupLayout(jPanelTablero);
        jPanelTablero.setLayout(jPanelTableroLayout);
        jPanelTableroLayout.setHorizontalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanelTableroLayout.setVerticalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlJuego.add(jPanelTablero, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jLabel3, gridBagConstraints);

        lblTiempo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTiempo.setText("Tiempo:     ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(lblTiempo, gridBagConstraints);

        lblTiempoDato.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTiempoDato.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(lblTiempoDato, gridBagConstraints);

        lblManzanas.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblManzanas.setText("      Manzanas:     ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(lblManzanas, gridBagConstraints);

        lblManzanasDato.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblManzanasDato.setText("0");
        pnlJuego.add(lblManzanasDato, new java.awt.GridBagConstraints());

        lblPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPuntuacion.setText("     Puntuación:    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        pnlJuego.add(lblPuntuacion, gridBagConstraints);
        lblPuntuacion.getAccessibleContext().setAccessibleName(" Puntuación:    ");

        lblPuntuacionDato.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPuntuacionDato.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(lblPuntuacionDato, gridBagConstraints);

        lblMuertes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMuertes.setText("     Muertes:    ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(lblMuertes, gridBagConstraints);

        lblMuertesDato.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMuertesDato.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(lblMuertesDato, gridBagConstraints);

        btnDetenerJuego.setBackground(new java.awt.Color(0, 0, 0));
        btnDetenerJuego.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        btnDetenerJuego.setForeground(new java.awt.Color(255, 255, 255));
        btnDetenerJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/octagon-pause.png"))); // NOI18N
        btnDetenerJuego.setText("  Detener ");
        btnDetenerJuego.setPreferredSize(new java.awt.Dimension(157, 38));
        btnDetenerJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerJuegoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(btnDetenerJuego, gridBagConstraints);

        jPanelEspaciadorUI.setPreferredSize(new java.awt.Dimension(55, 10));

        javax.swing.GroupLayout jPanelEspaciadorUILayout = new javax.swing.GroupLayout(jPanelEspaciadorUI);
        jPanelEspaciadorUI.setLayout(jPanelEspaciadorUILayout);
        jPanelEspaciadorUILayout.setHorizontalGroup(
            jPanelEspaciadorUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEspaciadorUILayout.setVerticalGroup(
            jPanelEspaciadorUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jPanelEspaciadorUI, gridBagConstraints);

        jPanelEspaciadorUI5.setPreferredSize(new java.awt.Dimension(55, 10));

        javax.swing.GroupLayout jPanelEspaciadorUI5Layout = new javax.swing.GroupLayout(jPanelEspaciadorUI5);
        jPanelEspaciadorUI5.setLayout(jPanelEspaciadorUI5Layout);
        jPanelEspaciadorUI5Layout.setHorizontalGroup(
            jPanelEspaciadorUI5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEspaciadorUI5Layout.setVerticalGroup(
            jPanelEspaciadorUI5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jPanelEspaciadorUI5, gridBagConstraints);

        jPanelEspaciadorUI1.setPreferredSize(new java.awt.Dimension(55, 10));

        javax.swing.GroupLayout jPanelEspaciadorUI1Layout = new javax.swing.GroupLayout(jPanelEspaciadorUI1);
        jPanelEspaciadorUI1.setLayout(jPanelEspaciadorUI1Layout);
        jPanelEspaciadorUI1Layout.setHorizontalGroup(
            jPanelEspaciadorUI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEspaciadorUI1Layout.setVerticalGroup(
            jPanelEspaciadorUI1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jPanelEspaciadorUI1, gridBagConstraints);

        jPanelEspaciadorUI2.setPreferredSize(new java.awt.Dimension(55, 10));

        javax.swing.GroupLayout jPanelEspaciadorUI2Layout = new javax.swing.GroupLayout(jPanelEspaciadorUI2);
        jPanelEspaciadorUI2.setLayout(jPanelEspaciadorUI2Layout);
        jPanelEspaciadorUI2Layout.setHorizontalGroup(
            jPanelEspaciadorUI2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEspaciadorUI2Layout.setVerticalGroup(
            jPanelEspaciadorUI2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jPanelEspaciadorUI2, gridBagConstraints);

        jPanelEspaciadorUI4.setPreferredSize(new java.awt.Dimension(55, 10));

        javax.swing.GroupLayout jPanelEspaciadorUI4Layout = new javax.swing.GroupLayout(jPanelEspaciadorUI4);
        jPanelEspaciadorUI4.setLayout(jPanelEspaciadorUI4Layout);
        jPanelEspaciadorUI4Layout.setHorizontalGroup(
            jPanelEspaciadorUI4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEspaciadorUI4Layout.setVerticalGroup(
            jPanelEspaciadorUI4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jPanelEspaciadorUI4, gridBagConstraints);

        jPanelEspaciadorUI3.setPreferredSize(new java.awt.Dimension(55, 10));

        javax.swing.GroupLayout jPanelEspaciadorUI3Layout = new javax.swing.GroupLayout(jPanelEspaciadorUI3);
        jPanelEspaciadorUI3.setLayout(jPanelEspaciadorUI3Layout);
        jPanelEspaciadorUI3Layout.setHorizontalGroup(
            jPanelEspaciadorUI3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelEspaciadorUI3Layout.setVerticalGroup(
            jPanelEspaciadorUI3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        pnlJuego.add(jPanelEspaciadorUI3, gridBagConstraints);

        pnlPrincipal.add(pnlJuego, "PanelJuego");

        getContentPane().add(pnlPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        this.setSize((this.width * 20) + 260, (this.height * 20) + 140);
        jPanelTablero.setMinimumSize(new Dimension((this.width * 20), (this.height * 20)));
        jPanelTablero.setPreferredSize(new Dimension((this.width * 20), (this.height * 20)));
        this.setLocationRelativeTo(null);
        super.paint(g);
    }

    @SuppressWarnings("empty-statement")
    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        cardLayout.show(pnlPrincipal, "PanelJuego");
        cronometro.start();
        reproducirMusicaFondo();
        crearTablero();

        lblManzanasDato.setText("0");
        lblPuntuacionDato.setText("0");
        lblTiempoDato.setText("00:00");
        lblMuertesDato.setText(String.valueOf(contadorMuertes));

        this.serpiente = new Serpiente(this.width, this.height, this.velocidad);
        serpiente.start();
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void rbVelAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVelAltaActionPerformed
        this.velocidad = 100;
    }//GEN-LAST:event_rbVelAltaActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        cardLayout.show(pnlPrincipal, "PanelInfo");
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnVolverInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverInfoActionPerformed
        cardLayout.show(pnlPrincipal, "PanelInicio");
    }//GEN-LAST:event_btnVolverInfoActionPerformed

    private void rbVelMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVelMediaActionPerformed
        this.velocidad = 200;
    }//GEN-LAST:event_rbVelMediaActionPerformed

    private void rbVelBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVelBajaActionPerformed
        this.velocidad = 300;
    }//GEN-LAST:event_rbVelBajaActionPerformed

    private void btnDetenerJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerJuegoActionPerformed
        this.dispose();
        serpiente.morir();    
    }//GEN-LAST:event_btnDetenerJuegoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnDetenerJuego;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnVolverInfo;
    private javax.swing.ButtonGroup buttonGroupDificultad;
    private javax.swing.ButtonGroup buttonGroupTamaño;
    private javax.swing.ButtonGroup buttonGroupVelocidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelClockImgInfo;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelManzanaInfo;
    private javax.swing.JLabel jLabelSerpienteInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEspaciadorUI;
    private javax.swing.JPanel jPanelEspaciadorUI1;
    private javax.swing.JPanel jPanelEspaciadorUI2;
    private javax.swing.JPanel jPanelEspaciadorUI3;
    private javax.swing.JPanel jPanelEspaciadorUI4;
    private javax.swing.JPanel jPanelEspaciadorUI5;
    private javax.swing.JPanel jPanelManzanInfo;
    private javax.swing.JPanel jPanelSerpienteInfo;
    private javax.swing.JPanel jPanelTablero;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lblAjusVelocidad;
    private javax.swing.JLabel lblManzanas;
    protected static javax.swing.JLabel lblManzanasDato;
    private javax.swing.JLabel lblMuertes;
    protected static javax.swing.JLabel lblMuertesDato;
    private javax.swing.JLabel lblPuntuacion;
    protected static javax.swing.JLabel lblPuntuacionDato;
    private javax.swing.JLabel lblTiempo;
    protected static javax.swing.JLabel lblTiempoDato;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JRadioButton rbVelAlta;
    private javax.swing.JRadioButton rbVelBaja;
    private javax.swing.JRadioButton rbVelMedia;
    // End of variables declaration//GEN-END:variables
}
