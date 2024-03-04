package com.jbrod.ide_sql.ui;

import com.jbrod.ide_sql.app.CsvDriver.Analyzer;
import com.jbrod.ide_sql.app.CsvDriver.CsvFile;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author jbravo
 */
public class AppFrame extends javax.swing.JFrame {

    private Analyzer analyzer;
    private String rootPath;
    private JTree tree; 
    
    /**
     * Creates new form AppFrame
     */
    public AppFrame(String rootPath, Analyzer analyzer) {
        
        this.analyzer = analyzer;
        this.rootPath = rootPath;
        

        // Crear JTree
        File rootFile = new File(rootPath);
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile.getName());
        //JTree tree = new JTree(root);
        tree = new JTree(root);
        addTreeNodes(root, rootFile);
        
        initComponents();
        
        //tbdWorkPanel.add(new FilePanel());
        
        //Agregar el jtree
        jScrollPane1.add(tree);
        jScrollPane1.setViewportView(tree);
        addListener();

        // Agregar TreeSelectionListener para mostrar el nombre del archivo al hacer clic
        //addListener(tree);
        
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
            System.out.println("El nombre del archivo a agregar como nodo es: " + fileName);
            CsvFile fileNode = new CsvFile(actualFile.getAbsolutePath(), fileName);
            //analyzer.addCsvFile(actualFile.getAbsolutePath(), fileNode);
            analyzer.addCsvFIle(fileNode);
            
            //DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(fileName) ;
            actualNode.add(fileNode);
            System.out.println(fileName);
        }
        
    }

    public  void addListener(){
        AppFrame app = this; 
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null && selectedNode.isLeaf()) {
                    CsvFile file = ((CsvFile)selectedNode);
                    tbdWorkPanel.addTab(file.getFileName(), file.getFilePanel());
                    file.updateAppFrame(app);
                    System.out.println("El titulo del archivo agregado es: " + file.getFileName());
                    System.out.println("La instancia del panel es la siguiente: " + file.getFilePanel());
                }
            }
        });

    }
    
    
    public void removeTab(FilePanel panel){
        tbdWorkPanel.remove(panel);
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbdWorkPanel = new javax.swing.JTabbedPane();
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
                .addComponent(tbdWorkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(tbdWorkPanel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tbdWorkPanel;
    // End of variables declaration//GEN-END:variables
}
