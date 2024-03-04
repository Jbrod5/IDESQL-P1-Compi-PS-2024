package com.jbrod.ide_sql.app.CsvDriver;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa un archivo CSV.
 * @author jbravo
 */
public class CsvFile {

    private String path;
    private String fileName; 
    private String content;
    private DefaultMutableTreeNode treeNode;
    private FileManager fileManager;  // Se le pasa una instancia que es unica para todos
    
    public CsvFile(String path, FileManager fileManager, DefaultMutableTreeNode treeNode){
          this.path = path;
          this.fileManager = fileManager; 
          
          content = fileManager.readFile(path);
          fileName= fileManager.getFileName(path);
          //treeNode = new DefaultMutableTreeNode(fileName);
          this.treeNode = treeNode;
    }
    
    public void updateContent(String content){
           fileManager.writeFile(path, content);
           this.content = fileManager.readFile(path);
    }

    
    /* Getters */
    public DefaultMutableTreeNode getTreeNode() {
        return treeNode;
    }

    public String getContent() {
        return content;
    }
    
    
}
