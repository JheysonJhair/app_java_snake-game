package com.jhairdev.ui_threads;

/**
 *
 * @author Alejandro González Navarro
 */
public class DialogPuntuacion extends javax.swing.JDialog {
    private int posicion;
    private TablaDePuntuacion tablaDePuntuacion;

    /**
     * Creates new form jDialogPuntuacion
     */
    public DialogPuntuacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        tablaDePuntuacion = new TablaDePuntuacion();
        
    }
    public void iniciar(){
        // Pone los datos
        jLabelPuntuacionC.setText(FormMain.jLabelPuntuacionC.getText());
        jLabelManzanasC.setText(FormMain.jLabelManzanasC.getText());
        jLabelTiempoC.setText(FormMain.jLabelTiempoC.getText());
        String[][] string = tablaDePuntuacion.recuperarLista();
        // Si su puntuación es mas alta muestra el botón de guardar
        for (int i = 0; i < 3; i++) {
            if(Integer.parseInt(string[i][1]) <= Integer.parseInt(this.jLabelPuntuacionC.getText())){
                // Al no poder escribir no tiene sentido permitir guardar su nombre.
                //this.jButtonGuardar.setVisible(true);
                //this.jTextFieldNombre.setVisible(true);
                posicion = i;
                break;
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelPuntuacion = new javax.swing.JLabel();
        jLabelPuntuacionC = new javax.swing.JLabel();
        jLabelManzanas = new javax.swing.JLabel();
        jLabelManzanasC = new javax.swing.JLabel();
        jLabelTiempo = new javax.swing.JLabel();
        jLabelTiempoC = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
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

        jLabelPuntuacion.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabelPuntuacion.setText("Puntuación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jLabelPuntuacion, gridBagConstraints);

        jLabelPuntuacionC.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelPuntuacionC.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(jLabelPuntuacionC, gridBagConstraints);

        jLabelManzanas.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabelManzanas.setText("Manzanas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jLabelManzanas, gridBagConstraints);

        jLabelManzanasC.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelManzanasC.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(jLabelManzanasC, gridBagConstraints);

        jLabelTiempo.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabelTiempo.setText("Tiempo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jLabelTiempo, gridBagConstraints);

        jLabelTiempoC.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabelTiempoC.setText("00:00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        getContentPane().add(jLabelTiempoC, gridBagConstraints);

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setPreferredSize(new java.awt.Dimension(200, 23));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 0, 0);
        getContentPane().add(jButtonSalir, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 65));

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Puntuación");

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/img/logo.png"))); // NOI18N

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

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel espacio;
    private javax.swing.JPanel espacio1;
    private javax.swing.JPanel espacio2;
    private javax.swing.JPanel espacio3;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelManzanas;
    private javax.swing.JLabel jLabelManzanasC;
    private javax.swing.JLabel jLabelPuntuacion;
    private javax.swing.JLabel jLabelPuntuacionC;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelTiempoC;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
