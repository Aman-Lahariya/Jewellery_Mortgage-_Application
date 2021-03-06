import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Aman Lahariya
 */
public class Restore extends javax.swing.JFrame {

    /**
     * Creates new form Restore
     */
    public Restore() {
        initComponents();
    }

    String path = null;
    String filename;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Path = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bt_Restore = new javax.swing.JButton();
        bt_back = new javax.swing.JButton();
        bt_Browse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restore Database");

        txt_Path.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 22)); // NOI18N
        jLabel3.setText("Restore Database");

        bt_Restore.setText("Restore");
        bt_Restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RestoreActionPerformed(evt);
            }
        });

        bt_back.setText("Back");
        bt_back.setToolTipText("Takes you back to prev form");
        bt_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backActionPerformed(evt);
            }
        });

        bt_Browse.setText("Browse Path");
        bt_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_BrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(bt_Restore, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_back, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_Path, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(bt_Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Browse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Restore)
                    .addComponent(bt_back))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_RestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RestoreActionPerformed
        // TODO add your handling code here:
        String user = "root";
        String pass = "root";
        String[] restoreCmd = new String[]{"C:/Program Files/MySQL/MySQL Server 5.7/bin/mysql.exe","--user=" +user,"--password=" +pass,"-e","source " +path};
        Process p=null;
        try
        {
            p = Runtime.getRuntime().exec(restoreCmd);
            //p = rt.exec("C:/Program Files/MySQL/MySQL Server 5.7/bin/mysql.exe -uroot -proot bag_shop -e"+path);
            int processComplete = p.waitFor();         
            if(processComplete==0)
            JOptionPane.showMessageDialog(this,"Restored sucessfully!");
            else
            {
            JOptionPane.showMessageDialog(this,"Can't restore backup at this moment!");
          
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_bt_RestoreActionPerformed

    private void bt_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bt_backActionPerformed

    private void bt_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_BrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try
        {
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            //path = path.replace("\\","/");
                //path = path + "_" + date + ".sql";
                txt_Path.setText(path);
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e);
            }
    }//GEN-LAST:event_bt_BrowseActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Restore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Browse;
    private javax.swing.JButton bt_Restore;
    private javax.swing.JButton bt_back;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_Path;
    // End of variables declaration//GEN-END:variables
}
