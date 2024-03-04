package com.jbrod.ide_sql;

import com.jbrod.ide_sql.app.CsvDriver.Analyzer;
import com.jbrod.ide_sql.app.CsvDriver.FileManager;
import com.jbrod.ide_sql.ui.AppFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author jbravo
 */
public class IDE_SQL {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //1. Obtener el directorio
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Selecciona un directorio:");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String selectedPath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Ruta del directorio seleccionado: " + selectedPath);
            
            
            
            FileManager fileManager = new FileManager();
            Analyzer analyzer = new Analyzer(selectedPath, fileManager);
            AppFrame appFrame = new AppFrame(selectedPath, analyzer);
            analyzer.setAppFrame(appFrame);
            
            appFrame.setVisible(true);
            
            
            
        } else {
            System.out.println("No se ha seleccionado ningún directorio.");
        }
    }
    
}
