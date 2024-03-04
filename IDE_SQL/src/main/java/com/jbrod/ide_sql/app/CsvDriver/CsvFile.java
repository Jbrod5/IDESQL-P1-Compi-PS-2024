package com.jbrod.ide_sql.app.CsvDriver;

import com.jbrod.ide_sql.ui.FilePanel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa un archivo CSV.
 * @author jbravo
 */
public class CsvFile extends DefaultMutableTreeNode {

    private String path;
    private String fileName; 
    private String content;
    private DefaultMutableTreeNode treeNode;
    private FileManager fileManager;  // Se le pasa una instancia que es unica para todos
    
    private FilePanel filePanel; 
    
    public CsvFile(String path, FileManager fileManager, DefaultMutableTreeNode treeNode){
          this.path = path;
          this.fileManager = fileManager; 
          
          content = fileManager.readFile(path);
          fileName= fileManager.getFileName(path);
          //treeNode = new DefaultMutableTreeNode(fileName);
          this.treeNode = treeNode;
          
          filePanel = new FilePanel(this);
    }
    
    public CsvFile(String path, String fileName){
        super(fileName);
        this.path = path;
    }
    
    public void addToList(FileManager fileManager ){
        this.fileManager = fileManager;
        content = fileManager.readFile(path);
          fileName= fileManager.getFileName(path);
          filePanel = new FilePanel(this);
    }
    
    public void updateContent(String content){
           fileManager.writeFile(path, content);
           this.content = fileManager.readFile(path);
    }

    
    /* Getters */
    public DefaultMutableTreeNode getTreeNode() {
        return treeNode;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

    public FilePanel getFilePanel() {
        return filePanel;
    }
    
    
}
