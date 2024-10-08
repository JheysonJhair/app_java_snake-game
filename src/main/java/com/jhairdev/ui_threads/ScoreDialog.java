package com.jhairdev.ui_threads;

/**
 *
 * @author Jhair
 */
public class ScoreDialog extends javax.swing.JDialog {


    public ScoreDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void iniciar() {
        lblPuntuacionDato.setText(FormMain.lblPuntuacionDato.getText());
        lblManzanasDato.setText(FormMain.lblManzanasDato.getText());
        lblTiempoDato.setText(FormMain.lblTiempoDato.getText());
        lblMuertesDato.setText(FormMain.lblMuertesDato.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblPuntuacion = new javax.swing.JLabel();
        lblPuntuacionDato = new javax.swing.JLabel();
        lblManzanas = new javax.swing.JLabel();
        lblManzanasDato = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblTiempoDato = new javax.swing.JLabel();
        lblMuertes = new javax.swing.JLabel();
        lblMuertesDato = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        espacio3 = new javax.swing.JPanel();
        espacio2 = new javax.swing.JPanel();
        espacio1 = new javax.swing.JPanel();
        espacio = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0};
        layout.rowHeights = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        getContentPane().setLayout(layout);

        lblPuntuacion.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblPuntuacion.setText("Puntuación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(lblPuntuacion, gridBagConstraints);

        lblPuntuacionDato.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPuntuacionDato.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(lblPuntuacionDato, gridBagConstraints);

        lblManzanas.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblManzanas.setText("Manzanas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(lblManzanas, gridBagConstraints);

        lblManzanasDato.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblManzanasDato.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(lblManzanasDato, gridBagConstraints);

        lblTiempo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblTiempo.setText("Tiempo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(lblTiempo, gridBagConstraints);

        lblTiempoDato.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTiempoDato.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(lblTiempoDato, gridBagConstraints);

        lblMuertes.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        lblMuertes.setText("Muertes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(lblMuertes, gridBagConstraints);

        lblMuertesDato.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblMuertesDato.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(lblMuertesDato, gridBagConstraints);

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(200, 23));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(btnSalir, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 65));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Puntuación");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(jPanel2, gridBagConstraints);

        espacio3.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        getContentPane().add(espacio3, gridBagConstraints);

        espacio2.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        getContentPane().add(espacio2, gridBagConstraints);

        espacio1.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        getContentPane().add(espacio1, gridBagConstraints);

        espacio.setPreferredSize(new java.awt.Dimension(30, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(espacio, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel espacio;
    private javax.swing.JPanel espacio1;
    private javax.swing.JPanel espacio2;
    private javax.swing.JPanel espacio3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblManzanas;
    private javax.swing.JLabel lblManzanasDato;
    private javax.swing.JLabel lblMuertes;
    private javax.swing.JLabel lblMuertesDato;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblPuntuacionDato;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoDato;
    // End of variables declaration//GEN-END:variables
}
