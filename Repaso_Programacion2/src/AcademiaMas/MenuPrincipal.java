package AcademiaMas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author a21pablosp
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuPrincipal() {
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

        btnAnModulo = new javax.swing.JButton();
        btnAnAlumno = new javax.swing.JButton();
        btnVerAlumno = new javax.swing.JButton();
        BarraMenu = new javax.swing.JMenuBar();
        MenuAlumno = new javax.swing.JMenu();
        miAñadirAlumno = new javax.swing.JMenuItem();
        miVerAlumno = new javax.swing.JMenuItem();
        miGuardarAlumno = new javax.swing.JMenuItem();
        miSalvarAlumno = new javax.swing.JMenuItem();
        MenuModulo = new javax.swing.JMenu();
        miAddModulo = new javax.swing.JMenuItem();
        miGuardaModulo = new javax.swing.JMenuItem();
        miSalvarModulo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MenuPrincipal");

        btnAnModulo.setText("Añadir Módulo");
        btnAnModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnModuloActionPerformed(evt);
            }
        });

        btnAnAlumno.setText("Añadir Alumno");
        btnAnAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnAlumnoActionPerformed(evt);
            }
        });

        btnVerAlumno.setText("Ver Alumno");
        btnVerAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerAlumnoActionPerformed(evt);
            }
        });

        MenuAlumno.setText("Alumnos");

        miAñadirAlumno.setText("Añadir Alumno");
        miAñadirAlumno.setToolTipText("");
        MenuAlumno.add(miAñadirAlumno);

        miVerAlumno.setText("Ver Alumno");
        miVerAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVerAlumnoActionPerformed(evt);
            }
        });
        MenuAlumno.add(miVerAlumno);

        miGuardarAlumno.setText("Guarda Alumno");
        MenuAlumno.add(miGuardarAlumno);

        miSalvarAlumno.setText("Salvar Alumno");
        MenuAlumno.add(miSalvarAlumno);

        BarraMenu.add(MenuAlumno);

        MenuModulo.setText("Módulos");

        miAddModulo.setText("Añadir Módulo");
        MenuModulo.add(miAddModulo);

        miGuardaModulo.setText("Guardar Modulo");
        miGuardaModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardaModuloActionPerformed(evt);
            }
        });
        MenuModulo.add(miGuardaModulo);

        miSalvarModulo.setText("Salvar Modulo");
        MenuModulo.add(miSalvarModulo);

        BarraMenu.add(MenuModulo);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnModulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnAnAlumno)
                .addGap(30, 30, 30)
                .addComponent(btnAnModulo)
                .addGap(39, 39, 39)
                .addComponent(btnVerAlumno)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miVerAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVerAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miVerAlumnoActionPerformed

    private void miGuardaModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardaModuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miGuardaModuloActionPerformed

    private void btnAnModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnModuloActionPerformed
        JDAñadirMódulo jdam = new JDAñadirMódulo(this,true);
        jdam.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnModuloActionPerformed

    private void btnAnAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnAlumnoActionPerformed
        JDAñadirAlumno jdaa = new JDAñadirAlumno(this,true);
        jdaa.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnAlumnoActionPerformed

    private void btnVerAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerAlumnoActionPerformed
        JDVerAlumno jdva = new JDVerAlumno(this,true);
        jdva.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerAlumnoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenu MenuAlumno;
    private javax.swing.JMenu MenuModulo;
    private javax.swing.JButton btnAnAlumno;
    private javax.swing.JButton btnAnModulo;
    private javax.swing.JButton btnVerAlumno;
    private javax.swing.JMenuItem miAddModulo;
    private javax.swing.JMenuItem miAñadirAlumno;
    private javax.swing.JMenuItem miGuardaModulo;
    private javax.swing.JMenuItem miGuardarAlumno;
    private javax.swing.JMenuItem miSalvarAlumno;
    private javax.swing.JMenuItem miSalvarModulo;
    private javax.swing.JMenuItem miVerAlumno;
    // End of variables declaration//GEN-END:variables
}
