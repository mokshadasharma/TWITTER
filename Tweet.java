
package twitter;


public class Tweet extends javax.swing.JPanel {

     public Tweet() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lbpr1 = new javax.swing.JLabel();
        lbcon = new javax.swing.JLabel();
        jtf2 = new javax.swing.JTextField();
        btbr = new javax.swing.JButton();
        btpo1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTextArea();
        lbsa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbpr2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jta2 = new javax.swing.JTextArea();
        jcb = new javax.swing.JComboBox<>();
        btpo2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbpr = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbtext = new javax.swing.JLabel();
        btpo = new javax.swing.JButton();

        setLayout(null);

        jPanel2.setLayout(null);

        lbpr1.setText("jLabel1");
        jPanel2.add(lbpr1);
        lbpr1.setBounds(70, 70, 80, 70);
        jPanel2.add(lbcon);
        lbcon.setBounds(490, 130, 80, 20);
        jPanel2.add(jtf2);
        jtf2.setBounds(190, 180, 150, 20);

        btbr.setText("BROWSE");
        jPanel2.add(btbr);
        btbr.setBounds(350, 180, 90, 23);

        btpo1.setText("POST");
        jPanel2.add(btpo1);
        btpo1.setBounds(190, 240, 100, 40);

        jta1.setColumns(20);
        jta1.setRows(5);
        jScrollPane2.setViewportView(jta1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(170, 60, 300, 100);

        lbsa.setText("jLabel1");
        jPanel2.add(lbsa);
        lbsa.setBounds(410, 260, 80, 60);

        jTabbedPane1.addTab("PHOTO TWEET", jPanel2);

        jPanel3.setLayout(null);

        lbpr2.setText("jLabel1");
        jPanel3.add(lbpr2);
        lbpr2.setBounds(100, 70, 80, 70);

        jta2.setColumns(20);
        jta2.setRows(5);
        jScrollPane3.setViewportView(jta2);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(190, 60, 240, 130);

        jPanel3.add(jcb);
        jcb.setBounds(250, 230, 180, 20);

        btpo2.setText("POST");
        btpo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpo2ActionPerformed(evt);
            }
        });
        jPanel3.add(btpo2);
        btpo2.setBounds(333, 270, 100, 23);

        jTabbedPane1.addTab("LOCATION TWEET", jPanel3);

        jPanel1.setLayout(null);

        lbpr.setText("jLabel1");
        lbpr.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(lbpr);
        lbpr.setBounds(100, 70, 80, 70);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(186, 66, 290, 140);

        lbtext.setText("jLabel1");
        jPanel1.add(lbtext);
        lbtext.setBounds(504, 170, 70, 20);

        btpo.setText("POST");
        jPanel1.add(btpo);
        btpo.setBounds(250, 230, 100, 40);

        jTabbedPane1.addTab("TEXT TWEET", jPanel1);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 760, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void btpo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btpo2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btbr;
    public javax.swing.JButton btpo;
    public javax.swing.JButton btpo1;
    public javax.swing.JButton btpo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JComboBox<String> jcb;
    public javax.swing.JTextArea jta1;
    public javax.swing.JTextArea jta2;
    public javax.swing.JTextField jtf2;
    public javax.swing.JLabel lbcon;
    public javax.swing.JLabel lbpr;
    public javax.swing.JLabel lbpr1;
    public javax.swing.JLabel lbpr2;
    public javax.swing.JLabel lbsa;
    public javax.swing.JLabel lbtext;
    // End of variables declaration//GEN-END:variables
}
