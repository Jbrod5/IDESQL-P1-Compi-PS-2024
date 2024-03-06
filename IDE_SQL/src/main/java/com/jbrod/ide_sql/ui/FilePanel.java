/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.jbrod.ide_sql.ui;

import com.jbrod.ide_sql.IDE_SQL;
import com.jbrod.ide_sql.app.CsvDriver.CsvFile;
import com.jbrod.ide_sql.app.analyzer.SqlLexer;
import com.jbrod.ide_sql.app.analyzer.SqlParser;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbravo
 */
public class FilePanel extends javax.swing.JPanel {

    /**
     * Creates new form FilePanel
     */
    private CsvFile file; 
    private AppFrame appFrame;
    
    public FilePanel(CsvFile file) {
        initComponents();
        this.file = file; 
    }
    
    public FilePanel() {
        initComponents();
    }
    
    public void updateFilePanel(){
        taContentFile.setText(file.getContent());
    }
    
    public void updateAppFrame(AppFrame app){
        this.appFrame = app;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExecute = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnSaveContent = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        taContentFile = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        taConsole = new javax.swing.JTextArea();

        btnExecute.setText("Ejecutar");
        btnExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnSaveContent.setText("Guardar");
        btnSaveContent.setActionCommand("Guardar texto");
        btnSaveContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveContentActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contenido del archivo"));

        taContentFile.setColumns(20);
        taContentFile.setFont(new java.awt.Font("Noto Sans Mono Condensed Medium", 0, 13)); // NOI18N
        taContentFile.setRows(5);
        jScrollPane2.setViewportView(taContentFile);

        jScrollPane3.setViewportView(jScrollPane2);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Consola / Resultado"));

        taConsole.setColumns(20);
        taConsole.setFont(new java.awt.Font("Noto Sans Mono Condensed Medium", 0, 13)); // NOI18N
        taConsole.setRows(5);
        jScrollPane1.setViewportView(taConsole);

        jScrollPane4.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 281, Short.MAX_VALUE)
                .addComponent(btnSaveContent)
                .addGap(18, 18, 18)
                .addComponent(btnExecute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExecute)
                    .addComponent(btnCerrar)
                    .addComponent(btnSaveContent))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveContentActionPerformed
        // TODO add your handling code here:
        String contentFile = taContentFile.getText();
        file.updateContent(contentFile);
        updateFilePanel();
    }//GEN-LAST:event_btnSaveContentActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        appFrame.removeTab(this);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
        // TODO add your handling code here:
        String cadena = taConsole.getText(); 
        StringReader rd = new StringReader(cadena);
        SqlLexer lexer = new SqlLexer(rd);
        SqlParser parser = new SqlParser(lexer);
        
        try {
            parser.parse();
            taConsole.setText("Salida: \n" + parser.instr);
        } catch (Exception ex) {
            Logger.getLogger(IDE_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExecuteActionPerformed

    public void setContentFileString(String content){
        taContentFile.setText(content);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnExecute;
    private javax.swing.JButton btnSaveContent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea taConsole;
    private javax.swing.JTextArea taContentFile;
    // End of variables declaration//GEN-END:variables
}
