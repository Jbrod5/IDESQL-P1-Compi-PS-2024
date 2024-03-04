package com.jbrod.ide_sql.ui;

import com.jbrod.ide_sql.app.CsvDriver.Analyzer;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author jbravo
 */
public class AppFrame extends javax.swing.JFrame {

    private Analyzer analyzer;
    private String rootPath;
    
    /**
     * Creates new form AppFrame
     */
    public AppFrame(String rootPath, Analyzer analyzer) {
        
        this.analyzer = analyzer;
        this.rootPath = rootPath;
        

        // Crear JTree
        File rootFile = new File(rootPath);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile.getName());
        JTree tree = new JTree(root);
        addTreeNodes(root, rootFile);
        
        initComponents();

        
        //Agregar el jtree
        jScrollPane1.add(tree);
        jScrollPane1.setViewportView(tree);
        
    }
    
    
    private void addTreeNodes(DefaultMutableTreeNode actualNode, File actualFile){
        if (actualFile.isDirectory()) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(actualFile.getName());
            actualNode.add(newNode);
            for (File archivo : actualFile.listFiles()) {
                addTreeNodes(newNode, archivo);
            }
        } else {
            String fileName = actualFile.getName();
            DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(fileName) ;
            actualNode.add(fileNode);
            analyzer.addCsvFile(actualFile.getAbsolutePath(), fileNode);
            System.out.println(fileName);
        }
    }


    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
