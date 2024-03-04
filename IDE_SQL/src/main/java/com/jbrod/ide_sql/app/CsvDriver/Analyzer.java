
package com.jbrod.ide_sql.app.CsvDriver;

import com.jbrod.ide_sql.ui.AppFrame;
import java.util.LinkedList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author jbravo
 */
public class Analyzer {

    private LinkedList<CsvFile> listFiles;
    private AppFrame appFrame;
    private String homePath;
    private FileManager fileManager;
    
    public  Analyzer(String path, FileManager fileManager){
        homePath = path;
        listFiles = new LinkedList<>();
        this.fileManager = fileManager;
    }
    
    public void setAppFrame(AppFrame appFrame){
        this.appFrame = appFrame;
    }
    
    public void addCsvFile(String path, DefaultMutableTreeNode treeNode ){
        CsvFile newFile = new CsvFile(path, fileManager, treeNode);
        listFiles.add(newFile);
    }
    
    public void addCsvFIle(CsvFile file){
        file.addToList(fileManager);
        listFiles.add(file);
    }
    
}
