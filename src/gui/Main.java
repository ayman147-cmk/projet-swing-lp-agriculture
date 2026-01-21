package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import services.UserService;

/**
 * @author ayman
 */
public class Main extends javax.swing.JFrame {

   public Main() {
        initComponents(); 
      this.setTitle("Authentification - Coopérative Agricole");
    this.setLocationRelativeTo(null); 
    

    java.awt.Color blackTransparent = new java.awt.Color(0, 0, 0, 150);
    
    jPanel1.setBackground(blackTransparent);
    
    jPanel1.setOpaque(true); 
    
    jLabel1.setForeground(java.awt.Color.WHITE);
    jLabel2.setForeground(java.awt.Color.WHITE);
    jLabel3.setForeground(java.awt.Color.WHITE); 
    
    jPanel1.repaint();
    }
    // </editor-fold>

    

                                       

   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new java.awt.Color(0, 0, 0, 150)); 
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setOpaque(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resize-1767353679397800243userremovebgpreview1-removebg-preview.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resize-1767353726253394102password-removebg-preview.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Connection");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mot de passe oublié ?");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txtLogin.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login ");

        txtPassword.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mot de passe ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 430, 300));

        jLabel4.setForeground(new java.awt.Color(223, 222, 222));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/main.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 String login = txtLogin.getText();
    String pass = new String(txtPassword.getPassword());
    
    UserService us = new UserService();
    
    if (us.authenticate(login, pass)) {
        JOptionPane.showMessageDialog(this, "Connexion réussie !");
        
        this.dispose();
        new MDIApplication().setVisible(true); 
    } else {
        JOptionPane.showMessageDialog(this, "Login ou motg de passe incorrecte", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    String email = JOptionPane.showInputDialog(this, "Entrez votre adresse email :");
    
    if (email != null && !email.trim().isEmpty()) {
        
        String reponse = JOptionPane.showInputDialog(this, "Quel est votre légume préféré ?");

        if (reponse != null && !reponse.trim().isEmpty()) {
            
            String newPass = JOptionPane.showInputDialog(this, "Entrez votre nouveau mot de passe :");

            if (newPass != null && !newPass.trim().isEmpty()) {
                
                String userLogin = JOptionPane.showInputDialog(this, "Confirmez votre Login (Username) :");
                
                if (userLogin != null) {
                    UserService us = new UserService();
                    
                    if (us.updatePassword(userLogin, newPass)) {
                        
                        us.sendActualEmail(email, newPass);

                        JOptionPane.showMessageDialog(this, "Mot de passe changé avec succès !");
                        
                        JOptionPane.showMessageDialog(this, "Votre nouveau mot de passe a été envoyé sur votre adresse email.");
                        
                        txtLogin.setText(userLogin);
                        txtPassword.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this, "Utilisateur introuvable !", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    }//GEN-LAST:event_jLabel3MouseClicked

                                      

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
        
    
   
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
