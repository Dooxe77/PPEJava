package annuaire.view;

import annuaire.controleur.controleurColloque;
import java.io.IOException;
import annuaire.dao.DaoEnsemble;
import annuaire.dao.daoColloque;
import annuaire.metier.Colloque;

/**
 *
 * @author anthony
 */
public class FrameConsulter extends javax.swing.JFrame {
    
    private daoColloque c; 
    private controleurColloque ctrlColloque;
    private Colloque uneColloque;
    private DaoEnsemble dEnsemble;
    
    public FrameConsulter() {
        c = new daoColloque();
        dEnsemble = new DaoEnsemble();
        this.ctrlColloque = new controleurColloque ();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        panConsulter = new javax.swing.JPanel();
        lblConsulter = new javax.swing.JLabel();
        btnFermer = new javax.swing.JButton();
        btnExporter = new javax.swing.JButton();
        jcbChoixColloque = new javax.swing.JComboBox();
        txtIntitule = new javax.swing.JTextField();
        txtDateDebut = new javax.swing.JTextField();
        txtDuree = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNbMax = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        jcbParticipants = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panConsulter.setBackground(new java.awt.Color(0, 153, 153));

        lblConsulter.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblConsulter.setForeground(new java.awt.Color(255, 255, 255));
        lblConsulter.setText("Consulter");

        btnFermer.setText("Fermer cette fenêtre");
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });

        btnExporter.setText("Exporter l'ensemble des données");
        btnExporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExporterActionPerformed(evt);
            }
        });

        String choixCb [] = new String[this.c.getALL().size()] ;
        for(int i = 0; i<this.c.getALL().size(); i++)
        {
            choixCb[i] = this.c.getALL().get(i).getNumColloque()+" - "+this.c.getALL().get(i).getIntituleColloque();
        }
        jcbChoixColloque.setModel(new javax.swing.DefaultComboBoxModel(choixCb));
        jcbChoixColloque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbChoixColloqueActionPerformed(evt);
            }
        });

        txtIntitule.setEditable(false);

        txtDateDebut.setEditable(false);

        txtDuree.setEditable(false);

        jLabel1.setText("Intitulé :");

        jLabel2.setText("Date de début :");

        jLabel3.setText("Durée (jours) :");

        txtNbMax.setEditable(false);

        jLabel4.setText("Nombre participants max :");

        jLabel5.setText("Description :");

        txtAreaDescription.setEditable(false);
        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescription);

        jcbParticipants.setModel(new javax.swing.DefaultComboBoxModel());

        jLabel6.setText("Participants :");

        jLabel7.setText("Choisir une colloque :");

        javax.swing.GroupLayout panConsulterLayout = new javax.swing.GroupLayout(panConsulter);
        panConsulter.setLayout(panConsulterLayout);
        panConsulterLayout.setHorizontalGroup(
            panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsulterLayout.createSequentialGroup()
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panConsulterLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNbMax, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbParticipants, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbChoixColloque, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConsulter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panConsulterLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel5)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panConsulterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(panConsulterLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panConsulterLayout.createSequentialGroup()
                        .addComponent(btnExporter)
                        .addGap(62, 62, 62)
                        .addComponent(btnFermer))
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panConsulterLayout.setVerticalGroup(
            panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsulterLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblConsulter)
                .addGap(52, 52, 52)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jcbParticipants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panConsulterLayout.createSequentialGroup()
                        .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jcbChoixColloque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)))
                .addGap(25, 25, 25)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIntitule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNbMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panConsulterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExporter)
                    .addComponent(btnFermer))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panConsulter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panConsulter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFermerActionPerformed

    private void btnExporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExporterActionPerformed
        
      controleurColloque ctrlColloque = new controleurColloque();
      ctrlColloque.exporterDonnee();
        
      
    }//GEN-LAST:event_btnExporterActionPerformed

    private void jcbChoixColloqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbChoixColloqueActionPerformed
            
            String choix = this.jcbChoixColloque.getSelectedItem().toString(); 
            String [] tabChoix = choix.split(" -"); // on coupe la chaine, on prend le premier élément (ici l'id)
            this.uneColloque = this.c.getUneColloque(Integer.parseInt(tabChoix[0])); // on obtient la colloque dans la bdd 
            this.txtIntitule.setText(uneColloque.getIntituleColloque());
            this.txtDateDebut.setText(uneColloque.getDateDebutColloque());
            this.txtNbMax.setText(Integer.toString(uneColloque.getNbParticipantMax()));
            this.txtDuree.setText(Integer.toString(uneColloque.getDureeColloque()));
            this.txtAreaDescription.setText(uneColloque.getDescriptionColloque());
            // place les nom des personnes de la colloque dans un tableau, grâce à la arraylist obtenu voir DaoEnsemble.getPersonneByColloque
            String [] tabNom = new String[this.dEnsemble.getPersonneByColloque(Integer.parseInt(tabChoix[0])).size()];
            for (int i = 0; i< this.dEnsemble.getPersonneByColloque(Integer.parseInt(tabChoix[0])).size(); i++)
            {
              tabNom[i] = this.dEnsemble.getPersonneByColloque(Integer.parseInt(tabChoix[0])).get(i);
            }
            this.jcbParticipants.setModel(new javax.swing.DefaultComboBoxModel(tabNom));
          
    }//GEN-LAST:event_jcbChoixColloqueActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameConsulter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameConsulter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameConsulter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameConsulter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameConsulter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExporter;
    private javax.swing.JButton btnFermer;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcbChoixColloque;
    private javax.swing.JComboBox jcbParticipants;
    private javax.swing.JLabel lblConsulter;
    private javax.swing.JPanel panConsulter;
    private javax.swing.JTextArea txtAreaDescription;
    private javax.swing.JTextField txtDateDebut;
    private javax.swing.JTextField txtDuree;
    private javax.swing.JTextField txtIntitule;
    private javax.swing.JTextField txtNbMax;
    // End of variables declaration//GEN-END:variables
}
