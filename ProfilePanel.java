/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.awt.Color;

/**
 *
 * @author agam sharma
 */
public class ProfilePanel extends javax.swing.JPanel {

    /**
     * Creates new form ProfilePanel
     */
    public ProfilePanel() {
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

        jsc1 = new javax.swing.JScrollPane();
        p1 = new javax.swing.JPanel();
        jsp2 = new javax.swing.JScrollPane();
        p2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        p1.setBackground(new java.awt.Color(102, 255, 255));
        p1.setLayout(null);
        jsc1.setViewportView(p1);

        add(jsc1);
        jsc1.setBounds(10, 10, 380, 470);

        p2.setLayout(null);
        jsp2.setViewportView(p2);

        add(jsp2);
        jsp2.setBounds(410, 10, 390, 470);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jsc1;
    public javax.swing.JScrollPane jsp2;
    public javax.swing.JPanel p1;
    public javax.swing.JPanel p2;
    // End of variables declaration//GEN-END:variables
}