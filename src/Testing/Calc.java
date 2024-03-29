/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

/**
 *
 * @author c1bilham
 */
public class Calc extends javax.swing.JFrame {

    /**
     * Creates new form Calc
     */
    public Calc() {
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("1+2+3");
        jLabel1.setToolTipText("");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("1+2+3");
        jLabel2.setToolTipText("");

        jTextField1.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInt(char ind)
    {
        switch(ind)
        {
            case('0'): return true;
            case('1'): return true;
            case('2'): return true;
            case('3'): return true;
            case('4'): return true;
            case('5'): return true;
            case('6'): return true;
            case('7'): return true;
            case('8'): return true;
            case('9'): return true;
        }
        return false;
    }
    
    public int depth = 0;
    public String parseEq(String curString)
    {
        String eqStr = curString;
        
        String resolvingStrLeft = "";
        String resolvingStrRight = "";
        
        String resolving = "";
        int count = 0;
        for (char ind: eqStr.toCharArray()) {
            if(isInt(ind))
            {
                count++;
                resolvingStrLeft += ind;
                System.out.println("Left hand side current: " + resolvingStrLeft);

            }
            else
            {
                resolvingStrRight = eqStr.substring(count, eqStr.length());
                System.out.println("Right hand: " + resolvingStrRight);
                
                String unit = resolvingStrRight.substring(0, 1);
                System.out.println("Unit: " + unit);

                if(unit.equals("+"))
                {
                    depth++;
                    System.out.println("Depth: " + depth);
                    resolving = parseEq(resolvingStrRight.substring(1));
                                        depth--;
                    System.out.println("Depth: " + depth);

                    System.out.println("Left hand side   resolved as: " + resolvingStrLeft);
                    System.out.println("Right hand side  resolved into: " + resolving);
                    int num1 = Integer.parseInt(resolvingStrLeft);
                    int num2 = Integer.parseInt(resolving);
                    int S = num1 + num2;
                    System.out.println("Answer: " + String.valueOf(S));
                    return String.valueOf(S);
                }
                else if(unit.equals("*"))
                {
                    
                    depth++;
                    System.out.println("Depth: " + depth);
                    resolving = parseEq(resolvingStrRight.substring(1));
                                        depth--;
                    System.out.println("Depth: " + depth);

                    System.out.println("Left hand side   resolved as: " + resolvingStrLeft);
                    System.out.println("Right hand side  resolved into: " + resolving);
                    int num1 = Integer.parseInt(resolvingStrLeft);
                    int num2 = Integer.parseInt(resolving);
                    int S = num1 * num2;
                    System.out.println("Answer: " + String.valueOf(S));
                    return String.valueOf(S);
                }
                
                
            }
        }
        
        
        System.out.println("Left hand side resolved as: " + resolvingStrLeft);
        System.out.println("right hand side resolved as: " + resolving);

        return resolvingStrLeft;
    }
    
    public void run(String value)
    {
        if(jLabel1.getText() == "-0"){
            jLabel1.setText(value);
        }
        else 
        {
            jLabel1.setText(jLabel1.getText() + value);
 
        }
        
        System.out.println(parseEq(jLabel1.getText()));
        jLabel2.setText(parseEq(jLabel1.getText()));

    }
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //run("1");
        if(jTextField1.getText() != "0")
        {
           //System.out.println(parseEq(jTextField1.getText()));
            jLabel2.setText(parseEq(jTextField1.getText()));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
